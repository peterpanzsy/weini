package com.weini.manage.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.OrderService;
import com.weini.manage.entity.TOrder;

public class OrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int index;
	private List<Object[]> nowMonthOrderlist;
	private List<Object[]> lastMonthOrderlist;
	private List<Object[]> datalist;
	private int code;
	// 新增订单的数据
	private int orderMenuID;
	private int boxID;
	private String orderStartTime;
	private String orderOrderTime;
	private int orderIsFirst;
	private int orderDispatchingID;
	private int userHeatID;
	private int userAppetite;
	/**
	 * 传入用户的id
	 * 获取用户最近两个月的订单信息
	 * index 用户id
	 * @return 
	 */
	public String getUserLastedMonthOrder(){
		this.index = 1;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;//month从0开始
		nowMonthOrderlist = (new OrderService()).getMonthOrderByUserID(index, year, month);
		if(month == 1){
			lastMonthOrderlist = (new OrderService()).getMonthOrderByUserID(index, year-1, 12);
		}else{
			lastMonthOrderlist = (new OrderService()).getMonthOrderByUserID(index, year, month-1);
		}
		return "SUCCESS";
	}
	/**
	 * 用户下单
	 * @return
	 */
	public String addOrder(){
		TOrder order = new TOrder();
		order.setOrderMenuinfoId(this.orderMenuID);
		order.setBoxId(this.boxID);
		order.setOrderStartTime(Timestamp.valueOf(this.orderStartTime));
		order.setOrderOrderTime(Timestamp.valueOf(this.orderOrderTime));
		order.setOrderIsFirst(this.orderIsFirst);
		order.setOrderDispatchingId(this.orderDispatchingID);
		// 剩余uesrHeatID,userAppetite 如果是isFirst的话就需要更新user表
//		TODO
		return "SUCCESS";
	}
	/**
	 *获取订单支付状态
	 * @return
	 */
	public String getOrderPayStatus(){
		return "SUCCESS";
	}
	/**
	 * 根据订单id获取子订单信息
	 * index 订单id
	 * @return 
	 */
	public String getSonOrderList(){
		datalist = (new OrderService()).getSonOrderByOrderID(index);
		return "SUCCESS";
	}
	
	
	public List<Object[]> getNowMonthOrderlist() {
		return nowMonthOrderlist;
	}
	public void setNowMonthOrderlist(List<Object[]> nowMonthOrderlist) {
		this.nowMonthOrderlist = nowMonthOrderlist;
	}
	public List<Object[]> getLastMonthOrderlist() {
		return lastMonthOrderlist;
	}
	public void setLastMonthOrderlist(List<Object[]> lastMonthOrderlist) {
		this.lastMonthOrderlist = lastMonthOrderlist;
	}
	public List<Object[]> getDatalist() {
		return datalist;
	}
	public void setDatalist(List<Object[]> datalist) {
		this.datalist = datalist;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getOrderMenuID() {
		return orderMenuID;
	}
	public void setOrderMenuID(int orderMenuID) {
		this.orderMenuID = orderMenuID;
	}
	public int getBoxID() {
		return boxID;
	}
	public void setBoxID(int boxID) {
		this.boxID = boxID;
	}
	public String getOrderStartTime() {
		return orderStartTime;
	}
	public void setOrderStartTime(String orderStartTime) {
		this.orderStartTime = orderStartTime;
	}
	public String getOrderOrderTime() {
		return orderOrderTime;
	}
	public void setOrderOrderTime(String orderOrderTime) {
		this.orderOrderTime = orderOrderTime;
	}
	public int getOrderIsFirst() {
		return orderIsFirst;
	}
	public void setOrderIsFirst(int orderIsFirst) {
		this.orderIsFirst = orderIsFirst;
	}
	public int getOrderDispatchingID() {
		return orderDispatchingID;
	}
	public void setOrderDispatchingID(int orderDispatchingID) {
		this.orderDispatchingID = orderDispatchingID;
	}
	public int getUserHeatID() {
		return userHeatID;
	}
	public void setUserHeatID(int userHeatID) {
		this.userHeatID = userHeatID;
	}
	public int getUserAppetite() {
		return userAppetite;
	}
	public void setUserAppetite(int userAppetite) {
		this.userAppetite = userAppetite;
	}
}
