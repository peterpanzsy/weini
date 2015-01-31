package com.weini.manage.action;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.OrderService;
import com.weini.manage.business.UserService;
import com.weini.manage.entity.TOrder;
import com.weini.manage.entity.TUser;
import com.weini.tools.Configure;

public class OrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取用户最近两个月的订单信息
	 * @return 
	 */
	public String getLastMonthOrderByUserID(){
		return SUCCESS;
	}
	/**
	 * 用户下单
	 * @return code 1:成功;0:失败
	 */
	public String addOrder(){
		code = 0;
		try{
	//		TUser user = (TUser) ActionContext.getContext().getSession().get(Configure.sessionUserName);
	//		int userID = user.getUserId();
			int userID = 1;
			this.orderMenuID = 1;
			this.boxID  = 3;
			this.orderStartTime = "2015-12-02 21:21:21";
			this.orderOrderTime = "2015-12-23 21:21:21";
			this.orderIsFirst  = 1;
			this.orderDispatchingID = 1;
			this.userHeatID = 1;
			this.userAppetite = 1;
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
			if((new OrderService()).addUserOrder(order, orderIsFirst, userID, userHeatID, userAppetite)){
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
		return SUCCESS;
	}
}
