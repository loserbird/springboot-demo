package com.loserbird.springboot.shiro.service;

import com.loserbird.springboot.shiro.mapper.UserMapper;
import com.loserbird.springboot.shiro.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
