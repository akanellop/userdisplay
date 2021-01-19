package com.example.userdisplay.services;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.domain.UserRegisterDTO;
import com.example.userdisplay.exceptions.BadPasswordDuplicateException;
import com.example.userdisplay.exceptions.ExistingEmailException;
import com.example.userdisplay.repositories.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserRepository userRepository;


    public void addUser(UserRegisterDTO data) throws Exception {
        if(!data.getPassword().equals(data.getPassword2())) {
            throw new BadPasswordDuplicateException(new Throwable());
        }

        try{
            User newUser = new User(data.getFullname(), data.getEmail(), data.getPassword(), data.getPhone(), data.getCompany());
            userRepository.save(newUser);
        }
        catch(Exception e){
            System.out.println("something went wrong while saving");
            throw new ExistingEmailException(e);
        }

    }
}
