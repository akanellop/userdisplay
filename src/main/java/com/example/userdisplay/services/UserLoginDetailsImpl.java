package com.example.userdisplay.services;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.repositories.UserRepository;
import com.example.userdisplay.models.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

public class UserLoginDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        return new LoginResponse(user.getEmail(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}
