package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.dto.UserParam;
import com.kalok.dexian.portal.entity.User;
import com.kalok.dexian.portal.entity.UserSocialRelation;
import com.kalok.dexian.portal.mapper.UserSocialMapper;
import com.kalok.dexian.portal.service.UserService;
import com.kalok.dexian.portal.service.UserSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSocialServiceImpl implements UserSocialService {

    @Autowired
    UserSocialMapper userSocialMapper;

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public int follow(Long userId, Long anotherUserId) {
        //创建正向联系对象
        UserSocialRelation userSocialRelation1 = new UserSocialRelation(userId, anotherUserId, 0);
        //创建逆向联系对象
        UserSocialRelation userSocialRelation2 = new UserSocialRelation(anotherUserId, userId, 1);
        UserSocialRelation retVal = userSocialMapper.queryRelationWithType(userId,anotherUserId,0);
        if(retVal != null){
            //关系已存在,无法添加
            return -1;
        }
        //添加逆向关系
        int count1 = userSocialMapper.insertRelationWithType(userSocialRelation1);
        //添加正向关系
        int count2 = userSocialMapper.insertRelationWithType(userSocialRelation2);
        return count1 + count2;
    }

    @Transactional
    @Override
    public int unfollow(Long userId, Long anotherUserId) {
        int count1 = userSocialMapper.deleteRelationWithType(userId,anotherUserId,0);
        int count2 = userSocialMapper.deleteRelationWithType(anotherUserId,userId,1);
        return count1 + count2;
    }

    @Override
    public List<UserParam> getAllFollowers(Long userId) {
        List<UserSocialRelation> relations = userSocialMapper.getRelationWithType(userId,1);
        List<Long> followerIds = new ArrayList<Long>();
        for(UserSocialRelation relation : relations){
            followerIds.add(relation.getAnotherUserId());
        }
        if(followerIds.size() == 0){
            return null;
        }
        List<UserParam> users = userService.getUsersByUserIds(followerIds);
        return users;
    }

    @Override
    public List<UserParam> getAllFollowings(Long userId) {
        List<UserSocialRelation> relations = userSocialMapper.getRelationWithType(userId,0);
        List<Long> followingIds = new ArrayList<>();
        for(UserSocialRelation relation : relations){
            followingIds.add(relation.getAnotherUserId());
        }
        if(followingIds.size() == 0){
            return null;
        }
        List<UserParam> users = userService.getUsersByUserIds(followingIds);
        return users;
    }
}
