package com.example.userdisplay.services;

import com.example.userdisplay.domain.UserRegisterDto;
import com.example.userdisplay.domain.UserEditDto;

public interface UserService {

    void addUser(UserRegisterDto data) throws Exception;
    void editUser(UserEditDto data) throws Exception;
}
