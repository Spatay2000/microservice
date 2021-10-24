package com.example.salesproducts.service;



import com.example.salesproducts.entity.SalesProduct;

import java.util.List;

public interface SalesProductService {
    SalesProduct getById(int id);
    List<SalesProduct> findAll();
    SalesProduct createSalesProduct(SalesProduct salesProduct);
    SalesProduct uptade(SalesProduct salesProduct);
    void delete(int id);


}
