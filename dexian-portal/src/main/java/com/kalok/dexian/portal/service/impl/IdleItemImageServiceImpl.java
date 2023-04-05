package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.portal.entity.IdleItemImage;
import com.kalok.dexian.portal.mapper.IdleItemImageMapper;
import com.kalok.dexian.portal.service.IdleItemImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdleItemImageServiceImpl implements IdleItemImageService {

    @Autowired
    IdleItemImageMapper idleItemImageMapper;
    @Override
    public int updateImages(List<IdleItemImage> images, Long id) {
        return idleItemImageMapper.updateAllImagesByItemId(images,id);
    }

    @Override
    public int deleteImages(Long idleItemId) {
        return idleItemImageMapper.deleteImagesById(idleItemId);
    }

    @Override
    public int insertImages(List<IdleItemImage> images, Long id) {
        return idleItemImageMapper.insertAllImagesByItemId(images,id);
    }

    @Override
    public List<IdleItemImage> getAllImagesById(Long itemId) {
        return idleItemImageMapper.getAllImagesById(itemId);
    }
}
