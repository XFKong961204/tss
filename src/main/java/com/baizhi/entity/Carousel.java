package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 轮播图
 */

public class Carousel {
    private String carousel_id;
    private String title;
    private String cdesc;
    private String imgPath;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date crateTime;

    public Carousel() {
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "carousel_id='" + carousel_id + '\'' +
                ", title='" + title + '\'' +
                ", cdesc='" + cdesc + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", status='" + status + '\'' +
                ", crateTime=" + crateTime +
                '}';
    }

    public String getCarousel_id() {
        return carousel_id;
    }

    public void setCarousel_id(String carousel_id) {
        this.carousel_id = carousel_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Carousel(String carousel_id, String title, String cdesc, String imgPath, String status, Date crateTime) {
        this.carousel_id = carousel_id;
        this.title = title;
        this.cdesc = cdesc;
        this.imgPath = imgPath;
        this.status = status;
        this.crateTime = crateTime;
    }
}