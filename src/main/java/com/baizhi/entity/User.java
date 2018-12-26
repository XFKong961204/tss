package com.baizhi.entity;

import java.util.Date;

/**
 * 用户表
 */
public class User {
    private String user_id;
    private String userName;
    private String passWord;
    private String realName;
    private String sex;
    private String dharmaName;
    private String profile;
    private String address;
    private String signature;
    private String phone;
    private String salt;
    private Date registerTime;

    public User() {
    }

    public User(String user_id, String userName, String passWord, String realName, String sex, String dharmaName, String profile, String address, String signature, String phone, String salt, Date registerTime) {
        this.user_id = user_id;
        this.userName = userName;
        this.passWord = passWord;
        this.realName = realName;
        this.sex = sex;
        this.dharmaName = dharmaName;
        this.profile = profile;
        this.address = address;
        this.signature = signature;
        this.phone = phone;
        this.salt = salt;
        this.registerTime = registerTime;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", profile='" + profile + '\'' +
                ", address='" + address + '\'' +
                ", signature='" + signature + '\'' +
                ", phone='" + phone + '\'' +
                ", salt='" + salt + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}
