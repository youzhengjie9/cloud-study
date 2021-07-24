package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableConfigServer
public class springBootApplication {

  public static void main(String[] args) {

      /**
       * springcloud bus只需要发送post请求给config-server即可全部刷新
       * http://localhost:3331/actuator/bus-refresh
       */


      SpringApplication.run(springBootApplication.class,args);
  }
}
