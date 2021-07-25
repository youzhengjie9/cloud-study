package com.boot.controller.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient("cloud-alibaba-user")
@RequestMapping(path = "/alibaba1")
public interface UserFeign {

    @ResponseBody
    @RequestMapping(path = "/port")
    public String curport();






}
