package com.atguigu.gulimall.member.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class GuliFeignConfig {

    @Bean("requestInterceptor")
    public RequestInterceptor requestInterceptor() {
        return template -> {
            //1.RequestContextHolder拿到request请求(通过threadLocal)
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();//旧请求
            //2.同步请求头信息Cookie
            String cookie = request.getHeader("Cookie");
            //给新请求同步cookie
            template.header("Cookie", cookie);
            //System.out.println("feign远程之前先进行requestInterceptor()");
        };
    }
}
