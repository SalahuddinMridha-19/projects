package com.sagor.travel.entity;

import javax.persistence.*;

@Entity
@Table(name = "addmission_level")
public class AddmissionLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public AddmissionLevel() {
    }

    public AddmissionLevel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddmissionLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
