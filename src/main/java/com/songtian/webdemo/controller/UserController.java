package com.songtian.webdemo.controller;


import com.songtian.webdemo.pojo.User;


import com.songtian.webdemo.service.UserService;
import com.sun.org.apache.bcel.internal.generic.L2I;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


/*    @RequestMapping("/login")
    public String login(User user, HttpSession httpSession, ModelMap map) {

        String name = user.getName();
        String pwd = user.getPwd();
        User userData = userService.login(user);

        if (userData != null) {


            if (userData.getPwd().equals(pwd)) {
                map.put("msg", name + "登录成功");
                httpSession.setAttribute("name", name);
                return "index";
            } else {
                map.put("msg", "密码错误");

            }
        }
        return "login";
    }*/


    @RequestMapping("/toLogin")
    public String login() {

        return "login";
    }

    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    @ResponseBody
    @RequestMapping("/login")
    public HashMap login(String name, String pwd) {
        System.out.println("开始异步登录");
        HashMap m = new HashMap();
        boolean mark = false;
        if (userService.login(name, pwd) != null) {
            mark = true;
        }
        m.put("mark", mark);
        System.out.println(mark);
        return m;
    }


    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }


    @ResponseBody
    @RequestMapping("/checkRegister")
    public HashMap CheckRegister(String name, User user, ModelMap map) {
        HashMap m = new HashMap();
        boolean mark = false;
        System.out.println(name);
        if (name != "" && name != null) {
            if (userService.checkRegisterByName(name) == 0) {
                //userService.register(user);
                //System.out.println(user.toString());
                mark = true;
            }
        }
        m.put("mark", mark);

        return m;

    }

/*
    @ResponseBody
    @RequestMapping("/register")
    public boolean register(User user,ModelMap modelMap){
        boolean mark=false;
        System.out.println(user.toString());
        if (userService.register(user)){
            System.out.println(userService.register(user));
            mark=true;
        }
        return mark;
    }
*/

    @RequestMapping("/register")
    public String register(User user) {
        userService.register(user);
        System.out.println(user.getBirthDate());
        return "redirect:index";
    }

    @RequestMapping("/selectAll")
    public String SelectAll(HttpSession session,Model model){
        List<User> userList=userService.selectAll();
        //model.addAttribute("userlist",userList);
        session.setAttribute("selectAll",userList);
        System.out.println(userList);
        return "index";
    }

/*    @RequestMapping("/toUpdate")
    public String ToUpdate(){
        return "update";
    }*/


    @RequestMapping("/checkPwd")
    public Boolean CheckPwd(int id,ModelMap modelMap){
        boolean mark=false;
        int i=userService.checkPwd(id);
        if (i > 0) {
            mark=true;
        }
        return mark;
    }


    @RequestMapping("/updateMsg")
    public String UpdateMsg(User user,ModelMap modelMap){
        int i=userService.updateMsg(user);
        if (i > 0) {
            modelMap.put("update_msg", "更新成功");
        } else {
            modelMap.put("update_msg", "更新失败");
            return "update";
        }
        return "index";

    }



}
