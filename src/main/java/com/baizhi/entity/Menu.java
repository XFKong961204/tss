package com.baizhi.entity;

import java.util.List;

public class Menu {
    private String menu_id;
    private String title;
    private String iconCls;
    private String parent_id;
    private String href;
    private List<Menu> menus;

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id='" + menu_id + '\'' +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", href='" + href + '\'' +
                ", menus=" + menus +
                '}';
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu(String menu_id, String title, String iconCls, String parent_id, String href, List<Menu> menus) {
        this.menu_id = menu_id;
        this.title = title;
        this.iconCls = iconCls;
        this.parent_id = parent_id;
        this.href = href;
        this.menus = menus;
    }

    public Menu() {
    }
}
