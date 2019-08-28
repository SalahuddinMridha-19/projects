package com.sagor.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
public class JobPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double totalAmount;
    private double paidAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentDate;
    private String salary;
    private String massage;
    @ManyToOne
    @JoinColumn(name = "cli_id")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "visa_id")
    private Visatype visatype;
    @ManyToOne
    @JoinColumn(name = "com_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "count_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "comb_id")
    private CompanyBranch companyBranch;

    @ManyToOne
    @JoinColumn(name = "jobtype_id")
    private JobType jobType;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private JobPost jobPost;

    public JobPackage() {
    }


    public JobPackage(String name, double totalAmount, double paidAmount, Date paymentDate, String salary, String massage, Client client, Visatype visatype, Company company, Country country, CompanyBranch companyBranch, JobType jobType, JobPost jobPost) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
        this.salary = salary;
        this.massage = massage;
        this.client = client;
        this.visatype = visatype;
        this.company = company;
        this.country = country;
        this.companyBranch = companyBranch;
        this.jobType = jobType;
        this.jobPost = jobPost;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CompanyBranch getCompanyBranch() {
        return companyBranch;
    }

    public void setCompanyBranch(CompanyBranch companyBranch) {
        this.companyBranch = companyBranch;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
