package com.coderbd.simplethymeleaftemplate.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "*Please enter user name")
    @Column(name ="user_name")
    @Size(max = 3,min = 2)
    private String userName;
    @NotEmpty(message = "*plase Enter the Password")
    @Size(max = 8,min = 6 ,message = "please enter minimum 8 characters")
    private String password;
    @NotEmpty(message = "*plase Enter the Password")
    @Size(max = 11,message = "please enter minimum 8 characters")
    private String mobile;

    public User() {
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
