package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.domain.IdleItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IdleItemMapper {
    IdleItem getItemById(@Param("itemId") Long itemId);

    int insertItem(@Param("item") IdleItem idleItem);

    Long getItemIdByUserId(@Param("userId") Long userId);

    int setStatusByItemId(@Param("itemId") Long itemId, @Param("statusCode") Integer statusCode);

    int deleteItemById(@Param("itemId") Long idleItemId);

    int updateItemById(@Param("item") IdleItem idleItem);
}
