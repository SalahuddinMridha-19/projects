package com.sagor.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_summary")
public class ClientTransactionSummary {

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
    private Date transDate;

}
