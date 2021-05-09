package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.service.PictureTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PictureTestController {
    @Autowired
    PictureTestService pictureTestService;

    @GetMapping("/picTest")
    public void picTest(){
        pictureTestService.addPicture();
    }
}
