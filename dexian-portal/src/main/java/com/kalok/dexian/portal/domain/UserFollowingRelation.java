package com.kalok.dexian.portal.domain;


import lombok.Data;

@Data
public class UserFollowingRelation {

  private Long id;
  private Long userId;
  private Long followingId;

}
