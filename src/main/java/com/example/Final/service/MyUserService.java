package com.example.Final.service;

import com.example.Final.entity.Permission;
import com.example.Final.entity.UserModel;
import com.example.Final.repository.PermissionRep;
import com.example.Final.repository.UserModelRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserModelRep userModelRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PermissionRep permissionRep;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserModel user = userModelRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return user;
    }

    public void registr(UserModel model) {
        if (userModelRepository.findByEmail(model.getEmail()) != null) return;

        model.setPassword(passwordEncoder.encode(model.getPassword()));

        Permission roleUser = permissionRep.findByName("ROLE_USER");
        if (roleUser == null) {
            throw new RuntimeException("ROLE_USER not found");
        }

        model.setPermissions(List.of(roleUser));
        userModelRepository.save(model);
    }
}
