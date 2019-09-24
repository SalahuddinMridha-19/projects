
package travelagency.Pojo;

public class Agency {
     private int id;
    private String agencyName;
    private String agencyCountry;
    private String agencyEmail;
    private String agencyContactNo;
    private String agencyAddress;

    public Agency() {
    }

    public Agency(int id, String agencyName, String agencyCountry, String agencyEmail, String agencyContactNo, String agencyAddress) {
        this.id = id;
        this.agencyName = agencyName;
        this.agencyCountry = agencyCountry;
        this.agencyEmail = agencyEmail;
        this.agencyContactNo = agencyContactNo;
        this.agencyAddress = agencyAddress;
    }

    public Agency(String agencyName, String agencyCountry, String agencyEmail, String agencyContactNo, String agencyAddress) {
        this.agencyName = agencyName;
        this.agencyCountry = agencyCountry;
        this.agencyEmail = agencyEmail;
        this.agencyContactNo = agencyContactNo;
        this.agencyAddress = agencyAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyCountry() {
        return agencyCountry;
    }

    public void setAgencyCountry(String agencyCountry) {
        this.agencyCountry = agencyCountry;
    }

    public String getAgencyEmail() {
        return agencyEmail;
    }

    public void setAgencyEmail(String agencyEmail) {
        this.agencyEmail = agencyEmail;
    }

    public String getAgencyContactNo() {
        return agencyContactNo;
    }

    public void setAgencyContactNo(String agencyContactNo) {
        this.agencyContactNo = agencyContactNo;
    }

    public String getAgencyAddress() {
        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }
    
}
