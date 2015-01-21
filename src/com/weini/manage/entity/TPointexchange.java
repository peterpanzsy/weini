package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TPointexchange entity. @author MyEclipse Persistence Tools
 */

public class TPointexchange implements java.io.Serializable {

	// Fields

	private Integer pointExchangeId;
	private String pointExchangeDescribe;
	private Float pointExchangeNeedPoint;
	private String pointExchangeImageAddress;
	private Boolean pointExchangeCanExchange;
	private Timestamp pointExchangeStartT;
	private Timestamp pointExchangeEndT;

	// Constructors

	/** default constructor */
	public TPointexchange() {
	}

	/** full constructor */
	public TPointexchange(String pointExchangeDescribe,
			Float pointExchangeNeedPoint, String pointExchangeImageAddress,
			Boolean pointExchangeCanExchange, Timestamp pointExchangeStartT,
			Timestamp pointExchangeEndT) {
		this.pointExchangeDescribe = pointExchangeDescribe;
		this.pointExchangeNeedPoint = pointExchangeNeedPoint;
		this.pointExchangeImageAddress = pointExchangeImageAddress;
		this.pointExchangeCanExchange = pointExchangeCanExchange;
		this.pointExchangeStartT = pointExchangeStartT;
		this.pointExchangeEndT = pointExchangeEndT;
	}

	// Property accessors

	public Integer getPointExchangeId() {
		return this.pointExchangeId;
	}

	public void setPointExchangeId(Integer pointExchangeId) {
		this.pointExchangeId = pointExchangeId;
	}

	public String getPointExchangeDescribe() {
		return this.pointExchangeDescribe;
	}

	public void setPointExchangeDescribe(String pointExchangeDescribe) {
		this.pointExchangeDescribe = pointExchangeDescribe;
	}

	public Float getPointExchangeNeedPoint() {
		return this.pointExchangeNeedPoint;
	}

	public void setPointExchangeNeedPoint(Float pointExchangeNeedPoint) {
		this.pointExchangeNeedPoint = pointExchangeNeedPoint;
	}

	public String getPointExchangeImageAddress() {
		return this.pointExchangeImageAddress;
	}

	public void setPointExchangeImageAddress(String pointExchangeImageAddress) {
		this.pointExchangeImageAddress = pointExchangeImageAddress;
	}

	public Boolean getPointExchangeCanExchange() {
		return this.pointExchangeCanExchange;
	}

	public void setPointExchangeCanExchange(Boolean pointExchangeCanExchange) {
		this.pointExchangeCanExchange = pointExchangeCanExchange;
	}

	public Timestamp getPointExchangeStartT() {
		return this.pointExchangeStartT;
	}

	public void setPointExchangeStartT(Timestamp pointExchangeStartT) {
		this.pointExchangeStartT = pointExchangeStartT;
	}

	public Timestamp getPointExchangeEndT() {
		return this.pointExchangeEndT;
	}

	public void setPointExchangeEndT(Timestamp pointExchangeEndT) {
		this.pointExchangeEndT = pointExchangeEndT;
	}

}