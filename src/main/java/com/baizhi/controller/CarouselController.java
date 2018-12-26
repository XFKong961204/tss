package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import com.baizhi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Carousel> findAll(){
        List<Carousel> carouselList = carouselService.findCarouse();
        return carouselList;
    }
    @RequestMapping("/remove")
    @ResponseBody
    public Result delete(String id){
        Result result = new Result();
        try {
            carouselService.removeCarouse(id);
            result.setSuccess(true);
            result.setMessage("数据已删除...");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return  result;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Result update(Carousel carousel){
        Result result = new Result();
        try {
            carouselService.modifyCarouse(carousel);
            result.setSuccess(true);
            result.setMessage("修改信息成功...");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/findOne")
    @ResponseBody
    public Carousel findOne(String id){
        Carousel one = carouselService.findOne(id);
        return one;
    }
    @RequestMapping("/addCarousel")
    @ResponseBody
    public void addCarousel(Carousel carousel,MultipartFile addFile,HttpServletRequest request){
        //上传轮播图
        System.out.println(carousel);
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
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
        carousel.setImgPath(name);
        carouselService.AddCarouse(carousel);
    }

    @RequestMapping("/modifyCarousel")
    @ResponseBody
    public void modifyCarousel(Carousel carousel,MultipartFile addFile,HttpServletRequest request){
        //上传轮播图
        System.out.println(addFile);
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
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
        carousel.setImgPath(name);
        carouselService.modifyCarouse(carousel);
    }

    @RequestMapping("/deleteCarousel")
    @ResponseBody
    public void deleteCarousel(String carousel_id, HttpServletRequest request){
        carouselService.removeCarouse(carousel_id);
    }

}
