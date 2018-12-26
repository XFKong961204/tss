package com.baizhi.entity;

import java.util.Date;

public class Guru {
    private String guru_id;
    private String name;
    private String profile;
    private String sex;
    private String state;

    @Override
    public String toString() {
        return "Guru{" +
                "guru_id='" + guru_id + '\'' +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", sex='" + sex + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Guru(String guru_id, String name, String profile, String sex, String state) {
        this.guru_id = guru_id;
        this.name = name;
        this.profile = profile;
        this.sex = sex;
        this.state = state;
    }

    public Guru() {
    }

    public Guru(String guru_id, String name, String profile, String sex) {
        this.guru_id = guru_id;
        this.name = name;
        this.profile = profile;
        this.sex = sex;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
