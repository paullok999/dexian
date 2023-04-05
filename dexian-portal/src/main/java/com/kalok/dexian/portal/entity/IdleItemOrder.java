package com.kalok.dexian.portal.entity;



import lombok.Data;

import java.util.Date;

@Data
public class IdleItemOrder {

  private Long id;
  private Long idleItemId;

  private Long userId;
  private Long addressId;
  private Integer orderType;
  private Integer orderStatus;
  private Date createTime;
  private Date lastUpdateTime;
}
