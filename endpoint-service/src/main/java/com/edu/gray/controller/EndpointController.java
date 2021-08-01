package com.edu.gray.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoyao.
 * @date 2021/7/30.
 * @time 9:03 PM.
 */
@RestController
@RequestMapping("/test")
public class EndpointController {
  @Value("${server.port}")
  private String port;

  @GetMapping("/sms-test")
  public String test() {

    return "sms-test:" + port;
  }

  @GetMapping("/sms-test2")
  public String test2() {

    return "sms-test2:" + port;
  }

  @GetMapping("/sms-test3")
  public String test3() {

    return "sms-test3:" + port;
  }
}
