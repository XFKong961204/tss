package com.baizhi.dao;

import java.util.List;

public interface BaseDao<T> {
    public void insert(T t);

    public void update(T t);

    public void delete(String id);

    public List<T> queryAll();

}
