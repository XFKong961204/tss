package com.baizhi.dao;

import com.baizhi.entity.Guru;

public interface GuruDao extends BaseDao<Guru> {
    public Guru queryById(String id);
}
