package com.weini.manage.entity;
// default package

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TSorderDispatching entity. @author MyEclipse Persistence Tools
 */
//@Entity   
//@Table(name="t_sorder_dispatching")
public class TSorderDispatching implements java.io.Serializable {

	// Fields

	private Integer sorderdispatchingId;
	private Integer SOrderId;
	private Integer dispatchingstatusId;
	private Timestamp statusTime;
	
	//pl add
	private String statusImage;
	private String statusDesc;
	private String statusStringTime;

	// Constructors

	public String getStatusStringTime() {
		if(this.statusTime != null){
			return this.statusTime.toString();
		}else{
			return "";
		}
	}

	/** default constructor */
	public TSorderDispatching() {
	}

	/** full constructor */
	public TSorderDispatching(Integer SOrderId,Integer dispatchingstatusId, Timestamp statusTime) {
		this.SOrderId = SOrderId;
		this.dispatchingstatusId = dispatchingstatusId;
		this.statusTime = statusTime;
	}

	// Property accessors
//	@Id              // 表示主键
//    @GenericGenerator(name = "generator", strategy = "increment")  
//    @GeneratedValue(generator = "generator")   // 自增长
//    @Column(name = "sorderdispatching_id")
	public Integer getSorderdispatchingId() {
		return this.sorderdispatchingId;
	}

	public void setSorderdispatchingId(Integer sorderdispatchingId) {
		this.sorderdispatchingId = sorderdispatchingId;
	}
	@Column(name = "s_order_id",nullable = false)
	public Integer getSOrderId() {
		return this.SOrderId;
	}

	public void setSOrderId(Integer SOrderId) {
		this.SOrderId = SOrderId;
	}
	@Column(name = "dispatchingstatus_id",nullable = false)
	public Integer getDispatchingstatusId() {
		return this.dispatchingstatusId;
	}

	public void setDispatchingstatusId(Integer dispatchingstatusId) {
		this.dispatchingstatusId = dispatchingstatusId;
	}
	@Column(name = "status_time")
	public Timestamp getStatusTime() {
		return this.statusTime;
	}
	
	public String getStringStatusTime() {
		if(this.statusTime != null){
			return this.statusTime.toString();
		}else{
			return "";
		}
		
	}

	public void setStatusTime(Timestamp statusTime) {
		this.statusTime = statusTime;
	}

	public String getStatusImage() {
		return statusImage;
	}

	public void setStatusImage(String statusImage) {
		this.statusImage = statusImage;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}