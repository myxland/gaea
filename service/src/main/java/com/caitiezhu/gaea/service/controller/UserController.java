package com.caitiezhu.gaea.service.controller;

import com.caitiezhu.gaea.service.model.User;
import com.caitiezhu.gaea.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public User getUser(@RequestParam("userId") Long userId) {
        return userService.getUser(userId);
    }
}
