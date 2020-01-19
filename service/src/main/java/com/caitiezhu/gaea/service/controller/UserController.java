package com.caitiezhu.gaea.service.controller;

import com.caitiezhu.gaea.service.common.Response;
import com.caitiezhu.gaea.service.model.po.User;
import com.caitiezhu.gaea.service.model.vo.RegisterVO;
import com.caitiezhu.gaea.service.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public User getUser(@RequestParam("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("register")
    public Response register(@RequestBody RegisterVO register) {
        return userService.register(register);
    }
}
