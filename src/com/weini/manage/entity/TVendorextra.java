package com.weini.manage.entity;
// default package

/**
 * TVendorextra entity. @author MyEclipse Persistence Tools
 */

public class TVendorextra implements java.io.Serializable {

	// Fields

	private Integer vendorextraId;
	private Integer vendorId;
	private String vendorextraName;
	private String vendorextraRegBrand;
	private String vendorextraRegAddress;
	private String vendorextraValidPeriod;
	private String vendorextraCommonAddress;
	private String vendorextraPhoneNumber;
	private String vendorextraScanningImage;
	private String vendorextraIndenfityFront;
	private String vendorextraIndenfityBack;

	// Constructors

	/** default constructor */
	public TVendorextra() {
	}

	/** full constructor */
	public TVendorextra(Integer vendorId, String vendorextraName,
			String vendorextraRegBrand, String vendorextraRegAddress,
			String vendorextraValidPeriod, String vendorextraCommonAddress,
			String vendorextraPhoneNumber, String vendorextraScanningImage,
			String vendorextraIndenfityFront, String vendorextraIndenfityBack) {
		this.vendorId = vendorId;
		this.vendorextraName = vendorextraName;
		this.vendorextraRegBrand = vendorextraRegBrand;
		this.vendorextraRegAddress = vendorextraRegAddress;
		this.vendorextraValidPeriod = vendorextraValidPeriod;
		this.vendorextraCommonAddress = vendorextraCommonAddress;
		this.vendorextraPhoneNumber = vendorextraPhoneNumber;
		this.vendorextraScanningImage = vendorextraScanningImage;
		this.vendorextraIndenfityFront = vendorextraIndenfityFront;
		this.vendorextraIndenfityBack = vendorextraIndenfityBack;
	}

	// Property accessors

	public Integer getVendorextraId() {
		return this.vendorextraId;
	}

	public void setVendorextraId(Integer vendorextraId) {
		this.vendorextraId = vendorextraId;
	}

	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorextraName() {
		return this.vendorextraName;
	}

	public void setVendorextraName(String vendorextraName) {
		this.vendorextraName = vendorextraName;
	}

	public String getVendorextraRegBrand() {
		return this.vendorextraRegBrand;
	}

	public void setVendorextraRegBrand(String vendorextraRegBrand) {
		this.vendorextraRegBrand = vendorextraRegBrand;
	}

	public String getVendorextraRegAddress() {
		return this.vendorextraRegAddress;
	}

	public void setVendorextraRegAddress(String vendorextraRegAddress) {
		this.vendorextraRegAddress = vendorextraRegAddress;
	}

	public String getVendorextraValidPeriod() {
		return this.vendorextraValidPeriod;
	}

	public void setVendorextraValidPeriod(String vendorextraValidPeriod) {
		this.vendorextraValidPeriod = vendorextraValidPeriod;
	}

	public String getVendorextraCommonAddress() {
		return this.vendorextraCommonAddress;
	}

	public void setVendorextraCommonAddress(String vendorextraCommonAddress) {
		this.vendorextraCommonAddress = vendorextraCommonAddress;
	}

	public String getVendorextraPhoneNumber() {
		return this.vendorextraPhoneNumber;
	}

	public void setVendorextraPhoneNumber(String vendorextraPhoneNumber) {
		this.vendorextraPhoneNumber = vendorextraPhoneNumber;
	}

	public String getVendorextraScanningImage() {
		return this.vendorextraScanningImage;
	}

	public void setVendorextraScanningImage(String vendorextraScanningImage) {
		this.vendorextraScanningImage = vendorextraScanningImage;
	}

	public String getVendorextraIndenfityFront() {
		return this.vendorextraIndenfityFront;
	}

	public void setVendorextraIndenfityFront(String vendorextraIndenfityFront) {
		this.vendorextraIndenfityFront = vendorextraIndenfityFront;
	}

	public String getVendorextraIndenfityBack() {
		return this.vendorextraIndenfityBack;
	}

	public void setVendorextraIndenfityBack(String vendorextraIndenfityBack) {
		this.vendorextraIndenfityBack = vendorextraIndenfityBack;
	}

}