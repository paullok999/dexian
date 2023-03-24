package com.kalok.dexian.portal.service;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.domain.User;

public interface UserService {
    CommonResult<User> login(String username, String password);

    User register(User user);
}
