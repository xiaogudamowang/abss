package com.leiduoduo.abss.service;

import com.leiduoduo.abss.pojo.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarList(String userCode);
    int delCarByCarCode(String carCode);

    int addBookToCar(String userCode, String bookCode, int number);
}
