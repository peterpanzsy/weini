package com.weini.manage.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import com.weini.manage.entity.TOrderrefund;

public class OrderRefundDao {
	
	protected  Session session ;
	
	public OrderRefundDao(Session sess) {
		this.session = sess;
	}
	/**
	 * 插入一条退款记录
	 * @param refund 退款数据类
	 * @return 
	 */
	public int insertOrderRefund(TOrderrefund refund){
		Query q = session.createSQLQuery("insert into t_orderrefund(order_num,"
				+ "orderrefund_reason,orderrefund_status,orderrefund_result) VALUES(?,?,?,?)");
		q.setString(0, refund.getOrderNum());
		q.setInteger(1,refund.getOrderrefundReason());
		q.setInteger(2,refund.getOrderrefundStatus());
		q.setInteger(3,refund.getOrderrefundResult());
		return q.executeUpdate();
	}
}
