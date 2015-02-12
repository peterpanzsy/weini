package com.weini.manage.entity;
// default package

import java.beans.Transient;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_order")
public class TOrder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNum;
	private Integer userId;
	private Integer orderMenuinfoId;
	private Integer boxId;
	private Timestamp orderStartTime;
	private Timestamp orderOrderTime;
	private Integer orderPayStatus;
	private Integer SOrderConsumeStatus;
	private Timestamp orderPayTime;
	private Float boxPrice;
	private Integer orderIsFirst;
	private Integer orderDispatchingId;
	private Integer orderSettleStatus;
	private Integer orderStatus;
	private String orderNotice;
	
	//pl add 
	//菜品是否是西餐
	private int orderMenuWestern;
	private String orderMenuTypeDesc;
	private int orderBoxType;
	private String orderBoxTypeName;
	private String orderStartTimeString;
	private String orderOrderTimeString;
	private String orderPayTimeString;

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(String orderNum, Integer userId, Integer orderMenuinfoId,
			Integer boxId, Timestamp orderStartTime, Timestamp orderOrderTime,
			Integer orderPayStatus, Integer SOrderConsumeStatus,
			Float boxPrice, Integer orderIsFirst, Integer orderDispatchingId,
			Integer orderSettleStatus, Integer orderStatus) {
		this.orderNum = orderNum;
		this.userId = userId;
		this.orderMenuinfoId = orderMenuinfoId;
		this.boxId = boxId;
		this.orderStartTime = orderStartTime;
		this.orderOrderTime = orderOrderTime;
		this.orderPayStatus = orderPayStatus;
		this.SOrderConsumeStatus = SOrderConsumeStatus;
		this.boxPrice = boxPrice;
		this.orderIsFirst = orderIsFirst;
		this.orderDispatchingId = orderDispatchingId;
		this.orderSettleStatus = orderSettleStatus;
		this.orderStatus = orderStatus;
	}

	/** full constructor */
	public TOrder(String orderNum, Integer userId, Integer orderMenuinfoId,
			Integer boxId, Timestamp orderStartTime, Timestamp orderOrderTime,
			Integer orderPayStatus, Integer SOrderConsumeStatus,
			Timestamp orderPayTime, Float boxPrice, Integer orderIsFirst,
			Integer orderDispatchingId, Integer orderSettleStatus,
			Integer orderStatus) {
		this.orderNum = orderNum;
		this.userId = userId;
		this.orderMenuinfoId = orderMenuinfoId;
		this.boxId = boxId;
		this.orderStartTime = orderStartTime;
		this.orderOrderTime = orderOrderTime;
		this.orderPayStatus = orderPayStatus;
		this.SOrderConsumeStatus = SOrderConsumeStatus;
		this.orderPayTime = orderPayTime;
		this.boxPrice = boxPrice;
		this.orderIsFirst = orderIsFirst;
		this.orderDispatchingId = orderDispatchingId;
		this.orderSettleStatus = orderSettleStatus;
		this.orderStatus = orderStatus;
	}

	// Property accessors
	@Id              // 表示主键
    @Column(name = "order_num")
	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "order_menuinfo_id")
	public Integer getOrderMenuinfoId() {
		return this.orderMenuinfoId;
	}

	public void setOrderMenuinfoId(Integer orderMenuinfoId) {
		this.orderMenuinfoId = orderMenuinfoId;
	}
	
	@Column(name = "box_id")
	public Integer getBoxId() {
		return this.boxId;
	}

	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	
	@Column(name = "order_startTime")
	public Timestamp getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(Timestamp orderStartTime) {
		this.orderStartTime = orderStartTime;
	}
	
	@Column(name = "order_orderTime")
	public Timestamp getOrderOrderTime() {
		return orderOrderTime;
	}

	public void setOrderOrderTime(Timestamp orderOrderTime) {
		this.orderOrderTime = orderOrderTime;
	}

	@Column(name = "order_payTime")
	public Timestamp getOrderPayTime() {
		return orderPayTime;
	}

	public void setOrderPayTime(Timestamp orderPayTime) {
		this.orderPayTime = orderPayTime;
	}

	@Column(name = "order_payStatus")
	public Integer getOrderPayStatus() {
		return this.orderPayStatus;
	}

	public void setOrderPayStatus(Integer orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}
	
	@Column(name = "S_order_ConsumeStatus")
	public Integer getSOrderConsumeStatus() {
		return this.SOrderConsumeStatus;
	}

	public void setSOrderConsumeStatus(Integer SOrderConsumeStatus) {
		this.SOrderConsumeStatus = SOrderConsumeStatus;
	}
	
	@Column(name = "box_price")
	public Float getBoxPrice() {
		return this.boxPrice;
	}

	public void setBoxPrice(Float boxPrice) {
		this.boxPrice = boxPrice;
	}
	
	@Column(name = "order_isFirst")
	public Integer getOrderIsFirst() {
		return this.orderIsFirst;
	}

	public void setOrderIsFirst(Integer orderIsFirst) {
		this.orderIsFirst = orderIsFirst;
	}

	@Column(name = "order_dispatching_id")
	public Integer getOrderDispatchingId() {
		return this.orderDispatchingId;
	}

	public void setOrderDispatchingId(Integer orderDispatchingId) {
		this.orderDispatchingId = orderDispatchingId;
	}

	@Column(name = "order_settleStatus")
	public Integer getOrderSettleStatus() {
		return this.orderSettleStatus;
	}

	public void setOrderSettleStatus(Integer orderSettleStatus) {
		this.orderSettleStatus = orderSettleStatus;
	}
	
	@Column(name = "order_status")
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@Column(name = "order_notice")
	public String getOrderNotice() {
		return orderNotice;
	}

	public void setOrderNotice(String orderNotice) {
		this.orderNotice = orderNotice;
	}

	@Transient
	public int getOrderMenuWestern() {
		return orderMenuWestern;
	}

	public void setOrderMenuWestern(int orderMenuWestern) {
		this.orderMenuWestern = orderMenuWestern;
	}
	
	@Transient
	public String getOrderMenuTypeDesc() {
		return orderMenuTypeDesc;
	}

	public void setOrderMenuTypeDesc(String orderMenuTypeDesc) {
		this.orderMenuTypeDesc = orderMenuTypeDesc;
	}
	
	@Transient
	private Timestamp getTimestampByString(String time) throws ParseException{
		DateFormat format2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = format2.parse(time);
    	Timestamp temp = new Timestamp(date.getTime());
    	return temp;
	}

	@Transient
	public int getOrderBoxType() {
		return orderBoxType;
	}

	public void setOrderBoxType(int orderBoxType) {
		this.orderBoxType = orderBoxType;
	}

	@Transient
	public String getOrderBoxTypeName() {
		return orderBoxTypeName;
	}

	public void setOrderBoxTypeName(String orderBoxTypeName) {
		this.orderBoxTypeName = orderBoxTypeName;
	}
	
	@Transient
	public String getOrderStartTimeString() {
		if(this.orderStartTime != null){
			return this.orderStartTime.toString();
		}else{
			return "";
		}
	}
	
	@Transient
	public String getOrderOrderTimeString() {
		if(this.orderOrderTime != null){
			return this.orderOrderTime.toString();
		}else{
			return "";
		}
	}
	
	@Transient
	public String getOrderPayTimeString() {
		if(this.orderPayTime != null){
			return this.orderPayTime.toString();
		}else{
			return "";
		}
	}


}