package com.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope //config client刷新注解
public class testController {

    /**
     * 用Postman发送下面的post请求
     * http://localhost:3332/actuator/refresh
     */

    @Value("${server.port}")
    private String port;

    @Value("${sys.version}")
    private String msg;


    @GetMapping(path = "/test")
    @ResponseBody
    public String test(){

        return port+"===>"+msg;
    }



}
