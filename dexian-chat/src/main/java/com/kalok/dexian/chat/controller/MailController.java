package com.kalok.dexian.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kalok.dexian.chat.api.entity.Feedback;
import com.kalok.dexian.chat.api.entity.RespBean;
import com.kalok.dexian.chat.service.FeedbackService;


/**
 * 邮箱服务控制器
 * @author Hai
 * @date 2020/6/29 - 18:42
 */
@RestController
@RequestMapping("/mail")
public class MailController {


  @Autowired
  FeedbackService feedbackService;
  /**
   * 发送反馈消息给系统管理员
   * @param feedback
   * @return
   */
  @PostMapping("/feedback")
  public RespBean sendFeedbackToMail(@RequestBody Feedback feedback){
      try{
        feedbackService.sendMessage(feedback);
      }catch (Exception e){
        e.printStackTrace();
      }finally {
        return RespBean.ok("邮件发送成功！感谢你的反馈~");
      }
  }
}
