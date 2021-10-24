package com.example.salesproducts.repo;


import com.example.salesproducts.entity.SalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesProductRepo extends JpaRepository<SalesProduct, Integer> {
    SalesProduct getById(int id);
    List<SalesProduct> findAll();

}
