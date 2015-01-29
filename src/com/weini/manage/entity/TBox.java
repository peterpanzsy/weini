package com.weini.manage.entity;
// default package

/**
 * TBox entity. @author MyEclipse Persistence Tools
 */

public class TBox implements java.io.Serializable {

	// Fields

	private Integer boxId;
	private String boxType;
	private Integer boxGender;
	private Float boxPrice;
	private Integer boxCityid;
	private String boxImage1;
	private String boxImage2;
	private String boxImage3;
	private String boxImage4;

	// Constructors

	/** default constructor */
	public TBox() {
	}

	/** full constructor */
	public TBox(String boxType, Integer boxGender, Float boxPrice,
			Integer boxCityid, String boxImage1, String boxImage2,
			String boxImage3, String boxImage4) {
		this.boxType = boxType;
		this.boxGender = boxGender;
		this.boxPrice = boxPrice;
		this.boxCityid = boxCityid;
		this.boxImage1 = boxImage1;
		this.boxImage2 = boxImage2;
		this.boxImage3 = boxImage3;
		this.boxImage4 = boxImage4;
	}

	// Property accessors

	public Integer getBoxId() {
		return this.boxId;
	}

	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}

	public String getBoxType() {
		return this.boxType;
	}

	public void setBoxType(String boxType) {
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

	public String getBoxImage1() {
		return this.boxImage1;
	}

	public void setBoxImage1(String boxImage1) {
		this.boxImage1 = boxImage1;
	}

	public String getBoxImage2() {
		return this.boxImage2;
	}

	public void setBoxImage2(String boxImage2) {
		this.boxImage2 = boxImage2;
	}

	public String getBoxImage3() {
		return this.boxImage3;
	}

	public void setBoxImage3(String boxImage3) {
		this.boxImage3 = boxImage3;
	}

	public String getBoxImage4() {
		return this.boxImage4;
	}

	public void setBoxImage4(String boxImage4) {
		this.boxImage4 = boxImage4;
	}

}