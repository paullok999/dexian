package com.kalok.dexian.portal.domain;


import lombok.Data;

import java.util.Date;

@Data
public class ForumPostReply {

  private Long id;
  private Long commentId;
  private Long userId;
  private String replyContent;
  private Long likeCount;
  private Date releaseTime;

}
