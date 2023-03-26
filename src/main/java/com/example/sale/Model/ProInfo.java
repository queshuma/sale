package com.example.sale.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "proinfo")
public class ProInfo implements Serializable{
  @Id
  @Column(name = "proid")
  private long proId;
  @Column(name = "proname")
  private String proName;
  @Column(name = "proclass")
  private String proClass;
  @Column(name = "proqual")
  private double proQual;
  @Column(name = "provalue")
  private long proValue;
  @Column(name = "prorenttimes")
  private String proRentTimes;
  @Column(name = "prohas")
  private String proHas;
  @Column(name = "profrom")
  private String proFrom;


  public long getProId() {
    return proId;
  }

  public void setProId(long proId) {
    this.proId = proId;
  }


  public String getProName() {
    return proName;
  }

  public void setProName(String proName) {
    this.proName = proName;
  }


  public String getProClass() {
    return proClass;
  }

  public void setProClass(String proClass) {
    this.proClass = proClass;
  }


  public double getProQual() {
    return proQual;
  }

  public void setProQual(double proQual) {
    this.proQual = proQual;
  }


  public long getProValue() {
    return proValue;
  }

  public void setProValue(long proValue) {
    this.proValue = proValue;
  }


  public String getProRentTimes() {
    return proRentTimes;
  }

  public void setProRentTimes(String proRentTimes) {
    this.proRentTimes = proRentTimes;
  }


  public String getProHas() {
    return proHas;
  }

  public void setProHas(String proHas) {
    this.proHas = proHas;
  }


  public String getProFrom() {
    return proFrom;
  }

  public void setProFrom(String proFrom) {
    this.proFrom = proFrom;
  }
}
