package com.sagor.travel.entity;

import javax.persistence.*;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String address;
    private String mobNo;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    public Branch() {
    }

    public Branch(String name, String address, String mobNo, Agency agency) {
        this.name = name;
        this.address = address;
        this.mobNo = mobNo;
        this.agency = agency;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", agency=" + agency +
                '}';
    }
}
