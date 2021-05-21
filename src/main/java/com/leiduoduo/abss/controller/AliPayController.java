package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.config.AlipayConfig;
import com.leiduoduo.abss.pojo.Car;
import com.leiduoduo.abss.service.AliPayService;
import com.leiduoduo.abss.vo.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class AliPayController {
    @Autowired
    private AliPayService aliPayService;

    @GetMapping("/alipay/pay")
    @ResponseBody
    public byte[] alipay(String bookCode,String userCode,int number){
        return aliPayService.alipay(bookCode,userCode,number);
    }
    @PostMapping("/alipay/order")
    @ResponseBody
    public String payOrder(@RequestBody() Car[] carlist){
        System.out.println("carlist----------------------------------"+carlist.toString());
        String result = aliPayService.payOrder(carlist);
        return result;
    }
    @GetMapping("/alipay/payList")
    @ResponseBody
    public byte[] payList(String code){
        byte[] bytes = aliPayService.payList(code);
        return bytes;
    }
}
