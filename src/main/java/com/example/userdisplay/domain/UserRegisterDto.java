package com.example.userdisplay.domain;

import java.time.LocalDate;

public class UserRegisterDto {
    private String fullname;
    private String email;
    private String password;
    private String company;
    private String phone;
    private String password2;

    public UserRegisterDto(){

    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword2() {
        return password2;
    }
}
