package com.example.service;

import com.example.model.Role;
import com.example.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findById(Long id);
    List<User> findAll();
    User findByEmail(String email);
    void saveUser(User user);
    void deleteById(Long id);

    List<Role> findAllRoles();
}
