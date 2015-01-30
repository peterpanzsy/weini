package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TStartpageinfo entity. @author MyEclipse Persistence Tools
 */

public class TStartpageinfo implements java.io.Serializable {

	// Fields

	private Integer startpageId;
	private Integer startpageStatus;
	private Timestamp startpageStarttime;
	private Timestamp startpageEndtime;
	private String startpageImageloc;

	// Constructors

	/** default constructor */
	public TStartpageinfo() {
	}

	/** full constructor */
	public TStartpageinfo(Integer startpageStatus,
			Timestamp startpageStarttime, Timestamp startpageEndtime,
			String startpageImageloc) {
		this.startpageStatus = startpageStatus;
		this.startpageStarttime = startpageStarttime;
		this.startpageEndtime = startpageEndtime;
		this.startpageImageloc = startpageImageloc;
	}

	// Property accessors

	public Integer getStartpageId() {
		return this.startpageId;
	}

	public void setStartpageId(Integer startpageId) {
		this.startpageId = startpageId;
	}

	public Integer getStartpageStatus() {
		return this.startpageStatus;
	}

	public void setStartpageStatus(Integer startpageStatus) {
		this.startpageStatus = startpageStatus;
	}

	public Timestamp getStartpageStarttime() {
		return this.startpageStarttime;
	}

	public void setStartpageStarttime(Timestamp startpageStarttime) {
		this.startpageStarttime = startpageStarttime;
	}

	public Timestamp getStartpageEndtime() {
		return this.startpageEndtime;
	}

	public void setStartpageEndtime(Timestamp startpageEndtime) {
		this.startpageEndtime = startpageEndtime;
	}

	public String getStartpageImageloc() {
		return this.startpageImageloc;
	}

	public void setStartpageImageloc(String startpageImageloc) {
		this.startpageImageloc = startpageImageloc;
	}

}