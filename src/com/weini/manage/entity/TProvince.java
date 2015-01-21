package com.weini.manage.entity;
// default package

/**
 * TProvince entity. @author MyEclipse Persistence Tools
 */

public class TProvince implements java.io.Serializable {

	// Fields

	private Integer provinceId;
	private String provinceName;

	// Constructors

	/** default constructor */
	public TProvince() {
	}

	/** full constructor */
	public TProvince(String provinceName) {
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