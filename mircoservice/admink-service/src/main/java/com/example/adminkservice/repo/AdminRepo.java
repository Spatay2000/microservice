package com.example.adminkservice.repo;


import com.example.adminkservice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Admin getById(int id);
    List<Admin> findAll();
    Admin findByEmail(String email);

}