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
 * TDispatching entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_dispatching")
public class TDispatching implements java.io.Serializable {

	// Fields

	private Integer dispatchingId;
	private Integer dispatchingProvince;
	private Integer dispatchingCity;
	private Integer dispatchingDistrict;
	private Integer dispatchingBusinessAreaid;
	private Integer dispatchingOfficeBuilding;
	private String dispatchingAddressDetail;
	private Integer userId;
	private String dispatchingPhoneNum;
	// Constructors

	/** default constructor */
	public TDispatching() {
	}

	/** minimal constructor */
	public TDispatching(Integer dispatchingProvince, Integer dispatchingCity,
			Integer dispatchingDistrict, Integer dispatchingBusinessAreaid,
			Integer dispatchingOfficeBuilding) {
		this.dispatchingProvince = dispatchingProvince;
		this.dispatchingCity = dispatchingCity;
		this.dispatchingDistrict = dispatchingDistrict;
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
	}

	/** full constructor */
	public TDispatching(Integer dispatchingProvince, Integer dispatchingCity,
			Integer dispatchingDistrict, Integer dispatchingBusinessAreaid,
			Integer dispatchingOfficeBuilding, String dispatchingAddressDetail,
			Integer userId,String dispatchingPhoneNum) {
		this.dispatchingProvince = dispatchingProvince;
		this.dispatchingCity = dispatchingCity;
		this.dispatchingDistrict = dispatchingDistrict;
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
		this.dispatchingAddressDetail = dispatchingAddressDetail;
		this.userId = userId;
		this.dispatchingPhoneNum =dispatchingPhoneNum;
	}

	// Property accessors
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "dispatching_id") 
	public Integer getDispatchingId() {
		return this.dispatchingId;
	}
	public void setDispatchingId(Integer dispatchingId) {
		this.dispatchingId = dispatchingId;
	}
	@Column(name = "dispatching_province",nullable = false)
	public Integer getDispatchingProvince() {
		return this.dispatchingProvince;
	}

	public void setDispatchingProvince(Integer dispatchingProvince) {
		this.dispatchingProvince = dispatchingProvince;
	}
	@Column(name = "dispatching_city",nullable = false)
	public Integer getDispatchingCity() {
		return this.dispatchingCity;
	}

	public void setDispatchingCity(Integer dispatchingCity) {
		this.dispatchingCity = dispatchingCity;
	}
	@Column(name = "dispatching_district",nullable = false)
	public Integer getDispatchingDistrict() {
		return this.dispatchingDistrict;
	}

	public void setDispatchingDistrict(Integer dispatchingDistrict) {
		this.dispatchingDistrict = dispatchingDistrict;
	}
	@Column(name = "dispatching_businessAreaid",nullable = false)
	public Integer getDispatchingBusinessAreaid() {
		return this.dispatchingBusinessAreaid;
	}

	public void setDispatchingBusinessAreaid(Integer dispatchingBusinessAreaid) {
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
	}
	@Column(name = "dispatching_officeBuilding",nullable = false)
	public Integer getDispatchingOfficeBuilding() {
		return this.dispatchingOfficeBuilding;
	}

	public void setDispatchingOfficeBuilding(Integer dispatchingOfficeBuilding) {
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
	}
	@Column(name = "dispatching_addressDetail")
	public String getDispatchingAddressDetail() {
		return this.dispatchingAddressDetail;
	}

	public void setDispatchingAddressDetail(String dispatchingAddressDetail) {
		this.dispatchingAddressDetail = dispatchingAddressDetail;
	}
	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}	
	@Column(name = "dispatching_phoneNum")
	public String getDispatchingPhoneNum() {
		return dispatchingPhoneNum;
	}

	public void setDispatchingPhoneNum(String dispatchingPhoneNum) {
		this.dispatchingPhoneNum = dispatchingPhoneNum;
	}

	@Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }

}