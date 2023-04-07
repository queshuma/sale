package com.example.sale.Model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userDate;

	@NotNull
   	@Column(name = "userphone" )
	private String userPhone;

	@NotNull
   	@Column(name = "useremail" )
	private String userEmail;

   	@Column(name = "useraddress" )
	private String userAddress;

   	@Column(name = "userrenttimes")
	private int userRentTimes;

   	@Column(name = "userbuytimes" )
	private int userBuyTimes;

   	@Column(name = "userrentpay" )
	private int userRentPay;

   	@Column(name = "userbuypay" )
	private int userBuyPay;

	@NotNull
	@Column(name = "userpassword" )
	private String userPassword;

	public UserInfo() {

	}
}
