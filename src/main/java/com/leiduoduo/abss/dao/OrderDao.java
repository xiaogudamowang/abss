package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.BookOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {
    List<BookOrder> getOrderList(String userCode);

    List<BookOrder> getOrderListByShopCode(String shopCode);

    int addOrder(BookOrder bookOrder);

}
