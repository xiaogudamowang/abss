package com.leiduoduo.abss.service;

import com.leiduoduo.abss.dao.BookDao;
import com.leiduoduo.abss.dao.BookShopDao;
import com.leiduoduo.abss.dao.CarDao;
import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarDao carDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    BookShopDao bookShopDao;

    @Override
    public List<Car> getCarList(String userCode) {
        List<Car> carList = null;
//        // 在car表中，根据userCode查出对应的bookCode
//        List<String> bookCodeList = carDao.getBookCodeByUserCodeFromCar(userCode);
//        // 根据查到的bookCode数组得到对应的List[Car]
//        if (null == bookCodeList){
//            return null;
//        } else{
//            bookList = carDao.getBookListByBookCodeList(bookCodeList);
//        }
//        // 给List[Car]中的total属性赋值
        // 根据userCode连接查询
        carList = carDao.getCarList(userCode);
        for (Car car:carList) {
            car.setTotal(car.getPrice()*car.getNumber());
        }
        // 返回List[Car]
        return carList;
    }

    @Override
    public int delCarByCarCode(String carCode) {
        return carDao.delCarByCarCode(carCode);
    }

    @Override
    public int addBookToCar(String userCode, String bookCode, int number) {
        Car car2 =carDao.getBookByBookCode(bookCode);
        if (null == car2){
            Book book = bookDao.getBookListByCode(bookCode);
            // car 赋值
            Car car = new Car();
            car.setBookCode(bookCode);
            car.setBookName(book.getBookName());
            car.setPrice(book.getPrice());
            car.setNumber(number);
            car.setShopCode(book.getShopCode());
            car.setShopName(bookShopDao.getShopByShopCode(book.getShopCode()).getShopName());
            car.setCarCode(System.currentTimeMillis()+"");
            car.setUserCode(userCode);
            car.setTotal(car.getPrice()*car.getNumber());
            return carDao.addBookToCar(car);
        }else{
            car2.setNumber(number);
            return carDao.addCarNumber(car2);
        }

    }
}
