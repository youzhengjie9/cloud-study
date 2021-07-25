package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 游政杰
 */
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现
public class SpringBootApplication2001 {

  public static void main(String[] args) {
      SpringApplication.run(SpringBootApplication2001.class,args);
  }
}
