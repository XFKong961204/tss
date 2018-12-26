package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService{
    List<Menu> findMenu();
    void modifyMenu(Menu menu);
    void AddMenu(Menu menu);
    void removeMenu(String id);
}
