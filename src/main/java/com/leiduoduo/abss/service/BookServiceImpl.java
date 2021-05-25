package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.BookDao;
import com.leiduoduo.abss.dao.SortDao;
import com.leiduoduo.abss.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    SortDao sortDao;

    @Override
    public List<Book> getBookList(int current) {
        current = 20 * (current -1);
        return bookDao.getBookList(current);
    }

    @Override
    public int addBook(Book book) {
        int random = new Random().nextInt(100);
        book.setBookCode(System.currentTimeMillis()+""+random);
        book.setSortName(sortDao.getNameByCode(book.getSortCode()));
        return bookDao.addBook(book);
    }

    @Override
    public List<Book> selectBookList(String condition) {
        return bookDao.selectBookList(condition);
    }

    @Override
    public List<Book> getBookRankList(String sortName) {
        return bookDao.getBookRankList(sortName);
    }

    @Override
    public List<Book> getBookListBySort(String sortName) {
        return bookDao.getBookListBySort(sortName);
    }

    @Override
    public Book getBookListByCode(String bookCode) {
        return bookDao.getBookListByCode(bookCode);
    }

    @Override
    public List<Book> getBookListByShopCode(String shopCode,int current) {
        Map<String, Object> map = new HashMap<>();
        map.put("shopCode",shopCode);
        map.put("current",20 * (current - 1));
        return bookDao.getBookListByShopCode(map);
    }

    @Override
    public int updateBook(Book book) {
        book.setSortName(sortDao.getNameByCode(book.getSortCode()));
        return bookDao.updateBook(book);
    }

    @Override
    public int delBookByCode(String bookCode, String shopCode) {
        return bookDao.delBookByCode(bookCode);
    }

    @Override
    public List<Book> getBookTopByShopCode(String shopCode) {
        return bookDao.getBookTopByShopCode(shopCode);
    }

    @Override
    public List<Book> getSortTopByShopCode(String shopCode) {
        return bookDao.getSortTopByShopCode(shopCode);
    }

    @Override
    public int getBookTotal() {
        return bookDao.getBookTotal();
    }

    @Override
    public int getBookListTotalByShopCode(String shopCode) {
        return bookDao.getBookListTotalByShopCode(shopCode);
    }
}
