package com.weini.manage.entity;
// default package

/**
 * TPointactivity entity. @author MyEclipse Persistence Tools
 */

public class TPointactivity implements java.io.Serializable {

	// Fields

	private Integer pointActivityId;
	private String pointActivityCity;
	private Integer pointActivityTimes;

	// Constructors

	/** default constructor */
	public TPointactivity() {
	}

	/** full constructor */
	public TPointactivity(String pointActivityCity, Integer pointActivityTimes) {
		this.pointActivityCity = pointActivityCity;
		this.pointActivityTimes = pointActivityTimes;
	}

	// Property accessors

	public Integer getPointActivityId() {
		return this.pointActivityId;
	}

	public void setPointActivityId(Integer pointActivityId) {
		this.pointActivityId = pointActivityId;
	}

	public String getPointActivityCity() {
		return this.pointActivityCity;
	}

	public void setPointActivityCity(String pointActivityCity) {
		this.pointActivityCity = pointActivityCity;
	}

	public Integer getPointActivityTimes() {
		return this.pointActivityTimes;
	}

	public void setPointActivityTimes(Integer pointActivityTimes) {
		this.pointActivityTimes = pointActivityTimes;
	}

}