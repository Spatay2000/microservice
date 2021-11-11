package com.example.salesproducts.service.impl;


import com.example.salesproducts.entity.SalesProduct;
import com.example.salesproducts.repo.SalesProductRepo;
import com.example.salesproducts.service.SalesProductService;
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

    @Override
    public List<SalesProduct> findAll() {
        return salesProductRepo.findAll();
    }


    @Override
    public SalesProduct createSalesProduct(SalesProduct salesProduct) {
        return salesProductRepo.save(salesProduct);
    }



    @Override
    public SalesProduct uptade(SalesProduct salesProduct) {
        return salesProductRepo.save(salesProduct);
    }

    @Override
    public void delete(int id) {
        SalesProduct salesProduct = salesProductRepo.getById(id);
        salesProductRepo.delete(salesProduct);
    }

}
