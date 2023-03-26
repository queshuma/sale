package com.example.sale.Model;


import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RepairInfo implements Serializable {

  @Id
  @Column(name = "proid")
  private Long proId;
  private String repairQus;
  private String repairName;
  private String repairPay;
  private java.sql.Timestamp repairTime;
  private java.sql.Timestamp repairBackTime;


  public Long getProId() {
    return proId;
  }

  public void setProId(Long proId) {
    this.proId = proId;
  }


  public String getRepairQus() {
    return repairQus;
  }

  public void setRepairQus(String repairQus) {
    this.repairQus = repairQus;
  }


  public String getRepairName() {
    return repairName;
  }

  public void setRepairName(String repairName) {
    this.repairName = repairName;
  }


  public String getRepairPay() {
    return repairPay;
  }

  public void setRepairPay(String repairPay) {
    this.repairPay = repairPay;
  }


  public java.sql.Timestamp getRepairTime() {
    return repairTime;
  }

  public void setRepairTime(java.sql.Timestamp repairTime) {
    this.repairTime = repairTime;
  }


  public java.sql.Timestamp getRepairBackTime() {
    return repairBackTime;
  }

  public void setRepairBackTime(java.sql.Timestamp repairBackTime) {
    this.repairBackTime = repairBackTime;
  }

}
