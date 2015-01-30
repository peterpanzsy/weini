package com.weini.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// default package



import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * TRegisteraddress entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_registeraddress")
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

	/** minimal constructor */
	public TRegisteraddress(Integer userId,
			Integer registerAddressBusinessAreaid) {
		this.userId = userId;
		this.registerAddressBusinessAreaid = registerAddressBusinessAreaid;
	}

	/** full constructor */
	public TRegisteraddress(Integer userId, String registerAddressDetail,
			Integer registerAddressBusinessAreaid) {
		this.userId = userId;
		this.registerAddressDetail = registerAddressDetail;
		this.registerAddressBusinessAreaid = registerAddressBusinessAreaid;
	}

	// Property accessors
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "registerAddress_id") 
	public Integer getRegisterAddressId() {
		return this.registerAddressId;
	}

	public void setRegisterAddressId(Integer registerAddressId) {
		this.registerAddressId = registerAddressId;
	}
	@Column(name = "user_id",nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "registerAddress_detail")
	public String getRegisterAddressDetail() {
		return this.registerAddressDetail;
	}

	public void setRegisterAddressDetail(String registerAddressDetail) {
		this.registerAddressDetail = registerAddressDetail;
	}
	@Column(name = "registerAddress_businessAreaid",nullable = false)
	public Integer getRegisterAddressBusinessAreaid() {
		return this.registerAddressBusinessAreaid;
	}

	public void setRegisterAddressBusinessAreaid(
			Integer registerAddressBusinessAreaid) {
		this.registerAddressBusinessAreaid = registerAddressBusinessAreaid;
	}
   @Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }  
}