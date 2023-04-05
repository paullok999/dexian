package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.dto.ForumPostCommentParam;
import com.kalok.dexian.portal.entity.ForumPostComment;
import com.kalok.dexian.portal.mapper.ForumPostCommentMapper;
import com.kalok.dexian.portal.service.ForumPostCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumPostCommentServiceImpl implements ForumPostCommentService {

    @Autowired
    ForumPostCommentMapper forumPostCommentMapper;
    @Override
    public List<ForumPostComment> getAllComments(Long postId) {
        //获取指定帖子下的所有评论
        List<ForumPostComment> comments = forumPostCommentMapper.getAllCommentsByPostId(postId);
        //找出所有最上层评论(parentCommentId() == 0)
        List<ForumPostComment> rootComments = comments.stream().filter(curComment -> {
            return curComment.getParentCommentId() == 0;
        }).collect(Collectors.toList());
        //找出所有最上层评论的子评论,并将其赋值给最上层评论
        for(ForumPostComment rootComment : rootComments){
            rootComment.setChildComments(getChildComments(comments,rootComment));
        }
        //返回所有最上层评论
        return rootComments;
    }

    @Transactional
    @Override
    public int addNewComment(Long parentCommentId, ForumPostCommentParam forumPostCommentParam) {
        ForumPostComment comment = new ForumPostComment();
        comment.setReleaseTime(new Date());
        BeanUtils.copyProperties(forumPostCommentParam,comment);
        //当前评论是新的最顶级评论
        if(parentCommentId == null || parentCommentId == 0){
            comment.setParentCommentId(0L);
        }else{
            comment.setParentCommentId(parentCommentId);
        }
        return forumPostCommentMapper.insertComment(comment);
    }

    @Transactional
    @Override
    public int addLikeCount(Long postId, Long commentId) {
        return forumPostCommentMapper.addLikeCount(postId,commentId);
    }

    @Transactional
    @Override
    public int deleteComment(Long postId, Long rootCommentId) {
        //获取指定帖子下的所有评论
        List<ForumPostComment> comments = forumPostCommentMapper.getAllCommentsByPostId(postId);
        //除了删除当前这条评论,还有删除这条评论下的子评论
        List<Long> subCommentIds = new ArrayList<Long>(); //所有子评论的ID集合
        getSubCommentIds(subCommentIds,comments,rootCommentId);
        subCommentIds.add(rootCommentId);
        return forumPostCommentMapper.deleteComments(subCommentIds);
    }

    private void getSubCommentIds(List<Long> subCommentIds,List<ForumPostComment> comments, Long rootCommentId) {
        List<Long> childCommentIds = new ArrayList<Long>();//当前评论的子评论的ID集合
        for(ForumPostComment curComment : comments){
            if(curComment.getParentCommentId() == rootCommentId){
                childCommentIds.add(curComment.getId());
                subCommentIds.add(curComment.getId());
            }
        }
        for(Long curCommentId : childCommentIds){
            getSubCommentIds(subCommentIds,comments,curCommentId);
        }
    }

    private List<ForumPostComment> getChildComments(List<ForumPostComment> comments,ForumPostComment rootComment) {
        List<ForumPostComment> childComments = comments.stream().filter(curComment -> {
            //找出所有符合条件的第一级子评论
            return curComment.getParentCommentId() == rootComment.getId();
        }).map(curComment -> {
            //以递归形式查找当前评论的子评论
            curComment.setChildComments(getChildComments(comments,curComment));
            return curComment;
            //最后收集成list返回
        }).collect(Collectors.toList());
        return childComments;
    }
}
