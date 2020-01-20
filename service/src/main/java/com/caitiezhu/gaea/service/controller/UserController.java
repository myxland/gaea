package com.caitiezhu.gaea.service.controller;

import com.caitiezhu.gaea.service.common.Response;
import com.caitiezhu.gaea.service.model.dto.user.LoginDTO;
import com.caitiezhu.gaea.service.model.dto.user.RegisterDTO;
import com.caitiezhu.gaea.service.model.po.User;
import com.caitiezhu.gaea.service.model.vo.UserVO;
import com.caitiezhu.gaea.service.service.UserService;
import com.caitiezhu.gaea.service.utils.JedisUtil;
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

    @PostMapping("/register")
    public Response register(@RequestBody RegisterDTO registerDTO) {
        return userService.register(registerDTO);
    }

    @PostMapping("/login")
    public Response<UserVO> login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
}
