package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService{
    List<User> findUser();
    void modifyUser(User user);
    void AddUser(User user);
    void removeUser(String id);
    User login(String userName,String passWord);
    List<Map<String,Integer>> query();

}
