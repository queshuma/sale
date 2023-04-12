package com.example.sale.Dto;

import lombok.Data;

@Data
public class ShopDto {
    private long proId;
    private String proName;
    private String proClass;
    private float proQual;
    private int sentTime;
    private float sentCost;
    private float sentDiscount;
    private float cost;

    public ShopDto() {

    }
}
