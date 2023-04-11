package com.example.sale.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;

/**
 * repairInfo
 * 
 * @author <a href = "SHUZHI" > huan </a >
 * @date 2023-03-27 09:36:46 
 */

@Data
@Entity
@Table ( name ="repairInfo")
public class RepairInfo  implements Serializable {

	private static final long serialVersionUID =  3526473407725010071L;

	@Id
   	@Column(name = "proid" )
	private String proId;

   	@Column(name = "repairqus" )
	private String repairQus;

   	@Column(name = "repairname" )
	private String repairName;

   	@Column(name = "repairpay" )
	private String repairPay;

   	@Column(name = "repairtime" )
	private Date repairTime;

   	@Column(name = "repairbacktime" )
	private Date repairBackTime;
}
