package com.baizhi.entity;

import java.util.Date;

public class Course {
    private String course_id;
    private String title;
    private String marking;
    private Date crateTime;

    public Course() {
    }

    public Course(String course_id, String title, String marking, Date crateTime) {
        this.course_id = course_id;
        this.title = title;
        this.marking = marking;
        this.crateTime = crateTime;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", title='" + title + '\'' +
                ", marking='" + marking + '\'' +
                ", crateTime=" + crateTime +
                '}';
    }
}
