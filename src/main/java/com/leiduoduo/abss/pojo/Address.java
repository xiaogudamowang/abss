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
public class Address {
    private int id;
    private String addCode;
    private String message;
    private String userCode;
    private String name;
    private String tel;
    private String createAt;
    private String updateAt;
    private int exist;
}
