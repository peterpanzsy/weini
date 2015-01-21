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
	private Integer userBank;
	private Integer userAlipay;
	private Date userRegdate;
	private String userPhoneNumber;
	private Integer userPhoneType;
	private Integer userPoint;
	private Integer userScale;
	private String userWeChatPay;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String userName, String userPwd, Integer userGender,
			String userAddress, Integer userBank, Integer userAlipay,
			Date userRegdate, String userPhoneNumber, Integer userPhoneType,
			Integer userPoint, Integer userScale, String userWeChatPay) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userGender = userGender;
		this.userAddress = userAddress;
		this.userBank = userBank;
		this.userAlipay = userAlipay;
		this.userRegdate = userRegdate;
		this.userPhoneNumber = userPhoneNumber;
		this.userPhoneType = userPhoneType;
		this.userPoint = userPoint;
		this.userScale = userScale;
		this.userWeChatPay = userWeChatPay;
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

	public Integer getUserBank() {
		return this.userBank;
	}

	public void setUserBank(Integer userBank) {
		this.userBank = userBank;
	}

	public Integer getUserAlipay() {
		return this.userAlipay;
	}

	public void setUserAlipay(Integer userAlipay) {
		this.userAlipay = userAlipay;
	}

	public Date getUserRegdate() {
		return this.userRegdate;
	}

	public void setUserRegdate(Date userRegdate) {
		this.userRegdate = userRegdate;
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

	public Integer getUserPoint() {
		return this.userPoint;
	}

	public void setUserPoint(Integer userPoint) {
		this.userPoint = userPoint;
	}

	public Integer getUserScale() {
		return this.userScale;
	}

	public void setUserScale(Integer userScale) {
		this.userScale = userScale;
	}

	public String getUserWeChatPay() {
		return this.userWeChatPay;
	}

	public void setUserWeChatPay(String userWeChatPay) {
		this.userWeChatPay = userWeChatPay;
	}

}