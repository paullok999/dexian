package com.kalok.dexian.portal.domain;


import lombok.Data;

import java.util.Date;

@Data
public class ForumPostComment {

  private Long id;
  private Long parentCommentId;
  private Long userId;
  private String commentContent;
  private Long likeCount;
  private Date releaseTime;

}
