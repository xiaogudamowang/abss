package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.OrderDao;
import com.leiduoduo.abss.pojo.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderServcice {
    @Autowired
    OrderDao orderDao;
    /**
     * 得到全部订单信息
     */
    @Override
    public List<BookOrder> getOrderList(String userCode) {
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
}
