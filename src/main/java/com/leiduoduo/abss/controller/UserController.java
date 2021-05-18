package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.annotation.UserLoginToken;
import com.leiduoduo.abss.pojo.Token;
import com.leiduoduo.abss.pojo.User;
import com.leiduoduo.abss.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    Token token;

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
        User resultUser = userService.login(user);
        if (null != resultUser){
            result.put("data",resultUser);
            result.put("token",token.getToken(resultUser.getUserCode()));
            result.put("code",0);
            result.put("message","登录成功");
        }else{
            result.put("data",null);
            result.put("token",null);
            result.put("code",401);
            result.put("message","用户不存在");
        }
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

    /**
     * 修改用户头像
     */
    @UserLoginToken
    @PostMapping("/updPicByUserCode")
    public Map<String,Object> updPicByUserCode(String userPicture,String userCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",userService.updPicByUserCode(userPicture,userCode));
        return result;
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Map<String,Object> register(@Valid User user, BindingResult br){
        Map<String,Object> result = new HashMap<>();
        if (br.getErrorCount()>0){
            result.put("code",500);
            result.put("message",br.getFieldError().getDefaultMessage());
            return result;
        }else {
            if (userService.register(user) == 1){
                result.put("code",0);
                result.put("message","注册成功");
            }else{
                result.put("code",500);
                result.put("message","注册失败,用户名已存在");
            }
            return result;
        }
    }
}
