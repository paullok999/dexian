package com.kalok.dexian.portal.controller;

import com.kalok.dexian.common.api.CommonResult;
import com.kalok.dexian.portal.dto.ForumPostCommentParam;
import com.kalok.dexian.portal.entity.ForumPostComment;
import com.kalok.dexian.portal.service.ForumPostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment")
@Controller
public class ForumPostCommentController {

    @Autowired
    ForumPostCommentService forumPostCommentService;

    /**
     * 获取指定文章下的所有评论
     * @param postId
     * @return
     */
    @RequestMapping(value = "/getAll/{postId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAllCommentsByPostId(@PathVariable("postId")Long postId){
        List<ForumPostComment> comments = forumPostCommentService.getAllComments(postId);
        if(comments.size() == 0){
            return CommonResult.success("当前文章暂无评论");
        }
        return CommonResult.success(comments,"获取评论成功");
    }

    /**
     * 在指定文章下的添加评论(或在某条评论下添加子评论)
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addComment(@RequestParam(required = false) Long parentCommentId,
                                   @RequestBody ForumPostCommentParam forumPostCommentParam){
        int count = forumPostCommentService.addNewComment(parentCommentId,forumPostCommentParam);
        if(count > 0){
            return CommonResult.success("评论成功");
        }
        return CommonResult.failed("评论失败");
    }

    /**
     * 点赞指定文章下的指定评论
     * @param postId
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/like",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult likeComment(@RequestParam("postId")Long postId,
                                    @RequestParam("commentId")Long commentId){
        int count = forumPostCommentService.addLikeCount(postId,commentId);
        if(count > 0){
            return CommonResult.success("点赞成功~");
        }
        return CommonResult.failed("点赞失败~");
    }

    /**
     * 删除评论
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteComment(@RequestParam("postId")Long postId,
                                      @RequestParam("commentId")Long commentId){
        int count = forumPostCommentService.deleteComment(postId,commentId);
        if(count > 0){
            return CommonResult.success("删除评论成功~");
        }
        return CommonResult.failed("删除评论失败~");
    }
}
