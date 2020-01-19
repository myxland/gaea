package com.caitiezhu.gaea.service.service;

import com.caitiezhu.gaea.service.common.Response;
import com.caitiezhu.gaea.service.model.dto.user.LoginDTO;
import com.caitiezhu.gaea.service.model.dto.user.RegisterDTO;
import com.caitiezhu.gaea.service.model.po.User;
import com.caitiezhu.gaea.service.model.vo.UserVO;

public interface UserService {
    User getUser(Long userId);

    Response register(RegisterDTO registerDTO);

    Response<UserVO> login(LoginDTO loginDTO);
}
