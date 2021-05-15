package com.leiduoduo.abss;

import com.leiduoduo.abss.dao.BookDao;
import com.leiduoduo.abss.dao.CarDao;
import com.leiduoduo.abss.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class AbssApplicationTests {
    @Autowired
    CarDao carDao;
    @Autowired
    CarService carService;
    @Test
    void contextLoads() {
        System.out.println(carService.getCarList("123"));
    }
}
