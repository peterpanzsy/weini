package com.weini.manage.business;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Vendor  implements java.io.Serializable {
   
	private static final long serialVersionUID = 8219783208388795965L;
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
    
	/** default constructor */
    public Vendor() {
    }

	public Vendor(int order, int vendorID, String vendorName,
			String vendorMail, String vendorPhonenum,
			Boolean vendorIsopen, int vendorTotalmoney, int vendorPaidmoney,
			int vendorRemainedmoney, int vendorEmploynum, int vendorCooknum,
			String vendorShophourStart, String vendorShophourEnd,
			int vendorPaytype, String vendorAccount, String vendorBusinessArea,
			String vendorDis, String vendorCity, String vendorProvince,String vendorDetail) {
		super();
		this.order = order;
		this.vendorID = vendorID;
		this.vendorName = vendorName;
		this.vendorMail = vendorMail;
		this.vendorPhonenum = vendorPhonenum;
		this.vendorIsopen = vendorIsopen;
		this.vendorTotalmoney = vendorTotalmoney;
		this.vendorPaidmoney = vendorPaidmoney;
		this.vendorRemainedmoney = vendorRemainedmoney;
		this.vendorEmploynum = vendorEmploynum;
		this.vendorCooknum = vendorCooknum;
		this.vendorShophourStart = vendorShophourStart;
		this.vendorShophourEnd = vendorShophourEnd;
		this.vendorPaytype = vendorPaytype;
		this.vendorAccount = vendorAccount;
		this.vendorBusinessArea = vendorBusinessArea;
		this.vendorDis = vendorDis;
		this.vendorCity = vendorCity;
		this.vendorProvince = vendorProvince;
		this.vendorDetail=vendorDetail;
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

	public int getVendorPaytype() {
		return vendorPaytype;
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
	
	

}