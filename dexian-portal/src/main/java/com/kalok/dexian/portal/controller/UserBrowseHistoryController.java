package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.domain.UserBrowseHistory;
import com.kalok.dexian.portal.service.UserBrowseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/history")
@Controller
public class UserBrowseHistoryController {

    @Autowired
    private UserBrowseHistoryService userBrowseHistoryService;

    /**
     * 查询历史浏览记录
     */
    @RequestMapping(path = "/query",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Map<String, List<UserBrowseHistory>>> queryHistory(){
        Map<String, List<UserBrowseHistory>> map = userBrowseHistoryService.getAllBrowseHistory();
        if(map.size() == 0){
            return CommonResult.success(null,"最近没有浏览记录~");
        }
        return CommonResult.success(map,"查询浏览记录成功");
    }

    /**
     * 清空历史浏览记录
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteBrowseHistory(){
        int count = userBrowseHistoryService.deleteBrowseHistory();
        if(count > 0){
            return CommonResult.success("浏览记录已全部清空");
        }
        return CommonResult.success("没有浏览记录要清空哟");
    }

}
