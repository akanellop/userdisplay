package com.example.userdisplay.domain;

public class UserEditDto {

        private String fullname;
        private String company;
        private String phone;
        private String password;
        private String password2;
        private String oldpassword;


        public UserEditDto(){
        }

        public String getFullname() {
            return fullname;
        }
        public String getPassword() {
            return password;
        }
        public String getPassword2() {
        return password2;
    }
        public String getCompany() {
            return company;
        }
        public String getPhone() {
            return phone;
        }
        public String getOldpassword() { return oldpassword;  }

}
