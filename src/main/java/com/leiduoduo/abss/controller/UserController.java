package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.pojo.User;
import com.leiduoduo.abss.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/getUserList")
    public Map<String,Object> getUserList(){
        Map<String,Object> result = new HashMap<>();
        result.put("data",userService.getUserList());
        return result;
    }
    @PostMapping("/addUser")
    public Map<String,Object> addUser(User user){
        Map<String,Object> result = new HashMap<>();
        result.put("data",userService.addUser(user));
        return result;
    }
    @PostMapping("/updateUser")
    public Map<String,Object> updateUser(User user){
        Map<String,Object> result = new HashMap<>();
        result.put("data",userService.updateUser(user));
        return result;
    }
    @PostMapping("/updateUser1")
    public Map<String,Object> updateUser1(User user){
        Map<String,Object> result = new HashMap<>();
        result.put("data",userService.updateUser1(user));
        return result;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Map<String,Object> login(User user){
        Map<String,Object> result = new HashMap<>();
        result.put("data",userService.login(user));
        return result;
    }

    /**
     * 设置默认地址
     */
    @PostMapping("/setAddress")
    public Map<String,Object> setAddress(String addCode,String userCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",userService.setAddress(addCode,userCode));
        return result;
    }

    /**
     * 根据userCode 删除 顾客
     */
    @PostMapping("/delUserByUserCode")
    public Map<String,Object> delUserByUserCode(String userCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",userService.delUserByUserCode(userCode));
        return result;
    }
}
