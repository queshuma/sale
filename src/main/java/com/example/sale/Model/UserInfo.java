package com.example.sale.Model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * userInfo
 * 
 * @author <a href = "SHUZHI" > huan </a >
 * @date 2023-03-27 09:36:46 
 */

@Entity
@Data
@Table ( name ="userinfo")
public class UserInfo  implements Serializable {

	private static final long serialVersionUID =  5597909586632887847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "userid" )
	private Long userId;

	@NotNull
   	@Column(name = "username" )
	private String userName;

	@NonNull
	@Column(name = "userpetname" )
	private String userPetName;

	@NotNull
   	@Column(name = "usersex" )
	private String userSex;

	@NotNull
   	@Column(name = "userdate" )
	private Date userDate;

	@NotNull
   	@Column(name = "userphone" )
	private String userPhone;

	@NotNull
   	@Column(name = "useremail" )
	private String userEmail;

   	@Column(name = "useraddress" )
	private String userAddress;

   	@Column(name = "userrenttimes" )
	private Long userRentTimes;

   	@Column(name = "userbuytimes" )
	private Long userBuyTimes;

   	@Column(name = "userrentpay" )
	private Long userRentPay;

   	@Column(name = "userbuypay" )
	private Long userBuyPay;

	@NotNull
	@Column(name = "userpassword" )
	private String userPassword;

	public UserInfo() {

	}
}
