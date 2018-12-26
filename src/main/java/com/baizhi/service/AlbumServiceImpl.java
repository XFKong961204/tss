package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public List<Album> findAlbum() {
        return albumDao.queryAll();
    }

    @Override
    public void modifyAlbum(Album album) {
        albumDao.update(album);
    }

    @Override
    public void AddAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDao.insert(album);
    }

    @Override
    public void removeAlbu(String id) {
        albumDao.delete(id);
    }
}
