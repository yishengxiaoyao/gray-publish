package com.edu.gray.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author xiaoyao.
 * @date 2021/7/30.
 * @time 2:32 PM.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GrayRule implements Serializable {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private Long userId;
  private String serviceName;
  private String metaVersion;
}
