package com.kalok.dexian.portal.controller;


import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.common.tool.MapAndObjectUtil;
import com.kalok.dexian.portal.dto.ForumPostParam;
import com.kalok.dexian.portal.entity.PostImage;
import com.kalok.dexian.portal.entity.PostVideo;
import com.kalok.dexian.portal.service.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/post")
@Controller
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;

    /**
     * 查询指定帖子的信息
     * @return
     */
    @RequestMapping(value = "/query/{postId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Map<String,Object>> queryPost(@PathVariable("postId")Long postId){
        Map<String,Object> map = forumPostService.getAllPostInfoByPostId(postId);
        if(map.size() == 0){
            return CommonResult.failed("您要查询的帖子不存在~");
        }
        return CommonResult.success(map,"查询帖子成功");
    }

    /**
     * 发布帖子
     * @return
     */
    @RequestMapping(value = "/release",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult releasePost(@RequestBody Map<String,Object> paramMap){
        Map<String, Object> forumPostMap = (Map<String, Object>) paramMap.get("forumPost");
        ForumPostParam forumPostParam = (ForumPostParam) MapAndObjectUtil.MapToObject(forumPostMap, ForumPostParam.class);
        List<PostImage> images = (List<PostImage>) paramMap.get("images");
        List<PostVideo> videos = (List<PostVideo>) paramMap.get("videos");
        int count = forumPostService.releasePost(forumPostParam,images,videos);
        if(count > 0){
            return CommonResult.success("发布帖子成功");
        }
        return CommonResult.failed("发布帖子失败");
    }
    /**
     * 修改帖子
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult editPost(@RequestBody Map<String,Object> paramMap){
        Map<String, Object> forumPostMap = (Map<String, Object>) paramMap.get("forumPost");
        ForumPostParam forumPostParam = (ForumPostParam) MapAndObjectUtil.MapToObject(forumPostMap, ForumPostParam.class);
        List<PostImage> images = (List<PostImage>) paramMap.get("images");
        List<PostVideo> videos = (List<PostVideo>) paramMap.get("videos");
        int count = forumPostService.updatePost(forumPostParam,images,videos);
        if(count > 0){
            return CommonResult.success("修改帖子成功");
        }
        return CommonResult.failed("修改帖子失败");
    }
    /**
     * 删除帖子
     * @return
     */
    @RequestMapping(value = "/delete/{postId}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deletePost(@PathVariable("postId")Long postId){
        int count = forumPostService.deletePost(postId);
        if(count > 0){
            return CommonResult.success("删除帖子成功");
        }
        return CommonResult.failed("删除帖子失败");
    }
    /**
     * 点赞帖子
     * TODO:引入Redis来缓存点赞数,降低访问数据库的频率
     * @return
     */
    @RequestMapping(value = "/like/{postId}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult likePost(@PathVariable("postId")Long postId){
        int count = forumPostService.likePostByPostId(postId);
        if(count > 0){
            return CommonResult.success("点赞成功~");
        }
        return CommonResult.failed("点赞失败");
    }

}
