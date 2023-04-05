package com.kalok.dexian.portal.entity;


import lombok.Data;

@Data
public class UserSocialRelation {

  private Long id;
  private Long userId;
  private Long anotherUserId;
  /**
   * 0 -> userId对应的用户关注anotherUserId对应的用户
   * 1 -> userId对应的用户被anotherUserId对应的用户所关注
   */
  private Integer relationType;

  public UserSocialRelation(Long userId, Long anotherUserId, Integer relationType) {
    this.userId = userId;
    this.anotherUserId = anotherUserId;
    this.relationType = relationType;
  }
}
