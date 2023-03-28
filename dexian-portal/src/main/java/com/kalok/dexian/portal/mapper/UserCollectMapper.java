package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.domain.UserCollect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCollectMapper {
    public List<Long> getRelationIds(@Param("userId") Long userId, @Param("collectType") Integer collectType);

    int insertCollectRecord(@Param("collect") UserCollect userCollect);

    int deleteCollects(@Param("collectIds") List<Long> collectIds);
}
