package com.leiduoduo.abss.dao;

import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CarDao {
    List<Car> getCarList(String userCode);
    int delCarByCarCode(String carCode);
    List<String> getBookCodeByUserCodeFromCar(String userCode);
    List<Book> getBookListByBookCodeList(List<String> bookCodeList);
    int addBookToCar(Car car);
    Car getBookByBookCode(String bookCode);
    int addCarNumber(Car car);
}
