package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.entity.IdleItemVideo;

import java.util.List;

public interface IdleItemVideoService {
    int updateVideos(List<IdleItemVideo> videos, Long id);

    int deleteVideos(Long idleItemId);

    int insertVideos(List<IdleItemVideo> videos, Long id);

    List<IdleItemVideo> getAllVideosById(Long itemId);
}
