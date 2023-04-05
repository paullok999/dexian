package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.ForumPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ForumPostMapper {
    int insertPost(@Param("forumPost") ForumPost forumPost);

    List<Long> getAllPostByUserId(@Param("userId") Long userId,@Param("isSort") Boolean isSortByReleaseDate);

    int updatePost(@Param("forumPost")ForumPost forumPost);

    int deletePost(@Param("postId") Long postId);

    ForumPost getPostByPostId(@Param("postId") Long postId);

    int likePostByPostId(@Param("postId")Long postId);

    int addBrowseCount(@Param("postId") Long postId);

    int addCollectCount(@Param("postId")Long postId);

    List<ForumPost> getPostByIds(List<Long> postIds);
}
