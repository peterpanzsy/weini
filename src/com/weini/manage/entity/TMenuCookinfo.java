package com.weini.manage.entity;
// default package

/**
 * TMenuCookinfo entity. @author MyEclipse Persistence Tools
 */

public class TMenuCookinfo implements java.io.Serializable {

	// Fields

	private Integer menuCookinfoid;
	private Integer menuinfoId;
	private Integer cookinfoId;

	// Constructors

	/** default constructor */
	public TMenuCookinfo() {
	}

	/** full constructor */
	public TMenuCookinfo(Integer menuinfoId, Integer cookinfoId) {
		this.menuinfoId = menuinfoId;
		this.cookinfoId = cookinfoId;
	}

	// Property accessors

	public Integer getMenuCookinfoid() {
		return this.menuCookinfoid;
	}

	public void setMenuCookinfoid(Integer menuCookinfoid) {
		this.menuCookinfoid = menuCookinfoid;
	}

	public Integer getMenuinfoId() {
		return this.menuinfoId;
	}

	public void setMenuinfoId(Integer menuinfoId) {
		this.menuinfoId = menuinfoId;
	}

	public Integer getCookinfoId() {
		return this.cookinfoId;
	}

	public void setCookinfoId(Integer cookinfoId) {
		this.cookinfoId = cookinfoId;
	}

}