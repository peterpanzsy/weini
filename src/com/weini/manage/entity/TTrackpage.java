package com.weini.manage.entity;
// default package

/**
 * TTrackpage entity. @author MyEclipse Persistence Tools
 */

public class TTrackpage implements java.io.Serializable {

	// Fields

	private Integer trackpageId;
	private String trackpageCurrentstate;
	private Integer trackpageCurbackcolindex;
	private String trackpageTiptext;

	// Constructors

	/** default constructor */
	public TTrackpage() {
	}

	/** full constructor */
	public TTrackpage(String trackpageCurrentstate,
			Integer trackpageCurbackcolindex, String trackpageTiptext) {
		this.trackpageCurrentstate = trackpageCurrentstate;
		this.trackpageCurbackcolindex = trackpageCurbackcolindex;
		this.trackpageTiptext = trackpageTiptext;
	}

	// Property accessors

	public Integer getTrackpageId() {
		return this.trackpageId;
	}

	public void setTrackpageId(Integer trackpageId) {
		this.trackpageId = trackpageId;
	}

	public String getTrackpageCurrentstate() {
		return this.trackpageCurrentstate;
	}

	public void setTrackpageCurrentstate(String trackpageCurrentstate) {
		this.trackpageCurrentstate = trackpageCurrentstate;
	}

	public Integer getTrackpageCurbackcolindex() {
		return this.trackpageCurbackcolindex;
	}

	public void setTrackpageCurbackcolindex(Integer trackpageCurbackcolindex) {
		this.trackpageCurbackcolindex = trackpageCurbackcolindex;
	}

	public String getTrackpageTiptext() {
		return this.trackpageTiptext;
	}

	public void setTrackpageTiptext(String trackpageTiptext) {
		this.trackpageTiptext = trackpageTiptext;
	}

}