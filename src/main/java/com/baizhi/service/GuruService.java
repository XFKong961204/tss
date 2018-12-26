package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService{
    List<Guru> findGuru();
    void modifyArticle(Guru guru);
    void AddGuru(Guru guru);
    void removeGuru(String id);
    Guru findOne(String id);
}
