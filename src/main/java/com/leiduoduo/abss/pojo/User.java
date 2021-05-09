package com.leiduoduo.abss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Accessors
public class User {
    private int id;
    private String userCode;
    private String userName;
    private String userPicture;
    private int gender;
    private String phoneNumber;
    private String password;
    private String address;
    private String e_mail;
    private String token;
    private String createAt;
    private String updateAt;
    private int exist;
}
