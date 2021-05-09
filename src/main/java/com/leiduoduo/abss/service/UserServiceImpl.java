package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.UserDao;
import com.leiduoduo.abss.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public List<User> getUserList(){
        return userDao.getUserList();
    }
    public int addUser(User user){
        String random = new Random().nextInt(100)+"";
        user.setUserCode(System.currentTimeMillis()+ random);
        System.out.println(user.toString());
        return userDao.addUser(user);
    }
    /**
     * 修改用户信息
     */
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
    /**
     * 修改用户信息
     */
    @Override
    public int updateUser1(User user) {
        return userDao.updateUser1(user);
    }

    /**
     * 登录
     */
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    /**
     * 设置默认地址
     */
    @Override
    public int setAddress(String addCode, String userCode) {
        User user = new User();
        user.setUserCode(userCode);
        user.setAddress(addCode);
        return userDao.setAddress(user);
    }

    /**
     * 删除user
     */
    @Override
    public int delUserByUserCode(String userCode) {
        return userDao.delUserByUserCode(userCode);
    }
}
