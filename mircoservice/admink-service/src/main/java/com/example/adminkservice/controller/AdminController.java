package com.example.adminkservice.controller;

import com.example.adminkservice.VO.ResponseTemplateVO;
import com.example.adminkservice.entity.Admin;
import com.example.adminkservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")



public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Admin createUser(@RequestBody Admin user) {
        return adminService.createUser(user);
    }

    @PostMapping("/update")
    public Admin update(@RequestBody Admin user) {
        return adminService.uptade(user);
    }

    @GetMapping("/all")
    public List<Admin> findAll() {
        return adminService.findAll();
    }

    @GetMapping("/all/{id}")
    public Admin getById(@PathVariable int id) {
        return adminService.getById(id);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam int id) {
        adminService.delete(id);
    }

    @PostMapping("/find")
    public Admin getByEmail(@RequestParam String email) {
        return adminService.findByEmail(email);
    }


    @GetMapping("/sales-product")
    public ResponseTemplateVO getSalesProduct(@RequestParam int adminId){
        return  adminService.getSalesProducts(adminId);
    }
}