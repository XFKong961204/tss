package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselService{
    List<Carousel> findCarouse();
    void modifyCarouse(Carousel carousel);
    void AddCarouse(Carousel carousel);
    void removeCarouse(String id);
    Carousel findOne(String id);
}
