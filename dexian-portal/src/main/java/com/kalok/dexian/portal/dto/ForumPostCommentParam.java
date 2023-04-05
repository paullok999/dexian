package com.kalok.dexian.portal.dto;

import lombok.Data;

@Data
public class ForumPostCommentParam {

    private Long postId;
    private Long userId;
    private String commentContent;
}
