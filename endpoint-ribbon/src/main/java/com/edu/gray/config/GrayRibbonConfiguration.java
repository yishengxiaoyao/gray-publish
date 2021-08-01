package com.edu.gray.config;

import com.edu.gray.rule.GrayLoadBalanceRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @author xiaoyao.
 * @date 2021/7/31.
 * @time 10:39 PM.
 */
public class GrayRibbonConfiguration {
  @Bean
  public IRule ribbonRule() {
    return new GrayLoadBalanceRule();
  }
}
