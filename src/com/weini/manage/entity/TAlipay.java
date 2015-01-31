package com.weini.manage.entity;
// default package

/**
 * TAlipay entity. @author MyEclipse Persistence Tools
 */

public class TAlipay implements java.io.Serializable {

	// Fields

	private Integer alipayId;
	private String alipayUsername;
	private String alipayUserAccount;
	private Integer alipayUserid;

	// Constructors

	/** default constructor */
	public TAlipay() {
	}

	/** full constructor */
	public TAlipay(String alipayUsername, String alipayUserAccount,
			Integer alipayUserid) {
		this.alipayUsername = alipayUsername;
		this.alipayUserAccount = alipayUserAccount;
		this.alipayUserid = alipayUserid;
	}

	// Property accessors

	public Integer getAlipayId() {
		return this.alipayId;
	}

	public void setAlipayId(Integer alipayId) {
		this.alipayId = alipayId;
	}

	public String getAlipayUsername() {
		return this.alipayUsername;
	}

	public void setAlipayUsername(String alipayUsername) {
		this.alipayUsername = alipayUsername;
	}

	public String getAlipayUserAccount() {
		return this.alipayUserAccount;
	}

	public void setAlipayUserAccount(String alipayUserAccount) {
		this.alipayUserAccount = alipayUserAccount;
	}

	public Integer getAlipayUserid() {
		return this.alipayUserid;
	}

	public void setAlipayUserid(Integer alipayUserid) {
		this.alipayUserid = alipayUserid;
	}

}