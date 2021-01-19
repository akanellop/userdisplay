package com.example.userdisplay.services;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.domain.UserRegisterDTO;
import com.example.userdisplay.exceptions.BadPasswordDuplicateException;
import com.example.userdisplay.exceptions.ExistingEmailException;
import com.example.userdisplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserRepository userRepository;


    public void addUser(UserRegisterDTO data) throws Exception {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher matcher = pattern.matcher(data.getPassword());

        if(!matcher.find()) {
            throw new BadPasswordDuplicateException(new Throwable());
        }
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
