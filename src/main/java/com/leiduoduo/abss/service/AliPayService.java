package com.leiduoduo.abss.service;


import com.leiduoduo.abss.pojo.Car;
import com.leiduoduo.abss.vo.PayVo;

/**
 * @author 徐柯
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/2922:18
 */
public interface AliPayService {
    /**
     * @return byte[]
     * @Author xuke
     * @Description 阿里支付接口
     * @Date 1:05 2020/9/9
     * @Param [payVo]
     **/
    byte[] alipay(String bookCode,String userCode,int number);

    byte[] payList(String code);

    String payOrder(Car[] carlist);
}
