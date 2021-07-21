package com.boot;

import com.config.FeignLoggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients  //开启openFeign的客户端
@Import(FeignLoggerConfig.class)   //导入Feign的日志增强配置类
public class springBootApplication {

  public static void main(String[] args) {
      SpringApplication.run(springBootApplication.class,args);
  }

}
