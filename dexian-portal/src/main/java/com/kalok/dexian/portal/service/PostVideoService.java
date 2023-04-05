package com.kalok.dexian.portal.service;



import com.kalok.dexian.portal.entity.PostVideo;

import java.util.List;

public interface PostVideoService {
    int deleteVideos(Long postId);

    List<PostVideo> getPostVideosByPostId(Long postId);

    int updatePostVideos(List<PostVideo> videos, Long postId);

    int insertPostVideos(List<PostVideo> videos,Long postId);
}
