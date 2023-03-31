package com.example.sale.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

/**
 * mastInfo
 * 
 * @author <a href = "SHUZHI" > huan </a >
 * @date 2023-03-27 09:36:46 
 */

@Entity
@Table ( name ="mastInfo")
public class MastInfo  implements Serializable {

	private static final long serialVersionUID =  6579063383852309305L;

	@Id
   	@Column(name = "mastId" )
	private String mastId;

   	@Column(name = "mastTitle" )
	private String mastTitle;

   	@Column(name = "mastName" )
	private String mastName;

   	@Column(name = "mastPwd" )
	private String mastPwd;
}
