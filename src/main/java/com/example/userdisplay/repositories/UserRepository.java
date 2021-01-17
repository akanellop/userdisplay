package com.example.userdisplay.repositories;

import com.example.userdisplay.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findAll();
    User findUserById(Long id);
    User findByEmail(String email);
}
