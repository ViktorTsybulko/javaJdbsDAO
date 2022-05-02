package com.jdbc.entity;

import java.sql.Time;
import java.util.Objects;

public class Trailer {
    private Integer id;
    private String name;
    private Time duration;

    public Trailer() {
    }

    public Trailer(String name, Time duration) {
        this.name = name;
        this.duration = duration;
    }

    public Trailer(Integer id, String name, Time duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
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

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trailer trailer = (Trailer) o;
        return Objects.equals(id, trailer.id) && Objects.equals(name, trailer.name) && Objects.equals(duration, trailer.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
