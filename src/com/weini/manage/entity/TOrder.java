package com.weini.manage.entity;
// default package

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

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
	
	//pl add 
	//菜品是否是西餐
	private int orderMenuWestern;
	private String orderMenuTypeDesc;
	private int orderBoxType;

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

	public String getOrderStartTime() {
		if(this.orderStartTime != null){
			return this.orderStartTime.toString();
		}else{
			return "";
		}
	}
	public Timestamp getOrderStartTimeTimestamp() {
		return this.orderStartTime;
	}

	public void setOrderStartTime(String orderStartTime) throws ParseException {
		this.orderStartTime = this.getTimestampByString(orderStartTime);
	}
	
	public void setOrderStartTime(Timestamp startTime) {
		this.orderStartTime = startTime;
	}

	public String getOrderOrderTime() {
		if(this.orderOrderTime != null){
			return this.orderOrderTime.toString();
		}else{
			return "";
		}
	}
	public Timestamp getOrderOrderTimeTimestamp() {
			return this.orderOrderTime;
	}

	public void setOrderOrderTime(String orderOrderTime) throws ParseException{
		this.orderOrderTime = this.getTimestampByString(orderOrderTime);
	}
	
	public void setOrderOrderTime(Timestamp orderTime) {
		this.orderOrderTime = orderTime;
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

	public String getOrderPayTime() {
		if(this.orderPayTime != null){
			return this.orderPayTime.toString();
		}else{
			return "";
		}
		
	}
	public Timestamp getOrderPayTimeTimestamp() {
		return this.orderPayTime;
	}

	public void setOrderPayTime(String orderPayTime) throws ParseException {
		this.orderPayTime = this.getTimestampByString(orderPayTime);
	}
	public void setOrderPayTime(Timestamp payTime) {
		this.orderPayTime = payTime;
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

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderMenuWestern() {
		return orderMenuWestern;
	}

	public void setOrderMenuWestern(int orderMenuWestern) {
		this.orderMenuWestern = orderMenuWestern;
	}

	public String getOrderMenuTypeDesc() {
		return orderMenuTypeDesc;
	}

	public void setOrderMenuTypeDesc(String orderMenuTypeDesc) {
		this.orderMenuTypeDesc = orderMenuTypeDesc;
	}
	private Timestamp getTimestampByString(String time) throws ParseException{
		DateFormat format2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = format2.parse(time);
    	Timestamp temp = new Timestamp(date.getTime());
    	return temp;
	}

	public int getOrderBoxType() {
		return orderBoxType;
	}

	public void setOrderBoxType(int orderBoxType) {
		this.orderBoxType = orderBoxType;
	}


}