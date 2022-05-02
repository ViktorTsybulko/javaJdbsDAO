package com.jdbc.entity;

import java.sql.Date;
import java.util.Objects;

public class Order {
    Date releaseDate;
    Customer customer;
    Telecast telecast;
    Trailer trailer;

    public Order() {
    }

    public Order(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Order(Date releaseDate, Customer customer, Telecast telecast, Trailer trailer) {
        this.releaseDate = releaseDate;
        this.customer = customer;
        this.telecast = telecast;
        this.trailer = trailer;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Telecast getTelecast() {
        return telecast;
    }

    public void setTelecast(Telecast telecast) {
        this.telecast = telecast;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(releaseDate, order.releaseDate) && Objects.equals(customer, order.customer) && Objects.equals(telecast, order.telecast) && Objects.equals(trailer, order.trailer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(releaseDate, customer, telecast, trailer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "releaseDate=" + releaseDate +
                ", customer=" + customer +
                ", telecast=" + telecast +
                ", trailer=" + trailer +
                '}';
    }
}
