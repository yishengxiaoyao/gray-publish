package com.edu.gray.rule;

import com.edu.gray.parameter.RibbonParameter;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoyao.
 * @date 2021/7/31.
 * @time 10:24 PM.
 */
public class GrayLoadBalanceRule extends AbstractLoadBalancerRule {
  @Override
  public void initWithNiwsConfig(IClientConfig iClientConfig) {}

  @Override
  public Server choose(Object key) {
    return choose(getLoadBalancer(), key);
  }

  private Server choose(ILoadBalancer loadBalancer, Object key) {
    Server server = null;
    while (null == server) {
      List<Server> reachableServers = loadBalancer.getReachableServers();
      Map<String, String> map = RibbonParameter.get();
      String version = "";
      if (null != map && map.containsKey("version")) {
        version = map.get("version");
      }
      for (int i = 0; i < reachableServers.size(); i++) {
        server = reachableServers.get(i);
        Map<String, String> metaData =
            ((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata();
        String version1 = metaData.get("version");
        if (version.trim().equalsIgnoreCase(version1.trim())) {
          return server;
        }
      }
    }
    return server;
  }
}
