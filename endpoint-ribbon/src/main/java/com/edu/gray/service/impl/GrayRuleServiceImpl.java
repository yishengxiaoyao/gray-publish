package com.edu.gray.service.impl;

import com.edu.gray.domain.GrayRule;
import com.edu.gray.repository.GrayRuleRepository;
import com.edu.gray.service.GrayRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author xiaoyao.
 * @date 2021/7/30.
 * @time 2:36 PM.
 */
@Service
public class GrayRuleServiceImpl implements GrayRuleService {
  @Autowired private GrayRuleRepository ruleRepository;

  @Override
  public Optional<GrayRule> findGrayRuleByUserIdAndServiceName(Long userId, String serviceName) {
    return ruleRepository.findByUserIdAndServiceName(userId, serviceName);
  }

  @Override
  public Long countByUserIdAndServiceName(Long userId, String serviceName) {
    return ruleRepository.countByUserIdAndServiceName(userId, serviceName);
  }

  @Override
  public Optional<GrayRule> findGrayRuleByUserId(Long userId) {
    return ruleRepository.findByUserId(userId);
  }
}
