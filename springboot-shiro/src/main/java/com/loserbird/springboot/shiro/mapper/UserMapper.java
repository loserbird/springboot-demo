package com.loserbird.springboot.shiro.mapper;

import com.loserbird.springboot.shiro.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findByUsername(@Param("username") String username);
}
