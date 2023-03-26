package com.example.sale.Model;


import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SentInfo implements Serializable {

  @Id
  @Column(name = "proid")
  private long proId;
  private long sentFirstPay;
  private long sentSecondPay;
  private long sentThirdPay;
  private long sentBuy;
  private double sentDiscount;


  public long getProId() {
    return proId;
  }

  public void setProId(long proId) {
    this.proId = proId;
  }


  public long getSentFirstPay() {
    return sentFirstPay;
  }

  public void setSentFirstPay(long sentFirstPay) {
    this.sentFirstPay = sentFirstPay;
  }


  public long getSentSecondPay() {
    return sentSecondPay;
  }

  public void setSentSecondPay(long sentSecondPay) {
    this.sentSecondPay = sentSecondPay;
  }


  public long getSentThirdPay() {
    return sentThirdPay;
  }

  public void setSentThirdPay(long sentThirdPay) {
    this.sentThirdPay = sentThirdPay;
  }


  public long getSentBuy() {
    return sentBuy;
  }

  public void setSentBuy(long sentBuy) {
    this.sentBuy = sentBuy;
  }


  public double getSentDiscount() {
    return sentDiscount;
  }

  public void setSentDiscount(double sentDiscount) {
    this.sentDiscount = sentDiscount;
  }

}
