package com.example.userdisplay.controllers;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserViewController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/homepage" )
    public String home(Model model) {
        System.out.println("dsaaaaaaaa");
        return "home";
    }

}
