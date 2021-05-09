package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.service.PictureTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureTestController {
    @Autowired
    PictureTestService pictureTestService;

    @PostMapping(value = "/picTest")
    public String picTest( MultipartFile file){
        return pictureTestService.addPicture(file);
    }


}
