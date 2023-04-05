package com.kalok.dexian.portal.entity;


import lombok.Data;

import java.util.Date;

@Data
public class ForumPost {

  private Long id;
  private Long userId;
  private String postContent;
  private Long browseCount;
  private Long collectCount;
  private Long likeCount;
  private Long commentCount;
  private Date releaseTime;


}
