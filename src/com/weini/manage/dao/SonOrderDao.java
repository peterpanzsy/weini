package com.weini.manage.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TSOrder;
import com.weini.manage.entity.TVendor;
import com.weini.manage.entity.TProvince;

public class SonOrderDao{
	protected  Session session ;
	
	public SonOrderDao(Session sess) {
		this.session = sess;
	}
	/**
	 * 根据父订单id获取子订单
	 * @param orderID 父订单id
	 * @return 子订单的列表
	 */
	public List<Object[]> getSOrderByOrderID(String orderID){
		List<Object[]> res = new ArrayList<Object[]>();
		Query q = session.createSQLQuery("select S_order_id,menu_id,S_order_whichday,S_order_consumeStatus,"
				+ "S_order_consumeEvaluate,S_order_dispatchingStartT,S_order_logisticsEvaluate,S_order_predictTime,"
				+ "S_order_isdispatchingStateOpen,S_order_isRefund,S_order_notice from t_s_order where F_order_num = ?;");
		List<Object> l = q.list();
		q.setString(0,orderID);
		if(l.size() > 0){
			for(int i = 0; i< l.size();i++){
				Object[] row = (Object[])(l.get(i));
				res.add(row);
			}
		}
		return res;
	}
	/**
	 * 插入子订单
	 * @param sonOrder 子订单
	 * @return 返回执行结果
	 */
	public int insertSonOrder(TSOrder sonOrder){
		Query q = session.createSQLQuery("insert into t_s_order(F_order_num,menu_id,S_order_whichday,"
				+ "S_order_status,S_order_consumeEvaluate,S_order_dispatchingDate,"
				+ "S_order_logisticsEvaluate,S_order_predictTime,S_order_isdispatchingStateOpen,"
				+ "S_order_notice,S_order_dispatchingID)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?);");
		q.setString(0,sonOrder.getFOrderNum());
		q.setInteger(1, sonOrder.getMenuId());
		q.setInteger(2,sonOrder.getSOrderWhichday());
		q.setInteger(3,sonOrder.getSOrderStatus());
		q.setString(4, sonOrder.getSOrderConsumeEvaluate());
		q.setTimestamp(5,sonOrder.getSOrderDispatchingDate());
		q.setString(6,sonOrder.getSOrderLogisticsEvaluate());
		q.setTimestamp(7,sonOrder.getSOrderPredictTime());
		q.setInteger(8,sonOrder.getSOrderIsdispatchingStateOpen());
		q.setString(10,sonOrder.getSOrderNotice());
		q.setInteger(11,sonOrder.getSOrderDispatchingId());
		return q.executeUpdate();
	}
	/**
	 * 更新子订单的状态
	 * @param sonorderID 子订单id
	 * @param status 订单状态
	 * @return
	 */
	public int updateSonOrderStatus(int sonorderID,int status){
		Query q = session.createSQLQuery("update t_s_order set S_order_status = ? where S_order_id = ?");
		q.setInteger(0,status);
		q.setInteger(1,sonorderID);
		return q.executeUpdate();
	}
	/**
	 * 取消子订单
	 * 将未发货的子订单状态设置为0
	 * @param fOrderNum 父订单编号
	 * @return
	 */
	public int updateSonNotConsumeOrderStatus(String fOrderNum){
		Query q = session.createSQLQuery("update t_s_order set S_order_status = 0 where S_order_status = 1 and F_order_num = ?");
		q.setString(0, fOrderNum);
		return q.executeUpdate();
	}
	/**
	 * 根据子订单的id获取该订单的分派状态是否开启
	 * @param sonOrderID
	 * @return
	 */
	public int getOrderDisStatusIsOpenBySonOrderID(int sonOrderID){
		int res = -1;
		Query q = session.createSQLQuery("SELECT S_order_isdispatchingStateOpen from t_s_order where S_order_id = ? ;");
		q.setInteger(0, sonOrderID);
		List l = q.list();
		if(l != null && l.size() > 0){
			res = (int)(l.get(0));
		}
		return res;
	}
}
