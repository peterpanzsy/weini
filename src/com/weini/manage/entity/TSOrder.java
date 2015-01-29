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
	private String dispatchingStatusId;
	private Integer menuId;
	private Integer SOrderWhichday;
	private Integer SOrderConsumeStatus;
	private String SOrderConsumeEvaluate;
	private Timestamp SOrderDispatchingStartT;
	private String SOrderLogisticsEvaluate;
	private Timestamp SOrderPredictTime;
	private Integer SOrderIsdispatchingStateOpen;
	private Integer SOrderIsRefund;
	private String SOrderNotice;

	// Constructors

	/** default constructor */
	public TSOrder() {
	}

	/** minimal constructor */
	public TSOrder(Integer FOrderId, String dispatchingStatusId,
			Integer menuId, Integer SOrderWhichday,
			Integer SOrderConsumeStatus, Timestamp SOrderDispatchingStartT,
			Timestamp SOrderPredictTime, Integer SOrderIsdispatchingStateOpen,
			Integer SOrderIsRefund) {
		this.FOrderId = FOrderId;
		this.dispatchingStatusId = dispatchingStatusId;
		this.menuId = menuId;
		this.SOrderWhichday = SOrderWhichday;
		this.SOrderConsumeStatus = SOrderConsumeStatus;
		this.SOrderDispatchingStartT = SOrderDispatchingStartT;
		this.SOrderPredictTime = SOrderPredictTime;
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
		this.SOrderIsRefund = SOrderIsRefund;
	}

	/** full constructor */
	public TSOrder(Integer FOrderId, String dispatchingStatusId,
			Integer menuId, Integer SOrderWhichday,
			Integer SOrderConsumeStatus, String SOrderConsumeEvaluate,
			Timestamp SOrderDispatchingStartT, String SOrderLogisticsEvaluate,
			Timestamp SOrderPredictTime, Integer SOrderIsdispatchingStateOpen,
			Integer SOrderIsRefund, String SOrderNotice) {
		this.FOrderId = FOrderId;
		this.dispatchingStatusId = dispatchingStatusId;
		this.menuId = menuId;
		this.SOrderWhichday = SOrderWhichday;
		this.SOrderConsumeStatus = SOrderConsumeStatus;
		this.SOrderConsumeEvaluate = SOrderConsumeEvaluate;
		this.SOrderDispatchingStartT = SOrderDispatchingStartT;
		this.SOrderLogisticsEvaluate = SOrderLogisticsEvaluate;
		this.SOrderPredictTime = SOrderPredictTime;
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
		this.SOrderIsRefund = SOrderIsRefund;
		this.SOrderNotice = SOrderNotice;
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

	public Integer getSOrderIsdispatchingStateOpen() {
		return this.SOrderIsdispatchingStateOpen;
	}

	public void setSOrderIsdispatchingStateOpen(
			Integer SOrderIsdispatchingStateOpen) {
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
	}

	public Integer getSOrderIsRefund() {
		return this.SOrderIsRefund;
	}

	public void setSOrderIsRefund(Integer SOrderIsRefund) {
		this.SOrderIsRefund = SOrderIsRefund;
	}

	public String getSOrderNotice() {
		return this.SOrderNotice;
	}

	public void setSOrderNotice(String SOrderNotice) {
		this.SOrderNotice = SOrderNotice;
	}

}