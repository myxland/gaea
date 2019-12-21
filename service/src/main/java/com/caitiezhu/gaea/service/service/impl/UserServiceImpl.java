package com.caitiezhu.gaea.service.service.impl;

import com.caitiezhu.gaea.service.dao.UserDAO;
import com.caitiezhu.gaea.service.model.User;
import com.caitiezhu.gaea.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public User getUser(Long userId) {
        return userDAO.getUser(userId);
    }
}
