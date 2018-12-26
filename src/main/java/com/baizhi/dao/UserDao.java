package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserDao extends BaseDao<User> {
    public User queryUser(String userName,String passWord);
    public List<Map<String,Integer>> query();
}
