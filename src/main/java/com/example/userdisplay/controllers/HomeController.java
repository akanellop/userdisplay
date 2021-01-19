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

        ModelAndView model = new ModelAndView();
        model.addObject("user",user);
        model.addObject("id", user.getId());
        model.addObject("name", user.getFullName());
        model.addObject("email", user.getEmail());
        model.addObject("company", user.getCompany());
        model.addObject("phone", user.getPhoneNumber());
        model.setViewName("Home");
        return model;

    }

}
