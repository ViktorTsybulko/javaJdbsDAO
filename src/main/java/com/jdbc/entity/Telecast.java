package com.jdbc.entity;

import java.util.Objects;

public class Telecast {
    private Integer id;
    private String name;
    private Integer rate;
    private Double costMinute;
    private Order order;

    public Telecast() {
    }

    public Telecast(String name, Integer rate, Double costMinute) {
        this.name = name;
        this.rate = rate;
        this.costMinute = costMinute;
    }

    public Telecast(Integer id, String name, Integer rate, Double costMinute) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.costMinute = costMinute;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Double getCostMinute() {
        return costMinute;
    }

    public void setCostMinute(Double costMinute) {
        this.costMinute = costMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telecast telecast = (Telecast) o;
        return Objects.equals(id, telecast.id) && Objects.equals(name, telecast.name) && Objects.equals(rate, telecast.rate) && Objects.equals(costMinute, telecast.costMinute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rate, costMinute);
    }

    @Override
    public String toString() {
        return "Telecast{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", costMinute=" + costMinute +
                ", releaseDate=" + order.getReleaseDate() +
                '}';
    }
}
