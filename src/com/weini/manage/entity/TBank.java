package com.weini.manage.entity;
// default package

/**
 * TBank entity. @author MyEclipse Persistence Tools
 */

public class TBank implements java.io.Serializable {

	// Fields

	private Integer bankId;
	private String bankUsername;
	private String bankCardNumber;
	private String bankBankname;
	private String bankSubBankname;
	private String bankSubBankAddress;
	private Integer bankUserType;
	private Integer bankUserid;

	// Constructors

	/** default constructor */
	public TBank() {
	}

	/** full constructor */
	public TBank(String bankUsername, String bankCardNumber,
			String bankBankname, String bankSubBankname,
			String bankSubBankAddress, Integer bankUserType, Integer bankUserid) {
		this.bankUsername = bankUsername;
		this.bankCardNumber = bankCardNumber;
		this.bankBankname = bankBankname;
		this.bankSubBankname = bankSubBankname;
		this.bankSubBankAddress = bankSubBankAddress;
		this.bankUserType = bankUserType;
		this.bankUserid = bankUserid;
	}

	// Property accessors

	public Integer getBankId() {
		return this.bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankUsername() {
		return this.bankUsername;
	}

	public void setBankUsername(String bankUsername) {
		this.bankUsername = bankUsername;
	}

	public String getBankCardNumber() {
		return this.bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getBankBankname() {
		return this.bankBankname;
	}

	public void setBankBankname(String bankBankname) {
		this.bankBankname = bankBankname;
	}

	public String getBankSubBankname() {
		return this.bankSubBankname;
	}

	public void setBankSubBankname(String bankSubBankname) {
		this.bankSubBankname = bankSubBankname;
	}

	public String getBankSubBankAddress() {
		return this.bankSubBankAddress;
	}

	public void setBankSubBankAddress(String bankSubBankAddress) {
		this.bankSubBankAddress = bankSubBankAddress;
	}

	public Integer getBankUserType() {
		return this.bankUserType;
	}

	public void setBankUserType(Integer bankUserType) {
		this.bankUserType = bankUserType;
	}

	public Integer getBankUserid() {
		return this.bankUserid;
	}

	public void setBankUserid(Integer bankUserid) {
		this.bankUserid = bankUserid;
	}

}