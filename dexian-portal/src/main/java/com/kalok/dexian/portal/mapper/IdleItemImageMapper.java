package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.domain.IdleItemImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IdleItemImageMapper {
    List<IdleItemImage> getAllImagesById(@Param("itemId")Long itemId);

    void insertAllImagesByItemId(List<IdleItemImage> images,@Param("idleItemId") Long idleItemId);

    void deleteImagesById(@Param("itemId") Long idleItemId);

    void updateAllImagesByItemId(List<IdleItemImage> images, Long idleItemId);
}
