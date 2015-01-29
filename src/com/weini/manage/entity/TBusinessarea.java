package com.weini.manage.entity;
// default package

/**
 * TBusinessarea entity. @author MyEclipse Persistence Tools
 */

public class TBusinessarea implements java.io.Serializable {

	// Fields

	private Integer businessAreaId;
	private String businessAreaName;
	private Integer districtId;

	// Constructors

	/** default constructor */
	public TBusinessarea() {
	}

	/** full constructor */
	public TBusinessarea(String businessAreaName, Integer districtId) {
		this.businessAreaName = businessAreaName;
		this.districtId = districtId;
	}

	// Property accessors

	public Integer getBusinessAreaId() {
		return this.businessAreaId;
	}

	public void setBusinessAreaId(Integer businessAreaId) {
		this.businessAreaId = businessAreaId;
	}

	public String getBusinessAreaName() {
		return this.businessAreaName;
	}

	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

}