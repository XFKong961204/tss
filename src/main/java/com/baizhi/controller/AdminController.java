package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @RequestMapping("/login")
    public String login(String userName, String passWord, HttpSession session,String code,boolean rememberMe){
        if (session.getAttribute("Code").equals(code)) {
            Admin login = adminService.login(userName, passWord);
            session.setAttribute("login",login);
            try {
                Subject subject= SecurityUtils.getSubject();
                subject.login(new UsernamePasswordToken(userName,passWord,rememberMe));

            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
            return "main/main";
        }else {
            return "login";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("login");
        return "redirect:login";
    }

    @RequestMapping("update")
    public String update(String passWord,HttpSession session){
        Admin admin=new Admin();
        admin.setAdmin_id(UUID.randomUUID().toString());
        Admin login = (Admin) session.getAttribute("login");
        admin.setUserName(login.getUserName());
        admin.setRealName(login.getRealName());
        admin.setPassWord(passWord);
        adminService.modifyAdmin(admin);
        return "user/logout";
    }
}

