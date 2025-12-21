package com.example.Final.repository;

import com.example.Final.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRep extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
