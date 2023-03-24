package com.kalok.dexian.portal.domain;


import lombok.Data;

@Data
public class UserFollowerRelation {

  private Long id;
  private Long userId;
  private Long followerId;

}
