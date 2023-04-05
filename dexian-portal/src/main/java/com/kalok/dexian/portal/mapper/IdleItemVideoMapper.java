package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.entity.IdleItemVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IdleItemVideoMapper {
    List<IdleItemVideo> getAllVideosById(@Param("itemId")Long itemId);

    int insertAllVideosByItemId(List<IdleItemVideo> videos,@Param("idleItemId") Long idleItemId);

    int deleteVideosById(@Param("itemId")Long idleItemId);

    int updateAllVideosByItemId(List<IdleItemVideo> videos, Long idleItemId);
}
