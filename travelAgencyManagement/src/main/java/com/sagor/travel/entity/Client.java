package com.sagor.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;

    private String accountNo;

    @Column(nullable = false)
    private String email;

    private String gender;

    @Column(nullable = false)
    private String nid;

    @Column(nullable = false)
    private String passportNo;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private String mobNo;
    @ManyToOne
    @JoinColumn(name = "visa_id")
    private Visatype visatype;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;


    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;


    //////File Upload==============
    @Column(nullable = true)
    private long fileSize;
    private String fileName;
    //  @Lob
    // private byte[] file;
    private String filePath;
    private String fileExtension;
//     == the end==

    public Client() {
    }

    public Client(String clientName, String accountNo, String email, String gender, String nid, String passportNo, Date regiDate, Date birthDate, String mobNo, Visatype visatype, Country country, Agency agency, Branch branch, long fileSize, String fileName, String filePath, String fileExtension) {
        this.clientName = clientName;
        this.accountNo = accountNo;
        this.email = email;
        this.gender = gender;
        this.nid = nid;
        this.passportNo = passportNo;
        this.regiDate = regiDate;
        this.birthDate = birthDate;
        this.mobNo = mobNo;
        this.visatype = visatype;
        this.country = country;
        this.agency = agency;
        this.branch = branch;
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileExtension = fileExtension;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Visatype getVisatype() {
        return visatype;
    }

    public void setVisatype(Visatype visatype) {
        this.visatype = visatype;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", nid='" + nid + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", regiDate=" + regiDate +
                ", birthDate=" + birthDate +
                ", mobNo='" + mobNo + '\'' +
                ", visatype=" + visatype +
                ", country=" + country +
                ", agency=" + agency +
                ", branch=" + branch +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }
}
