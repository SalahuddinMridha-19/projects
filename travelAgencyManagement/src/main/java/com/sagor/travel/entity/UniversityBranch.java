package com.sagor.travel.entity;

import javax.persistence.*;

@Entity
public class UniversityBranch {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String address;
    private String mobNo;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    public UniversityBranch() {
    }

    public UniversityBranch(String name, String address, String mobNo, University university) {
        this.name = name;
        this.address = address;
        this.mobNo = mobNo;
        this.university = university;
    }

    @Override
    public String toString() {
        return "UniversityBranch{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", universiry=" + university +
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

    public University getUniversiry() {
        return university;
    }

    public void setUniversiry(University universiry) {
        this.university = universiry;
    }
}
