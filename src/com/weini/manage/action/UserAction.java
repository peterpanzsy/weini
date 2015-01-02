package com.weini.manage.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.Admin;
import com.weini.manage.business.Auth;
import com.weini.manage.business.User;
import com.weini.manage.business.Vendor;
import com.weini.manage.dao.UserDao;
import com.weini.manage.dao.VendorDao;
import com.weini.tools.CipherUtil;


public class UserAction extends ActionSupport{
	String mark;
	List<User> dataList;
	
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

	public String listUser(){//根据角色获取账户列表		
		UserDao dao=new UserDao();
		dataList=dao.getUserList();
		dao.close();
		return "SUCCESS";
	}
	public String updateVendor(){//更新或者添加账户 
	
		return "SUCCESS";
	}
	public String delUser(){//删除账户		
		UserDao dao=new UserDao();
		dao.delUser(userID);
		dao.close();
		return "SUCCESS";
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public List<User> getDataList() {
		return dataList;
	}
	public void setDataList(List<User> dataList) {
		this.dataList = dataList;
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