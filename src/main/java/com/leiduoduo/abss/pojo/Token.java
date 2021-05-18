package com.leiduoduo.abss.pojo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class Token {
    public static final String Token_Secret = "123456";
    public String getToken(String userCode) {
        String token="";
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, 30);
        String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
        System.out.println(endDate);
        token= JWT.create().withAudience(userCode).withExpiresAt(now.getTime())
                .sign(Algorithm.HMAC256(Token_Secret));
        return token;
    }
}
