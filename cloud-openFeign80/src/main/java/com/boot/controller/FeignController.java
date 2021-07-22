package com.boot.controller;

import com.boot.feignService.UserFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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


    /*
   服务降级 ：降低不是核心业务的服务的优先级，减少资源的占用，给核心服务提供更多的资源
   一般来说，服务降级是在“”消费者“”端
   */

    //下面的接口是非核心业务，需要服务降级，因为处理下面业务要6秒，那么就是说会占用6秒的资源，但是下面不会核心业务，所以我们可以让它1.5秒
    //没有完成就返回fallback页面
    @ResponseBody
    @GetMapping(path = "/hystrixTimeout")
    @HystrixCommand(fallbackMethod="hystrixTimeoutFallback",commandProperties={
            //这个属性可以去  HystrixCommandProperties  抽象类去找
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")

    })
    //服务降级
    public String hystrixTimeout(){

        String s = userFeignService.hystrixTimeout();   //耗时6秒
        return s;
    }

    public String hystrixTimeoutFallback(){

        return "hystrixTimeoutFallback 服务降级";
    }

    /**
     * 服务熔断：可以在提供者端也可以在消费者端，这里选择在消费者端
     * 服务熔断过程：在一定时间内，随着服务调用失败次数越多，服务会降级，直到触发了熔断的条件就会由降级转成熔断，此时服务不可用
     * ，也就是访问这个服务接口都会进入fallback服务降级方法，而不会进入正常方法，直到一定时间过后，断路器会进入半开状态，直到成功率
     * 上升，才会由半开状态变成关闭状态，此时熔断恢复正常
     *
     *=============
     * 测试：
     * 连续请求：http://localhost/feign/timeoutBreak/0   并满足下面熔断条件
     * 然后立刻访问：http://localhost/feign/timeoutBreak/1  ，如果进入服务降级方法，则测试成功
     *
     */
    @GetMapping(path = "/timeoutBreak/{num}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "timeoutBreakHystrix",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //开启服务熔断功能
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数:10次
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期:10s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50") //失败率:这里是50%
            //****这个服务熔断条件是：10秒內10次请求失败5次就会熔断该服务
    })
    public String timeoutBreak(@PathVariable("num") int num){

        int i=10/num;   //模拟报错


        return "timeoutBreak--success";

    }

    public String timeoutBreakHystrix(@PathVariable("num") int num){

        return "timeoutBreakHystrix---服务熔断";
    }


}
