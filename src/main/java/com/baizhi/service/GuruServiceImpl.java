package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;
    @Override
    public List<Guru> findGuru() {
        return guruDao.queryAll();
    }

    @Override
    public void modifyArticle(Guru guru) {
        System.out.println(guru);
        guruDao.update(guru);
    }

    @Override
    public void AddGuru(Guru guru) {
        guruDao.insert(guru);
    }

    @Override
    public void removeGuru(String id) {
        guruDao.delete(id);
    }

    @Override
    public Guru findOne(String id) {
        return guruDao.queryById(id);
    }
}
