package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.BookOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderDao {
    List<Map<String,Object>> getOrderList(String userCode);

    List<BookOrder> getOrderListByShopCode(String shopCode);

    int addOrder(BookOrder bookOrder);

    int updsrcByOrderCode(BookOrder bookOrder);

    int updStateByOrderCode(BookOrder bookOrder);
}
