package com.boot.controller;

import com.boot.feign.TestFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(path = "/feign")
public class FeignController {

    @Resource
    private TestFeign testFeign;

    @RequestMapping(path = "/sentinelFeign")
    @ResponseBody
    public String sentinel_feign(){

        String s = testFeign.sentinelFeign();
        return s;
    }



}
