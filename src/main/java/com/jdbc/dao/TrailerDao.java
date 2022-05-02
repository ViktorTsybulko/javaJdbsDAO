package com.jdbc.dao;

import com.jdbc.entity.Customer;
import com.jdbc.entity.Trailer;

import java.sql.Time;
import java.util.List;

public interface TrailerDao {
    void create(Trailer trailer);
    void update(Trailer trailer);
    void remove(Trailer trailer);
    List<Trailer> findAll();
    Trailer findById(Integer id);
    Trailer findByName(String name);
    Trailer findByDuration(Time duration);
}
