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
public class BookShop {
    private int id;
    private String shopCode;
    private String shopName;
    private String shopPicture;
    private String phoneNumber;
    private String password;
    private String e_mail;
    private String address;
    private int memberTime;
    private String message;
    private String QQ;
    private String createAt;
    private String updateAt;
    private int exist;
}
