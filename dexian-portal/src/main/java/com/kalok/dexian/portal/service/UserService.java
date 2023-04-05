package com.kalok.dexian.portal.service;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.entity.User;
import com.kalok.dexian.portal.dto.UserParam;

import java.util.List;

public interface UserService {
    CommonResult<User> login(String username, String password);

    User register(User user);

    int edit(UserParam userParam);

    List<UserParam> getUsersByUserIds(List<Long> userIds);
}
