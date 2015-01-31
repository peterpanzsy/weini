package com.weini.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// default package

import org.hibernate.annotations.GenericGenerator;

/**
 * TVendorextra entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_vendorextra")
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
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "vendorextra_id") 
	public Integer getVendorextraId() {
		return this.vendorextraId;
	}

	public void setVendorextraId(Integer vendorextraId) {
		this.vendorextraId = vendorextraId;
	}
	@Column(name = "vendor_id",nullable = false)
	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	@Column(name = "vendorextra_name")
	public String getVendorextraName() {
		return this.vendorextraName;
	}

	public void setVendorextraName(String vendorextraName) {
		this.vendorextraName = vendorextraName;
	}
	@Column(name = "vendorextra_regBrand")
	public String getVendorextraRegBrand() {
		return this.vendorextraRegBrand;
	}

	public void setVendorextraRegBrand(String vendorextraRegBrand) {
		this.vendorextraRegBrand = vendorextraRegBrand;
	}
	@Column(name = "vendorextra_regAddress")
	public String getVendorextraRegAddress() {
		return this.vendorextraRegAddress;
	}

	public void setVendorextraRegAddress(String vendorextraRegAddress) {
		this.vendorextraRegAddress = vendorextraRegAddress;
	}
	@Column(name = "vendorextra_validPeriod")
	public String getVendorextraValidPeriod() {
		return this.vendorextraValidPeriod;
	}

	public void setVendorextraValidPeriod(String vendorextraValidPeriod) {
		this.vendorextraValidPeriod = vendorextraValidPeriod;
	}
	@Column(name = "vendorextra_commonAddress")
	public String getVendorextraCommonAddress() {
		return this.vendorextraCommonAddress;
	}

	public void setVendorextraCommonAddress(String vendorextraCommonAddress) {
		this.vendorextraCommonAddress = vendorextraCommonAddress;
	}
	@Column(name = "vendorextra_phoneNumber")
	public String getVendorextraPhoneNumber() {
		return this.vendorextraPhoneNumber;
	}

	public void setVendorextraPhoneNumber(String vendorextraPhoneNumber) {
		this.vendorextraPhoneNumber = vendorextraPhoneNumber;
	}
	@Column(name = "vendorextra_scanningImage")
	public String getVendorextraScanningImage() {
		return this.vendorextraScanningImage;
	}

	public void setVendorextraScanningImage(String vendorextraScanningImage) {
		this.vendorextraScanningImage = vendorextraScanningImage;
	}
	@Column(name = "vendorextra_indenfityFront")
	public String getVendorextraIndenfityFront() {
		return this.vendorextraIndenfityFront;
	}

	public void setVendorextraIndenfityFront(String vendorextraIndenfityFront) {
		this.vendorextraIndenfityFront = vendorextraIndenfityFront;
	}
	@Column(name = "vendorextra_indenfityBack")
	public String getVendorextraIndenfityBack() {
		return this.vendorextraIndenfityBack;
	}

	public void setVendorextraIndenfityBack(String vendorextraIndenfityBack) {
		this.vendorextraIndenfityBack = vendorextraIndenfityBack;
	}

}