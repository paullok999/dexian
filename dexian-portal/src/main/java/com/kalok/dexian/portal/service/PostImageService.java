package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.entity.PostImage;

import java.util.List;

public interface PostImageService {
    int deleteImages(Long postId);

    List<PostImage> getPostImagesByPostId(Long postId);

    int updatePostImages(List<PostImage> images, Long postId);

    int insertPostImages(List<PostImage> images,Long postId);
}
