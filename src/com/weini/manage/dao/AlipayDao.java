package com.weini.manage.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TAlipay;
import com.weini.manage.entity.TUser;

public class AlipayDao {
	
	protected Session session ;
	
	 public AlipayDao(Session sess){
		 this.session = sess;
	 }
	 
	 /**
	 * 保存或更新
	 * @param ali 要保存的TAlipay对象
	 * @return
	 */
	public boolean updateAlipay(TAlipay ali){
		try {
			session.saveOrUpdate(ali);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 删除一条记录
	 * @param ali
	 * @return
	 */
	public boolean delAlipay(TAlipay ali){
		try {
			session.delete(ali);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 删除和特定用户有关的记录
	 * @param userId
	 * @return
	 */
	public boolean delAlipayByUserId(Integer userId){
		try {
			SQLQuery q = session.createSQLQuery("DELETE FROM t_alipay WHERE alipay_userid =?");
			q.setInteger(0,userId);
			if(q.executeUpdate()!=0)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据用户id查找特定Id的支付宝账号
	 * @param userId
	 * @return
	 */
	public TAlipay findAlipayByUser(Integer userId){
		return (TAlipay) session.createQuery("from TAlipay t where t.alipayUserid = ?").setInteger(0, userId).uniqueResult();
	}
	/**
	 * 查找用户的支付宝
	 * @param user
	 * @return
	 */
	public TAlipay findAlipayByUser(TUser user){
		if(user.getUserId()!=null){
			return findAlipayByUser(user.getUserId());
		}else
			return null;
	}
}
