package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.BookDao;
import com.leiduoduo.abss.dao.BookShopDao;
import com.leiduoduo.abss.dao.OrderDao;
import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookOrder;
import com.leiduoduo.abss.pojo.BookShop;
import com.leiduoduo.abss.util.Arith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderServcice {
    @Autowired
    OrderDao orderDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    BookShopDao bookShopDao;
    /**
     * 得到全部订单信息
     */
    @Override
    public List<Map<String,Object>> getOrderList(String userCode) {
        return orderDao.getOrderList(userCode);
    }
    /**
     * 通过书店编码获取订单信息
     */
    @Override
    public List<BookOrder> getOrderListByShopCode(String shopCode) {
        return orderDao.getOrderListByShopCode(shopCode);
    }

    @Override
    public void addOrder(BookOrder bookOrder) {
        orderDao.addOrder(bookOrder);
    }

    /**
     * 添加订单
     */
    @Override
    public int insertOrder(String bookCode, String bookName, String userCode, int number) {
        BookOrder bookOrder = new BookOrder();
        Book book = bookDao.getBookListByCode(bookCode);
        BookShop bookShop = bookShopDao.getShopByShopCode(book.getShopCode());
        String orderCode = System.currentTimeMillis()+"";
        bookOrder.setOrderCode(orderCode);
        bookOrder.setBookCode(bookCode);
        bookOrder.setBookName(book.getBookName());
        bookOrder.setNumber(number);
        bookOrder.setPrice(book.getPrice());
        bookOrder.setUserCode(userCode);
        bookOrder.setTotal(Arith.mul(book.getPrice(),number));
        bookOrder.setShopCode(book.getShopCode());
        bookOrder.setShopName(bookShop.getShopName());
        bookDao.bookNumberSub1(bookCode);
        return orderDao.addOrder(bookOrder);
    }

    @Override
    public int updsrcByOrderCode(String orderCode,String src) {
        BookOrder bookOrder = new BookOrder();
        bookOrder.setOrderCode(orderCode);
        bookOrder.setSrc(src);
        return orderDao.updsrcByOrderCode(bookOrder);
    }

    @Override
    public int updStateByOrderCode(String orderCode, String state) {
        BookOrder bookOrder = new BookOrder();
        bookOrder.setOrderCode(orderCode);
        bookOrder.setState(state);
        return orderDao.updStateByOrderCode(bookOrder);
    }
}
