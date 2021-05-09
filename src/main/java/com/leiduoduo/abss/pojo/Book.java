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
public class Book {
    private int id;
    private String bookCode;
    private String bookName;
    private String ISBN;
    private String press;
    private String src;
    private String author;
    private String edition;
    private int shopNumber;
    private String sortCode;
    private String sortName;
    private String shopCode;
    private String message;
    private double price;
    private int number;
    private String createAt;
    private String updateAt;
    private int exist;
}
