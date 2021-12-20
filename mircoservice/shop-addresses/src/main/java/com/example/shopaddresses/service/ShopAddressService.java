package com.example.shopaddresses.service;




import com.example.shopaddresses.entity.ShopAddress;

import java.util.List;

public interface ShopAddressService {
    ShopAddress getById(int id);
    List<ShopAddress> findAll();
    ShopAddress createShopAddress(ShopAddress shopAddress);
    ShopAddress uptade(ShopAddress shopAddress);
    void delete(int id);


}
