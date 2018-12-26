package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findAlbum();
    void modifyAlbum(Album album);
    void AddAlbum(Album album);
    void removeAlbu(String id);
}
