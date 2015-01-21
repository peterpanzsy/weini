package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TSettle entity. @author MyEclipse Persistence Tools
 */

public class TSettle implements java.io.Serializable {

	// Fields

	private Integer settleId;
	private Integer bssinfoId;
	private Integer settleType;
	private Float settleMoney;
	private String settleState;
	private Timestamp settleDate;
	private Timestamp settleStartT;
	private Timestamp settleEndT;

	// Constructors

	/** default constructor */
	public TSettle() {
	}

	/** full constructor */
	public TSettle(Integer bssinfoId, Integer settleType, Float settleMoney,
			String settleState, Timestamp settleDate, Timestamp settleStartT,
			Timestamp settleEndT) {
		this.bssinfoId = bssinfoId;
		this.settleType = settleType;
		this.settleMoney = settleMoney;
		this.settleState = settleState;
		this.settleDate = settleDate;
		this.settleStartT = settleStartT;
		this.settleEndT = settleEndT;
	}

	// Property accessors

	public Integer getSettleId() {
		return this.settleId;
	}

	public void setSettleId(Integer settleId) {
		this.settleId = settleId;
	}

	public Integer getBssinfoId() {
		return this.bssinfoId;
	}

	public void setBssinfoId(Integer bssinfoId) {
		this.bssinfoId = bssinfoId;
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

	public Timestamp getSettleStartT() {
		return this.settleStartT;
	}

	public void setSettleStartT(Timestamp settleStartT) {
		this.settleStartT = settleStartT;
	}

	public Timestamp getSettleEndT() {
		return this.settleEndT;
	}

	public void setSettleEndT(Timestamp settleEndT) {
		this.settleEndT = settleEndT;
	}

}