package com.leiduoduo.abss.util;


import com.leiduoduo.abss.pojo.ResultFormat;

public class ResultUtil {


    public static ResultFormat success(Object object) {
        ResultFormat result =new ResultFormat();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static ResultFormat success() {
        return success(null);
    }

    public static ResultFormat error(Integer code, String msg) {
        ResultFormat result =new ResultFormat();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}