package com.weini.manage.entity;
// default package

/**
 * TDispatchingstatus entity. @author MyEclipse Persistence Tools
 */

public class TDispatchingstatus implements java.io.Serializable {

	// Fields

	private Integer dispatchingStatusId;
	private String dispatchingStatusName;

	// Constructors

	/** default constructor */
	public TDispatchingstatus() {
	}

	/** full constructor */
	public TDispatchingstatus(String dispatchingStatusName) {
		this.dispatchingStatusName = dispatchingStatusName;
	}

	// Property accessors

	public Integer getDispatchingStatusId() {
		return this.dispatchingStatusId;
	}

	public void setDispatchingStatusId(Integer dispatchingStatusId) {
		this.dispatchingStatusId = dispatchingStatusId;
	}

	public String getDispatchingStatusName() {
		return this.dispatchingStatusName;
	}

	public void setDispatchingStatusName(String dispatchingStatusName) {
		this.dispatchingStatusName = dispatchingStatusName;
	}

}