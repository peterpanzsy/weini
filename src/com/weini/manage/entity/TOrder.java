package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer userId;
	private Integer boxId;
	private Timestamp orderStartTime;
	private Timestamp orderOrderTime;
	private Integer orderPayStatus;
	private Integer SOrderConsumeStatus;
	private Boolean orderIsRefund;
	private Timestamp orderPayTime;
	private Float boxPrice;

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** full constructor */
	public TOrder(Integer userId, Integer boxId, Timestamp orderStartTime,
			Timestamp orderOrderTime, Integer orderPayStatus,
			Integer SOrderConsumeStatus, Boolean orderIsRefund,
			Timestamp orderPayTime, Float boxPrice) {
		this.userId = userId;
		this.boxId = boxId;
		this.orderStartTime = orderStartTime;
		this.orderOrderTime = orderOrderTime;
		this.orderPayStatus = orderPayStatus;
		this.SOrderConsumeStatus = SOrderConsumeStatus;
		this.orderIsRefund = orderIsRefund;
		this.orderPayTime = orderPayTime;
		this.boxPrice = boxPrice;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBoxId() {
		return this.boxId;
	}

	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}

	public Timestamp getOrderStartTime() {
		return this.orderStartTime;
	}

	public void setOrderStartTime(Timestamp orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	public Timestamp getOrderOrderTime() {
		return this.orderOrderTime;
	}

	public void setOrderOrderTime(Timestamp orderOrderTime) {
		this.orderOrderTime = orderOrderTime;
	}

	public Integer getOrderPayStatus() {
		return this.orderPayStatus;
	}

	public void setOrderPayStatus(Integer orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}

	public Integer getSOrderConsumeStatus() {
		return this.SOrderConsumeStatus;
	}

	public void setSOrderConsumeStatus(Integer SOrderConsumeStatus) {
		this.SOrderConsumeStatus = SOrderConsumeStatus;
	}

	public Boolean getOrderIsRefund() {
		return this.orderIsRefund;
	}

	public void setOrderIsRefund(Boolean orderIsRefund) {
		this.orderIsRefund = orderIsRefund;
	}

	public Timestamp getOrderPayTime() {
		return this.orderPayTime;
	}

	public void setOrderPayTime(Timestamp orderPayTime) {
		this.orderPayTime = orderPayTime;
	}

	public Float getBoxPrice() {
		return this.boxPrice;
	}

	public void setBoxPrice(Float boxPrice) {
		this.boxPrice = boxPrice;
	}

}