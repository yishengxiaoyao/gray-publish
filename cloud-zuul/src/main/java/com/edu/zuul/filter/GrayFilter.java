package com.edu.zuul.filter;

import com.edu.zuul.domain.GrayRule;
import com.edu.zuul.service.GrayRuleService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author xiaoyao.
 * @date 2021/7/30.
 * @time 2:27 PM.
 */
@Component
public class GrayFilter extends ZuulFilter {

  @Autowired private GrayRuleService grayRuleService;

  @Override
  public String filterType() {
    return FilterConstants.ROUTE_TYPE;
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext currentContext = RequestContext.getCurrentContext();
    HttpServletRequest request = currentContext.getRequest();
    long userId = Long.parseLong(request.getHeader("userId"));
    String servletPath = request.getServletPath();

    Optional<GrayRule> data = grayRuleService.findGrayRuleByUserId(userId);
    if (data.isPresent()
        && servletPath != null
        && servletPath.contains(data.get().getServiceName())) {
      RibbonFilterContextHolder.getCurrentContext().add("version", "v2");
    } else {
      RibbonFilterContextHolder.getCurrentContext().add("version", "v1");
    }
    return null;
  }
}
