package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.dto.UserParam;
import com.kalok.dexian.portal.service.UserSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/social")
@Controller
public class UserSocialController {

    @Autowired
    UserSocialService userSocialService;

    /**
     * 关注指定用户
     * @return
     */
    @RequestMapping(value = "/follow",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult follow(@RequestParam Long userId,
                               @RequestParam Long anotherUserId){
        int count = userSocialService.follow(userId,anotherUserId);
        if(count > 0){
            return CommonResult.success("关注成功~");
        }
        return CommonResult.failed("关注失败~");
    }

    /**
     * 取关指定用户
     * @return
     */
    @RequestMapping(value = "/unfollow",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult unfollow(@RequestParam Long userId,
                                 @RequestParam Long anotherUserId){
        int count = userSocialService.unfollow(userId,anotherUserId);
        if(count > 0){
            return CommonResult.success("取关成功~");
        }
        return CommonResult.failed("取关失败~");
    }
    /**
     *  获取指定用户的所有的粉丝
     */
    @RequestMapping(value = "/followers",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getAllFollowers(@RequestParam Long userId){
        List<UserParam> users = userSocialService.getAllFollowers(userId);
        if(users == null){
            return CommonResult.success("您还没有粉丝哟~");
        }
        return CommonResult.success(users,"获取粉丝成功~");
    }
    /**
     *  获取指定用户的所有关注的人
     */
    @RequestMapping(value = "/following",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getAllFollowings(@RequestParam Long userId){
        List<UserParam> users = userSocialService.getAllFollowings(userId);
        if(users == null){
            return CommonResult.success("您还没有关注的人哟~");
        }
        return CommonResult.success(users,"获取关注的人成功~");
    }

}
