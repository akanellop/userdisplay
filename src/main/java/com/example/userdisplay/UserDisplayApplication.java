package com.example.userdisplay;

import com.example.userdisplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserDisplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDisplayApplication.class, args);
	}

}
