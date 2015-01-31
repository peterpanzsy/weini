package com.weini.manage.entity;
// default package

/**
 * TBox entity. @author MyEclipse Persistence Tools
 */

public class TBox implements java.io.Serializable {

	// Fields

	private Integer boxId;
	private Integer boxGender;
	private Float boxPrice;
	private Integer boxCityid;
	private String boxImage1;
	private String boxDesc1;
	private String boxDesc2;
	private String boxDesc3;
	private String boxDesc4;
	private Integer boxType;
	private String boxTypename;

	// Constructors

	/** default constructor */
	public TBox() {
	}

	/** minimal constructor */
	public TBox(Integer boxGender, Float boxPrice, Integer boxCityid,
			String boxImage1, String boxDesc1, String boxDesc2,
			String boxDesc3, String boxDesc4, Integer boxType) {
		this.boxGender = boxGender;
		this.boxPrice = boxPrice;
		this.boxCityid = boxCityid;
		this.boxImage1 = boxImage1;
		this.boxDesc1 = boxDesc1;
		this.boxDesc2 = boxDesc2;
		this.boxDesc3 = boxDesc3;
		this.boxDesc4 = boxDesc4;
		this.boxType = boxType;
	}

	/** full constructor */
	public TBox(Integer boxGender, Float boxPrice, Integer boxCityid,
			String boxImage1, String boxDesc1, String boxDesc2,
			String boxDesc3, String boxDesc4, Integer boxType,
			String boxTypename) {
		this.boxGender = boxGender;
		this.boxPrice = boxPrice;
		this.boxCityid = boxCityid;
		this.boxImage1 = boxImage1;
		this.boxDesc1 = boxDesc1;
		this.boxDesc2 = boxDesc2;
		this.boxDesc3 = boxDesc3;
		this.boxDesc4 = boxDesc4;
		this.boxType = boxType;
		this.boxTypename = boxTypename;
	}

	// Property accessors

	public Integer getBoxId() {
		return this.boxId;
	}

	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
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

	public String getBoxDesc1() {
		return this.boxDesc1;
	}

	public void setBoxDesc1(String boxDesc1) {
		this.boxDesc1 = boxDesc1;
	}

	public String getBoxDesc2() {
		return this.boxDesc2;
	}

	public void setBoxDesc2(String boxDesc2) {
		this.boxDesc2 = boxDesc2;
	}

	public String getBoxDesc3() {
		return this.boxDesc3;
	}

	public void setBoxDesc3(String boxDesc3) {
		this.boxDesc3 = boxDesc3;
	}

	public String getBoxDesc4() {
		return this.boxDesc4;
	}

	public void setBoxDesc4(String boxDesc4) {
		this.boxDesc4 = boxDesc4;
	}

	public Integer getBoxType() {
		return this.boxType;
	}

	public void setBoxType(Integer boxType) {
		this.boxType = boxType;
	}

	public String getBoxTypename() {
		return this.boxTypename;
	}

	public void setBoxTypename(String boxTypename) {
		this.boxTypename = boxTypename;
	}

}