package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Album> findAll(){
        List<Album> album = albumService.findAlbum();
        return album;
    }
    @RequestMapping("/addAlbum")
    public void addAlbum(Album album, MultipartFile addFile, HttpServletRequest request){
        String realPath=request.getSession().getServletContext().getRealPath("/uploadAlbum");
        String name = addFile.getOriginalFilename();
        new File(realPath).mkdir();
        try {
            addFile.transferTo(new File(realPath+"\\"+name));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        album.setCover(name);
        albumService.AddAlbum(album);
    }
    @RequestMapping("/deleteAlbum")
    @ResponseBody
    public void deleteAlbum(String albun_id){
        albumService.removeAlbu(albun_id);
    }


}
