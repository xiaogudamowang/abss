package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookShop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookShopDao {
    BookShop shopLogin(BookShop bookShop);

    int updBookShop(BookShop bookShop);

    int changeShopPassword(BookShop bookShop);

    List<BookShop> getShopList(int current);

    int getShopListTotal();

    int delShopByShopCode(String shopCode);

    int updShopByShopCode(BookShop bookShop);

    BookShop getShopByShopCode(String shopCode);

    BookShop selectBookShopByBookShopName(String shopName);

    int addBookShop(BookShop bookShop);

    List<BookShop> getShopListShenHe();

    int updShopExistByShopCode(BookShop bookShop);

    int updMemberTimeByBookCode(String shopCode);

    int updMemberTiemSchedul();
}
