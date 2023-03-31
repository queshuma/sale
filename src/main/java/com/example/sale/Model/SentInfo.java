package com.example.sale.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * sentInfo
 * 
 * @author <a href = "SHUZHI" > huan </a >
 * @date 2023-03-27 09:36:46 
 */

@Entity
@Table ( name ="sentInfo")
public class SentInfo  implements Serializable {

	private static final long serialVersionUID =  6245064774274496210L;

	@Id
   	@Column(name = "proId" )
	private String proId;

   	@Column(name = "sentFirstPay" )
	private Long sentFirstPay;

   	@Column(name = "sentSecondPay" )
	private Long sentSecondPay;

   	@Column(name = "sentThirdPay" )
	private Long sentThirdPay;

   	@Column(name = "sentBuy" )
	private Long sentBuy;

   	@Column(name = "sentDiscount" )
	private BigDecimal sentDiscount;
}
