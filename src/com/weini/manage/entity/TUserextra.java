package com.weini.manage.entity;
// default package

/**
 * TUserextra entity. @author MyEclipse Persistence Tools
 */

public class TUserextra implements java.io.Serializable {

	// Fields

	private Integer userextraId;
	private String userId;
	private String userextraImage;
	private String userextraReserved;

	// Constructors

	/** default constructor */
	public TUserextra() {
	}

	/** full constructor */
	public TUserextra(String userId, String userextraImage,
			String userextraReserved) {
		this.userId = userId;
		this.userextraImage = userextraImage;
		this.userextraReserved = userextraReserved;
	}

	// Property accessors

	public Integer getUserextraId() {
		return this.userextraId;
	}

	public void setUserextraId(Integer userextraId) {
		this.userextraId = userextraId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
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

}