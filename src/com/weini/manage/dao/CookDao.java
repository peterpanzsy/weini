package com.weini.manage.dao;

import java.util.List;

import org.hibernate.Session;

import com.weini.manage.entity.TCookinfo;
import com.weini.manage.entity.TVendor;

public class CookDao {
	protected  Session session ;
	
	public CookDao(Session sess) {
		this.session = sess;
	}
	/**
	 *  添加或更新cook 之前不存在，添加；之前存在更新
	 * @param cook
	 * @return
	 */
	public boolean updateCook(TCookinfo cook){
		try {
			session.saveOrUpdate(cook);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 删除cook
	 * @param cook
	 * @return
	 */
	public boolean delCook(TCookinfo cook){
		try {
			session.delete(cook);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据商家Id来查找对应的Cook
	 * @param vendorId
	 * @return  存在返回List，否则返回null
	 */
	public List<TCookinfo> findCookByVendor(Integer vendorId){
		return  session.createQuery("from TCookinfo t where t.cookinfoVendorid = ?")
				.setInteger(0, vendorId).list();
	}
	/**
	 * 根据商家查找对应的Cook
	 * @param vendor
	 * @return  存在返回List，否则返回null
	 */
	public List<TCookinfo> findCookByVendor(TVendor vendor){
		if(vendor.getVendorId()==null)
			return null;
		return  findCookByVendor(vendor.getVendorId());
	}
	/**
	 * 所有的厨师列表
	 * @return
	 */
	public List<TCookinfo> findAllCook(){
		return  session.createQuery("from TCookinfo ").list();
	}
	
}
