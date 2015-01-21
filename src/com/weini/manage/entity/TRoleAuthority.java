package com.weini.manage.entity;
// default package

/**
 * TRoleAuthority entity. @author MyEclipse Persistence Tools
 */

public class TRoleAuthority implements java.io.Serializable {

	// Fields

	private Integer roleAuthorityId;
	private Integer roleAuthorityRoleid;
	private Integer roleAuthorityAuthorityid;

	// Constructors

	/** default constructor */
	public TRoleAuthority() {
	}

	/** full constructor */
	public TRoleAuthority(Integer roleAuthorityRoleid,
			Integer roleAuthorityAuthorityid) {
		this.roleAuthorityRoleid = roleAuthorityRoleid;
		this.roleAuthorityAuthorityid = roleAuthorityAuthorityid;
	}

	// Property accessors

	public Integer getRoleAuthorityId() {
		return this.roleAuthorityId;
	}

	public void setRoleAuthorityId(Integer roleAuthorityId) {
		this.roleAuthorityId = roleAuthorityId;
	}

	public Integer getRoleAuthorityRoleid() {
		return this.roleAuthorityRoleid;
	}

	public void setRoleAuthorityRoleid(Integer roleAuthorityRoleid) {
		this.roleAuthorityRoleid = roleAuthorityRoleid;
	}

	public Integer getRoleAuthorityAuthorityid() {
		return this.roleAuthorityAuthorityid;
	}

	public void setRoleAuthorityAuthorityid(Integer roleAuthorityAuthorityid) {
		this.roleAuthorityAuthorityid = roleAuthorityAuthorityid;
	}

}