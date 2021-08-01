package com.edu.gray.repository;

import com.edu.gray.domain.GrayRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author xiaoyao.
 * @date 2021/7/30.
 * @time 2:35 PM.
 */
public interface GrayRuleRepository extends JpaRepository<GrayRule, Long> {
  /**
   * 根据用户编号、服务名称获取数据
   *
   * @param userId
   * @param serviceName
   * @return
   */
  Optional<GrayRule> findByUserIdAndServiceName(long userId, String serviceName);

  Long countByUserIdAndServiceName(long userId, String serviceName);

  /**
   * 根据用户编号获取数据
   *
   * @param userId
   * @return
   */
  Optional<GrayRule> findByUserId(long userId);
}
