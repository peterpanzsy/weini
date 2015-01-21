package com.weini.manage.business;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.business.Vendor;
import com.weini.manage.entity.TVendor;
import com.weini.tools.HibernateSessionManager;


public class VendorDao  {
	Session session ;
	 
	public VendorDao()
	{		
		session = HibernateSessionManager.getThreadLocalSession();
	}
	public void close() {
		// TODO Auto-generated method stub
		HibernateSessionManager.commitThreadLocalTransaction();
		HibernateSessionManager.closeThreadLocalSession();
	}

	public void roll() {
		// TODO Auto-generated method stub
		HibernateSessionManager.rollbackThreadLocalTransaction();
		HibernateSessionManager.closeThreadLocalSession();
	}


	public void initDao()
	{	
		session = HibernateSessionManager.getThreadLocalSession();
	
	}	
	
	public List<Vendor> getVendorList(){
		SQLQuery q;
		q=session.createSQLQuery("select t.vendor_id,t.vendor_name,t.vendor_mail,t.vendor_phonenum,ifnull(t.vendor_pwd,''),t.vendor_isopen,ifnull(t.vendor_totalmoney,0),"
				+ "ifnull(t.vendor_paidmoney,0),ifnull(t.vendor_remainedmoney,0),ifnull(t.vendor_employernum,0),ifnull(t.vendor_cooknum,0),ifnull(t.vendor_shophour_start,current_timestamp),ifnull(t.vendor_shophour_end,current_timestamp),ifnull(t.vendor_paytype,0),"
				+ "ifnull(t.vendor_default_accountid,0),ifnull(t2.businessArea_name,''),ifnull(t3.district_name,''),ifnull(t4.city_name,''),ifnull(t5.province_name,''),ifnull(t.vendor_detail,'') "
				+ "from t_vendor t,t_businessarea t2,t_district t3,t_city t4,t_province t5 "
				+ "where t.vendor_business_areaid=t2.businessArea_id and t2.district_id=t3.district_id and t3.city_id=t4.city_id and t4.province_id=t5.province_id ");
		List l=q.list();
		List<Vendor> re=new ArrayList<Vendor>();
		for(int i=0;i<l.size();i++){
			Object[] row=(Object[])l.get(i);
			int vid=(Integer)row[0];
			String vname=(String)row[1];
			String vmail=(String)row[2];
			String vphone=(String)row[3];
			String vpwd=(String)row[4];
			Boolean isopen=(Boolean)row[5];
			int totalmoney=Integer.valueOf(row[6].toString());	
			int paidmoney=Integer.valueOf(row[7].toString());
			int remainedmoney=Integer.valueOf(row[8].toString());
			int employernum=Integer.valueOf(row[9].toString());
			int cooknum=Integer.valueOf(row[10].toString());
			String shophourStart=(String)row[11];
			String shophourEnd=(String)row[12];
			int paytype=Integer.valueOf(row[13].toString());
			int defaultAccount=Integer.valueOf(row[14].toString());
			String busArea=(String)row[15];
			String district=(String)row[16];
			String city=(String)row[17];
			String province=(String)row[18];	
			String vendorDetail=(String)row[19];
			String defaultAcc=String.valueOf(defaultAccount);
			Vendor v=new Vendor(i+1,vid, vname,vmail,vphone,isopen,totalmoney,paidmoney,remainedmoney,employernum,cooknum,shophourStart,shophourEnd,paytype,defaultAcc,busArea,district,city,province,vendorDetail); 
			re.add(v);
		}
		return re;
	}

	public int updateVendor(int id,String vname,String vmail,String vphone,Boolean isopen,int employernum,int cooknum,String vendorShophourStart,String vendorShophourEnd,String vendorDetail,String mark){//添加或修改账户信息
		int result=0;
		HibernateSessionManager.getThreadLocalTransaction();
		switch(mark){
			case "add":
				Query q = session.createSQLQuery("insert into t_vendor(vendor_name,vendor_mail,vendor_phonenum,vendor_isopen,vendor_employernum,vendor_cooknum,vendor_shophour_start,vendor_shophour_end,vendor_detail) values (?,?,?,?,?,?,?,?,?)");
				q.setParameter(0, vname);
				q.setParameter(1, vmail);
				q.setParameter(2, vphone);
				q.setParameter(3, isopen);
				q.setParameter(4, employernum);
				q.setParameter(5, cooknum);
				q.setParameter(6, vendorShophourStart);
				q.setParameter(7, vendorShophourEnd);
				q.setParameter(8, vendorDetail);
				result=q.executeUpdate();
				break;
			case "edit":
				Query q2 = session.createSQLQuery("update t_vendor set vendor_name=?,vendor_mail=?,vendor_phonenum=?,vendor_isopen=?,vendor_employernum=?,vendor_cooknum=?,vendor_shophour_start=?,vendor_shophour_end=?,vendor_detail=? where vendor_id=?");
				q2.setParameter(0, vname);
				q2.setParameter(1, vmail);
				q2.setParameter(2, vphone);
				q2.setParameter(3, isopen);
				q2.setParameter(4, employernum);
				q2.setParameter(5, cooknum);
				q2.setParameter(6, vendorShophourStart);
				q2.setParameter(7, vendorShophourEnd);
				q2.setParameter(8, vendorDetail);
				q2.setParameter(9, id);
				result=q2.executeUpdate();
				break;
		}
		return result;
	}
	public int delVendor(int id) {//删除账户以及其角色关系
		HibernateSessionManager.getThreadLocalTransaction();
		Query q = session.createSQLQuery(" delete from t_vendor where vendor_id=?");
		q.setParameter(0, id);
		int result=q.executeUpdate();		
		return result;
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


}