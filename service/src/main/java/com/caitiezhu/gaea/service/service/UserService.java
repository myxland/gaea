package com.caitiezhu.gaea.service.service;

import com.caitiezhu.gaea.service.common.Response;
import com.caitiezhu.gaea.service.model.po.User;
import com.caitiezhu.gaea.service.model.vo.RegisterVO;

public interface UserService {
    User getUser(Long userId);

    Response register(RegisterVO register);
}
