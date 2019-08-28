package com.sagor.travel.entity;

import javax.persistence.*;


@Entity

public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String mobNo;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Agency() {
    }

    public Agency(String name, String address, String mobNo, Country country) {
        this.name = name;
        this.address = address;
        this.mobNo = mobNo;
        this.country = country;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", country=" + country +
                '}';
    }
}
