package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.BookShopDao;
import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    BookShopDao bookShopDao;

    @Override
    public BookShop shopLogin(BookShop bookShop) {
        return bookShopDao.shopLogin(bookShop);
    }

    @Override
    public int updBookShop(BookShop bookShop) {
        return bookShopDao.updBookShop(bookShop);
    }

    @Override
    public int changeShopPassword(String password,String shopCode) {
        BookShop bookShop = new BookShop();
        bookShop.setShopCode(shopCode);
        bookShop.setPassword(password);
        return bookShopDao.changeShopPassword(bookShop);
    }

    @Override
    public List<BookShop> getShopList(int current) {
        return bookShopDao.getShopList(current);
    }

    @Override
    public int getShopListTotal() {
        return bookShopDao.getShopListTotal();
    }

    @Override
    public List<BookShop> getShopListShenHe() {
        return bookShopDao.getShopListShenHe();
    }

    @Override
    public int delShopByShopCode(String shopCode) {
        return bookShopDao.delShopByShopCode(shopCode);
    }

    @Override
    public int updShopByShopCode(BookShop bookShop) {
        return bookShopDao.updShopByShopCode(bookShop);
    }

    @Override
    public Map<String,Object> shopRegister(BookShop bookShop) {
        Map<String,Object> result = new HashMap<>();
        // 判断书店是否存在
        if (null != bookShopDao.selectBookShopByBookShopName(bookShop.getShopName())){
            result.put("code",0);
            result.put("message","该店铺名已存在！");
            return result;
        }else{
            // 注册书店，不需要添加其他东西
            bookShop.setShopCode(System.currentTimeMillis()+"");
            if(bookShopDao.addBookShop(bookShop) == 1){
                result.put("code",1);
                result.put("message","注册成功，请记好账号用于后续登录！ "+bookShop.getShopCode());
                return result;
            }else{
                result.put("code",0);
                result.put("message","注册失败");
                return result;
            }
        }
    }

    @Override
    public int updShopExistByShopCode(String shopCode, int exist) {
        BookShop bookShop = new BookShop();
        bookShop.setShopCode(shopCode);
        bookShop.setExist(exist);
        return bookShopDao.updShopExistByShopCode(bookShop);
    }


    @Override
    public int updMemberTimeByBookCode(String shopCode) {
        return bookShopDao.updMemberTimeByBookCode(shopCode);
    }

    @Override
    public BookShop getBookShopByCode(String shopCode) {
        return bookShopDao.getShopByShopCode(shopCode);
    }
}
