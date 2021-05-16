package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.Address;

import java.util.List;
import java.util.Map;

public interface AddressService {
    List<Address> getAddressList(String userCode);

    int addAddress(Address address);

    int delAddress(String addCode);

    Map<String, Object> updadd(Address address);
}
