package com.loserbird.springboot.shiro.service;

import com.loserbird.springboot.shiro.model.User;

public interface UserService {

    User findByUsername(String username);
}
