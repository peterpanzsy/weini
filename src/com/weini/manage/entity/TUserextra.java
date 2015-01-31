package com.weini.manage.entity;
// default package

import java.util.Date;

/**
 * TUserextra entity. @author MyEclipse Persistence Tools
 */

public class TUserextra implements java.io.Serializable {

	// Fields

	private Integer userextraId;
	private Integer userId;
	private String userextraImage;
	private String userextraReserved;
	private Date userextraBirthday;

	// Constructors

	/** default constructor */
	public TUserextra() {
	}

	/** minimal constructor */
	public TUserextra(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public TUserextra(Integer userId, String userextraImage,
			String userextraReserved, Date userextraBirthday) {
		this.userId = userId;
		this.userextraImage = userextraImage;
		this.userextraReserved = userextraReserved;
		this.userextraBirthday = userextraBirthday;
	}

	// Property accessors

	public Integer getUserextraId() {
		return this.userextraId;
	}

	public void setUserextraId(Integer userextraId) {
		this.userextraId = userextraId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserextraImage() {
		return this.userextraImage;
	}

	public void setUserextraImage(String userextraImage) {
		this.userextraImage = userextraImage;
	}

	public String getUserextraReserved() {
		return this.userextraReserved;
	}

	public void setUserextraReserved(String userextraReserved) {
		this.userextraReserved = userextraReserved;
	}

	public Date getUserextraBirthday() {
		return this.userextraBirthday;
	}

	public void setUserextraBirthday(Date userextraBirthday) {
		this.userextraBirthday = userextraBirthday;
	}

}