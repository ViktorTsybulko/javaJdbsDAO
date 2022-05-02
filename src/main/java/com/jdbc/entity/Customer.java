package com.jdbc.entity;

import java.util.Objects;

public class Customer {
    private Integer id;
    private String firm;
    private String contactPerson;
    private String telephone;
    private Integer code;

    public Customer() {
    }

    public Customer(Integer id, String film, String contactPerson, String telephone) {
        this.id = id;
        this.firm = film;
        this.contactPerson = contactPerson;
        this.telephone = telephone;
    }

    public Customer(Integer id, String film, String contactPerson, String telephone, Integer code) {
        this.id = id;
        this.firm = film;
        this.contactPerson = contactPerson;
        this.telephone = telephone;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String film) {
        this.firm = film;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firm, customer.firm) && Objects.equals(contactPerson, customer.contactPerson) && Objects.equals(telephone, customer.telephone) && Objects.equals(code, customer.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firm, contactPerson, telephone, code);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", film='" + firm + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", telephone='" + telephone + '\'' +
                ", code=" + code +
                '}';
    }
}
