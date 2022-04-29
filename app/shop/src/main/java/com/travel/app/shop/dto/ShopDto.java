package com.travel.app.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {

    private int orderNo;
    private String productName;
    private  int productNo;

}
