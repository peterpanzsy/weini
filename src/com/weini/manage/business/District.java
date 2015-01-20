package com.weini.manage.business;
// default package

/**
 * TDistrict entity. @author MyEclipse Persistence Tools
 */

public class District implements java.io.Serializable {

	// Fields

	private Integer districtId;
	private Integer cityId;
	private String districtName;

	// Constructors

	/** default constructor */
	public District() {
	}

	/** full constructor */
	public District(Integer cityId, String districtName) {
		this.cityId = cityId;
		this.districtName = districtName;
	}

	// Property accessors

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}