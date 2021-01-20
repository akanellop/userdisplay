package com.example.userdisplay.controllers;

import com.example.userdisplay.domain.UserRegisterDto;
import com.example.userdisplay.domain.UserEditDto;
import com.example.userdisplay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {   //Rest Controller for handling HTTP POST requests from client side.
                                    //Body requests are transformed to data transfer objects and they are manipulated in service layer.

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

        try{
            userService.editUser(data);
            return new ResponseEntity<>("Successful save.", HttpStatus.OK);
        }
        catch(Exception e){
            return  new ResponseEntity<>(e.getMessage() ,HttpStatus.BAD_REQUEST);
        }
    }

}
