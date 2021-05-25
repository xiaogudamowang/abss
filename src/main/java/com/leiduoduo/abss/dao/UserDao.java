package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> getUserList(int current);
    int addUser(User user);
    int updateUser(User user);
    int updateUser1(User user);
    User login(User user);
    User selectUserByUserName(String userName);
    int setAddress(User user);

    int delUserByUserCode(String userCode);

    int updPicByUserCode(User user);

    User getUserByUserCode(String userCode);

    User getUserByCode(String userCode);

    int updPasswordByCode(User user);

    int getUserListTotal();
}
