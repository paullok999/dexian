package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.domain.UserCollect;
import com.kalok.dexian.portal.service.UserCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/collect")
public class UserCollectController {

    @Autowired
    UserCollectService userCollectService;

    /**
     * 获取指定类型的全部用户收藏
     */
    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Map<String,Object>> getAllCollectsByType(@RequestParam("id")Long userId,
                                                                 @RequestParam("collectType")Integer collectType){
        Map<String,Object> map = userCollectService.getAllCollects(userId,collectType);
        if(map.size() > 0){
            return CommonResult.success(map,"获取收藏成功");
        }
        return CommonResult.success(null,"你啥都没收藏哟");
    }

    /**
     * TODO:加入收藏夹
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addToCollect(@RequestBody UserCollect userCollect){
        int count = userCollectService.addToCollect(userCollect);
        if(count > 0){
            return CommonResult.success("添加收藏成功~");
        }
        return CommonResult.success("添加收藏失败~");
    }

    /**
     * 取消收藏(可批量)
     * @param collectIds
     * @return
     */
    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelCollects(@RequestBody List<Long> collectIds){
        int count = userCollectService.deleteCollects(collectIds);
        if(count > 0){
            return CommonResult.success("取消收藏成功~");
        }
        return CommonResult.success("取消收藏失败~");
    }
}
