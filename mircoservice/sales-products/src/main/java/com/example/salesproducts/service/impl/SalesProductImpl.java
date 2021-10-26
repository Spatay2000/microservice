package com.example.salesproducts.service.impl;


import com.example.salesproducts.entity.SalesProduct;
import com.example.salesproducts.repo.SalesProductRepo;
import com.example.salesproducts.service.SalesProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesProductImpl implements SalesProductService {
    @Autowired
    private SalesProductRepo salesProductRepo;


    @Override
    public SalesProduct getById(int id) {
        return salesProductRepo.getById(id);
    }
    @HystrixCommand(
            fallbackMethod = "getByIdFallback",
            threadPoolKey = "getById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })

    public String getByIdFallback(){
        return "Service error";
    }
    @Override
    public List<SalesProduct> findAll() {
        return salesProductRepo.findAll();
    }
    @HystrixCommand(
            fallbackMethod = "finaAllFallback",
            threadPoolKey = "findAll",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public String findAllFallback(){
        return "Service error";
    }
    @Override
    public SalesProduct createSalesProduct(SalesProduct salesProduct) {
        return salesProductRepo.save(salesProduct);
    }

    @HystrixCommand(
            fallbackMethod = "createSalesProductFallback",
            threadPoolKey = "createSalesProduct",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public String createSalesProductFallback(){
        return "Service error";
    }
    @Override
    public SalesProduct uptade(SalesProduct salesProduct) {
        return salesProductRepo.save(salesProduct);
    }
    @HystrixCommand(
            fallbackMethod = "updateFallback",
            threadPoolKey = "update",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public String updateFallback(){
        return "Service error";
    }
    @Override
    public void delete(int id) {
        SalesProduct salesProduct = salesProductRepo.getById(id);
        salesProductRepo.delete(salesProduct);
    }

}
