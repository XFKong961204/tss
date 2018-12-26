package com.baizhi.entity;

/**
 * 管理员表
 */
public class Admin {
    private String Admin_id;
    private String userName;
    private String passWord;
    private String realName;

    @Override
    public String toString() {
        return "Admin{" +
                "Admin_id='" + Admin_id + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public Admin() {
    }

    public Admin(String admin_id, String userName, String passWord, String realName) {
        Admin_id = admin_id;
        this.userName = userName;
        this.passWord = passWord;
        this.realName = realName;
    }

    public String getAdmin_id() {
        return Admin_id;
    }

    public void setAdmin_id(String admin_id) {
        Admin_id = admin_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
