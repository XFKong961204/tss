package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;
    @Override
    public List<Chapter> findChapter() {
        return null;
    }

    @Override
    public void modifyChapter(Chapter chapter) {

    }

    @Override
    public void AddChapter(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        System.out.println("service"+chapter);
        chapterDao.insert(chapter);
    }

    @Override
    public void removeChapter(String id) {

    }
}
