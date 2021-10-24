package com.example.adminkservice.service;
import com.example.adminkservice.VO.ResponseTemplateVO;
import com.example.adminkservice.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin getById(int id);
    List<Admin> findAll();
    Admin createUser(Admin user);
    Admin uptade(Admin user);
    void delete(int id);
    Admin findByEmail(String email);
    ResponseTemplateVO getSalesProducts(int adminId);
}