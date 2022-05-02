package com.jdbc.dao.impl;

import com.jdbc.dao.AbstractJdbcDao;
import com.jdbc.dao.CustomerDao;
import com.jdbc.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomerDaoImpl extends AbstractJdbcDao implements CustomerDao {

    private static final String INSERT_QUERY = "INSERT INTO CUSTOMER(id_customer, firm, contact_person, telephone, code) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE CUSTOMER SET id_customer = ?, firm = ?, contact_person = ?, telephone = ?, code = ?";
    private static final String REMOVE_QUERY = "DELETE FROM CUSTOMER WHERE id_customer = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM Customer";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM Customer WHERE id_customer = ?";
    private static final String FIND_BY_FIRM_QUERY = "SELECT * FROM Customer WHERE firm = ?";
    private static final String FIND_BY_CONTACT_PERSON_QUERY = "SELECT * FROM Customer WHERE contact_person = ?";
    private static final String FIND_BY_TELEPHONE_QUERY = "SELECT * FROM Customer WHERE telephone = ?";
    private static final String FIND_BY_CODE_QUERY = "SELECT * FROM Customer WHERE code = ?";

    @Override
    public void create(Customer customer) {
        executeUpdateStatement(INSERT_QUERY, Arrays.asList(customer.getId(), customer.getFirm(), customer.getContactPerson(), customer.getTelephone(), customer.getCode()));
    }

    @Override
    public void update(Customer customer) {
        executeUpdateStatement(UPDATE_QUERY, Arrays.asList(customer.getId(), customer.getFirm(), customer.getContactPerson(), customer.getTelephone(), customer.getCode()));
    }

    @Override
    public void remove(Customer customer) {
        executeUpdateStatement(REMOVE_QUERY, Collections.singletonList(customer.getId()));
    }

    @Override
    public List<Customer> findAll() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_QUERY);
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setFirm(resultSet.getString(2));
                customer.setContactPerson(resultSet.getString(3));
                customer.setTelephone(resultSet.getString(4));
                customer.setCode(resultSet.getInt(5));

                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findById(Integer id) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setFirm(resultSet.getString(2));
                customer.setContactPerson(resultSet.getString(3));
                customer.setTelephone(resultSet.getString(4));
                customer.setCode(resultSet.getInt(5));
                return customer;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findByFirm(String firm) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_FIRM_QUERY)) {
            preparedStatement.setString(1, firm);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setFirm(resultSet.getString(2));
                customer.setContactPerson(resultSet.getString(3));
                customer.setTelephone(resultSet.getString(4));
                customer.setCode(resultSet.getInt(5));
                return customer;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findByContactPerson(String contactPerson) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CONTACT_PERSON_QUERY)) {
            preparedStatement.setString(1, contactPerson);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setFirm(resultSet.getString(2));
                customer.setContactPerson(resultSet.getString(3));
                customer.setTelephone(resultSet.getString(4));
                customer.setCode(resultSet.getInt(5));
                return customer;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findByTelephone(String telephone) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_TELEPHONE_QUERY)) {
            preparedStatement.setString(1, telephone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setFirm(resultSet.getString(2));
                customer.setContactPerson(resultSet.getString(3));
                customer.setTelephone(resultSet.getString(4));
                customer.setCode(resultSet.getInt(5));
                return customer;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findByCode(Integer code) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CODE_QUERY)) {
            preparedStatement.setInt(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setFirm(resultSet.getString(2));
                customer.setContactPerson(resultSet.getString(3));
                customer.setTelephone(resultSet.getString(4));
                customer.setCode(resultSet.getInt(5));
                return customer;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
