package com.example.userdisplay.services;

import com.example.userdisplay.domain.User;
import com.example.userdisplay.domain.UserRegisterDto;
import com.example.userdisplay.domain.UserEditDto;
import com.example.userdisplay.exceptions.BadPasswordDuplicateException;
import com.example.userdisplay.exceptions.ExistingEmailException;
import com.example.userdisplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserRepository userRepository;


    public void addUser(UserRegisterDto data) throws Exception {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher matcher = pattern.matcher(data.getPassword());

        if(!matcher.find()) {
            throw new BadPasswordDuplicateException(new Throwable());
        }
        if(!data.getPassword().equals(data.getPassword2())) {
            throw new BadPasswordDuplicateException(new Throwable());
        }

        try{
            User newUser = new User(data.getFullname(), data.getEmail(), data.getPassword(), data.getPhone(), data.getCompany());
            userRepository.save(newUser);
        }
        catch(Exception e){
            throw new ExistingEmailException(e);
        }

    }

    public void editUser(UserEditDto data) throws Exception {

        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher matcher = pattern.matcher(data.getPassword());
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());


        if(data.getOldpassword().equals(user.getPassword()) && (matcher.find()||data.getPassword().equals(""))){
            try {
                if (!data.getFullname().equals("Saved-Value")) {
                    user.setFullName(data.getFullname());
                }
                if (!data.getCompany().equals("Saved-Value")) {
                    user.setCompany(data.getCompany());

                }
                if (!data.getPhone().equals("Saved-Value")) {
                    user.setPhoneNumber(data.getPhone());

                }
                if (!data.getPassword().equals("") && data.getPassword().equals(data.getPassword2())) {
                    user.setPassword(data.getPassword());
                }
                userRepository.save(user);

            }catch (Exception e){
                throw new Exception();
            }

        }
        else{
            throw new BadPasswordDuplicateException(new Throwable());
        }
    }


}
