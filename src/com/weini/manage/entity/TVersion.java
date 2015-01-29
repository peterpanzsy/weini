package com.weini.manage.entity;
// default package

/**
 * TVersion entity. @author MyEclipse Persistence Tools
 */

public class TVersion implements java.io.Serializable {

	// Fields

	private Integer versionId;
	private Integer versionType;
	private String versionInfo;
	private String versionLoc;

	// Constructors

	/** default constructor */
	public TVersion() {
	}

	/** full constructor */
	public TVersion(Integer versionType, String versionInfo, String versionLoc) {
		this.versionType = versionType;
		this.versionInfo = versionInfo;
		this.versionLoc = versionLoc;
	}

	// Property accessors

	public Integer getVersionId() {
		return this.versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	public Integer getVersionType() {
		return this.versionType;
	}

	public void setVersionType(Integer versionType) {
		this.versionType = versionType;
	}

	public String getVersionInfo() {
		return this.versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public String getVersionLoc() {
		return this.versionLoc;
	}

	public void setVersionLoc(String versionLoc) {
		this.versionLoc = versionLoc;
	}

}