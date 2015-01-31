package com.weini.manage.entity;
// default package

/**
 * TOfficebuilding entity. @author MyEclipse Persistence Tools
 */

public class TOfficebuilding implements java.io.Serializable {

	// Fields

	private Integer officeBuildingId;
	private Integer businessAreaId;
	private Float officeBuildingLongitude;
	private Float officeBuildingLatitude;
	private Float officeBuildingRadius;
	private String officeBuildingName;

	// Constructors

	/** default constructor */
	public TOfficebuilding() {
	}

	/** minimal constructor */
	public TOfficebuilding(Integer businessAreaId) {
		this.businessAreaId = businessAreaId;
	}

	/** full constructor */
	public TOfficebuilding(Integer businessAreaId,
			Float officeBuildingLongitude, Float officeBuildingLatitude,
			Float officeBuildingRadius, String officeBuildingName) {
		this.businessAreaId = businessAreaId;
		this.officeBuildingLongitude = officeBuildingLongitude;
		this.officeBuildingLatitude = officeBuildingLatitude;
		this.officeBuildingRadius = officeBuildingRadius;
		this.officeBuildingName = officeBuildingName;
	}

	// Property accessors

	public Integer getOfficeBuildingId() {
		return this.officeBuildingId;
	}

	public void setOfficeBuildingId(Integer officeBuildingId) {
		this.officeBuildingId = officeBuildingId;
	}

	public Integer getBusinessAreaId() {
		return this.businessAreaId;
	}

	public void setBusinessAreaId(Integer businessAreaId) {
		this.businessAreaId = businessAreaId;
	}

	public Float getOfficeBuildingLongitude() {
		return this.officeBuildingLongitude;
	}

	public void setOfficeBuildingLongitude(Float officeBuildingLongitude) {
		this.officeBuildingLongitude = officeBuildingLongitude;
	}

	public Float getOfficeBuildingLatitude() {
		return this.officeBuildingLatitude;
	}

	public void setOfficeBuildingLatitude(Float officeBuildingLatitude) {
		this.officeBuildingLatitude = officeBuildingLatitude;
	}

	public Float getOfficeBuildingRadius() {
		return this.officeBuildingRadius;
	}

	public void setOfficeBuildingRadius(Float officeBuildingRadius) {
		this.officeBuildingRadius = officeBuildingRadius;
	}

	public String getOfficeBuildingName() {
		return this.officeBuildingName;
	}

	public void setOfficeBuildingName(String officeBuildingName) {
		this.officeBuildingName = officeBuildingName;
	}

}