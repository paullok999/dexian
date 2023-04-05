package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.PostVideo;
import com.kalok.dexian.portal.mapper.PostVideoMapper;
import com.kalok.dexian.portal.service.PostVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostVideoServiceImpl implements PostVideoService {

    @Autowired
    PostVideoMapper postVideoMapper;
    @Override
    public int deleteVideos(Long postId) {
        return postVideoMapper.deleteAllVideosByPostId(postId);
    }

    @Override
    public List<PostVideo> getPostVideosByPostId(Long postId) {
        return postVideoMapper.getAllVideosByPostId(postId);
    }

    @Override
    public int updatePostVideos(List<PostVideo> videos, Long postId) {
        return postVideoMapper.updateAllVideosByPostId(videos,postId);
    }

    @Override
    public int insertPostVideos(List<PostVideo> videos, Long postId) {
        return postVideoMapper.updateAllVideosByPostId(videos,postId);
    }
}
