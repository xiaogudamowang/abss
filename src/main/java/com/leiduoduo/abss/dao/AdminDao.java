package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.Admin;
import com.leiduoduo.abss.pojo.BookShop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Mapper
@Repository
public interface AdminDao {
    Admin adminLogin(Admin admin);
}
