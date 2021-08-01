package com.edu.gray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaoyao.
 * @date 2021/7/30.
 * @time 9:02 PM.
 */
@SpringBootApplication
@EnableEurekaClient
public class EndpointServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(EndpointServiceApplication.class, args);
  }
}
