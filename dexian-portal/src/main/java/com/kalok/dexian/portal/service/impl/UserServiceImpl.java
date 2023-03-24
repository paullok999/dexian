package com.kalok.dexian.portal.service.impl;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.mapper.UserMapper;
import com.kalok.dexian.portal.domain.User;
import com.kalok.dexian.portal.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonResult<User> login(String username, String password) {
        if(Strings.isEmpty(username) || Strings.isEmpty(password)){
            return CommonResult.failed("用户名或密码不能为空");
        }
        User user = userMapper.getUserByUserName(username);
        if(user == null){
            return CommonResult.failed("用户不存在");
        }else if(!user.getPassword().equals(password)){
            return CommonResult.failed("密码错误");
        }
        return CommonResult.success(user,"登录成功");
    }

    @Override
    public User register(User user) {
        String userName = user.getUsername();
        if(userName == null){
            return null;
        }
        User record = userMapper.getUserByUserName(userName);
        //若已经注册过了,则不注册了
        if(record != null) {
            return null;
        }
        user.setCreateTime(new Date());
        user.setLoginTime(null);
        userMapper.insertUser(user);
        return user;
    }



}
