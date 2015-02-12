package com.weini.manage.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TSorderDispatching;

public class SorderDispatchingDao {
	
	protected Session session ;
	
	 public SorderDispatchingDao(Session sess){
		 this.session = sess;
	 }
	 /**
	  * @param sorderId  子订单Id
	  * @param disId     送货地址Id
	  * @param status_time   时间
	  * @return
	  */
//	public boolean addSorderDispatching(Integer sorderId,Integer disId,Timestamp status_time){
//		SQLQuery q = session.createSQLQuery("INSERT INTO t_sorder_dispatching(s_order_id,dispatchingstatus_id,status_time) "
//				+ "VALUES (?,?,?) ");
//		q.setInteger(0,sorderId);
//		q.setInteger(1,disId);
//		q.setTimestamp(2, status_time);
//		try {
//			if(q.executeUpdate()>0){
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	/**
	 * 保存或更新
	 * @param sd 要保存的TSorderDispatching对象
	 * @return
	 */
	public boolean updateSorderDispatching(TSorderDispatching sd){
		try {
			session.saveOrUpdate(sd);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//	/**
//	 * 根据子订单号查找TSorderDispatching
//	 * @param sorderId
//	 * @return
//	 */
//	public List<TSorderDispatching> findSorderDispatchingBySOrderId(Integer sorderId){
//		return (List<TSorderDispatching>) session.createQuery("from TSorderDispatching t where t.SOrderId=? order by ").setInteger(0,sorderId).list();
//	}
	/**
	 * 根据子订单号查找订单的配送状态
	 * @param sorderId
	 * @return
	 */
	public List<TSorderDispatching> findSorderDispatchingBySOrderId(Integer sorderId){
		Query q = session.createSQLQuery("select s.dispatchingStatus_imagename,s.dispatchingStatus_desctext,"
				+ "so.status_time from t_sorder_dispatching as so,t_dispatchingstatus as s where s_order_id = ? "
				+ "and so.dispatchingstatus_id = s.dispatchingStatus_id ORDER BY status_time ASC;");
		q.setInteger(0, sorderId);
		List l = q.list();
		List<TSorderDispatching> res = new ArrayList<TSorderDispatching>();
		if(l != null && l.size() > 0){
			for(int i = 0; i< l.size();i++){
				Object[] row = (Object[])l.get(i);
				TSorderDispatching temp = new TSorderDispatching();
				temp.setStatusImage((String)row[0]);
				temp.setStatusDesc((String)row[1]);
				temp.setStatusTime((Timestamp)row[2]);
				res.add(temp);
			}
		}
		return res;
	}
}
