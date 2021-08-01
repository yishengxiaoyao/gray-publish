package com.edu.zuul.domain;

import lombok.*;

import javax.persistence.*;
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
