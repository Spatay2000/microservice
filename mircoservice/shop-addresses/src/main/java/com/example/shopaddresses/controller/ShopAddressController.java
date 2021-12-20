package com.example.shopaddresses.controller;



import com.example.shopaddresses.entity.ShopAddress;
import com.example.shopaddresses.service.ShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopaddress")

public class ShopAddressController {
    @Autowired
    private ShopAddressService shopAddressService;

    @PostMapping("/create")
    public ShopAddress createSalesProduct(@RequestBody ShopAddress shopAddress) {
        return shopAddressService.createShopAddress(shopAddress);
    }

    @PostMapping("/update")
    public  ShopAddress update(@RequestBody ShopAddress shopAddress){
        return shopAddressService.uptade(shopAddress);
    }

    @GetMapping("/all")
    public List<ShopAddress> findAll(){
        return shopAddressService.findAll();
    }

    @GetMapping("/all/{id}")
    public ShopAddress getById(@PathVariable int id ){
        return  shopAddressService.getById(id);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam int id ){
        shopAddressService.delete(id);
    }

     }

