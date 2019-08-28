package com.sagor.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "nominee")
    public class Nominee {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       @Column(name = "nominee_name", nullable = false)
       private String name;
       private String fatherName;
       private String motherName;
       @Column(name = "mobile")
       private String mobile;
       @Column(name = "date_of_birth", nullable = false)
       @DateTimeFormat(pattern="yyyy-MM-dd")
       private Date dateOfBirth;
       @Column(name = "national_id")
       private String nationalId;

       private String email;
       @Column(name = "gender")
       private String gender;

       private String presentAddress;

       private String parmanentAddress;

       @ManyToOne
       @JoinColumn(name = "client_id")
       private Client client;

    public Nominee() {
    }

    public Nominee(String name, String fatherName, String motherName, String mobile, Date dateOfBirth, String nationalId, String email, String gender, String presentAddress, String parmanentAddress, Client client) {
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.nationalId = nationalId;
        this.email = email;
        this.gender = gender;
        this.presentAddress = presentAddress;
        this.parmanentAddress = parmanentAddress;
        this.client = client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getParmanentAddress() {
        return parmanentAddress;
    }

    public void setParmanentAddress(String parmanentAddress) {
        this.parmanentAddress = parmanentAddress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Nominee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationalId='" + nationalId + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", presentAddress='" + presentAddress + '\'' +
                ", parmanentAddress='" + parmanentAddress + '\'' +
                ", client=" + client +
                '}';
    }
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";


}