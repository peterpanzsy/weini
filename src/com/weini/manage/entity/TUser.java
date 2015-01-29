package com.weini.manage.entity;
// default package

import java.util.Date;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

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
	private String userHeat;
	private Integer userDispatchdefaultId;
	private Integer userAppetite;

	// Constructors

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
			Integer userPointDefault, Date userRegdate, String userHeat,
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getUserGender() {
		return this.userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhoneNumber() {
		return this.userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public Integer getUserPhoneType() {
		return this.userPhoneType;
	}

	public void setUserPhoneType(Integer userPhoneType) {
		this.userPhoneType = userPhoneType;
	}

	public Integer getUserScale() {
		return this.userScale;
	}

	public void setUserScale(Integer userScale) {
		this.userScale = userScale;
	}

	public Integer getUserBankDefault() {
		return this.userBankDefault;
	}

	public void setUserBankDefault(Integer userBankDefault) {
		this.userBankDefault = userBankDefault;
	}

	public Integer getUserAlipayDefault() {
		return this.userAlipayDefault;
	}

	public void setUserAlipayDefault(Integer userAlipayDefault) {
		this.userAlipayDefault = userAlipayDefault;
	}

	public String getUserWeChatPay() {
		return this.userWeChatPay;
	}

	public void setUserWeChatPay(String userWeChatPay) {
		this.userWeChatPay = userWeChatPay;
	}

	public Integer getUserPointDefault() {
		return this.userPointDefault;
	}

	public void setUserPointDefault(Integer userPointDefault) {
		this.userPointDefault = userPointDefault;
	}

	public Date getUserRegdate() {
		return this.userRegdate;
	}

	public void setUserRegdate(Date userRegdate) {
		this.userRegdate = userRegdate;
	}

	public String getUserHeat() {
		return this.userHeat;
	}

	public void setUserHeat(String userHeat) {
		this.userHeat = userHeat;
	}

	public Integer getUserDispatchdefaultId() {
		return this.userDispatchdefaultId;
	}

	public void setUserDispatchdefaultId(Integer userDispatchdefaultId) {
		this.userDispatchdefaultId = userDispatchdefaultId;
	}

	public Integer getUserAppetite() {
		return this.userAppetite;
	}

	public void setUserAppetite(Integer userAppetite) {
		this.userAppetite = userAppetite;
	}

}