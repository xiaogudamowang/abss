package com.leiduoduo.abss.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.leiduoduo.abss.annotation.PassToken;
import com.leiduoduo.abss.annotation.UserLoginToken;
import com.leiduoduo.abss.pojo.Token;
import com.leiduoduo.abss.pojo.User;
import com.leiduoduo.abss.service.UserService;
import com.leiduoduo.abss.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("authorization");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.flag()) {
                return true;
            }
        }
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.flag()) {
                log.info("token===================================>"+token);
                String[] tokens =token.split(" ");
                // token = tokens[1];
                log.info(JWT.decode(token).getPayload());
                log.info(JWT.decode(token).getAudience().get(0));
                if (null == token){
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html; charset=utf-8");
                    response.getWriter().write(JSON.toJSONString(ResultUtil.error(401,"user no login")));
                    log.info("-------------------------->用户未登录");
                    return false;
                }
                String userCode = null;
                try {
                    userCode = JWT.decode(token).getAudience().get(0);
                    System.out.println(userCode);
                    for (String s : JWT.decode(token).getAudience()) {
                        log.info("tokenplayload------------------>"+s);
                    }
                } catch (JWTDecodeException e) {
                    e.printStackTrace();
                }
                User user = userService.getUserByCode(userCode);
                if (null == user) {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html; charset=utf-8");
                    response.getWriter().write(JSON.toJSONString(ResultUtil.error(401,"用户不存在")));
                    return false;
                }
//              判断token过期
                Date espDate = JWT.decode(token).getExpiresAt();
                Date nowDate = new Date();
                log.info("expDate=======================>"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(espDate));
                if (nowDate.compareTo(espDate) > 0) {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html; charset=utf-8");
                    response.getWriter().write(JSON.toJSONString(ResultUtil.error(401,"token已过期")));
                    return false;
                }
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(Token.Token_Secret)).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}