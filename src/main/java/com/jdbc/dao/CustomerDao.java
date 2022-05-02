package com.jdbc.dao;

import com.jdbc.entity.Customer;

import java.util.List;

public interface CustomerDao {
    void create(Customer customer);
    void update(Customer customer);
    void remove(Customer customer);
    List<Customer> findAll();
    Customer findById(Integer id);
    Customer findByFirm(String firm);
    Customer findByContactPerson(String contactPerson);
    Customer findByTelephone(String telephone);
    Customer findByCode(Integer code);
}
