package com.weini.manage.entity;
// default package

/**
 * TDispatching entity. @author MyEclipse Persistence Tools
 */

public class TDispatching implements java.io.Serializable {

	// Fields

	private Integer dispatchingId;
	private String dispatchingProvince;
	private String dispatchingCity;
	private Integer dispatchingBusinessAreaid;
	private String dispatchingOfficeBuilding;
	private String dispatchingAddressDetail;

	// Constructors

	/** default constructor */
	public TDispatching() {
	}

	/** full constructor */
	public TDispatching(String dispatchingProvince, String dispatchingCity,
			Integer dispatchingBusinessAreaid,
			String dispatchingOfficeBuilding, String dispatchingAddressDetail) {
		this.dispatchingProvince = dispatchingProvince;
		this.dispatchingCity = dispatchingCity;
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
		this.dispatchingAddressDetail = dispatchingAddressDetail;
	}

	// Property accessors

	public Integer getDispatchingId() {
		return this.dispatchingId;
	}

	public void setDispatchingId(Integer dispatchingId) {
		this.dispatchingId = dispatchingId;
	}

	public String getDispatchingProvince() {
		return this.dispatchingProvince;
	}

	public void setDispatchingProvince(String dispatchingProvince) {
		this.dispatchingProvince = dispatchingProvince;
	}

	public String getDispatchingCity() {
		return this.dispatchingCity;
	}

	public void setDispatchingCity(String dispatchingCity) {
		this.dispatchingCity = dispatchingCity;
	}

	public Integer getDispatchingBusinessAreaid() {
		return this.dispatchingBusinessAreaid;
	}

	public void setDispatchingBusinessAreaid(Integer dispatchingBusinessAreaid) {
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
	}

	public String getDispatchingOfficeBuilding() {
		return this.dispatchingOfficeBuilding;
	}

	public void setDispatchingOfficeBuilding(String dispatchingOfficeBuilding) {
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
	}

	public String getDispatchingAddressDetail() {
		return this.dispatchingAddressDetail;
	}

	public void setDispatchingAddressDetail(String dispatchingAddressDetail) {
		this.dispatchingAddressDetail = dispatchingAddressDetail;
	}

}