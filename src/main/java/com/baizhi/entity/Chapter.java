package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 章节
 */
public class Chapter {
    private String id;
    private String title;
    private String size;
    private String duration;
    @JSONField(format="yyyy-MM-dd")
    private Date uploadDate;
    private String downPath;
    private String a_id;

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", uploadDate=" + uploadDate +
                ", downPath='" + downPath + '\'' +
                ", a_id='" + a_id + '\'' +
                '}';
    }

    public Chapter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public Chapter(String id, String title, String size, String duration, Date uploadDate, String downPath, String a_id) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.uploadDate = uploadDate;
        this.downPath = downPath;
        this.a_id = a_id;
    }
}