package com.weini.manage.dao;

import org.hibernate.Session;

import com.weini.manage.entity.TAlipay;
import com.weini.manage.entity.TBank;

public class BankDao {
	 
	 protected Session session ;
	 public BankDao(Session sess){
		 this.session = sess;
	 }
	 /**
	  * 更新或保存
	  * @param bank
	  * @return
	  */
	 public boolean updateBank(TBank bank){
			try {
				session.saveOrUpdate(bank);
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
	public boolean delBank(TBank bank){
		try {
			session.delete(bank);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据用户id查找特定Id的银行账号
	 * @param userId
	 * @return
	 */
	public TBank findBankByUser(Integer userId){
		return (TBank) session.createQuery("from TBank t where t.bankUserid = ?").setInteger(0, userId).uniqueResult();
	}
}
