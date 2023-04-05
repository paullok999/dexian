package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.entity.IdleItem;
import com.kalok.dexian.portal.entity.IdleItemImage;
import com.kalok.dexian.portal.entity.IdleItemVideo;
import com.kalok.dexian.portal.dto.IdleItemParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IdleItemService {

    Map<String,Object> getItemById(Long itemId);

    int releaseItem(IdleItemParam param, List<IdleItemImage> images, List<IdleItemVideo> videos);

    int changeStatus(Long itemId, Integer statusCode);

    int deleteItem(Long itemId);

    int updateItem(IdleItemParam idleItemParam, List<IdleItemImage> images, List<IdleItemVideo> videos);

    int addCollectCount(Long itemId);

    List<IdleItem> getItemByIds(List<Long> relationIds);
}
