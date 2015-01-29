package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TSorderDispatching entity. @author MyEclipse Persistence Tools
 */

public class TSorderDispatching implements java.io.Serializable {

	// Fields

	private Integer sorderdispatchingId;
	private Integer SOrderId;
	private Integer dispatchingstatusId;
	private Timestamp statusTime;

	// Constructors

	/** default constructor */
	public TSorderDispatching() {
	}

	/** full constructor */
	public TSorderDispatching(Integer sorderdispatchingId, Integer SOrderId,
			Integer dispatchingstatusId, Timestamp statusTime) {
		this.sorderdispatchingId = sorderdispatchingId;
		this.SOrderId = SOrderId;
		this.dispatchingstatusId = dispatchingstatusId;
		this.statusTime = statusTime;
	}

	// Property accessors

	public Integer getSorderdispatchingId() {
		return this.sorderdispatchingId;
	}

	public void setSorderdispatchingId(Integer sorderdispatchingId) {
		this.sorderdispatchingId = sorderdispatchingId;
	}

	public Integer getSOrderId() {
		return this.SOrderId;
	}

	public void setSOrderId(Integer SOrderId) {
		this.SOrderId = SOrderId;
	}

	public Integer getDispatchingstatusId() {
		return this.dispatchingstatusId;
	}

	public void setDispatchingstatusId(Integer dispatchingstatusId) {
		this.dispatchingstatusId = dispatchingstatusId;
	}

	public Timestamp getStatusTime() {
		return this.statusTime;
	}

	public void setStatusTime(Timestamp statusTime) {
		this.statusTime = statusTime;
	}

}