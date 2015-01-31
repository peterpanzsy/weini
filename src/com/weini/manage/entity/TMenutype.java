package com.weini.manage.entity;
// default package

/**
 * TMenutype entity. @author MyEclipse Persistence Tools
 */

public class TMenutype implements java.io.Serializable {

	// Fields

	private Integer menutypeId;
	private String menutypeDesc;

	// Constructors

	/** default constructor */
	public TMenutype() {
	}

	/** full constructor */
	public TMenutype(String menutypeDesc) {
		this.menutypeDesc = menutypeDesc;
	}

	// Property accessors

	public Integer getMenutypeId() {
		return this.menutypeId;
	}

	public void setMenutypeId(Integer menutypeId) {
		this.menutypeId = menutypeId;
	}

	public String getMenutypeDesc() {
		return this.menutypeDesc;
	}

	public void setMenutypeDesc(String menutypeDesc) {
		this.menutypeDesc = menutypeDesc;
	}

}