package com.weini.manage.entity;
// default package

import java.sql.Timestamp;
import java.util.Date;

/**
 * TSOrder entity. @author MyEclipse Persistence Tools
 */

public class TSOrder implements java.io.Serializable {

	// Fields

	private Integer SOrderId;
	private String FOrderNum;
	private Integer menuId;
	private Integer SOrderWhichday;
	private String SOrderConsumeEvaluate;
	private Date SOrderDispatchingDate;
	private String SOrderLogisticsEvaluate;
	private Timestamp SOrderPredictTime;
	private Integer SOrderIsdispatchingStateOpen;
	private String SOrderNotice;
	private Integer SOrderDispatchingId;
	private Integer SOrderStatus;

	// Constructors

	/** default constructor */
	public TSOrder() {
	}

	/** minimal constructor */
	public TSOrder(String FOrderNum, Integer menuId, Integer SOrderWhichday,
			Date SOrderDispatchingDate, Integer SOrderIsdispatchingStateOpen,
			Integer SOrderStatus) {
		this.FOrderNum = FOrderNum;
		this.menuId = menuId;
		this.SOrderWhichday = SOrderWhichday;
		this.SOrderDispatchingDate = SOrderDispatchingDate;
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
		this.SOrderStatus = SOrderStatus;
	}

	/** full constructor */
	public TSOrder(String FOrderNum, Integer menuId, Integer SOrderWhichday,
			String SOrderConsumeEvaluate, Date SOrderDispatchingDate,
			String SOrderLogisticsEvaluate, Timestamp SOrderPredictTime,
			Integer SOrderIsdispatchingStateOpen, String SOrderNotice,
			Integer SOrderDispatchingId, Integer SOrderStatus) {
		this.FOrderNum = FOrderNum;
		this.menuId = menuId;
		this.SOrderWhichday = SOrderWhichday;
		this.SOrderConsumeEvaluate = SOrderConsumeEvaluate;
		this.SOrderDispatchingDate = SOrderDispatchingDate;
		this.SOrderLogisticsEvaluate = SOrderLogisticsEvaluate;
		this.SOrderPredictTime = SOrderPredictTime;
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
		this.SOrderNotice = SOrderNotice;
		this.SOrderDispatchingId = SOrderDispatchingId;
		this.SOrderStatus = SOrderStatus;
	}

	// Property accessors

	public Integer getSOrderId() {
		return this.SOrderId;
	}

	public void setSOrderId(Integer SOrderId) {
		this.SOrderId = SOrderId;
	}

	public String getFOrderNum() {
		return this.FOrderNum;
	}

	public void setFOrderNum(String FOrderNum) {
		this.FOrderNum = FOrderNum;
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

	public String getSOrderConsumeEvaluate() {
		return this.SOrderConsumeEvaluate;
	}

	public void setSOrderConsumeEvaluate(String SOrderConsumeEvaluate) {
		this.SOrderConsumeEvaluate = SOrderConsumeEvaluate;
	}

	public Date getSOrderDispatchingDate() {
		return this.SOrderDispatchingDate;
	}

	public void setSOrderDispatchingDate(Date SOrderDispatchingDate) {
		this.SOrderDispatchingDate = SOrderDispatchingDate;
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

	public String getSOrderNotice() {
		return this.SOrderNotice;
	}

	public void setSOrderNotice(String SOrderNotice) {
		this.SOrderNotice = SOrderNotice;
	}

	public Integer getSOrderDispatchingId() {
		return this.SOrderDispatchingId;
	}

	public void setSOrderDispatchingId(Integer SOrderDispatchingId) {
		this.SOrderDispatchingId = SOrderDispatchingId;
	}

	public Integer getSOrderStatus() {
		return this.SOrderStatus;
	}

	public void setSOrderStatus(Integer SOrderStatus) {
		this.SOrderStatus = SOrderStatus;
	}

}