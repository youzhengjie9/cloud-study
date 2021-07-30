package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //对spring提供的数据源进行排除，让seata来接管
@EnableDiscoveryClient
@EnableFeignClients
public class SpringBootApplication5001 {

  public static void main(String[] args) {
      SpringApplication.run(SpringBootApplication5001.class,args);
  }
}
