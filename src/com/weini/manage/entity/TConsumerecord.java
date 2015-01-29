package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TConsumerecord entity. @author MyEclipse Persistence Tools
 */

public class TConsumerecord implements java.io.Serializable {

	// Fields

	private Integer consumeRecordId;
	private Integer pointExchangeId;
	private Timestamp consumeRecordTime;
	private Integer consumeRecordUserid;

	// Constructors

	/** default constructor */
	public TConsumerecord() {
	}

	/** full constructor */
	public TConsumerecord(Integer pointExchangeId, Timestamp consumeRecordTime,
			Integer consumeRecordUserid) {
		this.pointExchangeId = pointExchangeId;
		this.consumeRecordTime = consumeRecordTime;
		this.consumeRecordUserid = consumeRecordUserid;
	}

	// Property accessors

	public Integer getConsumeRecordId() {
		return this.consumeRecordId;
	}

	public void setConsumeRecordId(Integer consumeRecordId) {
		this.consumeRecordId = consumeRecordId;
	}

	public Integer getPointExchangeId() {
		return this.pointExchangeId;
	}

	public void setPointExchangeId(Integer pointExchangeId) {
		this.pointExchangeId = pointExchangeId;
	}

	public Timestamp getConsumeRecordTime() {
		return this.consumeRecordTime;
	}

	public void setConsumeRecordTime(Timestamp consumeRecordTime) {
		this.consumeRecordTime = consumeRecordTime;
	}

	public Integer getConsumeRecordUserid() {
		return this.consumeRecordUserid;
	}

	public void setConsumeRecordUserid(Integer consumeRecordUserid) {
		this.consumeRecordUserid = consumeRecordUserid;
	}

}