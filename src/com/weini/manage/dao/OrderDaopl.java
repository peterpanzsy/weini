package com.weini.manage.dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.tools.TwoEntity;;
public class OrderDaopl{

	protected Session session;
	public OrderDaopl(Session sess) {
		this.session = sess;
	}
//=======================wang==========================
	public List searchLimit7(int userId) {
		SQLQuery q;
		String sql = ("SELECT t3.menuinfo_id,t3.menuinfo_name,t2.S_order_dispatchingStartT "
				+ "FROM t_menuinfo t3 ,"
				+ "(SELECT S_order_id,menu_id,S_order_dispatchingStartT FROM t_s_order t "
				+ "WHERE t.F_order_id IN (SELECT order_id FROM t_order WHERE user_id = ? )"
				+ "AND t.S_order_consumeStatus = 1 ) t2 "
				+ "WHERE t3.menuinfo_id = t2.menu_id "
				+ "ORDER BY t2.S_order_dispatchingStartT DESC " + "LIMIT 0,6 ;");
		q = session.createSQLQuery(sql);
		q.setInteger(0, userId);
		List l = q.list();
		List re = new ArrayList();
		for (int i = 0; i < l.size(); i++) {
			Object[] row = (Object[]) l.get(i);
			re.add(row);
		}
		return re;
	}

	public List searchMonth(Integer userId, int year, int month) {
		SQLQuery q;
		String sql = ("SELECT t3.menuinfo_id,t3.menuinfo_name,t2.S_order_dispatchingStartT "
				+ "FROM t_menuinfo t3 ,"
				+ "(SELECT S_order_id,menu_id,S_order_dispatchingStartT FROM t_s_order t "
				+ "WHERE t.F_order_id IN (SELECT order_id FROM t_order WHERE user_id = ? ) "
				+ "AND t.S_order_consumeStatus = 1 ) t2 "
				+ "WHERE t3.menuinfo_id = t2.menu_id "
				+       "AND YEAR(t2.S_order_dispatchingStartT) = ? "
				+		"AND MONTH(t2.S_order_dispatchingStartT) = ? "
				+ "ORDER BY t2.S_order_dispatchingStartT DESC ;");
		q = session.createSQLQuery(sql);
		q.setInteger(0, userId);
		q.setInteger(1,year);
		q.setInteger(2, month);
		List l = q.list();
		List re = new ArrayList();
		for (int i = 0; i < l.size(); i++) {
			Object[] row = (Object[]) l.get(i);
			re.add(row);
		}
		return re;
	}
//=======================wang==========================
	/**
	 * 获取用户下订单耗时时间分布的统计
	 * 0:总数；1："0-10";2:"10-20";3"20-30";4:"30-60";5:">60"
	 * @param temp int[6] int[0]存储的是总数
	 * @return
	 */
	public boolean getUserOrderTimeSum(int[] temp){
		boolean flag = false;
		Query q = session.createSQLQuery("select (t.order_orderTime - t.order_startTime) as time from t_order as t");
		List l = q.list();
		temp[0] = l.size(); 
		if(temp[0] > 0){
			flag = true;
			for(int i = 0; i < l.size(); i++){
				int time = ((BigInteger)(l.get(i))).intValue();
				if(time < 10){
					temp[1] ++;
				}else if(time < 20){
					temp[2]++;
				}else if(time < 30){
					temp[3]++;
				}else if(time < 60){
					temp[4]++;
				}else{
					temp[5]++;
				}
			}
		}
		return flag;
	}
	/**
	 * 获取实际用户的总数
	 * 只要下过订单且已付款都算，不管是否退款
	 * @return
	 */
	public int getRealBuyUserSum(){
		int res = 0;
		Query q = session.createSQLQuery("select count(distinct user_id) from t_order as t where t.order_payStatus = 1;");
		List l = q.list();
		if(l.size() > 0){
			res = ((BigInteger)(l.get(0))).intValue();
		}
		return res;
	}
	/**
	 * 获取订单的总金额，包括订单交易过程中没有发生退款和订单交易成功了一部分
	 * @return
	 */
	public double getOrderTotalMoney(){
		double res = 0;
		Query q1 = session.createSQLQuery("select SUM(box_price) from t_order as t where t.S_order_consumeStatus = -1 and t.order_isRefund = 0 and order_isvalid = 1;");
		Query q2 = session.createSQLQuery("select SUM(o.box_price / box_type * S_order_consumeStatus) from t_order as o,t_box as b where o.order_isRefund = 1 and o.S_order_consumeStatus != 0 and o.box_id = b.box_id and order_isvalid = 1;");
		List l1 = q1.list();
		List l2 = q1.list();
		if(l1.size() > 0 && l2.size() > 0){
			res = (double)l1.get(0) + (double)l2.get(0);
		}
		return res;
	}
	/**
	 * 获取给定时间段内的订单的总量，可以设置isAll选择统计全部订单还是至少有一部分成功交易的订单
	 * 注意：如果某一天内没有订单，则返回的list中就没有这个记录
	 * @param start 起始时间
	 * @param end 终止时间
	 * @param isAll 是否为全部订单，true表示是，false表示否
	 * @return
	 */
	public List<TwoEntity> getOrderSumByDate(String start, String end, boolean isAll){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q ;
		if(isAll){
			q = session.createSQLQuery("select DATE_FORMAT(order_orderTime,'%Y-%m-%d'),count(order_id) from t_order where order_orderTime between ? and ? group by DAY(order_orderTime) order by order_orderTime DESC;");
		}else{
			q = session.createSQLQuery("select DATE_FORMAT(order_orderTime,'%Y-%m-%d'),count(order_id) from t_order where t.order_isvalid = 1 and order_orderTime between ? and ? group by DAY(order_orderTime) order by order_orderTime DESC;");
		}
		q.setString(0,start);
		q.setString(1,end);
		List l = q.list();
		for(int i = 0; i < l.size(); i++){
			TwoEntity temp = new TwoEntity();
			Object[] row = (Object[]) l.get(i);
			temp.setIndex1(row[0]);
			temp.setIndex2(row[1]);
			res.add(temp);
		}
		return res;
	}
	/**
	 * 获取第一次订单的不同盒子模式的订单数
	 * 获取的订单都是有效订单（就是指不包含退订的订单）且都是完成交易的订单
	 * @return 返回模式和订单数的对应列表
	 */
	public List<TwoEntity> getOrderFirstModelSum(){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q = session.createSQLQuery("select box_type,count(order_id) from t_order as o,t_box as b where o.order_isFirst = 1 and o.order_isvalid = 1 and o.order_isRefund = 0 and o.S_order_consumeStatus = -1 and o.box_id = b.box_id group by box_type;");
		List l = q.list();
		for(int i = 0; i < l.size(); i++){
			Object[] row = (Object[])l.get(0);
			TwoEntity temp = new TwoEntity(row[0],row[1]);
			res.add(temp);
		}
		return res;
	}
	/**
	 * 获取第二次购买盒子模式的用户
	 * @return
	 */
	public int getUserSumSecondOrder(){
		int res = 0;
		Query q = session.createSQLQuery("select count(distinct user_id) from t_order where user_id in(select user_id from t_order group by user_id having count(order_id) > 1);");
		List l = q.list();
		if(l.size() > 0){
			res = (int)l.get(0);
		}
		return res;
	}
	/**
	 * 根据省，市，商圈来统计订单数
	 * 只要是有效订单都算
	 * @param provinceID 省ID
	 * @param cityID 城市ID
	 * @param bussID 商圈ID
	 * @return 返回模式和订单数的对应列表
	 */
	public List<TwoEntity> getOrderModelSumByDispatch(int provinceID,int cityID,int bussID){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q = session.createSQLQuery("select box_type,count(order_id) from t_order as o,t_box as b,"
				+ "t_dispatching as d where o.order_isvalid = 1 and d.dispatching_province = @province "
				+ "and d.dispatching_city = @city and d.dispatching_businessAreaid = @buss and "
				+ "o.order_dispatching_id = d.dispatching_id and o.box_id = b.box_id group by box_type;");
		q.setParameter("province",provinceID);
		q.setParameter("city",cityID);
		q.setParameter("buss",bussID);
		List l = q.list();
		for(int i = 0; i < l.size(); i++){
			Object[] row = (Object[])l.get(0);
			TwoEntity temp = new TwoEntity(row[0],row[1]);
			res.add(temp);
		}
		return res;
	}
	/**
	 * 根据商家id以及月份获取上月已结算订单或者未结算订单
	 */
//	public List<TOrder> get
	
}
