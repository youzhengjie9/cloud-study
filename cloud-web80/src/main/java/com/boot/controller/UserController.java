package com.boot.controller;

import com.config.RestTemplateConfig;
import com.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
@RequestMapping(path = "/comsumer") // 消费者
@Import(RestTemplateConfig.class) // 导入其他模块的类才能让里面的bean放到当前模块的IOC容器中，因为每个模块的容器都是不同的
public class UserController {

  @Resource private RestTemplate restTemplate;


//  private static String userController_URL = "http://localhost:8001/provider/"; //单机版
  private static String userController_URL = "http://USER-PROVIDER/provider/";  //ribbon负载均衡

  @GetMapping(path = "/userMoney/{username}")
  @ResponseBody
  public user userMoney(@PathVariable("username") String username) {

    user user = restTemplate.getForObject(userController_URL + "userMoney/" + username, user.class);

    return user;
  }

  @PostMapping(path = "/insertUser")
  @ResponseBody
  public user userMoney(user user) {
    System.out.println(user);
    System.out.println("===");
    user user1 = restTemplate.postForObject(userController_URL + "insertUser", user, user.class);
    System.out.println(user1);
    return user1;
  }


  //测试ribbon负载均衡（默认轮询算法）
  @GetMapping(path = "/curPort")
  @ResponseBody
  public String curPort() {

    String curPort = restTemplate.getForObject(userController_URL+"curPort", String.class);

    return curPort;
  }

}
