package com.songtian.webdemo.service;


import com.songtian.webdemo.pojo.User;

import java.util.List;

public interface UserService {

    String login(String name,String pwd);
//    boolean login(User user);

    int register(User user);

    int checkRegisterByName(String name);

    List<User> selectAll();

    Integer updateMsg(User user);

    Integer checkPwd(int id);
}
