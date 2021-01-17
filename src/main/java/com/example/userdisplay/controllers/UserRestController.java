package com.example.userdisplay.controllers;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.repositories.UserRepository;
import com.example.userdisplay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//eite to afino @restcontroller, eite prosthetorest dependecy sto maven kai
// grafo kalitera tis methodoys, kai mi soy po de xreiazetai kan o controler
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping(value="/createuser")
    public ResponseEntity<String> create(@RequestBody String data){
        try{
            //userRepository.save(data);
            userService.addUser(data);
            return new ResponseEntity<>("Successful save", HttpStatus.OK);

        }
        catch(Exception e){
            return  new ResponseEntity<>(""+e ,HttpStatus.BAD_REQUEST);
        }
    }
}
