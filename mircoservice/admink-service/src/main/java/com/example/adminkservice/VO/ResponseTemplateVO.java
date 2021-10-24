package com.example.adminkservice.VO;

import com.example.adminkservice.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Admin admin;
    private SalesProducts salesProducts;
}
