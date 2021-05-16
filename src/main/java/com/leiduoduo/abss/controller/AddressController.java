package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.pojo.Address;
import com.leiduoduo.abss.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/getAddressList")
    private Map<String,Object> getAddressList(String userCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",addressService.getAddressList(userCode));
        return result;
    }

    @PostMapping("/addAddress")
    public Map<String,Object> addAddress(Address address){
        Map<String,Object> result = new HashMap<>();
        result.put("data",addressService.addAddress(address));
        return result;
    }

    @PostMapping("/delAddress")
    public Map<String,Object> delAddress(String addCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",addressService.delAddress(addCode));
        return result;
    }
    @PostMapping("/updadd")
    public Map<String,Object> updadd(Address address){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> rs = new HashMap<>();
        rs = addressService.updadd(address);
        result.put("code",rs.get("code"));
        result.put("message",rs.get("message"));
        return result;
    }
}
