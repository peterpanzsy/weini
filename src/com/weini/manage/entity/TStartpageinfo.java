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
	private Integer startpagePhonetype;

	// Constructors

	/** default constructor */
	public TStartpageinfo() {
	}

	/** full constructor */
	public TStartpageinfo(Integer startpageStatus,
			Timestamp startpageStarttime, Timestamp startpageEndtime,
			String startpageImageloc, Integer startpagePhonetype) {
		this.startpageStatus = startpageStatus;
		this.startpageStarttime = startpageStarttime;
		this.startpageEndtime = startpageEndtime;
		this.startpageImageloc = startpageImageloc;
		this.startpagePhonetype = startpagePhonetype;
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
	public String getStartpageStringStarttime() {
		if(startpageStarttime != null){
			return this.startpageStarttime.toString();
		}else{
			return "";
		}
	}

	public void setStartpageStarttime(Timestamp startpageStarttime) {
		this.startpageStarttime = startpageStarttime;
	}

	public Timestamp getStartpageEndtime() {
		return this.startpageEndtime;
	}
	public String getStartpageStringEndtime() {
		if(this.startpageEndtime != null){
			return this.startpageEndtime.toString();
		}else{
			return "";
		}
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

	public Integer getStartpagePhonetype() {
		return this.startpagePhonetype;
	}

	public void setStartpagePhonetype(Integer startpagePhonetype) {
		this.startpagePhonetype = startpagePhonetype;
	}

}