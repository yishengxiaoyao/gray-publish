package com.edu.zuul.service;

import com.edu.zuul.domain.GrayRule;

import java.util.Optional;

/**
 * @author xiaoyao.
 * @date 2021/7/30.
 * @time 2:35 PM.
 */
public interface GrayRuleService {
  /**
   * 根据用户编号、服务名称获取数据
   *
   * @param userId
   * @param serviceName
   * @return
   */
  Optional<GrayRule> findGrayRuleByUserIdAndServiceName(Long userId, String serviceName);

  /**
   * 根据用户变化获取
   * @param userId
   * @return
   */
  Optional<GrayRule> findGrayRuleByUserId(Long userId);

  /**
   * 根据用户编号、服务名称获取数量
   * @param userId
   * @param serviceName
   * @return
   */
  Long countByUserIdAndServiceName(Long userId,String serviceName);
}
