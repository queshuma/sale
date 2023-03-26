package com.example.sale.Model;


public class UserFromInfo {

  private long proId;
  private String proFrom;
  private double proBackPay;
  private java.sql.Timestamp proInTime;
  private String proInName;
  private double proQual;


  public long getProId() {
    return proId;
  }

  public void setProId(long proId) {
    this.proId = proId;
  }


  public String getProFrom() {
    return proFrom;
  }

  public void setProFrom(String proFrom) {
    this.proFrom = proFrom;
  }


  public double getProBackPay() {
    return proBackPay;
  }

  public void setProBackPay(double proBackPay) {
    this.proBackPay = proBackPay;
  }


  public java.sql.Timestamp getProInTime() {
    return proInTime;
  }

  public void setProInTime(java.sql.Timestamp proInTime) {
    this.proInTime = proInTime;
  }


  public String getProInName() {
    return proInName;
  }

  public void setProInName(String proInName) {
    this.proInName = proInName;
  }


  public double getProQual() {
    return proQual;
  }

  public void setProQual(double proQual) {
    this.proQual = proQual;
  }

}
