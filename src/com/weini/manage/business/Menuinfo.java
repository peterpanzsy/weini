package com.weini.manage.business;
// default package

import java.sql.Timestamp;

/**
 * TMenuinfo entity. @author MyEclipse Persistence Tools
 */

public class Menuinfo implements java.io.Serializable {

	// Fields

	private Integer menuinfoId;
	private Integer vendorId;
	private String menuinfoImage1;
	private String menuinfoImage2;
	private String menuinfoImage3;
	private String menuinfoImage4;
	private String menuinfoDetail;
	private String menuinfoName;
	private Timestamp menuinfoDate;
	private Short menuinfoStatus;

	// add
	private String vendorName;
	private String bussinessName;
	private int order;//结果顺序
	// Constructors

	/** default constructor */
	public Menuinfo() {
	}

	/** minimal constructor */
	public Menuinfo(Integer menuinfoId, Timestamp menuinfoDate,
			Short menuinfoStatus) {
		this.menuinfoId = menuinfoId;
		this.menuinfoDate = menuinfoDate;
		this.menuinfoStatus = menuinfoStatus;
	}

	/** full constructor */
	public Menuinfo(Integer menuinfoId, Integer vendorId,
			String menuinfoImage1, String menuinfoImage2,
			String menuinfoImage3, String menuinfoImage4,
			String menuinfoDetail, String menuinfoName, Timestamp menuinfoDate,
			Short menuinfoStatus) {
		this.menuinfoId = menuinfoId;
		this.vendorId = vendorId;
		this.menuinfoImage1 = menuinfoImage1;
		this.menuinfoImage2 = menuinfoImage2;
		this.menuinfoImage3 = menuinfoImage3;
		this.menuinfoImage4 = menuinfoImage4;
		this.menuinfoDetail = menuinfoDetail;
		this.menuinfoName = menuinfoName;
		this.menuinfoDate = menuinfoDate;
		this.menuinfoStatus = menuinfoStatus;
	}

	// Property accessors

	public Integer getMenuinfoId() {
		return this.menuinfoId;
	}

	public void setMenuinfoId(Integer menuinfoId) {
		this.menuinfoId = menuinfoId;
	}

	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getMenuinfoImage1() {
		return this.menuinfoImage1;
	}

	public void setMenuinfoImage1(String menuinfoImage1) {
		this.menuinfoImage1 = menuinfoImage1;
	}

	public String getMenuinfoImage2() {
		return this.menuinfoImage2;
	}

	public void setMenuinfoImage2(String menuinfoImage2) {
		this.menuinfoImage2 = menuinfoImage2;
	}

	public String getMenuinfoImage3() {
		return this.menuinfoImage3;
	}

	public void setMenuinfoImage3(String menuinfoImage3) {
		this.menuinfoImage3 = menuinfoImage3;
	}

	public String getMenuinfoImage4() {
		return this.menuinfoImage4;
	}

	public void setMenuinfoImage4(String menuinfoImage4) {
		this.menuinfoImage4 = menuinfoImage4;
	}

	public String getMenuinfoDetail() {
		return this.menuinfoDetail;
	}

	public void setMenuinfoDetail(String menuinfoDetail) {
		this.menuinfoDetail = menuinfoDetail;
	}

	public String getMenuinfoName() {
		return this.menuinfoName;
	}

	public void setMenuinfoName(String menuinfoName) {
		this.menuinfoName = menuinfoName;
	}

	public Timestamp getMenuinfoDate() {
		return this.menuinfoDate;
	}

	public void setMenuinfoDate(Timestamp menuinfoDate) {
		this.menuinfoDate = menuinfoDate;
	}

	public Short getMenuinfoStatus() {
		return this.menuinfoStatus;
	}

	public void setMenuinfoStatus(Short menuinfoStatus) {
		this.menuinfoStatus = menuinfoStatus;
	}
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getBussinessName() {
		return bussinessName;
	}

	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}