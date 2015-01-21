package com.weini.manage.entity;
// default package

/**
 * TAuthority entity. @author MyEclipse Persistence Tools
 */

public class TAuthority implements java.io.Serializable {

	// Fields

	private Integer authorityId;
	private String authorityName;
	private String authorityRemark;

	// Constructors

	/** default constructor */
	public TAuthority() {
	}

	/** full constructor */
	public TAuthority(String authorityName, String authorityRemark) {
		this.authorityName = authorityName;
		this.authorityRemark = authorityRemark;
	}

	// Property accessors

	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityRemark() {
		return this.authorityRemark;
	}

	public void setAuthorityRemark(String authorityRemark) {
		this.authorityRemark = authorityRemark;
	}

}