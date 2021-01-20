package com.example.userdisplay.controllers;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.domain.UserRegisterDto;
import com.example.userdisplay.domain.UserEditDto;
import com.example.userdisplay.repositories.UserRepository;
import com.example.userdisplay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping(value="/createuser")
    public ResponseEntity<String> create(@RequestBody UserRegisterDto data){
        try{

            userService.addUser(data);
            return new ResponseEntity<>("Successful save.", HttpStatus.OK);

        }
        catch(Exception e){
            return  new ResponseEntity<>(e.getMessage() ,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/edituser")
    public ResponseEntity<String> edit(@RequestBody UserEditDto data){
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        try{
            userService.editUser(data);
            return new ResponseEntity<>("Successful save.", HttpStatus.OK);
        }
        catch(Exception e){
            return  new ResponseEntity<>(e.getMessage() ,HttpStatus.BAD_REQUEST);
        }
    }

}
