package com.boot.controller;

import com.boot.service.UserService;
import com.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/provider")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/userMoney/{username}")
    @ResponseBody
    public user userMoney(@PathVariable("username") String username){
        user user = userService.selectUserMoney(username);
        user.setUsername(username);
        return user;
    }

    @PostMapping(path = "/insertUser")
    @ResponseBody
    //因为前段传来的是json字符串不是json对象，所以要加@RequestBody注解使json字符串转换成Java对象
    public user userMoney(@RequestBody user user){

        userService.insertUser(user);

        return user;
    }

}
