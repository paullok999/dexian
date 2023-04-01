package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.domain.User;
import com.kalok.dexian.portal.dto.UserParam;
import com.kalok.dexian.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<User> login(@RequestBody User user){
        return userService.login(user.getUsername(),user.getPassword());
    }

    /**
     * 注册
     * @param user
     */
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody User user){
        User registered = userService.register(user);
        if(registered == null){
            return CommonResult.failed("注册失败");
        }
        return CommonResult.success(registered,"注册成功");
    }

    /**
     * 编辑用户信息
     * @param userParam
     * @return
     */
    @RequestMapping(path = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult edit(@RequestBody UserParam userParam){
        int count = userService.edit(userParam);
        if(count > 0){
            return CommonResult.success("编辑用户信息成功~");
        }
        return CommonResult.failed("编辑用户信息失败");
    }
}
