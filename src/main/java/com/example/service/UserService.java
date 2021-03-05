package com.example.service;

import com.example.model.Role;
import com.example.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {
    User findById(Long id);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(Long id);

    Set<Role> findAllRoles();
}
