package com.example.shopaddresses.repo;



import com.example.shopaddresses.entity.ShopAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopAddressRepo extends JpaRepository<ShopAddress, Integer> {
    ShopAddress getById(int id);
    List<ShopAddress> findAll();

}
