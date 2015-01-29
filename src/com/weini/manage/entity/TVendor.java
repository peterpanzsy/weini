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
	private Integer vendorIsopen;
	private Double vendorTotalmoney;
	private Double vendorPaidmoney;
	private Double vendorRemainedmoney;
	private Integer vendorEmployernum;
	private Integer vendorCooknum;
	private String vendorDetail;
	private Timestamp vendorShophourStart;
	private Integer vendorPaytype;
	private Integer vendorBusinessAreaid;
	private Integer vendorDefaultAccountid;
	private Timestamp vendorShophourEnd;

	// Constructors

	/** default constructor */
	public TVendor() {
	}

	/** minimal constructor */
	public TVendor(String vendorName, String vendorPhonenum, String vendorPwd,
			Integer vendorIsopen, Timestamp vendorShophourStart,
			Integer vendorPaytype, Integer vendorBusinessAreaid,
			Integer vendorDefaultAccountid, Timestamp vendorShophourEnd) {
		this.vendorName = vendorName;
		this.vendorPhonenum = vendorPhonenum;
		this.vendorPwd = vendorPwd;
		this.vendorIsopen = vendorIsopen;
		this.vendorShophourStart = vendorShophourStart;
		this.vendorPaytype = vendorPaytype;
		this.vendorBusinessAreaid = vendorBusinessAreaid;
		this.vendorDefaultAccountid = vendorDefaultAccountid;
		this.vendorShophourEnd = vendorShophourEnd;
	}

	/** full constructor */
	public TVendor(String vendorName, String vendorMail, String vendorPhonenum,
			String vendorPwd, Integer vendorIsopen, Double vendorTotalmoney,
			Double vendorPaidmoney, Double vendorRemainedmoney,
			Integer vendorEmployernum, Integer vendorCooknum,
			String vendorDetail, Timestamp vendorShophourStart,
			Integer vendorPaytype, Integer vendorBusinessAreaid,
			Integer vendorDefaultAccountid, Timestamp vendorShophourEnd) {
		this.vendorName = vendorName;
		this.vendorMail = vendorMail;
		this.vendorPhonenum = vendorPhonenum;
		this.vendorPwd = vendorPwd;
		this.vendorIsopen = vendorIsopen;
		this.vendorTotalmoney = vendorTotalmoney;
		this.vendorPaidmoney = vendorPaidmoney;
		this.vendorRemainedmoney = vendorRemainedmoney;
		this.vendorEmployernum = vendorEmployernum;
		this.vendorCooknum = vendorCooknum;
		this.vendorDetail = vendorDetail;
		this.vendorShophourStart = vendorShophourStart;
		this.vendorPaytype = vendorPaytype;
		this.vendorBusinessAreaid = vendorBusinessAreaid;
		this.vendorDefaultAccountid = vendorDefaultAccountid;
		this.vendorShophourEnd = vendorShophourEnd;
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

	public Integer getVendorIsopen() {
		return this.vendorIsopen;
	}

	public void setVendorIsopen(Integer vendorIsopen) {
		this.vendorIsopen = vendorIsopen;
	}

	public Double getVendorTotalmoney() {
		return this.vendorTotalmoney;
	}

	public void setVendorTotalmoney(Double vendorTotalmoney) {
		this.vendorTotalmoney = vendorTotalmoney;
	}

	public Double getVendorPaidmoney() {
		return this.vendorPaidmoney;
	}

	public void setVendorPaidmoney(Double vendorPaidmoney) {
		this.vendorPaidmoney = vendorPaidmoney;
	}

	public Double getVendorRemainedmoney() {
		return this.vendorRemainedmoney;
	}

	public void setVendorRemainedmoney(Double vendorRemainedmoney) {
		this.vendorRemainedmoney = vendorRemainedmoney;
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

	public Timestamp getVendorShophourStart() {
		return this.vendorShophourStart;
	}

	public void setVendorShophourStart(Timestamp vendorShophourStart) {
		this.vendorShophourStart = vendorShophourStart;
	}

	public Integer getVendorPaytype() {
		return this.vendorPaytype;
	}

	public void setVendorPaytype(Integer vendorPaytype) {
		this.vendorPaytype = vendorPaytype;
	}

	public Integer getVendorBusinessAreaid() {
		return this.vendorBusinessAreaid;
	}

	public void setVendorBusinessAreaid(Integer vendorBusinessAreaid) {
		this.vendorBusinessAreaid = vendorBusinessAreaid;
	}

	public Integer getVendorDefaultAccountid() {
		return this.vendorDefaultAccountid;
	}

	public void setVendorDefaultAccountid(Integer vendorDefaultAccountid) {
		this.vendorDefaultAccountid = vendorDefaultAccountid;
	}

	public Timestamp getVendorShophourEnd() {
		return this.vendorShophourEnd;
	}

	public void setVendorShophourEnd(Timestamp vendorShophourEnd) {
		this.vendorShophourEnd = vendorShophourEnd;
	}

}