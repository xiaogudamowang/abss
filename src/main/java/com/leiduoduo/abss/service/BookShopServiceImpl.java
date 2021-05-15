package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.BookShopDao;
import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<BookShop> getShopList() {
        return bookShopDao.getShopList();
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
    public int shopRegister(BookShop bookShop) {
        // 判断书店是否存在
        if (null != bookShopDao.selectBookShopByBookShopName(bookShop.getShopName())){
            return 0;
        }else{
            // 注册书店，不需要添加其他东西
            bookShop.setShopCode(System.currentTimeMillis()+"");
            return bookShopDao.addBookShop(bookShop);
        }
    }
}
