package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TTrackpage entity. @author MyEclipse Persistence Tools
 */

public class TTrackpage implements java.io.Serializable {

	// Fields

	private Integer trackpageId;
	private String trackpageCurrentstate;
	private Integer trackpageCurbackcolindex;
	private String trackpageTiptext;
	private Timestamp trackpageStartTime;
	private Timestamp trackpageEndTime;
	private String trackStringPageStartTime;
	private String trackStringPageEndTime;
	
	// Constructors

	/** default constructor */
	public TTrackpage() {
	}

	/** minimal constructor */
	public TTrackpage(String trackpageCurrentstate,
			Integer trackpageCurbackcolindex, String trackpageTiptext) {
		this.trackpageCurrentstate = trackpageCurrentstate;
		this.trackpageCurbackcolindex = trackpageCurbackcolindex;
		this.trackpageTiptext = trackpageTiptext;
	}

	/** full constructor */
	public TTrackpage(String trackpageCurrentstate,
			Integer trackpageCurbackcolindex, String trackpageTiptext,
			Timestamp trackpageStartTime, Timestamp trackpageEndTime) {
		this.trackpageCurrentstate = trackpageCurrentstate;
		this.trackpageCurbackcolindex = trackpageCurbackcolindex;
		this.trackpageTiptext = trackpageTiptext;
		this.trackpageStartTime = trackpageStartTime;
		this.trackpageEndTime = trackpageEndTime;
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

	public Timestamp getTrackpageStartTime() {
		return this.trackpageStartTime;
	}

	public void setTrackpageStartTime(Timestamp trackpageStartTime) {
		this.trackpageStartTime = trackpageStartTime;
	}

	public Timestamp getTrackpageEndTime() {
		return this.trackpageEndTime;
	}

	public void setTrackpageEndTime(Timestamp trackpageEndTime) {
		this.trackpageEndTime = trackpageEndTime;
	}
	
	public String getTrackStringPageStartTime() {
		if(trackpageStartTime != null){
			return this.trackpageStartTime.toString();
		}else{
			return "";
		}
	}

	public String getTrackStringPageEndTime() {
		if(this.trackpageEndTime != null){
			return this.trackpageEndTime.toString();
		}else{
			return "";
		}
	}

}