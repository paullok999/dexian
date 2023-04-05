package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.ForumPost;
import com.kalok.dexian.portal.dto.ForumPostParam;
import com.kalok.dexian.portal.entity.PostImage;
import com.kalok.dexian.portal.entity.PostVideo;
import com.kalok.dexian.portal.mapper.ForumPostMapper;
import com.kalok.dexian.portal.mapper.PostImageMapper;
import com.kalok.dexian.portal.mapper.PostVideoMapper;
import com.kalok.dexian.portal.service.ForumPostService;
import com.kalok.dexian.portal.service.PostImageService;
import com.kalok.dexian.portal.service.PostVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ForumPostServiceImpl implements ForumPostService {

    @Autowired
    private ForumPostMapper forumPostMapper;

    @Autowired
    private PostImageService postImageService;

    @Autowired
    private PostVideoService postVideoService;

    @Transactional
    @Override
    public int releasePost(ForumPostParam forumPostParam, List<PostImage> images, List<PostVideo> videos) {
        ForumPost forumPost = copyProperties(forumPostParam);
        int count = forumPostMapper.insertPost(forumPost);
        if(count == 0){
            //帖子内容插入失败,接下来都不用插入了
            return -1;
        }
        List<Long> postIds = forumPostMapper.getAllPostByUserId(forumPost.getUserId(),true);
        postImageService.insertPostImages(images,postIds.get(0));
        postVideoService.insertPostVideos(videos,postIds.get(0));
        return count;
    }

    @Transactional
    @Override
    public int updatePost(ForumPostParam forumPostParam, List<PostImage> images, List<PostVideo> videos) {
        ForumPost forumPost = copyProperties(forumPostParam);
        int count = forumPostMapper.updatePost(forumPost);
        if(count == 0){
            //帖子内容插入失败,接下来都不用插入了
            return -1;
        }
        postImageService.updatePostImages(images,forumPost.getId());
        postVideoService.updatePostVideos(videos,forumPost.getId());
        return count;
    }

    @Transactional
    @Override
    public int deletePost(Long postId) {
        postImageService.deleteImages(postId);
        postVideoService.deleteVideos(postId);
        return forumPostMapper.deletePost(postId);
    }

    @Transactional
    @Override
    public Map<String, Object> getAllPostInfoByPostId(Long postId) {
        Map<String, Object> map = new HashMap<String, Object>();
        ForumPost forumPost = forumPostMapper.getPostByPostId(postId);
        if(forumPost == null){
            //帖子已不存在,不需要再往下查了
            return map;
        }
        //修改浏览次数
        forumPostMapper.addBrowseCount(postId);
        map.put("post",forumPost);
        List<PostImage> images = postImageService.getPostImagesByPostId(postId);
        map.put("images",images);
        List<PostVideo> videos = postVideoService.getPostVideosByPostId(postId);
        map.put("videos",videos);
        return map;
    }

    @Override
    public int likePostByPostId(Long postId) {
        return forumPostMapper.likePostByPostId(postId);
    }

    @Override
    public int addCollectCount(Long postId) {
        return forumPostMapper.addCollectCount(postId);
    }

    @Override
    public List<ForumPost> getPostByIds(List<Long> relationIds) {
        return forumPostMapper.getPostByIds(relationIds);
    }


    private ForumPost copyProperties(ForumPostParam forumPostParam){
        ForumPost forumPost = new ForumPost();
        BeanUtils.copyProperties(forumPostParam,forumPost);
        forumPost.setReleaseTime(new Date());
        return forumPost;
    }
}
