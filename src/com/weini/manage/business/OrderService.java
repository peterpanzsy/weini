package com.weini.manage.business;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.weini.manage.dao.BoxModelDao;
import com.weini.manage.dao.OrderDao;
import com.weini.manage.dao.SonOrderDao;
import com.weini.manage.dao.UserDao;
import com.weini.manage.entity.TOrder;
import com.weini.manage.entity.TSOrder;
import com.weini.tools.HibernateSessionManager;
import com.weini.tools.Tools;


public class OrderService extends GeneralService {
	private OrderDao orderdao = new OrderDao(this.session);
	private SonOrderDao sonorderdao = new SonOrderDao(this.session);
	private BoxModelDao boxdao = new BoxModelDao(this.session);
	private UserDao userdao = new UserDao(this.session);
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
	/**
	 * 增加一个订单
	 * 	如果是isFirst订单，则需要更新用户的忌口和饭量
	 * 	增加一个订单
	 * 	增加对应的子订单
	 * @param order 订单对象
	 * @param orderIsFirst 是否是first订单
	 * @param userID 用户id
	 * @param userHeatID 用户讨厌食物的id
	 * @param userAppetite 用户的饭量
	 * @return 成功返回订单id，失败返回-1
	 */
	public int addUserOrder(TOrder order,int orderIsFirst,int userID,int userHeatID,int userAppetite){
		HibernateSessionManager.getThreadLocalTransaction();
		//设置默认值
		order.setOrderPayStatus(0);
		order.setSOrderConsumeStatus(0);
		order.setOrderIsRefund(0);
		order.setOrderIsvalid(1);
		order.setOrderSettleStatus(0);
		float boxPrice = 0;
		int box_type = 0;
		String userheat = "";
//		第一次订单
//		更新user表中的用户的userHeatID,userApptite
		try{
			if(orderIsFirst == 1){
				//失败的话可以忍受
				this.userdao.updateUserHeatAndAppe(userID, userHeatID, userAppetite);
				userheat = this.userdao.getUserHeatByID(userHeatID);
			}
			List<Object> temp = this.boxdao.getBoxPriceAndTypeByBoxID(order.getBoxId());
			if(temp.size() == 2){
				boxPrice = (float)temp.get(0);
				box_type = (int)temp.get(1);
				//设置盒子模式价格
				order.setBoxPrice(boxPrice);
				//增加订单
				// 获取订单id
				int orderID = this.orderdao.insertOrder(order);
				if(orderID > 0){
					TSOrder sonOrder = new TSOrder();
					sonOrder.setFOrderId(orderID);
					sonOrder.setFOrderNum(order.getOrderNum());
					sonOrder.setMenuId(order.getOrderMenuinfoId());
					sonOrder.setSOrderConsumeStatus(0);
					sonOrder.setSOrderConsumeEvaluate("");
					sonOrder.setSOrderLogisticsEvaluate("");
					sonOrder.setSOrderIsdispatchingStateOpen(1);
					sonOrder.setSOrderIsRefund(0);
					sonOrder.setSOrderNotice("注意：不吃："+userheat+" "+"饭量："+Tools.getUserAppetite(userAppetite));
					sonOrder.setSOrderDispatchingId(order.getOrderDispatchingId());
					
					//循环增加子订单
					List<String> dates = Tools.getDatesNotWeekend(box_type);
					for(int i = 1;i <= box_type;i++){
						//动态设置whichday
						sonOrder.setSOrderWhichday(i);
						sonOrder.setSOrderDispatchingDate((new SimpleDateFormat("yyyy-MM-dd")).parse(dates.get(i-1)));
						if(this.orderdao.insertSonOrder(sonOrder) <= 0){
							this.roll();
							return -1;
						}
					}
					this.close();
					return orderID;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
		}
		this.roll();
		return -1;
	}
}
