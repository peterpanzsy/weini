package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TVendor entity. @author MyEclipse Persistence Tools
 */

public class TVendor implements java.io.Serializable {

	// Fields

	private Integer vendorId;
	private String vendorName;
	private String vendorMail;
	private String vendorPhonenum;
	private String vendorPwd;
	private Boolean vendorIsopen;
	private Integer vendorTotalmoney;
	private Integer vendorPaidmoney;
	private Integer vendorRemianedmoney;
	private Integer vendorEmployernum;
	private Integer vendorCooknum;
	private String vendorDetail;
	private Timestamp vendorShophour;
	private Integer vendorPaytype;
	private Integer bssinfoBusinessAreaid;
	private Integer vendorDefaultAccountid;

	// Constructors

	/** default constructor */
	public TVendor() {
	}

	/** minimal constructor */
	public TVendor(Integer bssinfoBusinessAreaid) {
		this.bssinfoBusinessAreaid = bssinfoBusinessAreaid;
	}

	/** full constructor */
	public TVendor(String vendorName, String vendorMail, String vendorPhonenum,
			String vendorPwd, Boolean vendorIsopen, Integer vendorTotalmoney,
			Integer vendorPaidmoney, Integer vendorRemianedmoney,
			Integer vendorEmployernum, Integer vendorCooknum,
			String vendorDetail, Timestamp vendorShophour,
			Integer vendorPaytype, Integer bssinfoBusinessAreaid,
			Integer vendorDefaultAccountid) {
		this.vendorName = vendorName;
		this.vendorMail = vendorMail;
		this.vendorPhonenum = vendorPhonenum;
		this.vendorPwd = vendorPwd;
		this.vendorIsopen = vendorIsopen;
		this.vendorTotalmoney = vendorTotalmoney;
		this.vendorPaidmoney = vendorPaidmoney;
		this.vendorRemianedmoney = vendorRemianedmoney;
		this.vendorEmployernum = vendorEmployernum;
		this.vendorCooknum = vendorCooknum;
		this.vendorDetail = vendorDetail;
		this.vendorShophour = vendorShophour;
		this.vendorPaytype = vendorPaytype;
		this.bssinfoBusinessAreaid = bssinfoBusinessAreaid;
		this.vendorDefaultAccountid = vendorDefaultAccountid;
	}

	// Property accessors

	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return this.vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorMail() {
		return this.vendorMail;
	}

	public void setVendorMail(String vendorMail) {
		this.vendorMail = vendorMail;
	}

	public String getVendorPhonenum() {
		return this.vendorPhonenum;
	}

	public void setVendorPhonenum(String vendorPhonenum) {
		this.vendorPhonenum = vendorPhonenum;
	}

	public String getVendorPwd() {
		return this.vendorPwd;
	}

	public void setVendorPwd(String vendorPwd) {
		this.vendorPwd = vendorPwd;
	}

	public Boolean getVendorIsopen() {
		return this.vendorIsopen;
	}

	public void setVendorIsopen(Boolean vendorIsopen) {
		this.vendorIsopen = vendorIsopen;
	}

	public Integer getVendorTotalmoney() {
		return this.vendorTotalmoney;
	}

	public void setVendorTotalmoney(Integer vendorTotalmoney) {
		this.vendorTotalmoney = vendorTotalmoney;
	}

	public Integer getVendorPaidmoney() {
		return this.vendorPaidmoney;
	}

	public void setVendorPaidmoney(Integer vendorPaidmoney) {
		this.vendorPaidmoney = vendorPaidmoney;
	}

	public Integer getVendorRemianedmoney() {
		return this.vendorRemianedmoney;
	}

	public void setVendorRemianedmoney(Integer vendorRemianedmoney) {
		this.vendorRemianedmoney = vendorRemianedmoney;
	}

	public Integer getVendorEmployernum() {
		return this.vendorEmployernum;
	}

	public void setVendorEmployernum(Integer vendorEmployernum) {
		this.vendorEmployernum = vendorEmployernum;
	}

	public Integer getVendorCooknum() {
		return this.vendorCooknum;
	}

	public void setVendorCooknum(Integer vendorCooknum) {
		this.vendorCooknum = vendorCooknum;
	}

	public String getVendorDetail() {
		return this.vendorDetail;
	}

	public void setVendorDetail(String vendorDetail) {
		this.vendorDetail = vendorDetail;
	}

	public Timestamp getVendorShophour() {
		return this.vendorShophour;
	}

	public void setVendorShophour(Timestamp vendorShophour) {
		this.vendorShophour = vendorShophour;
	}

	public Integer getVendorPaytype() {
		return this.vendorPaytype;
	}

	public void setVendorPaytype(Integer vendorPaytype) {
		this.vendorPaytype = vendorPaytype;
	}

	public Integer getBssinfoBusinessAreaid() {
		return this.bssinfoBusinessAreaid;
	}

	public void setBssinfoBusinessAreaid(Integer bssinfoBusinessAreaid) {
		this.bssinfoBusinessAreaid = bssinfoBusinessAreaid;
	}

	public Integer getVendorDefaultAccountid() {
		return this.vendorDefaultAccountid;
	}

	public void setVendorDefaultAccountid(Integer vendorDefaultAccountid) {
		this.vendorDefaultAccountid = vendorDefaultAccountid;
	}

}