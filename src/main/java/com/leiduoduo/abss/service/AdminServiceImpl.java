package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.AdminDao;
import com.leiduoduo.abss.dao.BookShopDao;
import com.leiduoduo.abss.pojo.Admin;
import com.leiduoduo.abss.pojo.BookShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminDao adminDao;

    @Override
    public Admin adminLogin(Admin admin) {
        return adminDao.adminLogin(admin);
    }
}
