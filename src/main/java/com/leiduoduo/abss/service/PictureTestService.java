package com.leiduoduo.abss.service;

import org.springframework.web.multipart.MultipartFile;

public interface PictureTestService {
    String addPicture(MultipartFile file);
}
