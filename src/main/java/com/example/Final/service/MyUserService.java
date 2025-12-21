package com.example.Final.service;

import com.example.Final.entity.Permission;
import com.example.Final.entity.UserModel;
import com.example.Final.repository.PermissionRep;
import com.example.Final.repository.UserModelRep;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Primary
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserModelRep userModelRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRep permissionRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userModelRepository.findByEmail(username);

        if (Objects.nonNull(user)) {
            return user;
        }

        throw new UsernameNotFoundException("User Not Found");
    }

    public void registr(UserModel model) {
        UserModel check = userModelRepository.findByEmail(model.getEmail());
        if (check == null) {
            model.setPassword(passwordEncoder.encode(model.getPassword()));
            List<Permission> permissions = List.of(permissionRep.findByName("ROLE_USER"));

            model.setPermissions(permissions);
            userModelRepository.save(model);
        }
    }

}


