package com.example.sale.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * userFromInfo
 * 
 * @author <a href = "SHUZHI" > huan </a >
 * @date 2023-03-27 09:36:46 
 */

@Entity
@Table ( name ="userFromInfo")
public class UserFromInfo  implements Serializable {

	private static final long serialVersionUID =  5973069099316531625L;

	@Id
   	@Column(name = "proId" )
	private Long proId;

   	@Column(name = "proFrom" )
	private String proFrom;

   	@Column(name = "proBackPay" )
	private BigDecimal proBackPay;

   	@Column(name = "proInTime" )
	private Date proInTime;

   	@Column(name = "proInName" )
	private String proInName;

   	@Column(name = "proQual" )
	private BigDecimal proQual;
}
