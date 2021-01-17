package com.example.userdisplay.controllers;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //eite to afino @restcontroller, eite prosthetorest dependecy sto maven kai
// grafo kalitera tis methodoys, kai mi soy po de xreiazetai kan o controler
public class UserRestController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("users")
    public User getUserByEmailaaaa(){
        User a = userRepository.findByEmail("mm@gmail.com");
        return a;
    }

}
