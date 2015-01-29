package com.weini.manage.action;

import com.opensymphony.xwork2.ActionSupport;

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
	 * @return
	 */
	public String addOrder(){
		return SUCCESS;
	}
	/**
	 *获取订单支付状态
	 * @return
	 */
	public String getOrderPayStatus(){
		return SUCCESS;
	}
}
