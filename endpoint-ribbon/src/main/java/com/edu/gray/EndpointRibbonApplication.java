package com.edu.gray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaoyao.
 * @date 2021/7/31.
 * @time 10:22 PM.
 */
@SpringBootApplication
/**
 * @RibbonClient(name = "endpoint-service",configuration = GrayRibbonConfiguration.class)
 * 如果没有使用ribbon-discovery-filter-spring-cloud-starter 依赖的时候,需要写上上面的注解
 * 如果使用ribbon-discovery-filter-spring-cloud-starter,需要添加jpa的依赖
 */
public class EndpointRibbonApplication {
  public static void main(String[] args) {
    SpringApplication.run(EndpointRibbonApplication.class, args);
  }

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
