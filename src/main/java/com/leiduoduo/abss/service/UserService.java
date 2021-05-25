package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;


public interface UserService {
    List<User> getUserList(int current);
    int addUser(User user);
    int updateUser(User user);
    int updateUser1(User user);

    User login(User user);

    int setAddress(String addCode, String userCode);
    int delUserByUserCode(String userCode);

    User updPicByUserCode(String userPicture, String userCode);

    int register(User user);

    User getUserByCode(String userCode);

    int updPasswordByCode(String password, String userCode, String phoneNumber);

    int getUserListTotal();
}
