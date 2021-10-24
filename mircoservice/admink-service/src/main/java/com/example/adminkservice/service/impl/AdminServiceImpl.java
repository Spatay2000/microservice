package com.example.adminkservice.service.impl;

import com.example.adminkservice.VO.ResponseTemplateVO;
import com.example.adminkservice.VO.SalesProducts;
import com.example.adminkservice.entity.Admin;
import com.example.adminkservice.repo.AdminRepo;
import com.example.adminkservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class AdminServiceImpl implements AdminService, UserDetailsService {
    @Autowired
    private RestTemplate restTemplate;


    public SalesProducts getSalesProductsById(int SalesProductsId){
        return restTemplate.getForObject("http://sales-products-service/sales"+ SalesProductsId, SalesProducts.class);
    }

    @Autowired
    private AdminRepo AdminRepo;


    @Override
    public Admin getById(int id) {

        return AdminRepo.getById(id);
    }

    @Override
    public List<Admin> findAll() {
        return AdminRepo.findAll();
    }

    @Override
    public Admin createUser(Admin user) {
        user.setPassword(user.getPassword());
        return AdminRepo.save(user);
    }

    @Override
    public Admin uptade(Admin user) {
        return AdminRepo.save(user);
    }

    @Override
    public void delete(int id) {
        Admin user1 = AdminRepo.getById(id);
        AdminRepo.delete(user1);
    }

    @Override
    public Admin findByEmail(String email) {
        return AdminRepo.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = AdminRepo.findByEmail(username);

        if (user == null){
            throw new UsernameNotFoundException("User: " + username + " not found");
        }
        return user;
    }
    @Override
    public ResponseTemplateVO getSalesProducts(int adminId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        Admin admin = AdminRepo.getById(adminId);

        SalesProducts salesProducts = restTemplate.getForObject("http://localhost:9091/sales/all/1" , SalesProducts.class);

        vo.setSalesProducts(salesProducts);
        vo.setAdmin(admin);
        return vo;
    }
}