package com.kalok.dexian.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/collect")
public class UserCollectController {

    /**
     * 获取指定类型的全部用户收藏
     */
    @RequestMapping(value = "/{type}",method = RequestMethod.POST)
    @ResponseBody
    public void getAllCollectsByType(@PathVariable("type")Integer collectType){

    }

    /**
     * TODO:加入收藏夹
     */
    public void addToCollect(){

    }
}
