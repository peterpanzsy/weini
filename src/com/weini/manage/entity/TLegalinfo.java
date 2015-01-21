package com.weini.manage.entity;
// default package

/**
 * TLegalinfo entity. @author MyEclipse Persistence Tools
 */

public class TLegalinfo implements java.io.Serializable {

	// Fields

	private Integer legalinfoId;
	private Integer bssinfoId;
	private String legalinfoName;
	private String legalinfoRegBrand;
	private String legalinfoRegAddress;
	private String legalinfoValidPeriod;
	private String legalinfoCommonAddress;
	private String legalinfoPhoneNumber;
	private String legalinfoScanningImage;
	private String legalinfoIndenfityFront;
	private String legalinfoIndenfityBack;

	// Constructors

	/** default constructor */
	public TLegalinfo() {
	}

	/** full constructor */
	public TLegalinfo(Integer bssinfoId, String legalinfoName,
			String legalinfoRegBrand, String legalinfoRegAddress,
			String legalinfoValidPeriod, String legalinfoCommonAddress,
			String legalinfoPhoneNumber, String legalinfoScanningImage,
			String legalinfoIndenfityFront, String legalinfoIndenfityBack) {
		this.bssinfoId = bssinfoId;
		this.legalinfoName = legalinfoName;
		this.legalinfoRegBrand = legalinfoRegBrand;
		this.legalinfoRegAddress = legalinfoRegAddress;
		this.legalinfoValidPeriod = legalinfoValidPeriod;
		this.legalinfoCommonAddress = legalinfoCommonAddress;
		this.legalinfoPhoneNumber = legalinfoPhoneNumber;
		this.legalinfoScanningImage = legalinfoScanningImage;
		this.legalinfoIndenfityFront = legalinfoIndenfityFront;
		this.legalinfoIndenfityBack = legalinfoIndenfityBack;
	}

	// Property accessors

	public Integer getLegalinfoId() {
		return this.legalinfoId;
	}

	public void setLegalinfoId(Integer legalinfoId) {
		this.legalinfoId = legalinfoId;
	}

	public Integer getBssinfoId() {
		return this.bssinfoId;
	}

	public void setBssinfoId(Integer bssinfoId) {
		this.bssinfoId = bssinfoId;
	}

	public String getLegalinfoName() {
		return this.legalinfoName;
	}

	public void setLegalinfoName(String legalinfoName) {
		this.legalinfoName = legalinfoName;
	}

	public String getLegalinfoRegBrand() {
		return this.legalinfoRegBrand;
	}

	public void setLegalinfoRegBrand(String legalinfoRegBrand) {
		this.legalinfoRegBrand = legalinfoRegBrand;
	}

	public String getLegalinfoRegAddress() {
		return this.legalinfoRegAddress;
	}

	public void setLegalinfoRegAddress(String legalinfoRegAddress) {
		this.legalinfoRegAddress = legalinfoRegAddress;
	}

	public String getLegalinfoValidPeriod() {
		return this.legalinfoValidPeriod;
	}

	public void setLegalinfoValidPeriod(String legalinfoValidPeriod) {
		this.legalinfoValidPeriod = legalinfoValidPeriod;
	}

	public String getLegalinfoCommonAddress() {
		return this.legalinfoCommonAddress;
	}

	public void setLegalinfoCommonAddress(String legalinfoCommonAddress) {
		this.legalinfoCommonAddress = legalinfoCommonAddress;
	}

	public String getLegalinfoPhoneNumber() {
		return this.legalinfoPhoneNumber;
	}

	public void setLegalinfoPhoneNumber(String legalinfoPhoneNumber) {
		this.legalinfoPhoneNumber = legalinfoPhoneNumber;
	}

	public String getLegalinfoScanningImage() {
		return this.legalinfoScanningImage;
	}

	public void setLegalinfoScanningImage(String legalinfoScanningImage) {
		this.legalinfoScanningImage = legalinfoScanningImage;
	}

	public String getLegalinfoIndenfityFront() {
		return this.legalinfoIndenfityFront;
	}

	public void setLegalinfoIndenfityFront(String legalinfoIndenfityFront) {
		this.legalinfoIndenfityFront = legalinfoIndenfityFront;
	}

	public String getLegalinfoIndenfityBack() {
		return this.legalinfoIndenfityBack;
	}

	public void setLegalinfoIndenfityBack(String legalinfoIndenfityBack) {
		this.legalinfoIndenfityBack = legalinfoIndenfityBack;
	}

}