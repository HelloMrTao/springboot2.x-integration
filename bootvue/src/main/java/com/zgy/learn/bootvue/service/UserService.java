package com.zgy.learn.bootvue.service;

import com.zgy.learn.bootvue.mapper.UserMapper;
import com.zgy.learn.bootvue.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/8/5 1:25
 * @Modified by:
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    UserMapper mapper;

    public List<User> findAll() {
        return mapper.findAll();
    }

    public Integer saveUser(User user){
        return mapper.saveUser(user);
        // return mapper.insert(user);
    }
}
