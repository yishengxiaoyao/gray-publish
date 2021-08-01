package com.edu.gray.controller;

import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaoyao.
 * @date 2021/7/31.
 * @time 10:42 PM.
 */
@RestController
@RequestMapping("/test")
public class EndpointRibbonController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/call")
  public String testCall() {
    System.out.println(RibbonFilterContextHolder.getCurrentContext().get("version"));
    return restTemplate.getForObject("http://endpoint-service/test/sms-test2", String.class);
  }

  @GetMapping("/test")
  public String test() {
    System.out.println("api-passenger-test");
    return "api-passenger";
  }
}
