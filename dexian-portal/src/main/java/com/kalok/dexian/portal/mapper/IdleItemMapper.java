package com.kalok.dexian.portal.mapper;

import com.kalok.dexian.portal.domain.IdleItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IdleItemMapper {
    IdleItem getItemById(@Param("itemId") Long itemId);

    int insertItem(@Param("item") IdleItem idleItem);

    List<Long> getItemIdsByUserId(@Param("userId") Long userId,@Param("isSort") Boolean isSortByReleaseDate);

    int setStatusByItemId(@Param("itemId") Long itemId, @Param("statusCode") Integer statusCode);

    int deleteItemById(@Param("itemId") Long idleItemId);

    int updateItemById(@Param("item") IdleItem idleItem);

    List<IdleItem> getItemByIds(@Param("itemIds") List<Long> relationIds);
}
