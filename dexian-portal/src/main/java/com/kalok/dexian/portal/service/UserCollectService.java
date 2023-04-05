package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.entity.UserCollect;

import java.util.List;
import java.util.Map;

public interface UserCollectService {
    Map<String, Object> getAllCollects(Long userId, Integer collectType);

    int addToCollect(UserCollect userCollect);

    int deleteCollects(List<Long> collectIds);
}
