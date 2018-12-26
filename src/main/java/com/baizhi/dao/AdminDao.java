package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao extends BaseDao<Admin> {
    public Admin queryAdmin(String userName, String passWord);
    public Admin queryByUserName(String userName);

}
