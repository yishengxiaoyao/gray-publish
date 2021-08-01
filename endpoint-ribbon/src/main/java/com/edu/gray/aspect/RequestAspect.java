package com.edu.gray.aspect;

import com.edu.gray.domain.GrayRule;
import com.edu.gray.service.GrayRuleService;
import com.netflix.zuul.context.RequestContext;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author xiaoyao.
 * @date 2021/7/31.
 * @time 10:31 PM.
 */
@Aspect
@Component
public class RequestAspect {
  @Autowired private GrayRuleService grayRuleService;

  @Pointcut("execution(* com.edu.gray.controller..*Controller*.*(..))")
  private void anyMethod() {}

  /**
   * @Before(value = "anyMethod()") public void before(JoinPoint joinPoint) { HttpServletRequest
   * request = ((ServletRequestAttributes)
   * RequestContextHolder.getRequestAttributes()).getRequest(); String version =
   * request.getHeader("version"); Map<String, String> map = new HashMap<>(); map.put("version",
   * version); RibbonParameter.set(map); } 在启动类里面使用@RibbonClient注解的时候,需要打开。
   *
   * @param joinPoint
   */
  @Before(value = "anyMethod()")
  public void before(JoinPoint joinPoint) {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    long userId = Long.parseLong(request.getHeader("userId"));

    Optional<GrayRule> data = grayRuleService.findGrayRuleByUserId(userId);
    if (data.isPresent()) {
      RibbonFilterContextHolder.getCurrentContext().add("version", "v2");
    } else {
      RibbonFilterContextHolder.getCurrentContext().add("version", "v1");
    }
  }
}
