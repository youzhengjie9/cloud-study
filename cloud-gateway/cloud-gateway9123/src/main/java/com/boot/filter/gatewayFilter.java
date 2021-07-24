package com.boot.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Map;

//@Component
//public class gatewayFilter implements GlobalFilter, Ordered {
//
//  private Logger logger = LoggerFactory.getLogger(gatewayFilter.class);
//
//  /** gateway全局过滤器只需要实现GlobalFilter, Ordered 并加上@Component注解即可生效 */
//  @Override
//  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//    Map<String, Object> attributes = exchange.getAttributes();
//    attributes.forEach(
//        (k, v) -> {
//          System.out.println(k + "==>" + v);
//        });
//
//    logger.info("gateway filter===>");
//
//      ServerHttpRequest request = exchange.getRequest();
//      String gateway = request.getQueryParams().getFirst("gateway");
//    if (gateway!=null) {
//      System.out.println("===========1");
//      return chain.filter(exchange); // 放行
//    } else {
//
//      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//      return exchange.getResponse().setComplete(); // 拦截
//    }
//  }
//
//  @Override
//  public int getOrder() {
//    return 0;
//  }
//}
