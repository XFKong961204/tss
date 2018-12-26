package com.baizhi.realm;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.UUDecoder;

import java.util.UUID;

public class MyRealm extends AuthenticatingRealm {
    @Autowired
    private AdminService adminService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken=(UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        Admin admin=adminService.queryAdmin(username);
        System.out.println(admin);
        if (admin!=null){
            SimpleAccount account = new SimpleAccount(admin.getUserName(), admin.getPassWord(), UUID.randomUUID().toString());
            System.out.println(account);
            return account;

        }
        return null;
    }
}
