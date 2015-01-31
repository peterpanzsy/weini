package com.weini.manage.dao;

import java.sql.Timestamp;

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
	public boolean addSorderDispatching(Integer sorderId,Integer disId,Timestamp status_time){
		SQLQuery q = session.createSQLQuery("INSERT INTO t_sorder_dispatching(s_order_id,dispatchingstatus_id,status_time) "
				+ "VALUES (?,?,?) ");
		q.setInteger(0,sorderId);
		q.setInteger(1,disId);
		q.setTimestamp(2, status_time);
		try {
			if(q.executeUpdate()>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
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
	/**
	 * 根据子订单号查找TSorderDispatching
	 * @param sorderId
	 * @return
	 */
	public TSorderDispatching findSorderDispatchingBySOrderId(Integer sorderId){
		return (TSorderDispatching) session.createQuery("from TSorderDispatching t where t.SOrderId=?").setInteger(0,sorderId).uniqueResult();
	}
}
