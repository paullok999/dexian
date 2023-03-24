package com.kalok.dexian.portal.domain;


import lombok.Data;

@Data
public class UserCollect {

  private Long id;
  private Long userId;
  private Long relationId;
  private Integer collectType;
}
