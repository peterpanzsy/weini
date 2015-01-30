package com.weini.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// default package

import org.hibernate.annotations.GenericGenerator;

/**
 * TAlipay entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_alipay")
public class TAlipay implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "alipay_id") 
	public Integer getAlipayId() {
		return this.alipayId;
	}

	public void setAlipayId(Integer alipayId) {
		this.alipayId = alipayId;
	}
	@Column(name = "alipay_username",nullable = false)
	public String getAlipayUsername() {
		return this.alipayUsername;
	}

	public void setAlipayUsername(String alipayUsername) {
		this.alipayUsername = alipayUsername;
	}
	@Column(name = "alipay_userAccount",nullable = false)
	public String getAlipayUserAccount() {
		return this.alipayUserAccount;
	}

	public void setAlipayUserAccount(String alipayUserAccount) {
		this.alipayUserAccount = alipayUserAccount;
	}
	@Column(name = "alipay_userid",nullable = false)
	public Integer getAlipayUserid() {
		return this.alipayUserid;
	}

	public void setAlipayUserid(Integer alipayUserid) {
		this.alipayUserid = alipayUserid;
	}

}