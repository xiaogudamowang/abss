package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getUserList();
    int addUser(User user);
    int updateUser(User user);
    int updateUser1(User user);

    User login(User user);

    int setAddress(String addCode, String userCode);
    int delUserByUserCode(String userCode);
}
