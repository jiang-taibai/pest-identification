package com.jsjds.mapper;

import com.jsjds.my.mapper.MyMapper;
import com.jsjds.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends MyMapper<User> {
}