package com.boot.service.impl;

import com.boot.mapper.UserMapper;
import com.boot.service.UserService;
import com.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public user selectUserMoney(String username) {
        return userMapper.selectUserMoney(username);
    }

    @Override
    public void insertUser(user user) {
        userMapper.insertUser(user);
    }
}
