package com.weini.manage.entity;
// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;
/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_user")
public class TUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPwd;
	private Integer userGender;
	private String userAddress;
	private String userPhoneNumber;
	private Integer userPhoneType;
	private Integer userScale;
	private Integer userBankDefault;
	private Integer userAlipayDefault;
	private String userWeChatPay;
	private Integer userPointDefault;
	private Date userRegdate;
	private Integer userHeat;
	private Integer userDispatchdefaultId;
	private Integer userAppetite;
	//add 在平台上累计的天数
	private Integer countDays;  
	// Constructors

	//add
	public String notEat;  //不吃
	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String userName) {
		this.userName = userName;
	}

	/** full constructor */
	public TUser(String userName, String userPwd, Integer userGender,
			String userAddress, String userPhoneNumber, Integer userPhoneType,
			Integer userScale, Integer userBankDefault,
			Integer userAlipayDefault, String userWeChatPay,
			Integer userPointDefault, Date userRegdate, Integer userHeat,
			Integer userDispatchdefaultId, Integer userAppetite) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userGender = userGender;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
		this.userPhoneType = userPhoneType;
		this.userScale = userScale;
		this.userBankDefault = userBankDefault;
		this.userAlipayDefault = userAlipayDefault;
		this.userWeChatPay = userWeChatPay;
		this.userPointDefault = userPointDefault;
		this.userRegdate = userRegdate;
		this.userHeat = userHeat;
		this.userDispatchdefaultId = userDispatchdefaultId;
		this.userAppetite = userAppetite;
	}

	// Property accessors
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "user_id") 
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "user_pwd")
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Column(name = "user_gender")
	public Integer getUserGender() {
		return this.userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}
	@Column(name = "user_address")
	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Column(name = "user_phoneNumber")
	public String getUserPhoneNumber() {
		return this.userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	@Column(name = "user_phoneType")
	public Integer getUserPhoneType() {
		return this.userPhoneType;
	}

	public void setUserPhoneType(Integer userPhoneType) {
		this.userPhoneType = userPhoneType;
	}
	@Column(name = "user_scale")
	public Integer getUserScale() {
		return this.userScale;
	}

	public void setUserScale(Integer userScale) {
		this.userScale = userScale;
	}
	@Column(name = "user_bank_default")
	public Integer getUserBankDefault() {
		return this.userBankDefault;
	}

	public void setUserBankDefault(Integer userBankDefault) {
		this.userBankDefault = userBankDefault;
	}
	@Column(name = "user_alipay_default")
	public Integer getUserAlipayDefault() {
		return this.userAlipayDefault;
	}

	public void setUserAlipayDefault(Integer userAlipayDefault) {
		this.userAlipayDefault = userAlipayDefault;
	}
	@Column(name = "user_weChatPay")
	public String getUserWeChatPay() {
		return this.userWeChatPay;
	}

	public void setUserWeChatPay(String userWeChatPay) {
		this.userWeChatPay = userWeChatPay;
	}
	@Column(name = "user_point_default")
	public Integer getUserPointDefault() {
		return this.userPointDefault;
	}

	public void setUserPointDefault(Integer userPointDefault) {
		this.userPointDefault = userPointDefault;
	}
	@Column(name = "user_regdate")
	public Date getUserRegdate() {
		return this.userRegdate;
	}

	public void setUserRegdate(Date userRegdate) {
		this.userRegdate = userRegdate;
	}
	

	@Column(name = "user_dispatchdefault_id")
	public Integer getUserDispatchdefaultId() {
		return this.userDispatchdefaultId;
	}
	@Column(name = "user_heat")
	public Integer getUserHeat() {
		return userHeat;
	}

	public void setUserDispatchdefaultId(Integer userDispatchdefaultId) {
		this.userDispatchdefaultId = userDispatchdefaultId;
	}
	@Column(name = "user_appetite")
	public Integer getUserAppetite() {
		return this.userAppetite;
	}

	public void setUserAppetite(Integer userAppetite) {
		this.userAppetite = userAppetite;
	}
	@Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }
	@Transient
	public Integer getCountDays() {
		return countDays;
	}
	@Transient
	public String getNotEat() {
		return notEat;
	}

	public void setNotEat(String notEat) {
		this.notEat = notEat;
	}

	public void setUserHeat(Integer userHeat) {
		this.userHeat = userHeat;
	}

	public void setCountDays(Integer countDays) {
		this.countDays = countDays;
	}
	
}
