package com.example.Final.repository;


import com.example.Final.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserModelRep extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
}
