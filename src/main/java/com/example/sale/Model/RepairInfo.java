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
   	@Column(name = "proId" )
	private String proId;

   	@Column(name = "repairQus" )
	private String repairQus;

   	@Column(name = "repairName" )
	private String repairName;

   	@Column(name = "repairPay" )
	private String repairPay;

   	@Column(name = "repairTime" )
	private Date repairTime;

   	@Column(name = "repairBackTime" )
	private Date repairBackTime;
}
