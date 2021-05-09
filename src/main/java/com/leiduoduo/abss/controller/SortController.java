package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class SortController {
    @Autowired
    SortService sortService;

    @GetMapping("/getSortList")
    public Map<String,Object> getSortList(){
        Map<String,Object> result = new HashMap<>();
        result.put("data",sortService.getSortList());
        return result;
    }
}
