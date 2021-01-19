package com.example.userdisplay.services;

import com.example.userdisplay.domain.UserRegisterDTO;

public interface UserService {

    void addUser(UserRegisterDTO data) throws Exception;
}
