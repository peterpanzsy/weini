package com.weini.manage.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.DispatchingService;
import com.weini.manage.business.OrderService;
import com.weini.manage.business.OtherService;
import com.weini.manage.business.StartUpdateService;
import com.weini.manage.entity.DispatchingAddress;
import com.weini.manage.entity.TOrder;
import com.weini.manage.entity.TSOrder;
import com.weini.manage.entity.TSorderDispatching;
import com.weini.manage.entity.TTrackpage;
import com.weini.manage.entity.TUser;
import com.weini.tools.Configure;
import com.weini.tools.HibernateSessionManager;
import com.weini.tools.Tools;

public class OrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int index;
	private List<TSOrder> nowMonthOrderlist;
	private List<TSOrder> lastMonthOrderlist;
	private List datalist;
	private TOrder orderDetail;
	private int code;
	private String result;
	private int ordereStatus;
	private String orderNum;
	// 新增订单的数据
	private int boxID;
	private String orderStartTime;
	private String orderOrderTime;
	private int orderIsFirst;
	private int orderDispatchingID;
	private int userHeatID;
	private int userAppetite;
	private int menuWestern;
	private int userPungent;
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
	private List<TTrackpage> trackPage;
	private int sonOrderID;
	//地址信息类
	private DispatchingAddress disAddress;
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
		int userId = userId = Tools.getUserID();
		if(userId == -1){
			result="用户没有登录";
			return "FAIL";
		}
		nowMonthOrderlist = (new OrderService()).getMonthOrderByUserID(userId, year, month);
		if(month == 1){
			lastMonthOrderlist = (new OrderService()).getMonthOrderByUserID(userId, year-1, 12);
		}else{
			lastMonthOrderlist = (new OrderService()).getMonthOrderByUserID(userId, year, month-1);
		}
		if(nowMonthOrderlist != null && lastMonthOrderlist != null){
			code = 1;
		}else{
			code = 0;
			result = "查询失败";
			return "FAIL";
		}
		return "SUCCESS";
	}
	/**
	 * 用户下单
	 * 用户传入订单的信息
	 * 注意：用户会传入是中餐还是西餐，根据这个后台搜索这个商圈的菜，然后动态生成菜品id
	 * @return code 1:成功;0:失败
	 */
	public String addOrder(){
		code = 0;
		try{
			TUser user = (TUser) ActionContext.getContext().getSession().get(Configure.sessionUserName);
			if(user == null){
				code = 0; 
				result = "用户没有登录";
				return "FAIL";
			}
			TOrder order = new TOrder();
			order.setBoxId(this.boxID);
			order.setOrderStartTime(Timestamp.valueOf(this.orderStartTime));
			order.setOrderOrderTime(Timestamp.valueOf(this.orderOrderTime));
			order.setOrderIsFirst(this.orderIsFirst);
			order.setOrderDispatchingId(this.orderDispatchingID);
			order.setUserId(user.getUserId());
			order.setOrderMenuWestern(menuWestern);
			//设置订单编号
			order.setOrderNum((new OtherService()).getOrderNumSting());
			// 剩余uesrHeatID,userAppetite 如果是isFirst的话就需要更新user表
			if((orderNum = (new OrderService()).addUserOrder(order, orderIsFirst, user.getUserId(), userHeatID, userAppetite,userPungent)) != null){
				code = 1;
			}
		}catch(Exception e){
			e.printStackTrace();
			code = 0;
			result = "参数设置错误";
			return "FAIL";
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
			result = "查询失败";
			return "FAIL";
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
		}else{
			code = 0;
			result = "查询失败";
			return "FAIL";
		}
		return "SUCCESS";
	}
	/**
	 * 根据用户的id获取用户的订单记录
	 * @return
	 */
	public String getUserOrderListLimit(){
		code = 0;
		int userId = Tools.getUserID();
		if(userId == -1){
			result="用户没有登录";
			return "FAIL";
		}
		datalist = (new OrderService()).getUserOrderListLimit(userId,pageStart,pageLimit);
		if(datalist != null){
			code = 1;
		}else{
			code = 0;
			result = "查询失败";
			return "FAIL";
		}
		return "SUCCESS";
	}
	/**
	 * 获取用户的某一个月的订餐记录
	 * @return
	 */
	public String getUserSomeMonthOrder(){
		code = 0;
		int userId = Tools.getUserID();
		if(userId == -1){
			result="用户没有登录";
			return "FAIL";
		}	
		datalist = (new OrderService()).getMonthOrderByUserID(userId, year, month);
		if(datalist != null){
			code = 1;
		}else{
			code = 0;
			result="查询失败";
			return "FAIL";
		}
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
		}else{
			code = 0;
			result = "订单不存在";
			return "FAIL";
		}
		return "SUCCESS";
	}
	/**
	 * 根据订单编号获取订单简略信息
	 * @param orderNum 订单编号
	 * @return 订单信息，地址类
	 */
	public String getOrderSimpleInfoByOrderNum(){
		code = 0;
		orderDetail = (new OrderService()).getOrderDetailByOrderNum(orderNum);
		if(orderDetail != null){
			disAddress = (new DispatchingService()).findDispatchingByDisId(orderDetail.getOrderDispatchingId());
			code = 1;
		}else{
			code = 0;
			result = "订单不存在";
			return "FAIL";
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
	/**TODO 等待修改
	 * 
	 * @return
	 */
	public String getUserOrderByDate(){
		int userId = Tools.getUserID();
		if(userId == -1){
			code = 0;
			result="用户没有登录";
			return "FAIL";
		}
		datalist = (new OrderService()).searchUserOrderByDate(userId, dateStart, dateEnd, pageStart, pageLimit);
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
		int userId = Tools.getUserID();
		if(userId == -1){
			code = 0;
			result="用户没有登录";
			return "FAIL";
		}
		//获取用户今天的子订单id
		int sonId = -1;
		sonId = new OrderService().getTodaySonOrderByUserId(userId);
		if(sonId == -1){
			code = 0;
			result = "用户今天没有订单";
			return "FAIL";
		}
		code = 1;
		trackPage = (new StartUpdateService()).getTrackPageinfo();

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
	public int getUserPungent() {
		return userPungent;
	}
	public void setUserPungent(int userPungent) {
		this.userPungent = userPungent;
	}
	public List<TTrackpage> getTrackPage() {
		return trackPage;
	}
	public void setTrackPage(List<TTrackpage> trackPage) {
		this.trackPage = trackPage;
	}
	public int getSonOrderID() {
		return sonOrderID;
	}
	public void setSonOrderID(int sonOrderID) {
		this.sonOrderID = sonOrderID;
	}
	public int getMenuWestern() {
		return menuWestern;
	}
	public void setMenuWestern(int menuWestern) {
		this.menuWestern = menuWestern;
	}
	public DispatchingAddress getDisAddress() {
		return disAddress;
	}
	public void setDisAddress(DispatchingAddress disAddress) {
		this.disAddress = disAddress;
	}
}
