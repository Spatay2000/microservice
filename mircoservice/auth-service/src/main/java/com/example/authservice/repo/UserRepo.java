package com.example.authservice.repo;


import com.example.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User getById(int id);
    List<User> findAll();
    User findByEmail(String email);
}
