package com.boot.controller;

import com.boot.service.UserService;
import com.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(path = "/provider")
public class UserController {

  @Autowired private UserService userService;

  @Autowired private DiscoveryClient discoveryClient;

  @Value("${server.port}")
  private String port;

  @GetMapping(path = "/userMoney/{username}")
  @ResponseBody
  public user userMoney(@PathVariable("username") String username) {
    user user = userService.selectUserMoney(username);
    user.setUsername(username);
    return user;
  }

  @PostMapping(path = "/insertUser")
  @ResponseBody
  // 因为前段传来的是json字符串不是json对象，所以要加@RequestBody注解使json字符串转换成Java对象
  public user userMoney(@RequestBody user user) {

    userService.insertUser(user);

    return user;
  }

  @GetMapping(path = "/discovery")
  @ResponseBody
  public String discovery() {

    System.out.println(discoveryClient);
    Iterator<String> iterator = discoveryClient.getServices().stream().iterator();

    while (iterator.hasNext()){
        String next = iterator.next();
        System.out.println(next);
        List<ServiceInstance> instances = discoveryClient.getInstances(next);
      System.out.println(instances);
    }


    return "success";
  }

  @GetMapping(path = "/curPort")
  @ResponseBody
  public String curPort() {


    return "当前端口："+port;
  }

  @GetMapping(path = "/timeout")
  @ResponseBody
  public String timeout() {

    try {
      Thread.sleep(3000);  //模拟提供者超时
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return "success";
  }


}
