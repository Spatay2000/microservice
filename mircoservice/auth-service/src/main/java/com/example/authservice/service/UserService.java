package com.example.authservice.service;

import com.example.authservice.model.User;

import java.util.List;

public interface UserService {
    User getById(int id);
    List<User> findAll();
    User createUser(User user);
    User uptade(User user);
    void delete(int id);
    User findByEmail(String email);
}
