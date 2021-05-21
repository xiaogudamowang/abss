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
public class Car {
    private int id;
    private String carCode;
    private String bookCode;
    private String bookName;
    private String src;
    private String userCode;
    private int number;
    private double price;
    private double total;
    private String shopCode;
    private String shopName;
    private String createAt;
    private String updateAt;
    private int exist;

    public Car(String bookCode, String userCode, int number) {
        this.bookCode = bookCode;
        this.userCode = userCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carCode='" + carCode + '\'' +
                ", bookCode='" + bookCode + '\'' +
                ", bookName='" + bookName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", total=" + total +
                ", shopCode='" + shopCode + '\'' +
                ", shopName='" + shopName + '\'' +
                ", createAt='" + createAt + '\'' +
                ", updateAt='" + updateAt + '\'' +
                ", exist=" + exist +
                '}';
    }
}
