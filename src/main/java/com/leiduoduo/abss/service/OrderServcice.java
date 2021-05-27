package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.BookOrder;

import java.util.List;
import java.util.Map;

public interface OrderServcice {

    List<Map<String,Object>> getOrderList(String userCode);

    List<BookOrder> getOrderListByShopCode(String shopCode);

    void addOrder(BookOrder bookOrder);

    int insertOrder(String bookCode, String bookName, String userCode, int number);

    int updsrcByOrderCode(String orderCode,String src);

    int updStateByOrderCode(String orderCode, String state);
}
