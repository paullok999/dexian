package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.dto.ForumPostParam;
import com.kalok.dexian.portal.entity.ForumPost;
import com.kalok.dexian.portal.entity.PostImage;
import com.kalok.dexian.portal.entity.PostVideo;

import java.util.List;
import java.util.Map;

public interface ForumPostService {
    int releasePost(ForumPostParam forumPostParam, List<PostImage> images, List<PostVideo> videos);

    int updatePost(ForumPostParam forumPostParam, List<PostImage> images, List<PostVideo> videos);

    int deletePost(Long postId);

    Map<String, Object> getAllPostInfoByPostId(Long postId);

    int likePostByPostId(Long postId);

    int addCollectCount(Long postId);

    List<ForumPost> getPostByIds(List<Long> relationIds);
}
