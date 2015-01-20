package com.weini.manage.business;
// default package

/**
 * TCity entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private Integer provinceId;
	private String cityName;

	// Constructors

	/** default constructor */
	public City() {
	}

	/** full constructor */
	public City(Integer provinceId, String cityName) {
		this.provinceId = provinceId;
		this.cityName = cityName;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}