package com.example.sale.Dto;

import lombok.Data;

@Data
public class UserDto {
    private long userId;
    private String userName;
    private String userSex;
    private String userPhone;
    private String userEmail;
    private String userAddress;
    private String userPassword;

    public UserDto(long userId, String userName, String userSex
            , String userPhone, String userAddress, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
    }
}