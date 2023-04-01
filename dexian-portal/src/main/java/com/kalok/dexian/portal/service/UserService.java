package com.kalok.dexian.portal.service;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.domain.User;
import com.kalok.dexian.portal.dto.UserParam;

public interface UserService {
    CommonResult<User> login(String username, String password);

    User register(User user);

    int edit(UserParam userParam);
}
