package com.weini.manage.dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TOrder;
import com.weini.manage.entity.TSOrder;
import com.weini.tools.ThreeEntity;
import com.weini.tools.TwoEntity;;
public class OrderDao{

	protected Session session;
	public OrderDao(Session sess) {
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
	//=======================wang==========================
	/**
	 * 插入订单
	 * @param order
	 * @return 如果成功，返回订单id；否则返回-1；
	 */
	public int insertOrder(TOrder order){
		int res = -1;
		Query q = session.createSQLQuery("insert into t_order(order_num,user_id,order_menuinfo_id,box_id,"
			+ "order_startTime,order_orderTime,order_payStatus,S_order_consumeStatus,order_isRefund,"
			+ "order_payTime,box_price,order_isFirst,order_isvalid,order_dispatching_id,order_settleStatus)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		q.setString(0,order.getOrderNum());
		q.setInteger(1, order.getUserId());
		q.setInteger(2,order.getOrderMenuinfoId());
		q.setInteger(3,order.getBoxId());
		q.setTimestamp(4, order.getOrderStartTime());
		q.setTimestamp(5,order.getOrderOrderTime());
		q.setInteger(6,order.getOrderPayStatus());
		q.setInteger(7,order.getSOrderConsumeStatus());
		q.setInteger(8,order.getOrderIsRefund());
		q.setTimestamp(9,order.getOrderPayTime());
		q.setFloat(10,order.getBoxPrice());
		q.setInteger(11,order.getOrderIsFirst());
		q.setInteger(12,order.getOrderIsvalid());
		q.setInteger(13,order.getOrderDispatchingId());
		q.setInteger(14,order.getOrderSettleStatus());
		if(q.executeUpdate() > 0){
			Query q1 = session.createSQLQuery("SELECT last_insert_id() from t_order;");
			List l = q1.list();
			if(l.size() > 0){
				res = ((BigInteger)(l.get(0))).intValue();
			}
		}
		return res;
	}
	/**
	 * 插入子订单
	 * @param sonOrder 子订单
	 * @return
	 */
	public int insertSonOrder(TSOrder sonOrder){
		Query q = session.createSQLQuery("insert into t_s_order(F_order_id,menu_id,S_order_whichday,"
				+ "S_order_consumeStatus,S_order_consumeEvaluate,S_order_dispatchingDate,"
				+ "S_order_logisticsEvaluate,S_order_predictTime,S_order_isdispatchingStateOpen,"
				+ "S_order_isRefund,S_order_notice,F_order_num,S_order_dispatchingID)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
		q.setInteger(0,sonOrder.getFOrderId());
		q.setInteger(1, sonOrder.getMenuId());
		q.setInteger(2,sonOrder.getSOrderWhichday());
		q.setInteger(3,sonOrder.getSOrderConsumeStatus());
		q.setString(4, sonOrder.getSOrderConsumeEvaluate());
		q.setTimestamp(5,sonOrder.getSOrderDispatchingDate());
		q.setString(6,sonOrder.getSOrderLogisticsEvaluate());
		q.setTimestamp(7,sonOrder.getSOrderPredictTime());
		q.setInteger(8,sonOrder.getSOrderIsdispatchingStateOpen());
		q.setInteger(9,sonOrder.getSOrderIsRefund());
		q.setString(10,sonOrder.getSOrderNotice());
		q.setString(11,sonOrder.getFOrderNum());
		q.setInteger(12,sonOrder.getSOrderDispatchingId());
		return q.executeUpdate();
	}
	public List<Object[]> searchMonth(Integer userId, int year, int month) {
		Query q;
		String sql = ("SELECT order_id,order_num,order_menuinfo_id,DATE_FORMAT(order_orderTime,'%Y-%m-%d') as date,"
				+ "menuinfo_western,t.menutype_desc from t_order,t_menuinfo as m,t_menutype as t where order_isvalid = 1 and "
				+ "user_id = ? and order_menuinfo_id = m.menuinfo_id and m.menuinfo_type = t.menutype_id and YEAR(order_orderTime) = ? "
				+ "and MONTH(order_orderTime)=? ORDER BY order_orderTime;");
		q = session.createSQLQuery(sql);
		q.setInteger(0, userId);
		q.setInteger(1,year);
		q.setInteger(2, month);
		List l = q.list();
		List<Object[]> res = new ArrayList<Object[]>();
		for (int i = 0; i < l.size(); i++) {
			Object[] row = (Object[]) l.get(i);
			res.add(row);
		}
		return res;
	}
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
			Object[] row = (Object[])l.get(i);
			TwoEntity temp = new TwoEntity(row[0],((BigInteger)row[1]).intValue());
			res.add(temp);
		}
		return res;
	}
	/**
	 * 获取用户第二次购买购买盒子模式的分布
	 * @return 模式分布的统计数
	 */
	public List<TwoEntity> getUserSumSecondOrder(){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q = session.createSQLQuery("select box_type,count(order_id) from t_order as o, t_box as b where user_id in(select user_id from t_order where order_isvalid = 1 group by user_id having count(order_id) > 1) and order_isFirst = 0 and b.box_id = o.box_id GROUP BY b.box_type;");
		List l = q.list();
		for(int i = 0; i < l.size();i++){
			Object[] row = (Object[]) l.get(i);
			res.add(new TwoEntity(row[0],((BigInteger)row[1]).intValue()));
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
	public List<TwoEntity> getOrderModelSumByDispatch(int bussID){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q = session.createSQLQuery("select box_type,count(order_id) from t_order as o,t_box as b,"
				+ "t_dispatching as d where o.order_isvalid = 1 and d.dispatching_businessAreaid = ? and "
				+ "o.order_dispatching_id = d.dispatching_id and o.box_id = b.box_id group by box_type");
		q.setInteger(0,bussID);
		List l = q.list();
		for(int i = 0; i < l.size(); i++){
			Object[] row = (Object[])l.get(i);
			TwoEntity temp = new TwoEntity(row[0],((BigInteger)row[1]).intValue());
			res.add(temp);
		}
		return res;
	}
	/**
	 * 获取所有的用户第一次下的订单
	 * 要求： order_isvalid = 1 and order_isFirst = 1
	 * @return order_id user_name businessArea_name
	 */
	public List<ThreeEntity> getAllFirstOrder(){
		List<ThreeEntity> res = new ArrayList<ThreeEntity>();
		Query q = session.createSQLQuery("select order_id,user_name,businessArea_name from t_order as o,"
				+ "t_user as u,t_dispatching as d,t_businessarea as b where o.user_id = u.user_id AND "
				+ "o.order_dispatching_id = d.dispatching_id and d.dispatching_businessAreaid = "
				+ "b.businessArea_id and order_isFirst = 1 and o.order_isvalid = 1 GROUP BY o.box_id;");
		List l = q.list();
		for(int i = 0; i < l.size(); i++){
			Object[] row = (Object[])l.get(i);
			ThreeEntity temp = new ThreeEntity((int)row[0],(String)row[1],(String)row[2]);
			res.add(temp);
		}
		return res;
	}
	
	/**
	 * 获取index表中的订单日期和订单号
	 * @return list 0:date;1:num
	 */
	public List<String> getOrderNum(){
		List<String> res = new ArrayList<String>();;
		Query q = session.createSQLQuery("select index_value from t_index where index_name = 'order_date';");
		Query q1 = session.createSQLQuery("select index_value from t_index where index_name = 'order_num';");
		List l = q.list();
		List l1 = q1.list();
		if(l.size() > 0 && l1.size() > 0){
			res.add((String)l.get(0));
			res.add((String)l1.get(0));
		}
		return res;
	}
	/**
	 * 更新订单编号记录中num
	 * @param value 值
	 * @return
	 */
	public int updateOrderNum(String value){
		Query q = session.createSQLQuery("update t_index set index_value = ? where index_name = ?");
		q.setString(0, value);
		q.setString(1,"order_num");
		return q.executeUpdate();
	}
	/**
	 * 更新订单编号记录中的全部值
	 * @param date 形如"20150102"
	 * @param num 订单数
	 * @return
	 */
	public int updateOrderIndexAll(String date,String num){
		Query q = session.createSQLQuery("update t_index set index_value = ? where index_name = 'order_date'");
		q.setString(0,date);
		Query q1 = session.createSQLQuery("update t_index set index_value = ? where index_name = 'order_num'");
		q1.setString(0,num);
		return q.executeUpdate() * q1.executeUpdate() ;
	}
}
