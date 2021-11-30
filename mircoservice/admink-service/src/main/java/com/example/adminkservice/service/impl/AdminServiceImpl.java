package com.example.adminkservice.service.impl;

import com.example.adminkservice.VO.ResponseTemplateVO;
import com.example.adminkservice.VO.SalesProduct;
import com.example.adminkservice.entity.Admin;
import com.example.adminkservice.repo.AdminRepo;
import com.example.adminkservice.service.AdminService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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


    public SalesProduct getSalesProductsById(int salesProductsId){
        return restTemplate.getForObject("http://sales-products-service/sales"+ salesProductsId, SalesProduct.class);
    }


    @Autowired
    private AdminRepo AdminRepo;


    @Override
//    @HystrixCommand(
//            fallbackMethod = "getByIdFallback"
//    )
    public Admin getById(Integer id) {

        return AdminRepo.getById(id);
    }
    public Admin getByIdFallback(int id) {
        return AdminRepo.getById(0);
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
    @HystrixCommand(fallbackMethod = "getSalesProductsFallback",
            threadPoolKey = "getSalesProducts",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    @Override
    public ResponseTemplateVO getSalesProducts(Integer adminId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        Admin admin = AdminRepo.findById(adminId).get();

        SalesProduct salesProduct = restTemplate.getForObject("http://sales-products-service/sales/all/1" , SalesProduct.class);

        vo.setSalesProduct(salesProduct);
        vo.setAdmin(admin);
        return vo;
    }
    public ResponseTemplateVO getSalesProductsFallback(Integer adminId){
        System.out.println("here");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Admin admin = AdminRepo.findById(adminId).get();
        Admin a = new Admin(0, " ", " ", " ", " ");
        SalesProduct salesProduct = new SalesProduct(0,"Error",0.0);
        vo.setSalesProduct(salesProduct);
        vo.setAdmin(admin);
        return vo;
    }
}