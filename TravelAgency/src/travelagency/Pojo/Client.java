
package travelagency.Pojo;

public class Client {
    private int id;
    private String name;
    private String fatherName;
    private String genger;
    private int age;
    private String email;
    private int mobile;
    private String address;

    public Client() {
    }

    public Client(int id) {
        this.id = id;
    }

    public Client(int id, String name, String fatherName, String genger, int age, String email, int mobile, String address) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.genger = genger;
        this.age = age;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Client(String name, String fatherName, String genger, int age, String email, int mobile, String address) {
        this.name = name;
        this.fatherName = fatherName;
        this.genger = genger;
        this.age = age;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getGenger() {
        return genger;
    }

    public void setGenger(String genger) {
        this.genger = genger;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
