package com.example.shopaddresses.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "shop_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String SalesProduct;



}