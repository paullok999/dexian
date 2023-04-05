package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.entity.IdleItemImage;

import java.util.List;

public interface IdleItemImageService {
    int updateImages(List<IdleItemImage> images, Long id);

    int deleteImages(Long idleItemId);

    int insertImages(List<IdleItemImage> images, Long id);

    List<IdleItemImage> getAllImagesById(Long itemId);
}
