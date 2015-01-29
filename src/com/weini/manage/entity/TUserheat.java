package com.weini.manage.entity;
// default package

/**
 * TUserheat entity. @author MyEclipse Persistence Tools
 */

public class TUserheat implements java.io.Serializable {

	// Fields

	private Integer userheatId;
	private String userheatDetail;

	// Constructors

	/** default constructor */
	public TUserheat() {
	}

	/** minimal constructor */
	public TUserheat(Integer userheatId) {
		this.userheatId = userheatId;
	}

	/** full constructor */
	public TUserheat(Integer userheatId, String userheatDetail) {
		this.userheatId = userheatId;
		this.userheatDetail = userheatDetail;
	}

	// Property accessors

	public Integer getUserheatId() {
		return this.userheatId;
	}

	public void setUserheatId(Integer userheatId) {
		this.userheatId = userheatId;
	}

	public String getUserheatDetail() {
		return this.userheatDetail;
	}

	public void setUserheatDetail(String userheatDetail) {
		this.userheatDetail = userheatDetail;
	}

}