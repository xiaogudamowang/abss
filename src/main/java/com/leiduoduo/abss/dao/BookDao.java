package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BookDao {
    /*
    查询所有书籍
     */
    List<Book> getBookList(int current);
    /*
    添加书籍
     */
    int addBook(Book book);
    /*
    根据条件查询书籍
     */
    List<Book> selectBookList(String condition);
    /*
    根据购买量得到书籍排行版
     */
    List<Book> getBookRankList(String sortName);
    /*
    分类获取图书（按创建时间倒序）
     */
    List<Book> getBookListBySort(String sortName);
    /*
    根据bookCode获取图书
     */
    Book getBookListByCode(String bookCode);

    List<Book> getBookListByShopCode(Map<String, Object> map);

    int updateBook(Book book);
    /*
    根据书籍编码 删除 书籍
     */
    int delBookByCode(String bookCode);

    List<Book> getBookTopByShopCode(String shopCode);

    List<Book> getSortTopByShopCode(String shopCode);

    int bookNumberSub1(String bookCode);

    int getBookTotal();

    int getBookListTotalByShopCode(String shopCode);
}
