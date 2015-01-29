package com.weini.manage.entity;
// default package

/**
 * TCookinfo entity. @author MyEclipse Persistence Tools
 */

public class TCookinfo implements java.io.Serializable {

	// Fields

	private Integer cookinfoId;
	private String cookinfoName;
	private String cookinfoImage;
	private Integer cookinfoVendorid;

	// Constructors

	/** default constructor */
	public TCookinfo() {
	}

	/** minimal constructor */
	public TCookinfo(String cookinfoName, Integer cookinfoVendorid) {
		this.cookinfoName = cookinfoName;
		this.cookinfoVendorid = cookinfoVendorid;
	}

	/** full constructor */
	public TCookinfo(String cookinfoName, String cookinfoImage,
			Integer cookinfoVendorid) {
		this.cookinfoName = cookinfoName;
		this.cookinfoImage = cookinfoImage;
		this.cookinfoVendorid = cookinfoVendorid;
	}

	// Property accessors

	public Integer getCookinfoId() {
		return this.cookinfoId;
	}

	public void setCookinfoId(Integer cookinfoId) {
		this.cookinfoId = cookinfoId;
	}

	public String getCookinfoName() {
		return this.cookinfoName;
	}

	public void setCookinfoName(String cookinfoName) {
		this.cookinfoName = cookinfoName;
	}

	public String getCookinfoImage() {
		return this.cookinfoImage;
	}

	public void setCookinfoImage(String cookinfoImage) {
		this.cookinfoImage = cookinfoImage;
	}

	public Integer getCookinfoVendorid() {
		return this.cookinfoVendorid;
	}

	public void setCookinfoVendorid(Integer cookinfoVendorid) {
		this.cookinfoVendorid = cookinfoVendorid;
	}

}