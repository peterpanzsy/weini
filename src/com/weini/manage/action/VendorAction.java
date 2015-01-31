package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.entity.TVendor;


public class VendorAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String adminPassword;
	String confirmPassword;
	String mark;
	int id;
	List<TVendor> dataList;
	
	private int order;
    private int vendorID;
    private String vendorName;
    private String vendorMail;
    private String vendorPhonenum;
    private String vendorPassword;
    private Boolean vendorIsopen;
    private int vendorTotalmoney;
    private int vendorPaidmoney;
    private int vendorRemainedmoney;
    private int vendorEmploynum;
    private int vendorCooknum; 
    private String vendorShophourStart;
    private String vendorShophourEnd;
    private int vendorPaytype;
    private String vendorAccount;
    private String vendorBusinessArea;
    private String vendorDis;
    private String vendorCity;
    private String vendorProvince;
    private String vendorDetail;
	
//	public String listVendor(){//根据角色获取账户列表		
//		VendorDao dao=new VendorDao();
//		dataList=dao.getVendorList();
//		dao.close();
//		return "SUCCESS";
//	}
//	public String updateVendor(){//更新或者添加账户 
//		VendorDao dao=new VendorDao();
//	
//		int res=dao.updateVendor(vendorID,vendorName,vendorMail,vendorPhonenum,vendorIsopen,vendorEmploynum,vendorCooknum,vendorShophourStart,vendorShophourEnd,vendorDetail,mark);
//		dao.close();
//		return "SUCCESS";
//	}
//	public String delVendor(){//删除账户		
//		VendorDao dao=new VendorDao();
//		dao.delVendor(vendorID);
//		dao.close();
//		return "SUCCESS";
//	}
    
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getVendorID() {
		return vendorID;
	}
	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorMail() {
		return vendorMail;
	}
	public void setVendorMail(String vendorMail) {
		this.vendorMail = vendorMail;
	}
	public String getVendorPhonenum() {
		return vendorPhonenum;
	}
	public void setVendorPhonenum(String vendorPhonenum) {
		this.vendorPhonenum = vendorPhonenum;
	}
	public String getVendorPassword() {
		return vendorPassword;
	}
	public void setVendorPassword(String vendorPassword) {
		this.vendorPassword = vendorPassword;
	}
	public Boolean getVendorIsopen() {
		return vendorIsopen;
	}
	public void setVendorIsopen(Boolean vendorIsopen) {
		this.vendorIsopen = vendorIsopen;
	}
	public int getVendorTotalmoney() {
		return vendorTotalmoney;
	}
	public void setVendorTotalmoney(int vendorTotalmoney) {
		this.vendorTotalmoney = vendorTotalmoney;
	}
	public int getVendorPaidmoney() {
		return vendorPaidmoney;
	}
	public void setVendorPaidmoney(int vendorPaidmoney) {
		this.vendorPaidmoney = vendorPaidmoney;
	}
	public int getVendorRemainedmoney() {
		return vendorRemainedmoney;
	}
	public void setVendorRemainedmoney(int vendorRemainedmoney) {
		this.vendorRemainedmoney = vendorRemainedmoney;
	}
	public int getVendorEmploynum() {
		return vendorEmploynum;
	}
	public void setVendorEmploynum(int vendorEmploynum) {
		this.vendorEmploynum = vendorEmploynum;
	}
	public int getVendorCooknum() {
		return vendorCooknum;
	}
	public void setVendorCooknum(int vendorCooknum) {
		this.vendorCooknum = vendorCooknum;
	}
	public int getVendorPaytype() {
		return vendorPaytype;
	}
	public String getVendorShophourStart() {
		return vendorShophourStart;
	}
	public void setVendorShophourStart(String vendorShophourStart) {
		this.vendorShophourStart = vendorShophourStart;
	}
	public String getVendorShophourEnd() {
		return vendorShophourEnd;
	}
	public void setVendorShophourEnd(String vendorShophourEnd) {
		this.vendorShophourEnd = vendorShophourEnd;
	}
	public void setVendorPaytype(int vendorPaytype) {
		this.vendorPaytype = vendorPaytype;
	}
	public String getVendorAccount() {
		return vendorAccount;
	}
	public void setVendorAccount(String vendorAccount) {
		this.vendorAccount = vendorAccount;
	}
	public String getVendorBusinessArea() {
		return vendorBusinessArea;
	}
	public void setVendorBusinessArea(String vendorBusinessArea) {
		this.vendorBusinessArea = vendorBusinessArea;
	}
	public String getVendorDis() {
		return vendorDis;
	}
	public void setVendorDis(String vendorDis) {
		this.vendorDis = vendorDis;
	}
	public String getVendorCity() {
		return vendorCity;
	}
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public String getVendorProvince() {
		return vendorProvince;
	}
	public void setVendorProvince(String vendorProvince) {
		this.vendorProvince = vendorProvince;
	}
	
	public String getVendorDetail() {
		return vendorDetail;
	}
	public void setVendorDetail(String vendorDetail) {
		this.vendorDetail = vendorDetail;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
