package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private String orderNum;
	private Integer userId;
	private Integer orderMenuinfoId;
	private Integer boxId;
	private Timestamp orderStartTime;
	private Timestamp orderOrderTime;
	private Integer orderPayStatus;
	private Integer SOrderConsumeStatus;
	private Integer orderIsRefund;
	private Timestamp orderPayTime;
	private Float boxPrice;
	private Integer orderIsFirst;
	private Integer orderIsvalid;
	private Integer orderDispatchingId;
	private Integer orderSettleStatus;

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(String orderNum, Integer userId, Integer orderMenuinfoId,
			Integer boxId, Timestamp orderStartTime, Timestamp orderOrderTime,
			Integer orderPayStatus, Integer SOrderConsumeStatus,
			Integer orderIsRefund, Float boxPrice, Integer orderIsFirst,
			Integer orderIsvalid, Integer orderDispatchingId,
			Integer orderSettleStatus) {
		this.orderNum = orderNum;
		this.userId = userId;
		this.orderMenuinfoId = orderMenuinfoId;
		this.boxId = boxId;
		this.orderStartTime = orderStartTime;
		this.orderOrderTime = orderOrderTime;
		this.orderPayStatus = orderPayStatus;
		this.SOrderConsumeStatus = SOrderConsumeStatus;
		this.orderIsRefund = orderIsRefund;
		this.boxPrice = boxPrice;
		this.orderIsFirst = orderIsFirst;
		this.orderIsvalid = orderIsvalid;
		this.orderDispatchingId = orderDispatchingId;
		this.orderSettleStatus = orderSettleStatus;
	}

	/** full constructor */
	public TOrder(String orderNum, Integer userId, Integer orderMenuinfoId,
			Integer boxId, Timestamp orderStartTime, Timestamp orderOrderTime,
			Integer orderPayStatus, Integer SOrderConsumeStatus,
			Integer orderIsRefund, Timestamp orderPayTime, Float boxPrice,
			Integer orderIsFirst, Integer orderIsvalid,
			Integer orderDispatchingId, Integer orderSettleStatus) {
		this.orderNum = orderNum;
		this.userId = userId;
		this.orderMenuinfoId = orderMenuinfoId;
		this.boxId = boxId;
		this.orderStartTime = orderStartTime;
		this.orderOrderTime = orderOrderTime;
		this.orderPayStatus = orderPayStatus;
		this.SOrderConsumeStatus = SOrderConsumeStatus;
		this.orderIsRefund = orderIsRefund;
		this.orderPayTime = orderPayTime;
		this.boxPrice = boxPrice;
		this.orderIsFirst = orderIsFirst;
		this.orderIsvalid = orderIsvalid;
		this.orderDispatchingId = orderDispatchingId;
		this.orderSettleStatus = orderSettleStatus;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderMenuinfoId() {
		return this.orderMenuinfoId;
	}

	public void setOrderMenuinfoId(Integer orderMenuinfoId) {
		this.orderMenuinfoId = orderMenuinfoId;
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

	public Integer getOrderIsRefund() {
		return this.orderIsRefund;
	}

	public void setOrderIsRefund(Integer orderIsRefund) {
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

	public Integer getOrderIsFirst() {
		return this.orderIsFirst;
	}

	public void setOrderIsFirst(Integer orderIsFirst) {
		this.orderIsFirst = orderIsFirst;
	}

	public Integer getOrderIsvalid() {
		return this.orderIsvalid;
	}

	public void setOrderIsvalid(Integer orderIsvalid) {
		this.orderIsvalid = orderIsvalid;
	}

	public Integer getOrderDispatchingId() {
		return this.orderDispatchingId;
	}

	public void setOrderDispatchingId(Integer orderDispatchingId) {
		this.orderDispatchingId = orderDispatchingId;
	}

	public Integer getOrderSettleStatus() {
		return this.orderSettleStatus;
	}

	public void setOrderSettleStatus(Integer orderSettleStatus) {
		this.orderSettleStatus = orderSettleStatus;
	}

}