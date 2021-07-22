package com.boot.feignService;

import com.config.FeignLoggerConfig;
import com.pojo.user;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author 游政杰
 */
@Component //让feign客户端被spring扫描
@FeignClient(value = "USER-PROVIDER") // 值就是提供者的微服务名称
@RequestMapping(path = "/provider")  //这个映射路径别忘了写
public interface UserFeignService {

  @GetMapping(path = "/userMoney/{username}")
  @ResponseBody
  public user userMoney(@PathVariable("username") String username);

  @PostMapping(path = "/insertUser")
  @ResponseBody
  // 因为前段传来的是json字符串不是json对象，所以要加@RequestBody注解使json字符串转换成Java对象
  public user userMoney(@RequestBody user user);

  @GetMapping(path = "/discovery")
  @ResponseBody
  public String discovery();

  @GetMapping(path = "/curPort")
  @ResponseBody
  public String curPort();

  @GetMapping(path = "/timeout")
  @ResponseBody
  public String timeout() ;

  /*
   服务降级 ：降低不是核心业务的服务的优先级，减少资源的占用，给核心服务提供更多的资源
   一般来说，服务降级是在“”消费者“”端
   */

  //下面的接口是非核心业务，需要服务降级
  @ResponseBody
  @GetMapping(path = "/hystrixTimeout")
  public String hystrixTimeout();





}
