package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope //每一个“”使用到nacos配置中心的类“”都要加上，哪怕是service类，只要用到了nacos配置中心的配置就要加这个注解
@RequestMapping(path = "/alibaba")
public class UserController {

    @Value("${server.port}")
    private String port;



//    @Value("${sys.info}")
//    private String info;

    @ResponseBody
    @RequestMapping(path = "/port")
    public String curport(){

    //    System.out.println(info);


        return port;
    }







}
