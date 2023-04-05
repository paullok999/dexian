package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.IdleItemVideo;
import com.kalok.dexian.portal.mapper.IdleItemVideoMapper;
import com.kalok.dexian.portal.service.IdleItemImageService;
import com.kalok.dexian.portal.service.IdleItemVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdleItemVideoServiceImpl implements IdleItemVideoService {

    @Autowired
    IdleItemVideoMapper idleItemVideoMapper;

    @Override
    public int updateVideos(List<IdleItemVideo> videos, Long id) {
        return idleItemVideoMapper.updateAllVideosByItemId(videos,id);
    }

    @Override
    public int deleteVideos(Long idleItemId) {
        return idleItemVideoMapper.deleteVideosById(idleItemId);
    }

    @Override
    public int insertVideos(List<IdleItemVideo> videos, Long id) {
        return idleItemVideoMapper.insertAllVideosByItemId(videos,id);
    }

    @Override
    public List<IdleItemVideo> getAllVideosById(Long itemId) {
        return idleItemVideoMapper.getAllVideosById(itemId);
    }
}
