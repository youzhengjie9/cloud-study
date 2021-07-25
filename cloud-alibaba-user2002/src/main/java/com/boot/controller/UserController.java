package com.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope   //每一个“”使用到nacos配置中心的类“”都要加上
@RequestMapping(path = "/alibaba")
public class UserController {

    @Value("${server.port}")
    private String port;

    @ResponseBody
    @RequestMapping(path = "/port")
    public String curport(){

        return port;
    }




}
