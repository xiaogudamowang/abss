package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookShop;
import com.leiduoduo.abss.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookShopController {
    @Autowired
    BookShopService bookShopService;

    @PostMapping("/shopLogin")
    public Map<String, Object> shopLogin(BookShop bookShop){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookShopService.shopLogin(bookShop));
        return result;
    }

    @PostMapping("/updBookShop")
    public Map<String,Object> updBookShop(BookShop bookShop){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookShopService.updBookShop(bookShop));
        return result;
    }

    /**
     * 修改密码
     * @param password
     * @return
     */
    @PostMapping("/changeShopPassword")
    public Map<String,Object> changeShopPassword(String password ,String shopCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookShopService.changeShopPassword(password,shopCode));
        return result;
    }

    /**
     * 获取书店列表
     */
    @GetMapping("/getShopList")
    public Map<String,Object> getShopList(){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookShopService.getShopList());
        return result;
    }
    /**
     * 根据shopCode 删除 店铺
     */
    @PostMapping("/delShopByShopCode")
    public Map<String,Object> delShopByShopCode(String shopCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookShopService.delShopByShopCode(shopCode));
        return result;
    }
    /**
     * 根据shopCode 修改 店铺
     */
    @PostMapping("/updShopByShopCode")
    public Map<String,Object> updShopByShopCode(BookShop bookShop){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookShopService.updShopByShopCode(bookShop));
        return result;
    }
}
