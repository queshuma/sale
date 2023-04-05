package com.example.sale.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private String userName;
    private String userPetName;
    private String userSex;
    private String userPhone;
    private String userEmail;
    private Date userDate;
    private String userAddress;
    private String userPassword;

//    public UserDto(long userId, String userName, String userPetName, String userSex
//            , String userPhone, String userAddress, String userEmail, Date userDate) {
//        this.userId = userId;
//        this.userName = userName;
//        this.userPetName = userPetName;
//        this.userSex = userSex;
//        this.userPhone = userPhone;
//        this.userDate = userDate;
//        this.userAddress = userAddress;
//        this.userEmail = userEmail;
//    }

    public UserDto() {

    }
}