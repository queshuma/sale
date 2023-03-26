package com.example.sale.Model;


public class UserInfo {

  private String userId;
  private String userName;
  private String userSex;
  private java.sql.Timestamp userDate;
  private String userPhone;
  private String userEmail;
  private String userAddress;
  private long userRentTimes;
  private long userBuyTimes;
  private long userRentPay;
  private long userBuyPay;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserSex() {
    return userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }


  public java.sql.Timestamp getUserDate() {
    return userDate;
  }

  public void setUserDate(java.sql.Timestamp userDate) {
    this.userDate = userDate;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }


  public long getUserRentTimes() {
    return userRentTimes;
  }

  public void setUserRentTimes(long userRentTimes) {
    this.userRentTimes = userRentTimes;
  }


  public long getUserBuyTimes() {
    return userBuyTimes;
  }

  public void setUserBuyTimes(long userBuyTimes) {
    this.userBuyTimes = userBuyTimes;
  }


  public long getUserRentPay() {
    return userRentPay;
  }

  public void setUserRentPay(long userRentPay) {
    this.userRentPay = userRentPay;
  }


  public long getUserBuyPay() {
    return userBuyPay;
  }

  public void setUserBuyPay(long userBuyPay) {
    this.userBuyPay = userBuyPay;
  }

}
