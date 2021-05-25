package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.Book;

import java.util.List;


public interface BookService {
    List<Book> getBookList(int current);
    int addBook(Book book);
    List<Book> selectBookList(String condition);
    List<Book> getBookRankList(String sortName);
    /*
    分类获取图书（按创建时间倒序）
     */
    List<Book> getBookListBySort(String sortName);
    /*
    根据bookCode获取图书（按创建时间倒序）
     */
    Book getBookListByCode(String bookCode);
    /*
    通过商店编号查找书籍列表
     */
    List<Book> getBookListByShopCode(String shopCode,int current);
    /*
    通过商店编号与书籍编号 修改 书籍信息
     */
    int updateBook(Book book);
    /*
    根据书籍编码 删除 书籍
     */
    int delBookByCode(String bookCode, String shopCode);

    List<Book> getBookTopByShopCode(String shopCode);

    List<Book> getSortTopByShopCode(String shopCode);

    int getBookTotal();

    int getBookListTotalByShopCode(String shopCode);
}
