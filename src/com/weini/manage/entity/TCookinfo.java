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
	private Integer cookinfoBusinfoid;

	// Constructors

	/** default constructor */
	public TCookinfo() {
	}

	/** full constructor */
	public TCookinfo(String cookinfoName, String cookinfoImage,
			Integer cookinfoBusinfoid) {
		this.cookinfoName = cookinfoName;
		this.cookinfoImage = cookinfoImage;
		this.cookinfoBusinfoid = cookinfoBusinfoid;
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

	public Integer getCookinfoBusinfoid() {
		return this.cookinfoBusinfoid;
	}

	public void setCookinfoBusinfoid(Integer cookinfoBusinfoid) {
		this.cookinfoBusinfoid = cookinfoBusinfoid;
	}

}