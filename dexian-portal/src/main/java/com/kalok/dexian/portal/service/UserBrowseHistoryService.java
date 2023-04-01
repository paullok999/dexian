package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.domain.UserBrowseHistory;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserBrowseHistoryService {
    public Map<String, List<UserBrowseHistory>> getAllBrowseHistory();

    public void insertUserBrowseHistory(Long relationId,Integer historyType);

    int deleteBrowseHistory();
}
