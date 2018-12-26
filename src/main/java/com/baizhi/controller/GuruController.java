package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    //查所有
    @RequestMapping("findAll")
    @ResponseBody
    public List<Guru> findAll(){
        return guruService.findGuru();
    }
    //增加
    @RequestMapping("/addGuru")
    @ResponseBody
    public void addCarousel(Guru guru, MultipartFile addFile, HttpServletRequest request){
        System.out.println(guru);
        System.out.println(addFile);
        //上传轮播图
        String realPath = request.getSession().getServletContext().getRealPath("/uploadGuru");
        String name = addFile.getOriginalFilename();
        System.out.println(name);
        new File(realPath).mkdir();
        try {
            addFile.transferTo(new File(realPath+"/"+name));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        guru.setGuru_id(UUID.randomUUID().toString());
        guru.setProfile(name);
        guruService.AddGuru(guru);
    }
    //删除
    @RequestMapping("/deleteGuru")
    @ResponseBody
    public void deleteCarousel(String guru_id, HttpServletRequest request){
        guruService.removeGuru(guru_id);
    }

    //修改
    @RequestMapping("/updateGuru")
    public void updateGuru(Guru guru){
        System.out.println(guru);
        guruService.modifyArticle(guru);
    }
}

