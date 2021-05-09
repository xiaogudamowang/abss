package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/gatCarList")
    public Map<String,Object> getCarList(String userCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",carService.getCarList(userCode));
        return result;
    }

    @PostMapping("/delCarByCarCode")
    public Map<String,Object> delCarByCarCode(String carCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",carService.delCarByCarCode(carCode));
        return result;
    }
}
