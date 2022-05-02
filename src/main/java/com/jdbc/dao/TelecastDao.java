package com.jdbc.dao;

import com.jdbc.entity.Telecast;

import java.util.List;

public interface TelecastDao {
    void create(Telecast telecast);
    void update(Telecast telecast);
    void remove(Telecast telecast);
    List<Telecast> findAll();
    Telecast findById(Integer id);
    Telecast findByName(String name);
    Telecast findByRate(Integer rate);
    Telecast findByCostMinute(Double costMinute);
}
