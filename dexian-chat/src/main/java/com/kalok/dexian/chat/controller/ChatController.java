package com.kalok.dexian.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kalok.dexian.chat.api.entity.User;
import com.kalok.dexian.chat.service.UserService;

import java.util.List;

/**
 * @author Hai
 * @date 2020/6/16 - 21:32
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
  @Autowired
  UserService userService;

  @GetMapping("/users")
  public List<User> getUsersWithoutCurrentUser(){
    return userService.getUsersWithoutCurrentUser();
  }
}
