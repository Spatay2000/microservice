package com.example.salesproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SalesProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesProductsApplication.class, args);
    }

}
