package com.weini.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// default package

import org.hibernate.annotations.GenericGenerator;

/**
 * TBank entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_bank")
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
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "bank_id") 
	public Integer getBankId() {
		return this.bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	@Column(name = "bank_username",nullable = false)
	public String getBankUsername() {
		return this.bankUsername;
	}

	public void setBankUsername(String bankUsername) {
		this.bankUsername = bankUsername;
	}
	@Column(name = "bank_cardNumber",nullable = false)
	public String getBankCardNumber() {
		return this.bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
	@Column(name = "alipay_username",nullable = false)
	public String getBankBankname() {
		return this.bankBankname;
	}

	public void setBankBankname(String bankBankname) {
		this.bankBankname = bankBankname;
	}
	@Column(name = "bank_bankname",nullable = false)
	public String getBankSubBankname() {
		return this.bankSubBankname;
	}

	public void setBankSubBankname(String bankSubBankname) {
		this.bankSubBankname = bankSubBankname;
	}
	@Column(name = "bank_sub_bankAddress",nullable = false)
	public String getBankSubBankAddress() {
		return this.bankSubBankAddress;
	}

	public void setBankSubBankAddress(String bankSubBankAddress) {
		this.bankSubBankAddress = bankSubBankAddress;
	}
	@Column(name = "bank_userType",nullable = false)
	public Integer getBankUserType() {
		return this.bankUserType;
	}

	public void setBankUserType(Integer bankUserType) {
		this.bankUserType = bankUserType;
	}
	@Column(name = "bank_userid",nullable = false)
	public Integer getBankUserid() {
		return this.bankUserid;
	}

	public void setBankUserid(Integer bankUserid) {
		this.bankUserid = bankUserid;
	}

}
