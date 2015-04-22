package com.weini.manage.dao;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TVendor;
import com.weini.manage.entity.TVendorextra;
import com.weini.tools.HibernateSessionManager;


public class VendorDao  {
	Session session ;
	 
	public VendorDao(Session sess)
	{		
		session = sess;
	}
	/**
	 * 添加或更新t_vendor表
	 * @param vendor
	 * @return
	 */
	public void updateVendor(TVendor vendor){
		session.saveOrUpdate(vendor);
	}
    //--------------------------数据管理中的商家管理------------------
    /**
     * 数据管理-商家管理，列出所有商家
     * @return
     */
    public List<TVendor> listVendor(){
        return session.createSQLQuery("select * from t_vendor").addEntity(TVendor.class).list();
    }
    
    public void delVendor(TVendor vendor){
    	session.delete(vendor);
    } 
    
	/**
	 * 根据商家的id获取商家的名字信息
	 * @param id 商家id
	 * @return 商家名字
	 */
	public String findVendorNameByID(int id) {
		String name = "";
		Query q = session.createSQLQuery(" select t_vendor.vendor_name from t_vendor where vendor_id=?");
		q.setParameter(0, id);
		List l = q.list();
		if(l.size() > 0 ){
			name = (String) l.get(0);
		}
		return name;
	}

    /**
     * 根据商圈ID获取商家列表
     * @param busID
     * @return
     */
	public List<TVendor> listVendorsByBussID(int busID){
		List<TVendor> res = new ArrayList<TVendor>();
		Query q = session.createSQLQuery("select t_vendor.vendor_id,t_vendor.vendor_name from t_vendor where t_vendor.vendor_business_areaid = ?");
		q.setParameter(0,busID);
		List l = q.list();
		for(int i = 0;i < l.size();i++){
			Object[] row=(Object[])l.get(i);
			TVendor ven = new TVendor();
			ven.setVendorId((Integer)row[0]);
			ven.setVendorName((String)row[1]);
			res.add(ven);
		}
		return res;
	}
	/**
	 * 商家登录时，搜索商家是否存在
	 * @param username 用户名
	 * @param pass 用户密码
	 * @return 商家信息
	 */
	public TVendor searchVendor(String username,String pass){
		TVendor res = null;
		Query q = session.createSQLQuery("SELECT vendor_id,vendor_name,vendor_mail,vendor_phonenum,vendor_pwd,"
				+"vendor_isopen,vendor_totalmoney,vendor_paidmoney,vendor_remainedmoney,vendor_employernum,"
				+ "vendor_cooknum,vendor_detail,vendor_shophour_start,vendor_paytype,vendor_business_areaid,"
				+ "vendor_default_accountid,vendor_shophour_end FROM t_vendor WHERE "
				+ "vendor_mail = ? AND vendor_pwd= ?;");
		q.setString(0,username);
		q.setString(1,pass);
		List l = q.list();
		if(l.size() == 1){
			res = new TVendor();
			Object[] row = (Object[])l.get(0);
			//赋值
            res.setVendorId((int)row[0]);
            res.setVendorName((String)row[1]);
            res.setVendorMail((String)row[2]);
            res.setVendorPhonenum((String)row[3]);
            res.setVendorPwd((String)row[4]);
            res.setVendorIsopen((int)row[5]);
            res.setVendorTotalmoney(row[6]!=null?(double)row[6]:0.0);
            res.setVendorPaidmoney(row[7]!=null?(double)row[7]:0.0);
            res.setVendorRemainedmoney(row[8]!=null?(double)row[8]:0.0);
            res.setVendorEmployernum(row[9]!=null?(int)row[9]:0);
            res.setVendorCooknum(row[10]!=null?(int)row[10]:0);
            res.setVendorDetail((String)row[11]);
            res.setVendorShophourStart((Timestamp)row[12]);
            res.setVendorPaytype((int)row[13]);
            res.setVendorBusinessAreaid((int)row[14]);
		}
		return res;
	}

	//--------------------------和vendorextra有关的东东------------------
	/**
	 * 添加或更新t_vendorextra表
	 * @param ve
	 * @return
	 */
	public boolean updateVendorextra(TVendorextra ve){
		try {
			session.saveOrUpdate(ve);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据商家Id来查找特定的商家的信息
	 * @param vendorId 商家Id
	 * @return
	 */
	public TVendorextra findTVendorextraByVendor(Integer vendorId){
		return (TVendorextra) session.createQuery("fROM TVendorextra t WHERE t.vendorId = ? ").setInteger(0,vendorId).uniqueResult();
	}
	/**
	 * 根据商家vendor来查找特定的商家的信息vendorextra
	 * @param vendor
	 * @return
	 */
	public TVendorextra findTVendorextraByVendor(TVendor vendor){
		if(vendor.getVendorId()!=null){
			return findTVendorextraByVendor(vendor.getVendorId());
		}else{
			return null;
		}
	}
	/**
	 * 根据商家Id来删除t_vendorextra表中对应的数据
	 * @param vendorId 商家Id
	 * @return
	 */
	public boolean delVendorextra(Integer vendorId){
		SQLQuery q = session.createSQLQuery("DELETE FROM t_vendorextra WHERE vendor_id =?");
		q.setInteger(0,vendorId);
		if(q.executeUpdate()>0){
			return true;
		}
		return false;
	}
	/**
	 * 删除对应商家的vendorextra
	 * @param vendor 商家
	 * @return
	 */
	public boolean delVendorextra(TVendor vendor){
		try {
			if(vendor.getVendorId()!=null){
				session.delete(vendor);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}