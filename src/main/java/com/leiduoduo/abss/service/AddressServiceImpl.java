package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.AddressDao;
import com.leiduoduo.abss.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;
    @Override
    public List<Address> getAddressList(String userCode) {
        return addressDao.getAddressList(userCode);
    }

    @Override
    public int addAddress(Address address) {
        int rendom = new Random().nextInt(100);
        address.setAddCode(System.currentTimeMillis()+""+rendom);
        return addressDao.addAddress(address);
    }

    /**
     * 删除地址
     */
    @Override
    public int delAddress(String addCode) {
        return addressDao.delAddress(addCode);
    }

    /**
     * 修改地址信息
     */
    @Override
    public Map<String, Object> updadd(Address address) {
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        if (addressDao.updadd(address)){
            result.put("message","修改成功！");
        }else {
            result.put("message","修改失败！");
        }
        return result;
    }

    /**
     * 获取默认的地址
     */
    @Override
    public Address getMoRenAddressByUserCode(String userCode) {
        return addressDao.getMoRenAddressByUserCode(userCode);
    }
}
