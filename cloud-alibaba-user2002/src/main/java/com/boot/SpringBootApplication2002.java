package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 游政杰
 */
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现
public class SpringBootApplication2002 {

  public static void main(String[] args) {
      SpringApplication.run(SpringBootApplication2002.class,args);
  }
}
