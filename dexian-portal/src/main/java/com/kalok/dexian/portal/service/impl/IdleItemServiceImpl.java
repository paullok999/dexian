package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.IdleItem;
import com.kalok.dexian.portal.entity.IdleItemImage;
import com.kalok.dexian.portal.entity.IdleItemVideo;
import com.kalok.dexian.portal.dto.IdleItemParam;
import com.kalok.dexian.portal.mapper.IdleItemImageMapper;
import com.kalok.dexian.portal.mapper.IdleItemMapper;
import com.kalok.dexian.portal.mapper.IdleItemVideoMapper;
import com.kalok.dexian.portal.service.IdleItemImageService;
import com.kalok.dexian.portal.service.IdleItemService;
import com.kalok.dexian.portal.service.IdleItemVideoService;
import com.kalok.dexian.portal.service.UserBrowseHistoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class IdleItemServiceImpl implements IdleItemService {

    @Autowired
    IdleItemMapper idleItemMapper;
    @Autowired
    IdleItemImageService idleItemImageService;
    @Autowired
    IdleItemVideoService idleItemVideoService;
    @Autowired
    UserBrowseHistoryService userBrowseHistoryService;

    @Override
    public Map<String, Object> getItemById(Long itemId) {
        Map<String,Object> resMap = new HashMap<String,Object>();
        IdleItem idleItem = idleItemMapper.getItemById(itemId);
        List<IdleItemImage> images = idleItemImageService.getAllImagesById(itemId);
        List<IdleItemVideo> videos = idleItemVideoService.getAllVideosById(itemId);
        /*不空才放入*/
        if(idleItem != null){
            resMap.put("item",idleItem);
            idleItemMapper.addBrowseCount(itemId);
            //插入历史记录(类型:闲置物品)
            userBrowseHistoryService.insertUserBrowseHistory(idleItem.getId(),0);
        }
        if(images.size() != 0)resMap.put("images",images);
        if(videos.size() != 0)resMap.put("videos",videos);
        return resMap;
    }
    @Transactional
    @Override
    public int releaseItem(IdleItemParam param, List<IdleItemImage> images, List<IdleItemVideo> videos) {
        IdleItem idleItem = copyProperties(param);
        int count = idleItemMapper.insertItem(idleItem);
        if(count == 0){
            //插入失败
            return -1;
        }
        //查询刚刚的插入成功的闲置物品ID(自动生成)
        //所获取集合按发布时间降序排序,我们只需要第一个
        List<Long> itemIds = idleItemMapper.getItemIdsByUserId(idleItem.getUserId(),true);
        idleItemImageService.insertImages(images,itemIds.get(0));
        idleItemVideoService.insertVideos(videos,itemIds.get(0));
        return count;
    }

    @Override
    public int changeStatus(Long itemId, Integer statusCode) {
        return idleItemMapper.setStatusByItemId(itemId,statusCode);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int deleteItem(Long idleItemId) {
        //删除闲置物品关联的图片
        idleItemImageService.deleteImages(idleItemId);
        //删除关联的视频
        idleItemVideoService.deleteVideos(idleItemId);
        return idleItemMapper.deleteItemById(idleItemId);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int updateItem(IdleItemParam idleItemParam, List<IdleItemImage> images, List<IdleItemVideo> videos) {
        IdleItem idleItem = copyProperties(idleItemParam);
        int count = idleItemMapper.updateItemById(idleItem);
        if(count == 0){
            //更新失败
            return -1;
        }
        //更新与闲置物品相关的图片和视频
        idleItemImageService.updateImages(images,idleItem.getId());
        idleItemVideoService.updateVideos(videos,idleItem.getId());
        return count;
    }

    @Override
    public int addCollectCount(Long itemId) {
        return idleItemMapper.addCollectCount(itemId);
    }

    @Override
    public List<IdleItem> getItemByIds(List<Long> relationIds) {
        return idleItemMapper.getItemByIds(relationIds);
    }

    @Override
    public List<IdleItem> getLatestIdleItems() {
        List<IdleItem> res = new ArrayList<IdleItem>();
        //按时间降序获取闲置物品
        List<IdleItem> items = idleItemMapper.getItemsByTime();
        List<IdleItemImage> images = idleItemImageService.getAllImages();
        //设置封面
        for(IdleItem item : items){
            Long curId = item.getId();
            for(IdleItemImage image : images){
                if(image.getIdleItemId() == curId){
                    item.setCover(image);
                    break;
                }
            }
        }
        return res;
    }

    private IdleItem copyProperties(IdleItemParam param){
        IdleItem idleItem = new IdleItem();
        BeanUtils.copyProperties(param,idleItem);
        idleItem.setItemStatus(1);
        idleItem.setReleaseTime(new Date());
        return idleItem;
    }
}
