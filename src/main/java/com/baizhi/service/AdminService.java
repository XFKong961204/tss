package com.baizhi.service;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminService{
    List<Admin> findAdmin();
    void modifyAdmin(Admin admin);
    void AddAdmin(Admin admin);
    void removeAdmin(String id);
    Admin login(String userName,String passWord);
    Admin queryAdmin(String userName);
}
