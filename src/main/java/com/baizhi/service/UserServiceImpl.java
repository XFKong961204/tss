package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findUser() {
        return userDao.queryAll();
    }

    @Override
    public void modifyUser(User user) {
        userDao.update(user);
    }

    @Override
    public void AddUser(User user) {

        user.setUser_id(UUID.randomUUID().toString());
        userDao.insert(user);
    }

    @Override
    public void removeUser(String id) {
        userDao.delete(id);
    }

    @Override
    public User login(String userName,String passWord) {
        return userDao.queryUser(userName,passWord);
    }



    @Override
    public List<Map<String, Integer>> query() {
        List<Map<String, Integer>> query = userDao.query();
        return query;
    }

}
