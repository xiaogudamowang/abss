package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.BookOrder;

import java.util.List;

public interface OrderServcice {

    List<BookOrder> getOrderList(String userCode);

    List<BookOrder> getOrderListByShopCode(String shopCode);

    void addOrder(BookOrder bookOrder);
}
