package com.sagor.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class JobTransactionSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAmount;
    private double paidAmount;
    private double dueAmount;
    @OneToOne
    @JoinColumn(name= "client_id")
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transDate;
    @ManyToOne
    @JoinColumn(name = "JobPack_id")
    private JobPackage jobPackage;

    public JobTransactionSummary() {
    }

    public JobTransactionSummary(double totalAmount, double paidAmount, double dueAmount, Client client, Date transDate, JobPackage jobPackage) {
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.client = client;
        this.transDate = transDate;
        this.jobPackage = jobPackage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
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

    public JobPackage getJobPackage() {
        return jobPackage;
    }

    public void setJobPackage(JobPackage jobPackage) {
        this.jobPackage = jobPackage;
    }
}
