package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.PostImage;
import com.kalok.dexian.portal.mapper.PostImageMapper;
import com.kalok.dexian.portal.service.PostImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageServiceImpl implements PostImageService {

    @Autowired
    PostImageMapper postImageMapper;
    @Override
    public int deleteImages(Long postId) {
        return postImageMapper.deleteAllImagesByPostId(postId);
    }

    @Override
    public List<PostImage> getPostImagesByPostId(Long postId) {
        return postImageMapper.getAllImagesByPostId(postId);
    }

    @Override
    public int updatePostImages(List<PostImage> images, Long postId) {
        return postImageMapper.updateAllImagesByPostId(images,postId);
    }

    @Override
    public int insertPostImages(List<PostImage> images, Long postId) {
        return postImageMapper.insertAllImagesByPostId(images,postId);
    }
}
