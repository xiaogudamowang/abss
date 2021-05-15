package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookShop;

import java.util.List;

public interface BookShopService {
    BookShop shopLogin(BookShop bookShop);

    int updBookShop(BookShop bookShop);

    int changeShopPassword(String password,String shopCode);

    List<BookShop> getShopList();

    int delShopByShopCode(String shopCode);

    int updShopByShopCode(BookShop bookShop);

    int shopRegister(BookShop bookShop);
}
