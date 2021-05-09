package com.leiduoduo.abss;

import com.leiduoduo.abss.dao.BookDao;
import com.leiduoduo.abss.dao.CarDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AbssApplicationTests {
    @Autowired
    CarDao carDao;
    @Test
    void contextLoads() {
        System.out.println(carDao.getCarList("123"));
    }

}
