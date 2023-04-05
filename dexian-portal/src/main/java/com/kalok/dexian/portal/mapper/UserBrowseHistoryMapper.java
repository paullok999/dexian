package com.kalok.dexian.portal.mapper;


import com.kalok.dexian.portal.entity.UserBrowseHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserBrowseHistoryMapper {
    List<UserBrowseHistory> getBrowseHistoryOrderByDate();

    int insertUserBrowseHistory(@Param("userBrowseHistory") UserBrowseHistory userBrowseHistory);

    Integer queryByRelationId(@Param("relationId") Long relationId);

    int updateUserBrowseHistory(@Param("userBrowseHistory")UserBrowseHistory userBrowseHistory);

    int deleteAllBrowseHistory();
}
