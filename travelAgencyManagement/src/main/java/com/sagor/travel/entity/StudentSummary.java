package com.sagor.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StudentSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double payableAmount;
    private double paymentAmount;
    private double dueAmount;
    @OneToOne
    @JoinColumn(name= "client_id")
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transDate;
    @ManyToOne
    @JoinColumn(name = "StuPack_id")
    private StudentPackage studentPackage;

    public StudentSummary() {
    }

    public StudentSummary(double payableAmount, double paymentAmount, double dueAmount, Client client, Date transDate, StudentPackage studentPackage) {
        this.payableAmount = payableAmount;
        this.paymentAmount = paymentAmount;
        this.dueAmount = dueAmount;
        this.client = client;
        this.transDate = transDate;
        this.studentPackage = studentPackage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public StudentPackage getStudentPackage() {
        return studentPackage;
    }

    public void setStudentPackage(StudentPackage studentPackage) {
        this.studentPackage = studentPackage;
    }
}
