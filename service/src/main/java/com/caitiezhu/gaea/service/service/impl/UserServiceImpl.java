package com.caitiezhu.gaea.service.service.impl;

import com.caitiezhu.gaea.service.common.Response;
import com.caitiezhu.gaea.service.dao.UserDAO;
import com.caitiezhu.gaea.service.enums.ErrorCode;
import com.caitiezhu.gaea.service.model.dto.user.LoginDTO;
import com.caitiezhu.gaea.service.model.po.User;
import com.caitiezhu.gaea.service.model.dto.user.RegisterDTO;
import com.caitiezhu.gaea.service.model.vo.UserVO;
import com.caitiezhu.gaea.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUser(Long userId) {
        return userDAO.getUser(userId);
    }

    @Override
    public Response register(RegisterDTO registerDTO) {
        int result = userDAO.insertUserInfo(registerDTO);
        if (result > 0) {
            return Response.build(ErrorCode.SUCCESS);
        }
        return Response.build(ErrorCode.FAIL);
    }

    @Override
    public Response<UserVO> login(LoginDTO loginDTO) {
        User user = userDAO.selectUser(loginDTO);
        if (user != null) {
            return Response.build(ErrorCode.SUCCESS, new UserVO().toVO(user));
        }
        return Response.build(ErrorCode.FAIL);
    }
}
