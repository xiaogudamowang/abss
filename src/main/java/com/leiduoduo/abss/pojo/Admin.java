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
public class Admin {
    private int id;
    private String adminCode;
    private String adminName;
    private String phoneNumber;
    private String password;
    private String e_mail;
    private String createAt;
    private String updateAt;
    private int exist;
}
