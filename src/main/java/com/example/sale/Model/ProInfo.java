package com.example.sale.Model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "proinfo")
public class ProInfo implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "proid")
  private long proId;

  @NotNull
  @Column(name = "proname")
  private String proName;

  @NotNull
  @Column(name = "proclass")
  private String proClass;

  @NotNull
  @Column(name = "proqual")
  private double proQual;

  @NotNull
  @Column(name = "provalue")
  private long proValue;

  @NotNull
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "protimes")
  private Date proTimes;

  @NotNull
  @Column(name = "prohas")
  private String proHas;

  @NotNull
  @Column(name = "profrom")
  private String proFrom;

  public ProInfo() {

  }
}
