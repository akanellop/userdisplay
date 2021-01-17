package com.example.userdisplay.controllers;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value= {"/home"},method = RequestMethod.GET)
    public ModelAndView home(){
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(user.getFullName());

        ModelAndView model = new ModelAndView();

        model.setViewName("Home");
        return model;

    }

}
