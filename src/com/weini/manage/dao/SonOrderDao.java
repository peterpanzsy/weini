package com.weini.manage.dao;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TOrder;
import com.weini.manage.entity.TSOrder;
import com.weini.manage.entity.TVendor;
import com.weini.manage.entity.TProvince;

public class SonOrderDao{
	protected  Session session ;
	
	public SonOrderDao(Session sess) {
		this.session = sess;
	}
	//TODO 等待修改返回值
	/**
	 * 根据父订单id获取子订单
	 * @param orderID 父订单id
	 * @return 子订单的列表
	 */
//	String sql = ("select S_order_id,F_order_num,menu_id,S_order_whichday,S_order_consumeEvaluate,"
//			+ "S_order_dispatchingDate,S_order_logisticsEvaluate,S_order_predictTime,S_order_isdispatchingStateOpen,"
//			+ "S_order_notice,S_order_dispatchingID,S_order_status,user_id from t_s_order where user_id = ? "
//			+ "AND YEAR(S_order_dispatchingDate) = ? AND MONTH(S_order_dispatchingDate) = ?;");
//	public List<Object[]> getSOrderByOrderID(String orderID){
//		List<Object[]> res = new ArrayList<Object[]>();
//		Query q = session.createSQLQuery("select S_order_id,menu_id,S_order_whichday,S_order_consumeStatus,"
//				+ "S_order_consumeEvaluate,S_order_dispatchingStartT,S_order_logisticsEvaluate,S_order_predictTime,"
//				+ "S_order_isdispatchingStateOpen,S_order_isRefund,S_order_notice from t_s_order where F_order_num = ?;");
//		List<Object> l = q.list();
//		q.setString(0,orderID);
//		if(l.size() > 0){
//			for(int i = 0; i< l.size();i++){
//				Object[] row = (Object[])(l.get(i));
//				res.add(row);
//			}
//		}
//		return res;
//	}
	/**
	 * 插入子订单
	 * @param sonOrder 子订单
	 * @return 返回执行结果
	 */
	public int insertSonOrder(TSOrder sonOrder){
		Query q = session.createSQLQuery("insert into t_s_order(F_order_num,menu_id,S_order_whichday,"
				+ "S_order_status,S_order_consumeEvaluate,S_order_dispatchingDate,"
				+ "S_order_logisticsEvaluate,S_order_predictTime,S_order_isdispatchingStateOpen,"
				+ "S_order_notice,S_order_dispatchingID,user_id)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
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
		q.setInteger(12, sonOrder.getUserId());
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
	/**
	 * 根据用户id获取用户一个月的消费记录
	 * 订单要求 所有订单
	 * @param userId 用户id
	 * @param year 年
	 * @param month 月
	 * @return 子订单的id，订单的日期
	 * @throws ParseException 日期转换错误
	 */
	public List<TSOrder> searchMonthSonOrder(Integer userId, int year, int month) throws ParseException {
		List<TSOrder> res = new ArrayList<TSOrder>();
		Query q;
		String sql = ("select S_order_id,S_order_dispatchingDate,mtype.menutype_desc from t_s_order as so,"
				+ "t_menutype as mtype,t_menuinfo as minfo where minfo.menuinfo_id = so.menu_id and "
				+ "minfo.menuinfo_type = mtype.menutype_id and user_id = ? "
				+ "AND YEAR(S_order_dispatchingDate) = ? AND MONTH(S_order_dispatchingDate) = ?;");
		q = session.createSQLQuery(sql);
		q.setInteger(0, userId);
		q.setInteger(1,year);
		q.setInteger(2, month);
		List l = q.list();
		if(l != null){
			for (int i = 0; i < l.size(); i++) {
				Object[] row = (Object[]) l.get(i);
				TSOrder sorder = new TSOrder();
				sorder.setSOrderId((int)row[0]);
				sorder.setSOrderDispatchingDate((Date)row[1]);
				sorder.setMenuTypeDesc((String)row[2]);
				res.add(sorder);
			}
		}
		return res;
	}
}
