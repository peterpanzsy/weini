package com.weini.manage.entity;
// default package

/**
 * TDistrict entity. @author MyEclipse Persistence Tools
 */

public class TDistrict implements java.io.Serializable {

	// Fields

	private Integer districtId;
	private Integer cityId;
	private String districtName;

	// Constructors

	/** default constructor */
	public TDistrict() {
	}

	/** full constructor */
	public TDistrict(Integer cityId, String districtName) {
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