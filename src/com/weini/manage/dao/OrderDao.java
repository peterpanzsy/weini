package com.weini.manage.dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	/**
	 *  获取用户的订单一定条数的订单记录
	 *  获取字段：订单编号，盒子模式id，订单时间，订单支付时间,订单状态
	 * @param userID 用户id
	 * @param pageStart 页面开始记录数
	 * @param pageLimit 一页的限制条数
	 * @return
	 */
	public List<TOrder> getUserOrderLimit(int userID,int pageStart,int pageLimit) {
		List<TOrder> res = new ArrayList<TOrder>();
		Query q = session.createSQLQuery("select order_num,box_type,order_orderTime,order_status"
				+ " from t_order as o,t_box as b where o.box_id = b.box_id and user_id = ? ORDER BY order_orderTime DESC limit ?,?; ");
		q.setInteger(0, userID);
		q.setInteger(1,pageStart);
		q.setInteger(2,pageLimit);
		List l = q.list();
		if(l != null && l.size() > 0){
			for (int i = 0; i < l.size(); i++) {
				TOrder temp = new TOrder();
				Object[] row = (Object[]) l.get(i);
				temp.setOrderNum((String)row[0]);
				temp.setOrderBoxType((int)row[1]);
				temp.setOrderOrderTime(((Timestamp)row[2]));
				temp.setOrderStatus((int)row[3]);
				res.add(temp);
			}
		}
		return res;
	}
	/**
	 * 插入订单
	 * @param order
	 * @return 
	 */
	public int insertOrder(TOrder order){
		Query q = session.createSQLQuery("insert into t_order(order_num,user_id,order_menuinfo_id,box_id,"
			+ "order_startTime,order_orderTime,order_payStatus,S_order_consumeStatus,"
			+ "order_payTime,box_price,order_isFirst,order_dispatching_id,order_settleStatus,order_status,order_notice)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		q.setString(0,order.getOrderNum());
		q.setInteger(1, order.getUserId());
		q.setInteger(2,order.getOrderMenuinfoId());
		q.setInteger(3,order.getBoxId());
		q.setTimestamp(4, order.getOrderStartTime());
		q.setTimestamp(5,order.getOrderOrderTime());
		q.setInteger(6,order.getOrderPayStatus());
		q.setInteger(7,order.getSOrderConsumeStatus());
		q.setTimestamp(8,order.getOrderPayTime());
		q.setFloat(9,order.getBoxPrice());
		q.setInteger(10,order.getOrderIsFirst());
		q.setInteger(11,order.getOrderDispatchingId());
		q.setInteger(12,order.getOrderSettleStatus());
		q.setInteger(13,order.getOrderStatus());
		q.setString(14, order.getOrderNotice());
		return q.executeUpdate();
	}
	/**
	 * 根据订单的编号查找订单的支付状态
	 * @param orderNum 订单编号
	 * @return 订单的支付状态
	 */
	public int getOrderPayStatusByOrderNum(String orderNum){
		int res = -1;
		Query q = session.createSQLQuery("select order_payStatus from t_order where order_num = ?;");
		q.setString(0,orderNum);
		List l = q.list();
		if(l != null && l.size() == 1){
			res = (int)l.get(0);
		}
		return res;
	}
	/**
	 * 根据用户id获取用户一个月的消费记录
	 * 订单要求 所有订单都是可以的
	 * @param userId 用户id
	 * @param year 年
	 * @param month 月
	 * @return
	 * @throws ParseException 日期转换错误
	 */
	public List<TOrder> searchMonthOrder(Integer userId, int year, int month) throws ParseException {
		List<TOrder> res = new ArrayList<TOrder>();
		Query q;
		String sql = ("SELECT order_num,order_menuinfo_id,order_orderTime,"
				+ "menuinfo_western,t.menutype_desc from t_order,t_menuinfo as m,t_menutype as t where "
				+ "user_id = ? and order_menuinfo_id = m.menuinfo_id and m.menuinfo_type = t.menutype_id and YEAR(order_orderTime) = ? "
				+ "and MONTH(order_orderTime)=? ORDER BY order_orderTime;");
		q = session.createSQLQuery(sql);
		q.setInteger(0, userId);
		q.setInteger(1,year);
		q.setInteger(2, month);
		List l = q.list();
		if(l != null){
			for (int i = 0; i < l.size(); i++) {
				Object[] row = (Object[]) l.get(i);
				TOrder order = new TOrder();
				order.setOrderNum((String)row[0]);
				order.setOrderMenuinfoId((int)row[1]);
				order.setOrderOrderTime((Timestamp)row[2]);
				order.setOrderMenuWestern((int)row[3]);
				order.setOrderMenuTypeDesc((String)row[4]);
				res.add(order);
			}
		}
		return res;
	}
	/**
	 * 获取用户下订单耗时时间分布的统计
	 * 订单要求：所有订单都是可以的
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
				int time = ((Double)(l.get(i))).intValue();
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
	 * 订单要求 order_status > 0
	 * 只要下过订单且已付款都算，不管是否退款
	 * @return
	 */
	public int getRealBuyUserSum(){
		int res = 0;
		Query q = session.createSQLQuery("select count(distinct user_id) from t_order as t where t.order_payStatus = 1 and order_status > 0;");
		List l = q.list();
		if(l.size() > 0){
			res = ((BigInteger)(l.get(0))).intValue();
		}
		return res;
	}
	/**
	 * 获取订单的总金额，包括订单交易过程中没有发生退款和订单交易成功了一部分
	 * 订单要求：
	 * 		order_status > 1
	 * 		
	 * @return
	 */
	public double getOrderTotalMoney(){
		double res = 0;
		Query q = session.createSQLQuery("select SUM(o.box_price / box_type * S_order_consumeStatus) from t_order as o,t_box as b where o.order_status > 1 and o.box_id = b.box_id;");
		List l = q.list();
		if(l!= null && l.size() > 0 ){
			res = (double)l.get(0);
		}
		return res;
	}
	/**
	 * 获取给定时间段内的有效订单的总量，可以设置isAll选择统计全部订单还是至少有一部分成功交易的订单
	 * 注意：如果某一天内没有订单，则返回的list中就没有这个记录
	 * @param start 起始时间
	 * @param end 终止时间
	 * @param isAll 是否为全部订单，true表示是，false表示否
	 * 订单要求：
	 * 		交易成功
	 * 		order_status > 1
	 * @return
	 */
	public List<TwoEntity> getOrderSumByDate(String start, String end, boolean isAll){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q ;
		if(isAll){
			q = session.createSQLQuery("select DATE_FORMAT(order_orderTime,'%Y-%m-%d'),count(order_num) from t_order where order_orderTime between ? and ? group by DAY(order_orderTime) order by order_orderTime DESC;");
		}else{
			q = session.createSQLQuery("select DATE_FORMAT(order_orderTime,'%Y-%m-%d'),count(order_num) from t_order where t.order_status > 1 and order_orderTime between ? and ? group by DAY(order_orderTime) order by order_orderTime DESC;");
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
	 * 获取的订单都是消费成功的订单（就是指不包含退订的订单）且都是完成交易的订单
	 *  order_status > 4
	 * @return 返回模式和订单数的对应列表
	 */
	public List<TwoEntity> getOrderFirstModelSum(){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q = session.createSQLQuery("select box_type,count(order_num) from t_order as o,t_box as b where o.order_isFirst = 1 and o.order_status > 4 and o.box_id = b.box_id group by box_type;");
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
	 * order_status > -1
	 */
	public List<TwoEntity> getUserSumSecondOrder(){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q = session.createSQLQuery("select box_type,count(order_num) from t_order as o, t_box as b where user_id in(select user_id from t_order where order_status > -1 group by user_id having count(order_num) > 1) and order_isFirst = 0 and b.box_id = o.box_id GROUP BY b.box_type;");
		List l = q.list();
		for(int i = 0; i < l.size();i++){
			Object[] row = (Object[]) l.get(i);
			res.add(new TwoEntity(row[0],((BigInteger)row[1]).intValue()));
		}
		return res;
	}
	/**
	 * 根据省，市，商圈来统计订单数
	 * 只要是有效订单都算 order_status > -1
	 * @param provinceID 省ID
	 * @param cityID 城市ID
	 * @param bussID 商圈ID
	 * @return 返回模式和订单数的对应列表
	 */
	public List<TwoEntity> getOrderModelSumByDispatch(int bussID){
		List<TwoEntity> res = new ArrayList<TwoEntity>();
		Query q = session.createSQLQuery("select box_type,count(order_num) from t_order as o,t_box as b,"
				+ "t_dispatching as d where o.order_status > -1 and d.dispatching_businessAreaid = ? and "
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
	 * 要求： order_status > -1
	 * @return order_num user_name businessArea_name
	 */
	public List<ThreeEntity> getAllFirstOrder(){
		List<ThreeEntity> res = new ArrayList<ThreeEntity>();
		Query q = session.createSQLQuery("select order_num,user_name,businessArea_name from t_order as o,"
				+ "t_user as u,t_dispatching as d,t_businessarea as b where o.user_id = u.user_id AND "
				+ "o.order_dispatching_id = d.dispatching_id and d.dispatching_businessAreaid = "
				+ "b.businessArea_id and order_isFirst = 1 and o.order_status > -1 GROUP BY o.box_id;");
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
	/**
	 * 根据订单id获取订单的详细情况(不包含结算状态)
	 * @param orderNum
	 * @return
	 */
	public TOrder getOrderDetailByOrderNum(String orderNum){
		TOrder res = null;
		Query q = session.createSQLQuery("select order_num,user_id,order_menuinfo_id,box_type,order_orderTime,order_payStatus,"
				+ "S_order_consumeStatus,order_payTime,o.box_price,order_isFirst,order_dispatching_id,order_status,box_typename,order_notice "
				+ "from t_order as o, t_box as b where o.box_id = b.box_id and order_num = ?;");
		q.setString(0, orderNum);
		List l = q.list();
		if(l != null && l.size() == 1){
			res = new TOrder();
			Object[] row = (Object[])l.get(0);
			res.setOrderNum((String)row[0]);
			res.setUserId((int)row[1]);
			res.setOrderMenuinfoId((int)row[2]);
			res.setOrderBoxType((int)row[3]);
			res.setOrderOrderTime(((Timestamp)row[4]));
			res.setOrderPayStatus((int)row[5]);
			res.setSOrderConsumeStatus((int)row[6]);
			res.setOrderPayTime(((Timestamp)row[7]));
			res.setBoxPrice((float)row[8]);
			res.setOrderIsFirst((int)row[9]);
			res.setOrderDispatchingId((int)row[10]);
			res.setOrderStatus((int)row[11]);
			res.setOrderBoxTypeName((String)row[12]);
			res.setOrderNotice((String)row[13]);
		}
		return res;
	}
	/**
	 * 更改订单的状态
	 * @param orderNum 订单编号
	 * @return 执行结果
	 */
	public int updateOrderStatus(String orderNum,int status){
		Query q = session.createSQLQuery("update t_order set order_status = ? where order_num = ?");
		q.setInteger(0,status);
		q.setString(1,orderNum);
		return q.executeUpdate();
	}
	/**TODO 等待修改
	 * 根据日期来查找用户的订单
	 * @param userID 用户订单
	 * @param start 开始日期
	 * @param end 结束日期
	 * @param pageStart 页面开始记录
	 * @param pageLimit 页面记录
	 * @return
	 */
	public List<Object[]> getUserOrderByDate(int userID,String start,String end,int pageStart,int pageLimit){
		Query q = session.createSQLQuery("select order_num,order_menuinfo_id,order_orderTime,order_status from t_order where order_orderTime BETWEEN ? and ? "
				+ "and user_id = ? ORDER BY order_orderTime limit ?,?;");
		q.setString(0, start);
		q.setString(1,end);
		q.setInteger(2,userID);
		q.setInteger(3,pageStart);
		q.setInteger(4,pageLimit);
		List<Object[]> res = new ArrayList<Object[]>();
		List l = q.list();
		if(l != null && l.size() > 0){
			for(int i = 0;i < l.size();i++){
				List<Object> temp = new ArrayList<Object>();
				Object[] rows = (Object[])l.get(i);
				temp.add((String)rows[0]);
				temp.add((int)rows[1]);
				if(rows[2] == null){
					temp.add(null);
				}else{
					temp.add(((Timestamp)rows[2]).toString());
				}
				temp.add((int)rows[3]);
				res.add(temp.toArray());
			}
		}
		return res;
	}
}
