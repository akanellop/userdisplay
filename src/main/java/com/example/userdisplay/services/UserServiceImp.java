package com.example.userdisplay.services;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.repositories.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserRepository userRepository;

    private List<String> userAttr(String json){
        List<String> attr = new ArrayList<>();
        json = json.substring(1,json.indexOf("}"));
        json = json.replaceAll("\"","");
        String [] arrStr = json.split(",");
        for(String str: arrStr){
            attr.add(str.substring(str.indexOf(":")+1));
        }
        return attr;
    }

    private User attrToEnt(List<String> attr) throws Exception {
        if(!attr.get(2).equals(attr.get(5))){
            throw new Exception();
        }
        User newUser = new User(attr.get(0),attr.get(1),attr.get(2),attr.get(3),attr.get(4));
        return newUser;
    }

    public void addUser(String data) throws Exception {

        try{
            User newUser = attrToEnt(userAttr(data));
            userRepository.save(newUser);
        }
        catch(Exception e){
            System.out.println("something went wrong while saving");
            throw new Exception();
        }

    }
}
