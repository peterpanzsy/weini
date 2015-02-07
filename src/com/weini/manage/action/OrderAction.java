package com.weini.manage.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.OrderService;
import com.weini.manage.business.OtherService;
import com.weini.manage.business.StartUpdateService;
import com.weini.manage.entity.TOrder;
import com.weini.manage.entity.TSorderDispatching;
import com.weini.manage.entity.TTrackpage;
import com.weini.tools.Tools;

public class OrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int index;
	private List nowMonthOrderlist;
	private List lastMonthOrderlist;
	private List datalist;
	private TOrder orderDetail;
	private int code;
	private String result;
	private int ordereStatus;
	private String orderNum;
	// 新增订单的数据
	private int orderMenuID;
	private int boxID;
	private String orderStartTime;
	private String orderOrderTime;
	private int orderIsFirst;
	private int orderDispatchingID;
	private int userHeatID;
	private int userAppetite;
	private int pageStart;
	private int pageLimit;
	//开始，截止日期 形如 2015-12-01
	private String dateStart;
	private String dateEnd;
	// 用户的某一月订单
	private int year;
	private int month;
	// 用户退款原因
	private int refundReason;
	//订单溯源信息；
	private TTrackpage trackPage;
	private int sonOrderID;
	/**
	 * 获取用户最近两个月的订单信息
	 * @return 
	 */
	public String getUserLastedMonthOrder(){
		code = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;//month从0开始
		int userID = -1;
		try{
			userID = Tools.getUserID();
		}catch(Exception e){
			e.printStackTrace();
			return "SUCCESS";
		}
		nowMonthOrderlist = (new OrderService()).getMonthOrderByUserID(userID, year, month);
		if(month == 1){
			lastMonthOrderlist = (new OrderService()).getMonthOrderByUserID(userID, year-1, 12);
		}else{
			lastMonthOrderlist = (new OrderService()).getMonthOrderByUserID(userID, year, month-1);
		}
		code = 1;
		return "SUCCESS";
	}
	/**
	 * 用户下单
	 * @return code 1:成功;0:失败
	 */
	public String addOrder(){
		code = 0;
		try{
//			int userID = 1;
//			orderMenuID =1;
//			boxID = 3;
//			orderStartTime="2015-01-22 10:35:18";
//			orderOrderTime = "2015-01-22 10:35:18";
//			orderIsFirst = 0;
//			orderDispatchingID = 1;
//			userHeatID = 1;
//			userAppetite = 1;
			int userID = Tools.getUserID();
			TOrder order = new TOrder();
			order.setOrderMenuinfoId(this.orderMenuID);
			order.setBoxId(this.boxID);
			order.setOrderStartTime(Timestamp.valueOf(this.orderStartTime));
			order.setOrderOrderTime(Timestamp.valueOf(this.orderOrderTime));
			order.setOrderIsFirst(this.orderIsFirst);
			order.setOrderDispatchingId(this.orderDispatchingID);
			order.setUserId(userID);
			//设置订单编号
			order.setOrderNum((new OtherService()).getOrderNumSting());
			// 剩余uesrHeatID,userAppetite 如果是isFirst的话就需要更新user表
			if((result = (new OrderService()).addUserOrder(order, orderIsFirst, userID, userHeatID, userAppetite)) != null){
				code = 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	/**
	 *获取订单支付状态
	 * @return
	 */
	public String getOrderPayStatus(){
		if((ordereStatus = (new OrderService()).getOrderStatusByOrderNum(orderNum)) != -1){
			code = 1;
		}else{
			code = 0;
		}
		return "SUCCESS";
	}
	/**
	 * 根据订单id获取子订单信息
	 * orderNum 订单id
	 * @return 
	 */
	public String getSonOrderList(){
		code = 0;
		datalist = (new OrderService()).getSonOrderByOrderID(orderNum);
		if(datalist != null){
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 根据用户的id获取用户的订单记录
	 * @return
	 */
	public String getUserOrderListLimit(){
		code = 0;
		try{
			datalist = (new OrderService()).getUserOrderListLimit(1/*Tools.getUserID()*/,pageStart,pageLimit);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(datalist != null){
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 获取用户的某一个月的订餐记录
	 * @return
	 */
	public String getUserSomeMonthOrder(){
		code = 0;
		int userID = -1;
		try{
			userID = Tools.getUserID();
			
		}catch(Exception e){
			e.printStackTrace();
			return "SUCCESS";
		}
		datalist = (new OrderService()).getMonthOrderByUserID(userID, year, month);
		code = 1;
		return "SUCCESS";
	}
	/**
	 * 根据订单编号获取订单详细
	 * @param orderNum 订单编号
	 * @return
	 */
	public String getOrderDetailByOrderNum(){
		code = 0;
		orderDetail = (new OrderService()).getOrderDetailByOrderNum(orderNum);
		if(orderDetail != null){
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 用户退款
	 * orderNum 订单编号
	 * refundReason 退款原因索引
	 * @return
	 */
	public String UserApplyRefund(){
		code = 0;
		if((new OrderService()).UserApplyRefund(orderNum, refundReason)){
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 
	 * @return
	 */
	public String getUserOrderByDate(){
		code = 0;
		try{
			datalist = (new OrderService()).searchUserOrderByDate(Tools.getUserID(), dateStart, dateEnd, pageStart, pageLimit);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(datalist != null){
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 应用启动时，获取溯源页面的文案信息以及
	 * @param 子订单id
	 * @return 如果有，返回页面信息；否则，返回null
	 */
	public String searchOrderStatusTrack(){
		code = 0;
		setTrackPage((new StartUpdateService()).getTrackPageinfo());
		datalist = (new OrderService()).getSonOrderDispatchStatus(sonOrderID);
		if(datalist != null){
			code = 1;
		}
		return "SUCCESS";
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
	public String getResult() {
		return result;
	}
	public TOrder getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(TOrder orderDetail) {
		this.orderDetail = orderDetail;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getOrdereStatus() {
		return ordereStatus;
	}
	public void setOrdereStatus(int ordereStatus) {
		this.ordereStatus = ordereStatus;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(int refundReason) {
		this.refundReason = refundReason;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public List getNowMonthOrderlist() {
		return nowMonthOrderlist;
	}
	public void setNowMonthOrderlist(List nowMonthOrderlist) {
		this.nowMonthOrderlist = nowMonthOrderlist;
	}
	public List getLastMonthOrderlist() {
		return lastMonthOrderlist;
	}
	public void setLastMonthOrderlist(List lastMonthOrderlist) {
		this.lastMonthOrderlist = lastMonthOrderlist;
	}
	public List getDatalist() {
		return datalist;
	}
	public void setDatalist(List datalist) {
		this.datalist = datalist;
	}
	public TTrackpage getTrackPage() {
		return trackPage;
	}
	public void setTrackPage(TTrackpage trackPage) {
		this.trackPage = trackPage;
	}
	public int getSonOrderID() {
		return sonOrderID;
	}
	public void setSonOrderID(int sonOrderID) {
		this.sonOrderID = sonOrderID;
	}
}
