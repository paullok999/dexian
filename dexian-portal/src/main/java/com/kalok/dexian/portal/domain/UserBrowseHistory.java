package com.kalok.dexian.portal.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserBrowseHistory {

  private Long id;
  private Long relationId;
  private Date browseTime;
  private Integer historyType;
}
