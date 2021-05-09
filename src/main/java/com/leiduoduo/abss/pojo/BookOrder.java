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
public class BookOrder {
    private int id;
    private String orderCode;
    private String bookCode;
    private String bookName;
    private int number;
    private double price;
    private String userCode;
    private String state;
    private double total;
    private String shopCode;
    private String shopName;
    private String updateAt;
    private int exist;
}
