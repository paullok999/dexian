package com.kalok.dexian.portal.service;

import com.kalok.dexian.portal.dto.UserParam;

import java.util.List;

public interface UserSocialService {
    int follow(Long userId, Long anotherUserId);

    int unfollow(Long userId, Long anotherUserId);

    List<UserParam> getAllFollowers(Long userId);

    List<UserParam> getAllFollowings(Long userId);
}
