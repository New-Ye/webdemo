package com.songtian.webdemo.service.impl;

import com.songtian.webdemo.mapper.UserMapper;

import com.songtian.webdemo.pojo.User;
import com.songtian.webdemo.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public String login(String name,String pwd) {

        return userMapper.login(name,pwd);
    }



    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public int checkRegisterByName(String name) {
        return userMapper.checkRegisterByName(name);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public Integer updateMsg(User user) {

        return userMapper.updateMsg(user);
    }

    @Override
    public Integer checkPwd(int id) {
        return userMapper.checkPwd(id);
    }
}
