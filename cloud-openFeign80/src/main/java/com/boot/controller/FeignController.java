package com.boot.controller;

import com.boot.feignService.UserFeignService;
import com.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/feign")
public class FeignController {

    @Autowired
    private UserFeignService userFeignService;


    @GetMapping(path = "/userMoney/{username}")
    @ResponseBody
    public user userMoney(@PathVariable("username") String username){

        user user = userFeignService.userMoney(username);
        return user;
    }

    @PostMapping(path = "/insertUser")
    @ResponseBody
    // 因为前段传来的是json字符串不是json对象，所以要加@RequestBody注解使json字符串转换成Java对象
    public user userMoney(@RequestBody user user){

        com.pojo.user user1 = userFeignService.userMoney(user);
        return user1;
    }

    @GetMapping(path = "/discovery")
    @ResponseBody
    public String discovery(){
        String discovery = userFeignService.discovery();
        return discovery;
    }

    @GetMapping(path = "/curPort")
    @ResponseBody
    public String curPort(){
        String s = userFeignService.curPort();
        return s;
    }

    //测试openFeign底层的ribbon超时
    @GetMapping(path = "/timeout")
    @ResponseBody
    public String timeout() {

        String timeout = userFeignService.timeout();

        return timeout;
    }

}
