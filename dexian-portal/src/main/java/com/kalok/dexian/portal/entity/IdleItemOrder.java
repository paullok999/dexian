package com.kalok.dexian.portal.entity;



import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class IdleItemOrder {

  private Long id;
  private Long idleItemId;

  private Long userId;
  private Long addressId;

  private BigDecimal orderPrice;
  private Integer orderType;
  private Integer orderStatus;
  private Date createTime;
  private Date lastUpdateTime;
}
