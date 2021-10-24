package com.example.salesproducts.controller;


import com.example.salesproducts.entity.SalesProduct;
import com.example.salesproducts.service.SalesProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")

public class SalesProductController {
    @Autowired
    private SalesProductService salesProductService;

    @PostMapping("/create")
    public SalesProduct createSalesProduct(@RequestBody SalesProduct salesProduct) {
        return salesProductService.createSalesProduct(salesProduct);
    }

    @PostMapping("/update")
    public  SalesProduct update(@RequestBody SalesProduct salesProduct){
        return salesProductService.uptade(salesProduct);
    }

    @PostMapping("/all")
    public List<SalesProduct> findAll(){
        return salesProductService.findAll();
    }

    @GetMapping("/all/{id}")
    public SalesProduct getById(@PathVariable int id ){
        return  salesProductService.getById(id);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam int id ){
        salesProductService.delete(id);
    }

     }

