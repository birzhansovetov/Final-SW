package com.example.Final.repository;

import com.example.Final.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRep extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String username);
}
