package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.CarDao;
import com.leiduoduo.abss.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarDao carDao;

    @Override
    public List<Car> getCarList(String userCode) {
        return carDao.getCarList(userCode);
    }

    @Override
    public int delCarByCarCode(String carCode) {
        return carDao.delCarByCarCode(carCode);
    }
}
