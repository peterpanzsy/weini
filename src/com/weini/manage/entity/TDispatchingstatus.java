package com.weini.manage.entity;
// default package

/**
 * TDispatchingstatus entity. @author MyEclipse Persistence Tools
 */

public class TDispatchingstatus implements java.io.Serializable {

	// Fields

	private Integer dispatchingStatusId;
	private String dispatchingStatusImagename;
	private String dispatchingStatusDesctext;

	// Constructors

	/** default constructor */
	public TDispatchingstatus() {
	}

	/** full constructor */
	public TDispatchingstatus(String dispatchingStatusImagename,
			String dispatchingStatusDesctext) {
		this.dispatchingStatusImagename = dispatchingStatusImagename;
		this.dispatchingStatusDesctext = dispatchingStatusDesctext;
	}

	// Property accessors

	public Integer getDispatchingStatusId() {
		return this.dispatchingStatusId;
	}

	public void setDispatchingStatusId(Integer dispatchingStatusId) {
		this.dispatchingStatusId = dispatchingStatusId;
	}

	public String getDispatchingStatusImagename() {
		return this.dispatchingStatusImagename;
	}

	public void setDispatchingStatusImagename(String dispatchingStatusImagename) {
		this.dispatchingStatusImagename = dispatchingStatusImagename;
	}

	public String getDispatchingStatusDesctext() {
		return this.dispatchingStatusDesctext;
	}

	public void setDispatchingStatusDesctext(String dispatchingStatusDesctext) {
		this.dispatchingStatusDesctext = dispatchingStatusDesctext;
	}

}