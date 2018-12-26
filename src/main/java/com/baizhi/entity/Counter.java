package com.baizhi.entity;

import java.util.Date;

public class Counter {
    private String counter_id;
    private String title;
    private Date createTime;
    private Integer count;
    private String course_id;
    private String user_id;

    public Counter() {
    }

    public Counter(String counter_id, String title, Date createTime, Integer count, String course_id, String user_id) {
        this.counter_id = counter_id;
        this.title = title;
        this.createTime = createTime;
        this.count = count;
        this.course_id = course_id;
        this.user_id = user_id;
    }

    public String getCounter_id() {
        return counter_id;
    }

    public void setCounter_id(String counter_id) {
        this.counter_id = counter_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "counter_id='" + counter_id + '\'' +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", count=" + count +
                ", course_id='" + course_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
