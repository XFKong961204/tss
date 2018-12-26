package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;

public interface CounterService{
    List<Counter> findCounter();
    void modifyCounter(Counter counter);
    void AddCounter(Counter counter);
    void removeCounter(String id);
}
