package com.caitiezhu.gaea.service.dao;

import com.caitiezhu.gaea.service.model.po.User;
import com.caitiezhu.gaea.service.model.vo.RegisterVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {

    User getUser(@Param("userId") Long userId);

    int insertUserInfo(RegisterVO register);
}
