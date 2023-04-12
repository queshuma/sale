package com.example.sale.Dto;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class OrderDto {
    private long userId;
    private String userPetName;
    private String userName;
    private String userPhone;
    private String userAddress;
    private int proCount;
    private Date costTime = new Date();
    private float costSum;
    private List<ShopDto> shopDtoList;

    public OrderDto() {

    }
}
