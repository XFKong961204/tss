package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    public static int getMp3TrackLength(File mp3File) {
        System.out.println("我进来了");


        try {
            MP3File f = (MP3File) AudioFileIO.read(mp3File);
            MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
            System.out.println(audioHeader.getTrackLength());
            return audioHeader.getTrackLength();
        } catch (Exception e) {
            return -1;
        }
    }
    @RequestMapping("/addChapter")
    public void addChapter(String a_id, MultipartFile addFile, HttpServletRequest request){
        //获取文件名
        String filename=addFile.getOriginalFilename();
        //获取文件路径
        String realPath=request.getSession().getServletContext().getRealPath("/uploadChapter");
        new File(realPath).mkdir();
        File file=new File(realPath+"/"+filename);
        try {
                addFile.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        //获取文件大小
        String size= String.valueOf(addFile.getSize()/1024/1024+"M");
        //获取音频时长
        String durationM= String.valueOf(getMp3TrackLength(file)/60);
        String durationS= String.valueOf(getMp3TrackLength(file)%60);
        String duration=(durationM+"."+durationS+"分钟");

        Chapter chapter=new Chapter(null,filename,size,duration,null,realPath,a_id);
        chapterService.AddChapter(chapter);

    }

    @RequestMapping("/downloadChapter")
    @ResponseBody
    public void download(String title,HttpServletRequest request,HttpServletResponse response) throws IOException{
        //根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/uploadChapter");
        //根据文件名获取指定的文件的输入流
        FileInputStream is = new FileInputStream(new File(realPath+"/"+title));
        //设置响应头//attachment;以附件的形式下载  inline: 在线打开  注意:处理下载时的中文乱码   需要对中文文件名做网络编码
        response.setHeader("content-disposition", "attachment;fileName="+URLEncoder.encode(title,"UTF-8"));
        //获取输出流
        ServletOutputStream os = response.getOutputStream();
        //文件拷贝
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);//优雅的关闭流
        IOUtils.closeQuietly(os);//优雅的关闭流



    }



}
