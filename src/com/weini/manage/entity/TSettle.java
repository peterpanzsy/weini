package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TSettle entity. @author MyEclipse Persistence Tools
 */

public class TSettle implements java.io.Serializable {

	// Fields

	private Integer settleId;
	private Integer vendorId;
	private Integer settleType;
	private Float settleMoney;
	private String settleState;
	private Timestamp settleDate;
	private Integer settleOrderStartId;
	private Integer settleOrderEndId;

	// Constructors

	/** default constructor */
	public TSettle() {
	}

	/** full constructor */
	public TSettle(Integer vendorId, Integer settleType, Float settleMoney,
			String settleState, Timestamp settleDate,
			Integer settleOrderStartId, Integer settleOrderEndId) {
		this.vendorId = vendorId;
		this.settleType = settleType;
		this.settleMoney = settleMoney;
		this.settleState = settleState;
		this.settleDate = settleDate;
		this.settleOrderStartId = settleOrderStartId;
		this.settleOrderEndId = settleOrderEndId;
	}

	// Property accessors

	public Integer getSettleId() {
		return this.settleId;
	}

	public void setSettleId(Integer settleId) {
		this.settleId = settleId;
	}

	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getSettleType() {
		return this.settleType;
	}

	public void setSettleType(Integer settleType) {
		this.settleType = settleType;
	}

	public Float getSettleMoney() {
		return this.settleMoney;
	}

	public void setSettleMoney(Float settleMoney) {
		this.settleMoney = settleMoney;
	}

	public String getSettleState() {
		return this.settleState;
	}

	public void setSettleState(String settleState) {
		this.settleState = settleState;
	}

	public Timestamp getSettleDate() {
		return this.settleDate;
	}

	public void setSettleDate(Timestamp settleDate) {
		this.settleDate = settleDate;
	}

	public Integer getSettleOrderStartId() {
		return this.settleOrderStartId;
	}

	public void setSettleOrderStartId(Integer settleOrderStartId) {
		this.settleOrderStartId = settleOrderStartId;
	}

	public Integer getSettleOrderEndId() {
		return this.settleOrderEndId;
	}

	public void setSettleOrderEndId(Integer settleOrderEndId) {
		this.settleOrderEndId = settleOrderEndId;
	}

}