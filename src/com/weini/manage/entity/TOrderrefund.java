package com.weini.manage.entity;
// default package

/**
 * TOrderrefund entity. @author MyEclipse Persistence Tools
 */

public class TOrderrefund implements java.io.Serializable {

	// Fields

	private Integer orderrefundId;
	private String orderNum;
	private Integer orderrefundReason;
	private Integer orderrefundStatus;
	private Integer orderrefundResult;

	// Constructors

	/** default constructor */
	public TOrderrefund() {
	}

	/** full constructor */
	public TOrderrefund(String orderNum, Integer orderrefundReason,
			Integer orderrefundStatus, Integer orderrefundResult) {
		this.orderNum = orderNum;
		this.orderrefundReason = orderrefundReason;
		this.orderrefundStatus = orderrefundStatus;
		this.orderrefundResult = orderrefundResult;
	}

	// Property accessors

	public Integer getOrderrefundId() {
		return this.orderrefundId;
	}

	public void setOrderrefundId(Integer orderrefundId) {
		this.orderrefundId = orderrefundId;
	}

	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOrderrefundReason() {
		return this.orderrefundReason;
	}

	public void setOrderrefundReason(Integer orderrefundReason) {
		this.orderrefundReason = orderrefundReason;
	}

	public Integer getOrderrefundStatus() {
		return this.orderrefundStatus;
	}

	public void setOrderrefundStatus(Integer orderrefundStatus) {
		this.orderrefundStatus = orderrefundStatus;
	}

	public Integer getOrderrefundResult() {
		return this.orderrefundResult;
	}

	public void setOrderrefundResult(Integer orderrefundResult) {
		this.orderrefundResult = orderrefundResult;
	}

}