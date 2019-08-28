package com.sagor.travel.entity;

import javax.persistence.*;

@Entity
public class CompanyBranch {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String address;
    private String mobNo;

    @ManyToOne
    @JoinColumn(name = "Company_id")
    private Company company;

    public CompanyBranch() {
    }

    public CompanyBranch(String name, String address, String mobNo, Company company) {
        this.name = name;
        this.address = address;
        this.mobNo = mobNo;
        this.company = company;
    }

    @Override
    public String toString() {
        return "CompanyBranch{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", company=" + company +
                '}';
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
