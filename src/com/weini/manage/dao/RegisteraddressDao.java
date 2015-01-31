package com.weini.manage.dao;

import org.hibernate.Session;

import com.weini.manage.entity.TRegisteraddress;

public class RegisteraddressDao {
	
	protected Session session;
	
	public RegisteraddressDao(Session sess){
		this.session = sess;
	} 
	/**
	 * 根据用户id来查找用户的注册地址
	 * @param userId
	 * @return 如果存在返回TRegisteraddress，否则返回null
	 */
	public TRegisteraddress findByUserId(Integer userId){
		return (TRegisteraddress) session.createQuery("from TRegisteraddress t where t.userId = ? ").setInteger(0,userId).uniqueResult();
	}
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	public boolean addRegisteraddress(TRegisteraddress address){
		if(address.getUserId()==null||address.getRegisterAddressBusinessAreaid()==null){
			return false;
		}else{
			session.save(address);
			return true;
		}
	}
	/**
	 * 更新
	 * @param address
	 * @return
	 */
	public boolean updateRegisteraddress(TRegisteraddress address){
		if(address.getRegisterAddressId()==null||address.getUserId()==null||address.getRegisterAddressBusinessAreaid()==null){
			return false;
		}else{
			session.update(address);
			return true;
		}
	}
	
	/**
	 * 删除
	 * @param address
	 * @return
	 */
	public boolean delRegisteraddress(TRegisteraddress address){
		if(address.getRegisterAddressId()==null||address.getUserId()==null||address.getRegisterAddressBusinessAreaid()==null){
			return false;
		}else{
			session.delete(address);
			return true;
		}
	}
}
