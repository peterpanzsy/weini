package com.weini.manage.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.weini.manage.dao.OrderDao;
import com.weini.manage.dao.SonOrderDao;
import com.weini.manage.entity.TOrder;


public class OrderService extends GeneralService {
	private OrderDao orderdao = new OrderDao(this.session);
	private SonOrderDao sonorderdao = new SonOrderDao(this.session);
	/**
	 * 根据用户的id获取本月的订单记录
	 * @param userID 用户id
	 * @return
	 */
	public List<Object[]> getMonthOrderByUserID(int userID,int year,int month){
		List<Object[]> res = null;
		try{
			res = this.orderdao.searchMonth(userID, year, month);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	/**
	 * 获取子订单根据父订单的id
	 * @param orderID 父订单id
	 * @return
	 */
	public List<Object[]> getSonOrderByOrderID(int orderID){
		List<Object[]> res = null;
		try{
			res = this.sonorderdao.getSOrderByOrderID(orderID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
}
