package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<Admin> findAdmin() {
        return null;
    }

    @Override
    public void modifyAdmin(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public void AddAdmin(Admin admin) {

    }

    @Override
    public void removeAdmin(String id) {

    }

    @Override
    public Admin login(String userName, String passWord) {
        return adminDao.queryAdmin(userName,passWord);
    }

    @Override
    public Admin queryAdmin(String userName) {
        return adminDao.queryByUserName(userName);
    }
}
