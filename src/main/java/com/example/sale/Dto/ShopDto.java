package com.example.sale.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ShopDto {

    private List<ShopProDto> shopProDto;

    private float costSum;

    public ShopDto() {

    }
}
