package com.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggerConfig {

    //openFeign日志增强
    @Bean
    public Logger.Level feignLogger(){

        return Logger.Level.FULL;
    }



}
