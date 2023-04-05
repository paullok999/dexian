package com.kalok.dexian.portal.entity;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ForumPostComment {

  private Long id;

  private Long postId;
  /**
   * 无父评论 -> parentCommentId = 0
   * 有父评论 -> parentCommentId = 父评论的ID
   */
  private Long parentCommentId;
  private Long userId;
  private String commentContent;
  private Long likeCount;
  private Date releaseTime;

  //子评论
  private List<ForumPostComment> childComments;

}
