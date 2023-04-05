package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.dto.ForumPostCommentParam;
import com.kalok.dexian.portal.entity.ForumPostComment;

import java.util.List;

public interface ForumPostCommentService {
    List<ForumPostComment> getAllComments(Long postId);

    int addNewComment(Long parentCommentId, ForumPostCommentParam forumPostCommentParam);

    int addLikeCount(Long postId, Long commentId);

    int deleteComment(Long postId, Long commentId);
}
