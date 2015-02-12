package com.weini.manage.entity;
// default package

import java.beans.Transient;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TSOrder entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_s_order")
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
	private Integer userId;
	
	//pl add
	private String menuTypeDesc; 
	private String SOrderDispatchingDateString;
	// Constructors

	public String getSOrderDispatchingDateString() {
		if(this.SOrderDispatchingDate != null){
			return this.SOrderDispatchingDate.toString();
		}else{
			return "";
		}
	}

	/** default constructor */
	public TSOrder() {
	}

	/** minimal constructor */
	public TSOrder(String FOrderNum, Integer menuId, Integer SOrderWhichday,
			Date SOrderDispatchingDate, Integer SOrderIsdispatchingStateOpen,
			Integer SOrderDispatchingId, Integer SOrderStatus, Integer userId) {
		this.FOrderNum = FOrderNum;
		this.menuId = menuId;
		this.SOrderWhichday = SOrderWhichday;
		this.SOrderDispatchingDate = SOrderDispatchingDate;
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
		this.SOrderDispatchingId = SOrderDispatchingId;
		this.SOrderStatus = SOrderStatus;
		this.userId = userId;
	}

	/** full constructor */
	public TSOrder(String FOrderNum, Integer menuId, Integer SOrderWhichday,
			String SOrderConsumeEvaluate, Date SOrderDispatchingDate,
			String SOrderLogisticsEvaluate, Timestamp SOrderPredictTime,
			Integer SOrderIsdispatchingStateOpen, String SOrderNotice,
			Integer SOrderDispatchingId, Integer SOrderStatus, Integer userId) {
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
		this.userId = userId;
	}

	// Property accessors
	@Id
	// 表示主键
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	// 自增长
	@Column(name = "S_order_id")
	public Integer getSOrderId() {
		return this.SOrderId;
	}

	public void setSOrderId(Integer SOrderId) {
		this.SOrderId = SOrderId;
	}
	
	@Column(name = "F_order_num")
	public String getFOrderNum() {
		return this.FOrderNum;
	}

	public void setFOrderNum(String FOrderNum) {
		this.FOrderNum = FOrderNum;
	}
	
	@Column(name = "menu_id")
	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	@Column(name = "S_order_whichday")
	public Integer getSOrderWhichday() {
		return this.SOrderWhichday;
	}

	public void setSOrderWhichday(Integer SOrderWhichday) {
		this.SOrderWhichday = SOrderWhichday;
	}
	@Column(name = "S_order_consumeEvaluate")
	public String getSOrderConsumeEvaluate() {
		return this.SOrderConsumeEvaluate;
	}

	public void setSOrderConsumeEvaluate(String SOrderConsumeEvaluate) {
		this.SOrderConsumeEvaluate = SOrderConsumeEvaluate;
	}

	@Column(name = "S_order_dispatchingDate")
	public Date getSOrderDispatchingDate() {
		return this.SOrderDispatchingDate;
	}

	public void setSOrderDispatchingDate(Date SOrderDispatchingDate) {
		this.SOrderDispatchingDate = SOrderDispatchingDate;
	}
	
	@Column(name = "S_order_logisticsEvaluate")
	public String getSOrderLogisticsEvaluate() {
		return this.SOrderLogisticsEvaluate;
	}

	public void setSOrderLogisticsEvaluate(String SOrderLogisticsEvaluate) {
		this.SOrderLogisticsEvaluate = SOrderLogisticsEvaluate;
	}
	
	@Column(name = "S_order_predictTime")
	public Timestamp getSOrderPredictTime() {
		return this.SOrderPredictTime;
	}

	public void setSOrderPredictTime(Timestamp SOrderPredictTime) {
		this.SOrderPredictTime = SOrderPredictTime;
	}
	
	@Column(name = "S_order_isdispatchingStateOpen")
	public Integer getSOrderIsdispatchingStateOpen() {
		return this.SOrderIsdispatchingStateOpen;
	}

	public void setSOrderIsdispatchingStateOpen(
			Integer SOrderIsdispatchingStateOpen) {
		this.SOrderIsdispatchingStateOpen = SOrderIsdispatchingStateOpen;
	}
	
	@Column(name = "S_order_notice")
	public String getSOrderNotice() {
		return this.SOrderNotice;
	}

	public void setSOrderNotice(String SOrderNotice) {
		this.SOrderNotice = SOrderNotice;
	}
	@Column(name = "S_order_dispatchingID")
	public Integer getSOrderDispatchingId() {
		return this.SOrderDispatchingId;
	}

	public void setSOrderDispatchingId(Integer SOrderDispatchingId) {
		this.SOrderDispatchingId = SOrderDispatchingId;
	}
	@Column(name = "S_order_status")
	public Integer getSOrderStatus() {
		return this.SOrderStatus;
	}

	public void setSOrderStatus(Integer SOrderStatus) {
		this.SOrderStatus = SOrderStatus;
	}
	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	@Transient
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Transient
	public String getMenuTypeDesc() {
		return menuTypeDesc;
	}
	@Transient
	public void setMenuTypeDesc(String menuTypeDesc) {
		this.menuTypeDesc = menuTypeDesc;
	}

}