package com.leiduoduo.abss.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.leiduoduo.abss.config.AlipayConfig;
import com.leiduoduo.abss.dao.BookDao;
import com.leiduoduo.abss.dao.BookShopDao;
import com.leiduoduo.abss.dao.CarDao;
import com.leiduoduo.abss.pojo.Book;
import com.leiduoduo.abss.pojo.BookOrder;
import com.leiduoduo.abss.pojo.Car;
import com.leiduoduo.abss.qrcode.QRCodeUtil;
import com.leiduoduo.abss.qrcode.QrCodeResponse;
import com.leiduoduo.abss.qrcode.QrResponse;
import com.leiduoduo.abss.util.Arith;
import com.leiduoduo.abss.util.GenerateNum;
import com.leiduoduo.abss.vo.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;

@Service
public class AliPayServiceImpl implements AliPayService {
    @Autowired
    private AlipayConfig alipayConfig;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookShopDao bookShopDao;
    @Autowired
    CarDao carDao;

    @Override
    public byte[] alipay(String bookCode,String userCode,int number) {
        try {
            Book book = bookDao.getBookListByCode(bookCode);

            // 业务数据
            // 1: 支付的订单编号
            String orderCode = GenerateNum.generateOrder();
            // 2：书名
            String bookName = book.getBookName();
            // 3: 单价
            double price = book.getPrice();
            // 4: 总价
            double total = price*number;
            // 5: 商店编号
            String shopCode = book.getShopCode();
            // 6: 商店名称
            String shopName = bookShopDao.getShopByShopCode(shopCode).getShopName();
            // 支付宝携带的参数在回调中可以通过request获取
            JSONObject json = new JSONObject();
            json.put("orderCode", orderCode);
            json.put("bookCode", bookCode);
            json.put("bookName", bookName);
            json.put("number", number);
            json.put("price", price);
            json.put("userCode", userCode);
            json.put("total", total);
            json.put("shopCode", shopCode);
            json.put("shopName", shopName);
            String params = json.toString();


            // 支付信息的参数
            // 6：设置支付相关的信息
            AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
            model.setOutTradeNo(orderCode); // 自定义订单号
            model.setTotalAmount(total+"");// 支付金额
            model.setSubject(bookName);// 支付的产品名称
            model.setBody(params);// 支付的请求体参数
            model.setTimeoutExpress("30m");// 支付的超时时间
            model.setStoreId(userCode+"");// 支付的库存id
            QrCodeResponse qrCodeResponse = qrcodePay(model);



            // 二维码生成
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            String logopath = ResourceUtils.getFile("classpath:favicon.png").getAbsolutePath();
            BufferedImage buffImg = QRCodeUtil.encode(qrCodeResponse.getQr_code(), logopath, false);//获取二维码
            ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
            ImageIO.write(buffImg, "JPEG", imageOut);
            imageOut.close();
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            return FileCopyUtils.copyToByteArray(input);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 通过code找到car
     * @param code
     * @return
     */
    @Override
    public byte[] payList(String code) {
        try {
            List<Car> carList = carDao.selectCarListByBigOrderCode(code);
            double total = 0.0;
            for (Car car:carList
                 ) {
                total=Arith.add(total,car.getTotal());
            }


            // 支付宝携带的参数在回调中可以通过request获取
            JSONObject json = new JSONObject();
            json.put("code", code);
            String params = json.toString();

            //--------------------------
            System.out.println("total============================="+total);


            // 支付信息的参数
            // 6：设置支付相关的信息
            AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
            model.setOutTradeNo(System.currentTimeMillis()+""); // 自定义订单号
            model.setTotalAmount(total+"");// 支付金额
            model.setSubject("复合订单");// 支付的产品名称
            model.setBody(params);// 支付的请求体参数
            model.setTimeoutExpress("30m");// 支付的超时时间
            model.setStoreId(System.currentTimeMillis()+"");// 支付的库存id
            QrCodeResponse qrCodeResponse = qrcodePay(model);



            // 二维码生成
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            String logopath = ResourceUtils.getFile("classpath:favicon.png").getAbsolutePath();
            BufferedImage buffImg = QRCodeUtil.encode(qrCodeResponse.getQr_code(), logopath, false);//获取二维码
            ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
            ImageIO.write(buffImg, "JPEG", imageOut);
            imageOut.close();
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            return FileCopyUtils.copyToByteArray(input);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String payOrder(Car[] carlist) {
        String bigOrderCode = System.currentTimeMillis()+"";
        for (Car car:carlist
             ) {
            Map<String,Object> map = new HashMap<>();
            map.put("bigOrderCode",bigOrderCode);
            map.put("bookCode",car.getBookCode());
            map.put("userCode",car.getUserCode());
            carDao.upCode(map);
        }
        return bigOrderCode;
    }

    /**
     * 扫码运行代码
     * 验签通过返回QrResponse
     * 失败打印日志信息
     * 参考地址：https://opendocs.alipay.com/apis/api_1/alipay.trade.app.pay
     *
     * @param model
     * @return
     */
    public QrCodeResponse qrcodePay(AlipayTradePrecreateModel model) {
        // 1: 获取阿里请求客户端
        AlipayClient alipayClient = getAlipayClient();
        // 2: 获取阿里请求对象
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        // 3：设置请求参数的集合，最大长度不限
        request.setBizModel(model);
        // 设置异步回调地址
        request.setNotifyUrl(alipayConfig.getNotify_url());
        // 设置同步回调地址
        request.setReturnUrl(alipayConfig.getReturn_url());
        AlipayTradePrecreateResponse alipayTradePrecreateResponse = null;
        try {
            alipayTradePrecreateResponse = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        QrResponse qrResponse = JSON.parseObject(alipayTradePrecreateResponse.getBody(), QrResponse.class);
        return qrResponse.getAlipay_trade_precreate_response();
    }
    /**
     * 获取AlipayClient对象
     *
     * @return
     */
    private AlipayClient getAlipayClient() {
        AlipayClient alipayClient =
                new DefaultAlipayClient(alipayConfig.getGatewayUrl(), alipayConfig.getApp_id(), alipayConfig.getMerchant_private_key(),
                        "JSON", alipayConfig.getCharset(), alipayConfig.getAlipay_public_key(), alipayConfig.getSign_type()); //获得初始化的AlipayClient
        return alipayClient;
    }
}
