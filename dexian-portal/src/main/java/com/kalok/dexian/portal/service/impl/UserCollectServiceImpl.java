package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.domain.IdleItem;
import com.kalok.dexian.portal.domain.IdleItemImage;
import com.kalok.dexian.portal.domain.UserCollect;
import com.kalok.dexian.portal.mapper.IdleItemImageMapper;
import com.kalok.dexian.portal.mapper.IdleItemMapper;
import com.kalok.dexian.portal.mapper.UserCollectMapper;
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
    IdleItemMapper idleItemMapper;

    @Autowired
    IdleItemImageMapper idleItemImageMapper;
    @Autowired
    UserCollectMapper userCollectMapper;
    @Override
    public Map<String, Object> getAllCollects(Long userId, Integer collectType) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Long> relationIds = userCollectMapper.getRelationIds(userId,collectType);
        if(relationIds.size() == 0){
            return map;
        }
        if(collectType == 0){
            //收藏的是闲置物品
            List<IdleItem> items = idleItemMapper.getItemByIds(relationIds);
            map.put("items",items);
        }else if(collectType == 1){
            //TODO:收藏的是帖子
        }
        return map;
    }


    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int addToCollect(UserCollect userCollect) {
        return userCollectMapper.insertCollectRecord(userCollect);
    }

    @Override
    public int deleteCollects(List<Long> collectIds) {
        return userCollectMapper.deleteCollects(collectIds);
    }
}
