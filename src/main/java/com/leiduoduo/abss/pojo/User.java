package com.leiduoduo.abss.pojo;

import com.sun.istack.internal.NotNull;
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
public class User {
    private int id;
    private String userCode;
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    private String userPicture;
    private int gender;
    @NotEmpty(message = "联系方式不能为空")
    private String phoneNumber;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "地址不能为空")
    private String address;
    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确！")
    private String e_mail;
    private String token;
    private String createAt;
    private String updateAt;
    private int exist;
}
