package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.IdleItemImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IdleItemImageMapper {
    List<IdleItemImage> getAllImagesById(@Param("itemId")Long itemId);

    int insertAllImagesByItemId(List<IdleItemImage> images,@Param("idleItemId") Long idleItemId);

    int deleteImagesById(@Param("itemId") Long idleItemId);

    int updateAllImagesByItemId(List<IdleItemImage> images,@Param("idleItemId") Long idleItemId);

    List<IdleItemImage> getAllImages();
}
