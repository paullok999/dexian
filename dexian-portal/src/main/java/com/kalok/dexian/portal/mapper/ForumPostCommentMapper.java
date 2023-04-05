package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.ForumPostComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ForumPostCommentMapper {

    List<ForumPostComment> getAllCommentsByPostId(@Param("postId") Long postId);

    int insertComment(@Param("comment") ForumPostComment comment);

    int addLikeCount(@Param("postId")Long postId,@Param("commentId") Long commentId);

    int deleteComment(@Param("postId")Long postId,@Param("commentId") Long commentId);

    int deleteComments(@Param("commentIds") List<Long> commentIds);
}
