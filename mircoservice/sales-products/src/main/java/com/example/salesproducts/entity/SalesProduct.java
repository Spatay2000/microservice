package com.example.salesproducts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String SalesProduct;
        private double value;

}