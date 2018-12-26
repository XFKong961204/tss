package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(String userName,String passWord){
        User user=userService.login(userName,passWord);
        return "main/main";
    }

    @RequestMapping("register")
    public String register(User user){
        user.setSalt(Md5.MD5(user.getPassWord()));
        userService.AddUser(user);
        return "cmfzuser/login";

    }
    @RequestMapping("update")
    public String update(User user){
        userService.modifyUser(user);
        return "login";
    }
    @ResponseBody
    @RequestMapping("/queryCity")
    public List<Map<String,Integer>> queryCity(){
        List list=new ArrayList();
        List<Map<String, Integer>> query = userService.query();

        return query;

    }

}
