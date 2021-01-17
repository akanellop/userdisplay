package com.example.userdisplay.domain;

import javax.persistence.*;

@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    private static final int MAX_STRING_LENGTH = 60;
    private static final int MAX_PHONE_LENGTH = 13;



    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname", length = MAX_STRING_LENGTH, nullable = false)
    private String fullName;

    @Column(name = "email", length = MAX_STRING_LENGTH, nullable = false)
    private String email;

    @Column(name = "password", length = MAX_STRING_LENGTH, nullable = false)
    private String password;

    @Column(name = "phone", length = MAX_PHONE_LENGTH)
    private String phoneNumber;

    @Column(name = "company", length = MAX_STRING_LENGTH)
    private String company;

    public User(){}

    public User(String fullname, String email,String password, String phone,String company){
        this.fullName = fullname;
        this.email = email;
        this.password = password;
        this.phoneNumber= phone;
        this.company = company;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompany() {
        return company;
    }

}
