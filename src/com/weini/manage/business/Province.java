package com.weini.manage.business;
// default package

/**
 * TProvince entity. @author MyEclipse Persistence Tools
 */

public class Province implements java.io.Serializable {

	// Fields

	private Integer provinceId;
	private String provinceName;

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** full constructor */
	public Province(String provinceName) {
		this.provinceName = provinceName;
	}

	// Property accessors

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}