package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.ForumPost;
import com.kalok.dexian.portal.entity.IdleItem;
import com.kalok.dexian.portal.entity.UserCollect;
import com.kalok.dexian.portal.mapper.IdleItemImageMapper;
import com.kalok.dexian.portal.mapper.IdleItemMapper;
import com.kalok.dexian.portal.mapper.UserCollectMapper;
import com.kalok.dexian.portal.service.ForumPostService;
import com.kalok.dexian.portal.service.IdleItemService;
import com.kalok.dexian.portal.service.UserCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCollectServiceImpl implements UserCollectService {

    @Autowired
    UserCollectMapper userCollectMapper;

    @Autowired
    IdleItemService idleItemService;

    @Autowired
    ForumPostService forumPostService;


    @Override
    public Map<String, Object> getAllCollects(Long userId, Integer collectType) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Long> relationIds = userCollectMapper.getRelationIds(userId,collectType);
        if(relationIds.size() == 0){
            return map;
        }
        if(collectType == 0){
            //收藏的是闲置物品
            List<IdleItem> items = idleItemService.getItemByIds(relationIds);
            map.put("items",items);
        }else if(collectType == 1){
            //收藏的是帖子
            List<ForumPost> posts = forumPostService.getPostByIds(relationIds);
            map.put("posts",posts);
        }
        return map;
    }


    @Transactional
    @Override
    public int addToCollect(UserCollect userCollect) {
        Integer collectType = userCollect.getCollectType();
        if(collectType == 0){
            //收藏的是闲置物品
            idleItemService.addCollectCount(userCollect.getRelationId());
        }else if(collectType == 1){
            //收藏的是帖子
            forumPostService.addCollectCount(userCollect.getRelationId());
        }
        return userCollectMapper.insertCollectRecord(userCollect);
    }

    @Override
    public int deleteCollects(List<Long> collectIds) {
        return userCollectMapper.deleteCollects(collectIds);
    }
}
