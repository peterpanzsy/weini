package com.weini.manage.business;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class User  implements java.io.Serializable {
   
	private static final long serialVersionUID = 8219783208388795965L;
	private int order;
    private int userID;
    private String userName;
    private int userGender;
    private String userAddress;
    private String userPhoneNumber;
    private int userPhoneType;
    private int userScale;
    
    private String bankName;
    private String bankUserName;
    private String bankCardNumber;
    private String subBankName;
    private String subBankAddress;
	
    private String alipayUserName;
    private String alipayUserAccount;
    
	private String weChatPay;
	
	private Date userRegdate;
	
	private int pointTotal;

	public User(int order, int userID, String userName, int userGender,
			String userAddress, String userPhoneNumber, int userPhoneType,
			int userScale, String bankName, String bankUserName,
			String bankCardNumber, String subBankName, String subBankAddress,
			String alipayUserName, String alipayUserAccount, String weChatPay,
			Date userRegdate, int pointTotal) {
		super();
		this.order = order;
		this.userID = userID;
		this.userName = userName;
		this.userGender = userGender;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
		this.userPhoneType = userPhoneType;
		this.userScale = userScale;
		this.bankName = bankName;
		this.bankUserName = bankUserName;
		this.bankCardNumber = bankCardNumber;
		this.subBankName = subBankName;
		this.subBankAddress = subBankAddress;
		this.alipayUserName = alipayUserName;
		this.alipayUserAccount = alipayUserAccount;
		this.weChatPay = weChatPay;
		this.userRegdate = userRegdate;
		this.pointTotal = pointTotal;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserGender() {
		return userGender;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public int getUserPhoneType() {
		return userPhoneType;
	}

	public void setUserPhoneType(int userPhoneType) {
		this.userPhoneType = userPhoneType;
	}

	public int getUserScale() {
		return userScale;
	}

	public void setUserScale(int userScale) {
		this.userScale = userScale;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankUserName() {
		return bankUserName;
	}

	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getSubBankName() {
		return subBankName;
	}

	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}

	public String getSubBankAddress() {
		return subBankAddress;
	}

	public void setSubBankAddress(String subBankAddress) {
		this.subBankAddress = subBankAddress;
	}

	public String getAlipayUserName() {
		return alipayUserName;
	}

	public void setAlipayUserName(String alipayUserName) {
		this.alipayUserName = alipayUserName;
	}

	public String getAlipayUserAccount() {
		return alipayUserAccount;
	}

	public void setAlipayUserAccount(String alipayUserAccount) {
		this.alipayUserAccount = alipayUserAccount;
	}

	public String getWeChatPay() {
		return weChatPay;
	}

	public void setWeChatPay(String weChatPay) {
		this.weChatPay = weChatPay;
	}

	public Date getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(Date userRegdate) {
		this.userRegdate = userRegdate;
	}

	public int getPointTotal() {
		return pointTotal;
	}

	public void setPointTotal(int pointTotal) {
		this.pointTotal = pointTotal;
	}
	
	
	

}