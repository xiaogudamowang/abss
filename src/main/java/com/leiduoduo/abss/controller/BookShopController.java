package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookShop;
import com.leiduoduo.abss.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public Map<String,Object> getShopList(int current){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookShopService.getShopList(current));
        result.put("total",bookShopService.getShopListTotal());
        return result;
    }
    /**
     * 获取所有待审核的书店
     */
    @GetMapping("/getShopListShenHe")
    public Map<String,Object> getShopListShenHe(){
        Map<String,Object> result = new HashMap<>();
        result.put("data",bookShopService.getShopListShenHe());
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

    /**
     * 添加书店
     */
    @PostMapping("/shopRegister")
    public Map<String,Object> shopRegister(@Valid BookShop bookShop, BindingResult br){
        Map<String,Object> result = new HashMap<>();
        if (br.getErrorCount()>0){
            result.put("code",500);
            result.put("message",br.getFieldError().getDefaultMessage());
            return result;
        }else {
            Map<String,Object> rs = bookShopService.shopRegister(bookShop);
            result.put("code",rs.get("code"));
            result.put("message",rs.get("message"));
            return result;
        }
    }

    @PostMapping("/updShopExistByShopCode")
    public Map<String,Object> updShopExistByShopCode(String shopCode,int exist){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",bookShopService.updShopExistByShopCode(shopCode,exist));
        result.put("message","操作成功");
        return result;
    }

    @PostMapping("/updMemberTimeByBookCode")
    public Map<String,Object> updMemberTimeByBookCode(String shopCode){
        System.out.println(shopCode);
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",bookShopService.updMemberTimeByBookCode(shopCode));
        result.put("message","充值成功");
        return result;
    }

}
