package com.sagor.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
public class StudentPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double amount;
    private double paymentAmount;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentDate;

    private String annualFee;

    private String massage;
    @ManyToOne
    @JoinColumn(name = "cli_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "visa_id")
    private Visatype visatype;
    @ManyToOne
    @JoinColumn(name = "count_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "uni_id")
    private University university;

    @ManyToOne
    @JoinColumn(name = "bra_id")
    private UniversityBranch universityBranch;

    @ManyToOne
    @JoinColumn(name = "addmission_id")
    private AddmissionLevel addmissionLevel;

    public StudentPackage() {
    }

    public StudentPackage(double amount, Date paymentDate, Client client, Visatype visatype, Country country, University universiry, UniversityBranch universityBranch, AddmissionLevel addmissionLevel) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.client = client;
        this.visatype = visatype;
        this.country = country;
        this.university = university;
        this.universityBranch = universityBranch;
        this.addmissionLevel = addmissionLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "StudentPackage{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", client=" + client +
                ", visatype=" + visatype +
                ", country=" + country +
                ", university=" + university +
                ", universityBranch=" + universityBranch +
                ", addmissionLevel=" + addmissionLevel +
                '}';
    }

    public String getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(String annualFee) {
        this.annualFee = annualFee;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Visatype getVisatype() {
        return visatype;
    }

    public void setVisatype(Visatype visatype) {
        this.visatype = visatype;
    }

    public University getUniversiry() {
        return university;
    }

    public void setUniversiry(University universiry) {
        this.university = universiry;
    }

    public UniversityBranch getUniversityBranch() {
        return universityBranch;
    }

    public void setUniversityBranch(UniversityBranch universityBranch) {
        this.universityBranch = universityBranch;
    }

    public AddmissionLevel getAddmissionLevel() {
        return addmissionLevel;
    }

    public void setAddmissionLevel(AddmissionLevel addmissionLevel) {
        this.addmissionLevel = addmissionLevel;
    }
}
