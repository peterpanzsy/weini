package com.weini.manage.entity;
// default package

/**
 * TRegisteraddress entity. @author MyEclipse Persistence Tools
 */

public class TRegisteraddress implements java.io.Serializable {

	// Fields

	private Integer registerAddressId;
	private Integer userId;
	private String registerAddressDetail;
	private Integer registerAddressBusinessAreaid;

	// Constructors

	/** default constructor */
	public TRegisteraddress() {
	}

	/** full constructor */
	public TRegisteraddress(Integer userId, String registerAddressDetail,
			Integer registerAddressBusinessAreaid) {
		this.userId = userId;
		this.registerAddressDetail = registerAddressDetail;
		this.registerAddressBusinessAreaid = registerAddressBusinessAreaid;
	}

	// Property accessors

	public Integer getRegisterAddressId() {
		return this.registerAddressId;
	}

	public void setRegisterAddressId(Integer registerAddressId) {
		this.registerAddressId = registerAddressId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRegisterAddressDetail() {
		return this.registerAddressDetail;
	}

	public void setRegisterAddressDetail(String registerAddressDetail) {
		this.registerAddressDetail = registerAddressDetail;
	}

	public Integer getRegisterAddressBusinessAreaid() {
		return this.registerAddressBusinessAreaid;
	}

	public void setRegisterAddressBusinessAreaid(
			Integer registerAddressBusinessAreaid) {
		this.registerAddressBusinessAreaid = registerAddressBusinessAreaid;
	}

}