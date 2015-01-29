package com.weini.manage.entity;
// default package

/**
 * TDispatching entity. @author MyEclipse Persistence Tools
 */

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
			Integer userId) {
		this.dispatchingProvince = dispatchingProvince;
		this.dispatchingCity = dispatchingCity;
		this.dispatchingDistrict = dispatchingDistrict;
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
		this.dispatchingAddressDetail = dispatchingAddressDetail;
		this.userId = userId;
	}

	// Property accessors

	public Integer getDispatchingId() {
		return this.dispatchingId;
	}

	public void setDispatchingId(Integer dispatchingId) {
		this.dispatchingId = dispatchingId;
	}

	public Integer getDispatchingProvince() {
		return this.dispatchingProvince;
	}

	public void setDispatchingProvince(Integer dispatchingProvince) {
		this.dispatchingProvince = dispatchingProvince;
	}

	public Integer getDispatchingCity() {
		return this.dispatchingCity;
	}

	public void setDispatchingCity(Integer dispatchingCity) {
		this.dispatchingCity = dispatchingCity;
	}

	public Integer getDispatchingDistrict() {
		return this.dispatchingDistrict;
	}

	public void setDispatchingDistrict(Integer dispatchingDistrict) {
		this.dispatchingDistrict = dispatchingDistrict;
	}

	public Integer getDispatchingBusinessAreaid() {
		return this.dispatchingBusinessAreaid;
	}

	public void setDispatchingBusinessAreaid(Integer dispatchingBusinessAreaid) {
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
	}

	public Integer getDispatchingOfficeBuilding() {
		return this.dispatchingOfficeBuilding;
	}

	public void setDispatchingOfficeBuilding(Integer dispatchingOfficeBuilding) {
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
	}

	public String getDispatchingAddressDetail() {
		return this.dispatchingAddressDetail;
	}

	public void setDispatchingAddressDetail(String dispatchingAddressDetail) {
		this.dispatchingAddressDetail = dispatchingAddressDetail;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}