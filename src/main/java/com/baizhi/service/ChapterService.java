package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService{
    List<Chapter> findChapter();
    void modifyChapter(Chapter chapter);
    void AddChapter(Chapter chapter);
    void removeChapter(String id);
}
