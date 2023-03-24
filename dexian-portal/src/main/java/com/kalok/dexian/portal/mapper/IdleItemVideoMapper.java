package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.domain.IdleItemVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IdleItemVideoMapper {
    List<IdleItemVideo> getAllVideosById(@Param("itemId")Long itemId);

    void insertAllVideosByItemId(List<IdleItemVideo> videos,@Param("idleItemId") Long idleItemId);

    void deleteVideosById(@Param("itemId")Long idleItemId);

    void updateAllVideosByItemId(List<IdleItemVideo> videos, Long idleItemId);
}
