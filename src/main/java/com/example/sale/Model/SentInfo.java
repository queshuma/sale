package com.example.sale.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * sentInfo
 * 
 * @author <a href = "SHUZHI" > huan </a >
 * @date 2023-03-27 09:36:46 
 */

@Data
@Entity
@Table ( name ="sentinfo")
public class SentInfo implements Serializable {

	@Id
   	@Column(name = "proid" )
	private long proId;

   	@Column(name = "sentfirstpay" )
	private float sentFirstPay;

   	@Column(name = "sentsecondpay" )
	private float sentSecondPay;

   	@Column(name = "sentthirdpay" )
	private float sentThirdPay;

	@Column(name = "sentforthpay" )
	private float sentForthPay;

	@Column(name = "sentfirthpay" )
	private float sentFirthPay;

   	@Column(name = "sentbuy" )
	private float sentBuy;

   	@Column(name = "sentdiscount" )
	private float sentDiscount;

	public SentInfo() {

	}
}
