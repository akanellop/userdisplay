package com.example.userdisplay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    //controller to return custom login and register views

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @GetMapping("/register")
    private String register() {
        return "register";
    }

}
