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
public class MemberOrder {
    private int id;
    private String orderCode;
    private String shopCode;
    private String state;
    private double price;
    private int number;
    private double total;
    private String commodityName;
    private String createAt;
    private String updateAt;
    private int exist;
}
