package com.baizhi.service;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.UUDecoder;

import java.util.List;
import java.util.UUID;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDao carouselDao;
    @Override
    public List<Carousel> findCarouse() {
        return carouselDao.queryAll();
    }

    @Override
    public void modifyCarouse(Carousel carousel) {
        carouselDao.update(carousel);
    }

    @Override
    public void AddCarouse(Carousel carousel) {
        carousel.setCarousel_id(UUID.randomUUID().toString());
        carouselDao.insert(carousel);
    }

    @Override
    public void removeCarouse(String id) {
        carouselDao.delete(id);
    }

    @Override
    public Carousel findOne(String id) {
        return carouselDao.queryCarousel(id);
    }
}
