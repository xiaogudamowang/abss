package com.leiduoduo.abss.controller;

import com.leiduoduo.abss.config.AlipayConfig;
import com.leiduoduo.abss.service.AliPayService;
import com.leiduoduo.abss.vo.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
