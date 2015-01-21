package com.weini.manage.entity;
// default package

/**
 * TBox entity. @author MyEclipse Persistence Tools
 */

public class TBox implements java.io.Serializable {

	// Fields

	private Integer boxId;
	private Integer officeBuildingId;
	private Integer boxType;
	private Integer boxGender;
	private Float boxPrice;
	private Integer boxCityid;

	// Constructors

	/** default constructor */
	public TBox() {
	}

	/** full constructor */
	public TBox(Integer officeBuildingId, Integer boxType, Integer boxGender,
			Float boxPrice, Integer boxCityid) {
		this.officeBuildingId = officeBuildingId;
		this.boxType = boxType;
		this.boxGender = boxGender;
		this.boxPrice = boxPrice;
		this.boxCityid = boxCityid;
	}

	// Property accessors

	public Integer getBoxId() {
		return this.boxId;
	}

	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}

	public Integer getOfficeBuildingId() {
		return this.officeBuildingId;
	}

	public void setOfficeBuildingId(Integer officeBuildingId) {
		this.officeBuildingId = officeBuildingId;
	}

	public Integer getBoxType() {
		return this.boxType;
	}

	public void setBoxType(Integer boxType) {
		this.boxType = boxType;
	}

	public Integer getBoxGender() {
		return this.boxGender;
	}

	public void setBoxGender(Integer boxGender) {
		this.boxGender = boxGender;
	}

	public Float getBoxPrice() {
		return this.boxPrice;
	}

	public void setBoxPrice(Float boxPrice) {
		this.boxPrice = boxPrice;
	}

	public Integer getBoxCityid() {
		return this.boxCityid;
	}

	public void setBoxCityid(Integer boxCityid) {
		this.boxCityid = boxCityid;
	}

}