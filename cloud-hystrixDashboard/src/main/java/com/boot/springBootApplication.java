package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard  //开启Hystrix仪表盘
public class springBootApplication {

  public static void main(String[] args) {
      SpringApplication.run(springBootApplication.class,args);

  }


}
