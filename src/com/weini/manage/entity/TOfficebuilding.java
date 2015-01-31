package com.weini.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// default package

import org.hibernate.annotations.GenericGenerator;

/**
 * TOfficebuilding entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_officebuilding")
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
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "officeBuilding_id") 
	public Integer getOfficeBuildingId() {
		return this.officeBuildingId;
	}

	public void setOfficeBuildingId(Integer officeBuildingId) {
		this.officeBuildingId = officeBuildingId;
	}
	@Column(name = "box_gender")
	public Integer getBusinessAreaId() {
		return this.businessAreaId;
	}

	public void setBusinessAreaId(Integer businessAreaId) {
		this.businessAreaId = businessAreaId;
	}
	@Column(name = "officeBuilding_longitude")
	public Float getOfficeBuildingLongitude() {
		return this.officeBuildingLongitude;
	}

	public void setOfficeBuildingLongitude(Float officeBuildingLongitude) {
		this.officeBuildingLongitude = officeBuildingLongitude;
	}
	@Column(name = "officeBuilding_latitude")
	public Float getOfficeBuildingLatitude() {
		return this.officeBuildingLatitude;
	}

	public void setOfficeBuildingLatitude(Float officeBuildingLatitude) {
		this.officeBuildingLatitude = officeBuildingLatitude;
	}
	@Column(name = "officeBuilding_radius")
	public Float getOfficeBuildingRadius() {
		return this.officeBuildingRadius;
	}

	public void setOfficeBuildingRadius(Float officeBuildingRadius) {
		this.officeBuildingRadius = officeBuildingRadius;
	}
	@Column(name = "officeBuilding_name")
	public String getOfficeBuildingName() {
		return this.officeBuildingName;
	}

	public void setOfficeBuildingName(String officeBuildingName) {
		this.officeBuildingName = officeBuildingName;
	}

}