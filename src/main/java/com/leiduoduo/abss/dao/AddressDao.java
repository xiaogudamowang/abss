package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressDao {
    List<Address> getAddressList(String userCode);

    int addAddress(Address address);

    int delAddress(String addCode);

    boolean updadd(Address address);
}
