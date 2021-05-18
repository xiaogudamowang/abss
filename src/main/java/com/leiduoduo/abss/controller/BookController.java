package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.User;
import com.leiduoduo.abss.service.BookService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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
     * 通过商店编号查找书籍Top
     */
    @GetMapping("/getBookTopByShopCode")
    public Map<String,Object> getBookTopByShopCode(String shopCode){
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> bookList = new LinkedList<>();
        for (Book book: bookService.getBookTopByShopCode(shopCode)) {
            Map<String,Object> item = new HashMap<>();
            item.put("value",book.getShopNumber());
            item.put("name",book.getBookName());
            bookList.add(item);
        }
        result.put("data",bookList);
        return result;
    }

    /**
     * 通过商店编号查找类别Top
     */
    @GetMapping("/getSortTopByShopCode")
    public Map<String,Object> getSortTopByShopCode(String shopCode){
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> bookList = new LinkedList<>();
        for (Book book: bookService.getSortTopByShopCode(shopCode)) {
            Map<String,Object> item = new HashMap<>();
            item.put("value",book.getId());
            item.put("name",book.getSortName());
            bookList.add(item);
        }
        result.put("data",bookList);
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

    /**
     * 爬虫
     */
    @GetMapping("/pachon")
    public void pachon() throws IOException {
        String url="http://search.dangdang.com/?key=java";
        // 解析网页
        Document document = Jsoup.parse(new URL(url), 3000);
        Element element = document.getElementById("component_59");
        // System.out.println(element.html());
        // 获取所有的li元素
        Elements li = element.getElementsByTag("li");
        // 获取元素中的内容
        for (Element element1 : li) {
            Book book = new Book();
            String eleurl = element1.getElementsByTag("a").eq(0).attr("href");
            String img = element1.getElementsByTag("img").eq(0).attr("data-original");
            Double price = Double.parseDouble(element1.getElementsByClass("search_now_price").eq(0).text().substring(1));
            String title = element1.getElementsByClass("name").eq(0).text();
            // 出版社
            String press = element1.getElementsByClass("search_book_author").get(0).getElementsByTag("span").eq(2).text().substring(1);
            // 作者
            String author = element1.getElementsByClass("search_book_author").get(0).getElementsByTag("span").eq(0).text();
            // 版次
            String edition = "1";
            int shopNumber = new Random().nextInt(10);
            String sortCode = "3";
            String shopCode = "13869168164163516";
            String sortName = "科学";
            // 书籍描述
            String message = element1.getElementsByClass("detail").text();
            int number = 500;

//            System.out.println("===================================");
//            System.out.println(img);
//            System.out.println(press);
//            System.out.println(author);
//            System.out.println(price);
//            System.out.println(title);
//            System.out.println(message);
            Document eledocument = Jsoup.parse(new URL(eleurl), 3000);
            String isbn = eledocument.getElementById("detail_describe").getElementsByTag("li").eq(4).text().substring(11);
//            System.out.println(isbn);
            book.setBookCode(System.currentTimeMillis()+"");
            book.setBookName(title);
            book.setISBN(isbn);
            book.setSrc(img);
            book.setPress(press);
            book.setAuthor(author);
            book.setEdition(edition);
            book.setShopNumber(shopNumber);
            book.setSortCode(sortCode);
            book.setSortName(sortName);
            book.setShopCode(shopCode);
            book.setMessage(message);
            book.setPrice(price);
            book.setNumber(number);
            bookService.addBook(book);
        }
    }
}
