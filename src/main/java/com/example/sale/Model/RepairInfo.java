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
@Table ( name ="repairinfo")
public class RepairInfo  implements Serializable {

	private static final long serialVersionUID =  3526473407725010071L;

	@Id
   	@Column(name = "proid" )
	private long proId;

   	@Column(name = "userid" )
	private long userId;

	@Column(name = "senttime")
	private int sentTime;

   	@Column(name = "addtime" )
	private Date addTime;
}
