package com.leiduoduo.abss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Accessors
public class BookShop {
    private int id;
    private String shopCode;
    @NotEmpty(message = "书店名称不能为空")
    private String shopName;
    private String shopPicture;
    @NotEmpty(message = "联系方式不能为空")
    private String phoneNumber;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String e_mail;
    @NotEmpty(message = "地址不能为空")
    private String address;
    private int memberTime;
    @NotEmpty(message = "店铺描述不能为空")
    private String message;
    @NotEmpty(message = "QQ不能为空")
    private String QQ;
    private String createAt;
    private String updateAt;
    private int exist;
}
