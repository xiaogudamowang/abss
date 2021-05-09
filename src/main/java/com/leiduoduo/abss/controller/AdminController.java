package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.pojo.Admin;
import com.leiduoduo.abss.pojo.BookShop;
import com.leiduoduo.abss.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/adminLogin")
    public Map<String, Object> shopLogin(Admin admin){
        Map<String,Object> result = new HashMap<>();
        result.put("data",adminService.adminLogin(admin));
        return result;
    }
}
