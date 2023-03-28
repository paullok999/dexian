package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.domain.IdleItem;
import com.kalok.dexian.portal.domain.IdleItemImage;
import com.kalok.dexian.portal.domain.IdleItemVideo;
import com.kalok.dexian.portal.dto.IdleItemParam;
import com.kalok.dexian.portal.mapper.IdleItemImageMapper;
import com.kalok.dexian.portal.mapper.IdleItemMapper;
import com.kalok.dexian.portal.mapper.IdleItemVideoMapper;
import com.kalok.dexian.portal.service.IdleItemService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IdleItemServiceImpl implements IdleItemService {

    @Autowired
    IdleItemMapper idleItemMapper;
    @Autowired
    IdleItemImageMapper idleItemImageMapper;

    @Autowired
    IdleItemVideoMapper idleItemVideoMapper;

    @Override
    public Map<String, Object> getItemById(Long itemId) {
        Map<String,Object> resMap = new HashMap<String,Object>();
        IdleItem idleItem = idleItemMapper.getItemById(itemId);
        List<IdleItemImage> images = idleItemImageMapper.getAllImagesById(itemId);
        List<IdleItemVideo> videos = idleItemVideoMapper.getAllVideosById(itemId);
        /*不空才放入*/
        if(idleItem != null)resMap.put("item",idleItem);
        if(images.size() != 0)resMap.put("images",images);
        if(videos.size() != 0)resMap.put("videos",videos);
        return resMap;
    }
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int insertNewItem(IdleItemParam param, List<IdleItemImage> images, List<IdleItemVideo> videos) {
        IdleItem idleItem = copyProperties(param);
        int count = idleItemMapper.insertItem(idleItem);
        if(count == 0){
            //插入失败
            return -1;
        }
        //查询刚刚的插入成功的闲置物品ID(自动生成)
        //所获取集合按发布时间降序排序,我们只需要第一个
        List<Long> itemIds = idleItemMapper.getItemIdsByUserId(idleItem.getUserId(),true);
        insertImages(images,itemIds.get(0));
        insertVideos(videos,itemIds.get(0));
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
        deleteImages(idleItemId);
        //删除关联的视频
        deleteVideos(idleItemId);
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
        updateImages(images,idleItem.getId());
        updateVideos(videos,idleItem.getId());
        return count;
    }
    private IdleItem copyProperties(IdleItemParam param){
        IdleItem idleItem = new IdleItem();
        BeanUtils.copyProperties(param,idleItem);
        idleItem.setItemStatus(1);
        idleItem.setReleaseTime(new Date());
        return idleItem;
    }

    private void deleteVideos(Long idleItemId) {
        idleItemVideoMapper.deleteVideosById(idleItemId);
    }

    private void deleteImages(Long idleItemId) {
        idleItemImageMapper.deleteImagesById(idleItemId);
    }

    private void insertImages(List<IdleItemImage> images,Long idleItemId){
        idleItemImageMapper.insertAllImagesByItemId(images,idleItemId);
    }
    private void insertVideos(List<IdleItemVideo> videos,Long idleItemId){
        idleItemVideoMapper.insertAllVideosByItemId(videos,idleItemId);
    }

    private void updateImages(List<IdleItemImage> images,Long idleItemId){
        idleItemImageMapper.updateAllImagesByItemId(images,idleItemId);
    }
    private void updateVideos(List<IdleItemVideo> videos,Long idleItemId){
        idleItemVideoMapper.updateAllVideosByItemId(videos,idleItemId);
    }
}
