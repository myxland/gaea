package com.caitiezhu.gaea.service.dao;

import com.caitiezhu.gaea.service.model.dto.user.LoginDTO;
import com.caitiezhu.gaea.service.model.dto.user.RegisterDTO;
import com.caitiezhu.gaea.service.model.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {

    User getUser(@Param("userId") Long userId);

    int insertUserInfo(RegisterDTO registerDTO);

    User selectUser(LoginDTO loginDTO);

}
