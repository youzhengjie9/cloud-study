package com.boot.controller;

import com.boot.controller.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/web")
public class WebController {

    @Autowired
    private UserFeign userFeign;

    @ResponseBody
    @GetMapping(path = "/port")
    public String port(){

        String curport = userFeign.curport();
        return curport;
    }


}
