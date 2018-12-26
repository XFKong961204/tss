package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService{
    List<Course> findCourse();
    void modifyCourse(Course course);
    void AddCourse(Course course);
    void removeCourse(String id);
}
