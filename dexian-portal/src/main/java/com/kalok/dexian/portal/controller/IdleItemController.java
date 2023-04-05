package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.common.tool.MapAndObjectUtil;
import com.kalok.dexian.portal.entity.IdleItemImage;
import com.kalok.dexian.portal.entity.IdleItemVideo;
import com.kalok.dexian.portal.dto.IdleItemParam;
import com.kalok.dexian.portal.service.IdleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/item")
@Controller
public class IdleItemController {


    @Autowired
    IdleItemService idleItemService;

    /**
     * 获取闲置物品详细信息
     * @param itemId
     * @return
     */
    @RequestMapping(value = "/info/{itemId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Map<String,Object>> getCertainItemInfo(@PathVariable("itemId") Long itemId){
        Map<String, Object> map = idleItemService.getItemById(itemId);
        if(map.size() == 0){
            return CommonResult.failed("闲置物品信息不存在");
        }
        return CommonResult.success(map,"获取闲置物品信息成功");
    }

    /**
     * 发布闲置物品
     * @return
     */
    @RequestMapping(value = "/release",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult releaseItem(@RequestBody Map<String, Object> paramMap){
        Map<String,Object> idleItemMap = (Map<String, Object>) paramMap.get("idleItem");
        //调用工具类完成Map到对象的转换
        IdleItemParam idleItemParam = (IdleItemParam) MapAndObjectUtil.MapToObject(idleItemMap, IdleItemParam.class);
        List<IdleItemImage> images = (List<IdleItemImage>) paramMap.get("images");
        List<IdleItemVideo> videos = (List<IdleItemVideo>) paramMap.get("videos");
        int count = idleItemService.releaseItem(idleItemParam,images,videos);
        if(count > 0){
            return CommonResult.success("发布闲置物品成功");
        }
        return CommonResult.failed("发布闲置物品失败");
    }

    /**
     *  编辑闲置物品
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult editItem(@RequestBody Map<String,Object> paramMap){
        Map<String,Object> idleItemMap = (Map<String, Object>) paramMap.get("idleItem");
        //调用工具类完成Map到对象的转换
        IdleItemParam idleItemParam = (IdleItemParam) MapAndObjectUtil.MapToObject(idleItemMap, IdleItemParam.class);
        List<IdleItemImage> images = (List<IdleItemImage>) paramMap.get("images");
        List<IdleItemVideo> videos = (List<IdleItemVideo>) paramMap.get("videos");
        int count = idleItemService.updateItem(idleItemParam,images,videos);
        if(count > 0){
            return CommonResult.success("编辑闲置物品成功");
        }
        return CommonResult.failed("编辑闲置物品失败");
    }

    /**
     * 删除闲置物品
     * @param itemId
     * @return
     */
    @RequestMapping(value = "/delete/{itemId}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteItem(@PathVariable("itemId")Long itemId){
        int count = idleItemService.deleteItem(itemId);
        if(count > 0){
            return CommonResult.success("删除闲置物品成功");
        }
        return CommonResult.failed("删除闲置物品失败");
    }

    /**
     * 修改闲置物品状态
     * @param statusCode
     * @return
     */
    @RequestMapping("/changeStatus")
    @ResponseBody
    public CommonResult changeItemStatus(@RequestParam("itemId") Long itemId,
                                         @RequestParam("statusCode") Integer statusCode){
        int count = idleItemService.changeStatus(itemId,statusCode);
        if(count > 0){
            return CommonResult.success("闲置物品状态修改成功");
        }
        return CommonResult.failed("闲置物品状态修改失败");
    }
}
