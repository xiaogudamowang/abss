package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.AddressDao;
import com.leiduoduo.abss.dao.UserDao;
import com.leiduoduo.abss.pojo.Address;
import com.leiduoduo.abss.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Random;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    AddressDao addressDao;

    public List<User> getUserList(int current){
        return userDao.getUserList(current);
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

    /**
     * 修改用户头像
     */
    @Override
    @Transactional
    public User updPicByUserCode(String userPicture, String userCode) {
        User user = new User();
        user.setUserPicture(userPicture);
        user.setUserCode(userCode);
        userDao.updPicByUserCode(user);
        return userDao.getUserByUserCode(userCode);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    @Transactional
    public int register(User user) {
        // 判断用户是否已经存在
        if (null != userDao.selectUserByUserName(user.getUserName())){
            return 0;
        }else{
            // 不存在则注册用户
            user.setUserCode(System.currentTimeMillis()+"");
            // 添加收货地址
            Address address = new Address();
            address.setAddCode(System.currentTimeMillis()+"");
            address.setMessage(user.getAddress());
            address.setTel(user.getPhoneNumber());
            address.setName(user.getUserName());
            address.setUserCode(user.getUserCode());
            addressDao.addAddress(address);
            // 添加用户
            user.setAddress(address.getAddCode());
            return userDao.addUser(user);
        }
    }

    /**
     * 通过userCode得到User（用在Token）
     */
    @Override
    public User getUserByCode(String userCode) {
        return userDao.getUserByCode(userCode);
    }

    /**
     * 修改用户密码，联系方式
     * @param password
     * @param userCode
     * @param phoneNumber
     * @return
     */
    @Override
    public int updPasswordByCode(String password, String userCode, String phoneNumber) {
        User user = new User();
        user.setUserCode(userCode);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        return userDao.updPasswordByCode(user);
    }

    /**
     * 得到用户的数量
     * @return
     */
    @Override
    public int getUserListTotal() {
        return userDao.getUserListTotal();
    }
}
