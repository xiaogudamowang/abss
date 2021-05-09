package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.User;
import com.leiduoduo.abss.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    BookService bookService;

    /**
     * 查询所有书籍
     * @return
     */
    @GetMapping("/getBookList")
    public Map<String,Object> getBookList(){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.getBookList());
        return result;
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @PostMapping("/addBook")
    public Map<String,Object> addBook(Book book){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.addBook(book));
        return result;
    }

    /**
     * 根据条件查询书籍
     * @param condition
     * @return
     */
    @GetMapping("/selectBook")
    public Map<String,Object> selectBook(String condition){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.selectBookList(condition));
        return result;
    }

    /**
     * 根据类别得到书籍排行
     * @param sortName
     * @return
     */
    @GetMapping("/getBookRankList")
    public Map<String,Object> getBookRankList(String sortName){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.getBookRankList(sortName));
        return result;
    }
    /**
     * 根据类别查询书籍（按创建时间降序）
     * @param sortName
     * @return
     */
    @GetMapping("/getBookListBySort")
    public Map<String,Object> getBookListBySort(String sortName){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.getBookListBySort(sortName));
        return result;
    }
    /**
     * 根据编号查询书籍
     * @param bookCode
     * @return
     */
    @GetMapping("/getBookListByCode")
    public Map<String,Object> getBookListByCode(String bookCode){

        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.getBookListByCode(bookCode));
        return result;
    }
    /**
     * 通过商店编号查找书籍列表
     */
    @GetMapping("/getBookListByShopCode")
    public Map<String,Object> getBookListByShopCode(String shopCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.getBookListByShopCode(shopCode));
        return result;
    }

    /**
     * 通过商店编号与书籍编号 修改 书籍信息
     * @param book
     * @return
     */
    @PostMapping("/updBook")
    public Map<String,Object> updateBook(Book book){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.updateBook(book));
        return result;
    }

    /**
     * 根据书籍编码 删除 书籍
     * @param bookCode
     * @param shopCode
     * @return
     */
    @PostMapping("/delBookByCode")
    public Map<String,Object> delBookByCode(String bookCode,String shopCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookService.delBookByCode(bookCode,shopCode));
        return result;
    }
}
