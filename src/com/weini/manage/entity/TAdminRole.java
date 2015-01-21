package com.weini.manage.entity;
// default package

/**
 * TAdminRole entity. @author MyEclipse Persistence Tools
 */

public class TAdminRole implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer adminRoleId;
	private Integer adminRoleAdminid;
	private Integer adminRoleRoleid;

	// Constructors

	/** default constructor */
	public TAdminRole() {
	}

	/** full constructor */
	public TAdminRole(Integer adminRoleAdminid, Integer adminRoleRoleid) {
		this.adminRoleAdminid = adminRoleAdminid;
		this.adminRoleRoleid = adminRoleRoleid;
	}

	// Property accessors

	public Integer getAdminRoleId() {
		return this.adminRoleId;
	}

	public void setAdminRoleId(Integer adminRoleId) {
		this.adminRoleId = adminRoleId;
	}

	public Integer getAdminRoleAdminid() {
		return this.adminRoleAdminid;
	}

	public void setAdminRoleAdminid(Integer adminRoleAdminid) {
		this.adminRoleAdminid = adminRoleAdminid;
	}

	public Integer getAdminRoleRoleid() {
		return this.adminRoleRoleid;
	}

	public void setAdminRoleRoleid(Integer adminRoleRoleid) {
		this.adminRoleRoleid = adminRoleRoleid;
	}

}