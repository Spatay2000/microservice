package com.example.shopaddresses.service.impl;



import com.example.shopaddresses.entity.ShopAddress;
import com.example.shopaddresses.repo.ShopAddressRepo;
import com.example.shopaddresses.service.ShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopAddressImpl implements ShopAddressService {
    @Autowired
    private ShopAddressRepo shopAddressRepo;


    @Override
    public ShopAddress getById(int id) {
        return shopAddressRepo.getById(id);
    }

    @Override
    public List<ShopAddress> findAll() {
        return shopAddressRepo.findAll();
    }


    @Override
    public ShopAddress createShopAddress(ShopAddress shopAddress) {
        return shopAddressRepo.save(shopAddress);
    }



    @Override
    public ShopAddress uptade(ShopAddress shopAddress) {
        return shopAddressRepo.save(shopAddress);
    }

    @Override
    public void delete(int id) {
        ShopAddress shopAddress = shopAddressRepo.getById(id);
        shopAddressRepo.delete(shopAddress);
    }

}
