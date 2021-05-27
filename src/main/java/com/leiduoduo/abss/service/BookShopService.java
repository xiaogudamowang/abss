package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookShop;

import java.util.List;
import java.util.Map;

public interface BookShopService {
    BookShop shopLogin(BookShop bookShop);

    int updBookShop(BookShop bookShop);

    int changeShopPassword(String password,String shopCode);

    List<BookShop> getShopList(int current);

    int getShopListTotal();

    int delShopByShopCode(String shopCode);

    int updShopByShopCode(BookShop bookShop);

    Map<String,Object> shopRegister(BookShop bookShop);

    List<BookShop> getShopListShenHe();

    int updShopExistByShopCode(String shopCode, int exist);

    int updMemberTimeByBookCode(String shopCode);

    BookShop getBookShopByCode(String shopCode);
}
