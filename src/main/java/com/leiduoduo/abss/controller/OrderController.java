package com.leiduoduo.abss.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.leiduoduo.abss.pojo.BookOrder;
import com.leiduoduo.abss.service.OrderServcice;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class OrderController {
    @Autowired
    OrderServcice orderServcice;

    @GetMapping("/getOrderList")
    public Map<String,Object> getOrderList(String userCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",orderServcice.getOrderList(userCode));
        return result;
    }
    @GetMapping("/getOrderListByShopCode")
    public Map<String,Object> getOrderListByShopCode(String shopCode){
        Map<String,Object> result = new HashMap<>();
        result.put("data",orderServcice.getOrderListByShopCode(shopCode));
        return result;
    }

    /**
     * 添加订单
     * @param request
     * @return
     */
    @PostMapping("/insertOrder")
    public Map<String,Object> insertOrder(String bookCode,String bookName,String userCode,int number){
        Map<String,Object> result = new HashMap<>();
        result.put("data",orderServcice.insertOrder(bookCode,bookName,userCode,number));
        return result;
    }

    @RequestMapping("/addOrder")
    public String addOrder(HttpServletRequest request){
        boolean result = false;
        try {
            result = alipayCallback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result) {
            return "success"; // 请不要修改或删除
        } else {
            // 验证失败
            return "fail";
        }
    }

    /**
     * 支付宝回调
     *
     * @return
     * @throws Exception
     */
    private boolean alipayCallback(HttpServletRequest request) throws Exception {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, new String(valueStr.getBytes("ISO-8859-1"), "UTF-8"));
        }
        // 返回公共参数
        String extparamString = request.getParameter("extra_common_param");
        String tradeno = params.get("trade_no");;
        //交易完成
        String body = params.get("body");
        if (StringUtils.isEmpty(tradeno)) {
            tradeno = params.get("trade_no");
        }
        try {
            JSONObject bodyJson = JSONObject.parseObject(body);
            String orderCode = bodyJson.getString("orderCode");
            String bookCode = bodyJson.getString("bookCode");
            String bookName = bodyJson.getString("bookName");
            int number = Integer.parseInt(bodyJson.getString("number"));
            double price = Double.parseDouble(bodyJson.getString("price"));
            String userCode = bodyJson.getString("userCode");
            double total = Double.parseDouble(bodyJson.getString("total"));
            String shopCode = bodyJson.getString("shopCode");
            String shopName = bodyJson.getString("shopName");
            BookOrder bookOrder = new BookOrder();
            bookOrder.setOrderCode(orderCode);
            bookOrder.setBookName(bookName);
            bookOrder.setBookCode(bookCode);
            bookOrder.setNumber(number);
            bookOrder.setPrice(price);
            bookOrder.setUserCode(userCode);
            bookOrder.setTotal(total);
            bookOrder.setShopCode(shopCode);
            bookOrder.setShopName(shopName);
            orderServcice.addOrder(bookOrder);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
