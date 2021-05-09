package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressList(String userCode);

    int addAddress(Address address);

    int delAddress(String addCode);
}
