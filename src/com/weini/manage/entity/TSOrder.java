package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

/**
 * TSOrder entity. @author MyEclipse Persistence Tools
 */

public class TSOrder implements java.io.Serializable {

	// Fields

	private Integer SOrderId;
	private Integer FOrderId;
	private Integer dispatchingId;
	private String dispatchingStatusId;
	private Integer menuId;
	private Integer SOrderWhichday;
	private Integer SOrderConsumeStatus;
	private String SOrderConsumeEvaluate;
	private Integer SOrderDispatchingId;
	private Timestamp SOrderDispatchingStartT;
	private String SOrderLogisticsEvaluate;
	private Timestamp SOrderPredictTime;
	private Boolean SOrderIsdispatchingStateOpen;

	// Constructors

	/** default constructor */
	public TSOrder() {
	}

	/** full constructor */
	public TSOrder(Integer FOrderId, Integer dispatchingId,
			String dispatchingStatusId, Integer menuId, Integer SOrderWhichday,
			Integer SOrderConsumeStatus, String SOrderConsumeEvaluate,
			Integer SOrderDispatchingId, Timestamp SOrderDispatchingStartT,
			String SOrderLogisticsEvaluate, Timestamp SOrderPredictTime,
			Boolean SOrderIsdispatchingStateOpen) {
		this.FOrderId = FOrderId;
		this.dispatchingId = dispatchingId;
		this.dispatchingStatusId = dispatchingStatusId;
		this.menuId = menuId;
		this.SOrderWhichday = SOrderWhichday;
		this.SOrderConsumeStatus = SOrderConsumeStatus;
		this.SOrderConsumeEvaluate = SOrderConsumeEvaluate;
		this.SOrderDispatchingId = SOrderDispatchingId;
		this.SOrderDispatchingStartT = SOrderDispatchingStartT;
		this.SOrderLogisticsEvaluate = SOrderLogisticsEvaluate;
		this.SOrderPredictTime = SOrderPredictTime;
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
	}

	// Property accessors

	public Integer getSOrderId() {
		return this.SOrderId;
	}

	public void setSOrderId(Integer SOrderId) {
		this.SOrderId = SOrderId;
	}

	public Integer getFOrderId() {
		return this.FOrderId;
	}

	public void setFOrderId(Integer FOrderId) {
		this.FOrderId = FOrderId;
	}

	public Integer getDispatchingId() {
		return this.dispatchingId;
	}

	public void setDispatchingId(Integer dispatchingId) {
		this.dispatchingId = dispatchingId;
	}

	public String getDispatchingStatusId() {
		return this.dispatchingStatusId;
	}

	public void setDispatchingStatusId(String dispatchingStatusId) {
		this.dispatchingStatusId = dispatchingStatusId;
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getSOrderWhichday() {
		return this.SOrderWhichday;
	}

	public void setSOrderWhichday(Integer SOrderWhichday) {
		this.SOrderWhichday = SOrderWhichday;
	}

	public Integer getSOrderConsumeStatus() {
		return this.SOrderConsumeStatus;
	}

	public void setSOrderConsumeStatus(Integer SOrderConsumeStatus) {
		this.SOrderConsumeStatus = SOrderConsumeStatus;
	}

	public String getSOrderConsumeEvaluate() {
		return this.SOrderConsumeEvaluate;
	}

	public void setSOrderConsumeEvaluate(String SOrderConsumeEvaluate) {
		this.SOrderConsumeEvaluate = SOrderConsumeEvaluate;
	}

	public Integer getSOrderDispatchingId() {
		return this.SOrderDispatchingId;
	}

	public void setSOrderDispatchingId(Integer SOrderDispatchingId) {
		this.SOrderDispatchingId = SOrderDispatchingId;
	}

	public Timestamp getSOrderDispatchingStartT() {
		return this.SOrderDispatchingStartT;
	}

	public void setSOrderDispatchingStartT(Timestamp SOrderDispatchingStartT) {
		this.SOrderDispatchingStartT = SOrderDispatchingStartT;
	}

	public String getSOrderLogisticsEvaluate() {
		return this.SOrderLogisticsEvaluate;
	}

	public void setSOrderLogisticsEvaluate(String SOrderLogisticsEvaluate) {
		this.SOrderLogisticsEvaluate = SOrderLogisticsEvaluate;
	}

	public Timestamp getSOrderPredictTime() {
		return this.SOrderPredictTime;
	}

	public void setSOrderPredictTime(Timestamp SOrderPredictTime) {
		this.SOrderPredictTime = SOrderPredictTime;
	}

	public Boolean getSOrderIsdispatchingStateOpen() {
		return this.SOrderIsdispatchingStateOpen;
	}

	public void setSOrderIsdispatchingStateOpen(
			Boolean SOrderIsdispatchingStateOpen) {
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
	}

}