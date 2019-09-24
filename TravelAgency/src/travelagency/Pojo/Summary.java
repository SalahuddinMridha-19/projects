package travelagency.Pojo;

import java.sql.Date;

public class Summary {

    private int id;
    private double totalAmount;
    private double paidAmount;
    private double dueAmount;
    private String paymentType;//cash, checque
    private String purposeOfPayment;
    private Date paymentDate;
    private String paymentPlace;
    private String note;
    Client client;

    public Summary() {
    }

    public Summary(int id) {
        this.id = id;
    }

    public Summary(double totalAmount, double paidAmount, double dueAmount, String paymentType, String purposeOfPayment, Date paymentDate, String paymentPlace, String note, Client client) {
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.paymentType = paymentType;
        this.purposeOfPayment = purposeOfPayment;
        this.paymentDate = paymentDate;
        this.paymentPlace = paymentPlace;
        this.note = note;
        this.client = client;
    }

    public Summary(int id, double totalAmount, double paidAmount, double dueAmount, String paymentType, String purposeOfPayment, Date paymentDate, String paymentPlace, String note, Client client) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.dueAmount = dueAmount;
        this.paymentType = paymentType;
        this.purposeOfPayment = purposeOfPayment;
        this.paymentDate = paymentDate;
        this.paymentPlace = paymentPlace;
        this.note = note;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPurposeOfPayment() {
        return purposeOfPayment;
    }

    public void setPurposeOfPayment(String purposeOfPayment) {
        this.purposeOfPayment = purposeOfPayment;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentPlace() {
        return paymentPlace;
    }

    public void setPaymentPlace(String paymentPlace) {
        this.paymentPlace = paymentPlace;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

   
  

}
