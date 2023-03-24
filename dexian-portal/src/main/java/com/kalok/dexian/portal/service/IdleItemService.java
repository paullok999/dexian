package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.domain.IdleItemImage;
import com.kalok.dexian.portal.domain.IdleItemVideo;
import com.kalok.dexian.portal.dto.IdleItemParam;

import java.util.List;
import java.util.Map;

public interface IdleItemService {

    Map<String,Object> getItemById(Long itemId);

    int insertNewItem(IdleItemParam param, List<IdleItemImage> images, List<IdleItemVideo> videos);

    int changeStatus(Long itemId, Integer statusCode);

    int deleteItem(Long itemId);

    int updateItem(IdleItemParam idleItemParam, List<IdleItemImage> images, List<IdleItemVideo> videos);
}
