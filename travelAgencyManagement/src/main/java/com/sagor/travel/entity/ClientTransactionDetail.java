package com.sagor.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_details")
public class ClientTransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double payableAmount;
    private double totalAmount;
    private double dueAmount;
    @ManyToOne
    @JoinColumn(name= "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "visatype_id")
    private Visatype visatype;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transDate=new Date();

    public ClientTransactionDetail() {
    }

    public ClientTransactionDetail(double payableAmount, double totalAmount, double dueAmount, Client client, Visatype visatype, Date transDate) {
        this.payableAmount = payableAmount;
        this.totalAmount = totalAmount;
        this.dueAmount = dueAmount;
        this.client = client;
        this.visatype = visatype;
        this.transDate = transDate;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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

    public Visatype getVisatype() {
        return visatype;
    }

    public void setVisatype(Visatype visatype) {
        this.visatype = visatype;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    @Override
    public String toString() {
        return "ClientTransactionDetail{" +
                "id=" + id +
                ", payableAmount=" + payableAmount +
                ", totalAmount=" + totalAmount +
                ", dueAmount=" + dueAmount +
                ", client=" + client +
                ", visatype=" + visatype +
                ", transDate=" + transDate +
                '}';
    }
}
