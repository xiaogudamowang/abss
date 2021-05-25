package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.service.PictureTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureTestController {
    @Autowired
    PictureTestService pictureTestService;

    @PostMapping(value = "/picTest")
    public String picTest(@RequestParam(value = "file",required = false) MultipartFile file){
        System.out.println(file);
        return pictureTestService.addPicture(file);
    }
}
