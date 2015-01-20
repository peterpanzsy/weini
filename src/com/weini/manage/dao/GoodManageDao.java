package com.weini.manage.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.business.Admin;
import com.weini.manage.business.Auth;
import com.weini.manage.business.BusinessArea;
import com.weini.manage.business.City;
import com.weini.manage.business.District;
import com.weini.manage.business.Menuinfo;
import com.weini.manage.business.Province;
import com.weini.manage.business.Vendor;
import com.weini.tools.HibernateSessionManager;


public class GoodManageDao  {
	 
	 Session session ;
	 
	public GoodManageDao()
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
	
	public List<Menuinfo> listGoodInfo(boolean isExistGood){
		SQLQuery q;
		q = session.createSQLQuery("select menu.menuinfo_id, menu.menuinfo_name, vendor.vendor_name, barea.businessArea_name from t_menuinfo menu,t_vendor vendor,t_businessarea barea where menu.menuinfo_status = ? and menu.vendor_id = vendor.vendor_id and vendor.vendor_business_areaid = barea.businessArea_id ");
		q.setParameter(0, isExistGood);
		List l = q.list();
		List<Menuinfo> re=new ArrayList<Menuinfo>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  Menuinfo menu=new Menuinfo();
			  menu.setMenuinfoId((Integer)row[0]);
			  menu.setMenuinfoName((String)row[1]);
			  menu.setVendorName((String)row[2]);
			  menu.setBussinessName((String)row[3]);
			  menu.setOrder(i+1);
			  re.add(menu);
		}
		return re;
	}
	/**
	 * 删除菜品
	 * @param id 菜品id
	 * @return 删除结果
	 */
	public boolean changeGoodStatus(int id,boolean isDelete) {
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		Query q = session.createSQLQuery(" update t_menuinfo set menuinfo_status = ? where menuinfo_id = ?");
		q.setParameter(0, isDelete);
		q.setParameter(1, id);
		int result;
		try{
			result=q.executeUpdate();
			if(result > 0) flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean addGoodInfo(Menuinfo menu) {
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		Query q = session.createSQLQuery("insert into t_menuinfo(vendor_id, menuinfo_image1,menuinfo_image2,menuinfo_image3,menuinfo_image4,menuinfo_detail,menuinfo_name,menuinfo_date,menuinfo_status) value (?,?,?,?,?,?,?,?,1)");
		q.setParameter(0, menu.getVendorId());
		q.setParameter(1, menu.getMenuinfoImage1());
		q.setParameter(2, menu.getMenuinfoImage2());
		q.setParameter(3, menu.getMenuinfoImage3());
		q.setParameter(4, menu.getMenuinfoImage4());
		q.setParameter(5, menu.getMenuinfoDetail());
		q.setParameter(6, menu.getMenuinfoName());
		q.setParameter(7, menu.getMenuinfoDate());		
		int result;
		try{
			result=q.executeUpdate();
			if(result > 0) flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 列出所有的省份信息
	 * @return
	 */
	public List<Province> listProivceInfo(){
		SQLQuery q;
		q = session.createSQLQuery("select * from t_province");
		List l = q.list();
		List<Province> result=new ArrayList<Province>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  Province pro=new Province();
			  pro.setProvinceId((Integer)row[0]);
			  pro.setProvinceName((String)row[1]);
			  result.add(pro);
		}
		return result;
	}
	
	/**
	 * 根据省份列出所有的城市
	 * @param proviceID 省份id
	 * @return 城市列表
	 */
	public List<City> listCityInfoByProviceID(int proviceID){
		SQLQuery q;
		q = session.createSQLQuery("select t_city.city_id,t_city.city_name from t_city where t_city.province_id = ?");
		q.setParameter(0, proviceID);
		List l = q.list();
		List<City> result=new ArrayList<City>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  City city=new City();
			  city.setCityId((Integer)row[0]);
			  city.setCityName((String)row[1]);
			  result.add(city);
		}
		return result;
	}
	/**
	 * 根据城市列出所有的县区
	 * @param cityID 城市id
	 * @return 城市列表
	 */
	public List<District> listDistrictInfoByCityID(int cityID){
		SQLQuery q;
		q = session.createSQLQuery("select t_district.district_id,t_district.district_name from t_district where t_district.city_id = ?");
		q.setParameter(0, cityID);
		List l = q.list();
		List<District> result=new ArrayList<District>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  District dis=new District();
			  dis.setDistrictId((Integer)row[0]);
			  dis.setDistrictName((String)row[1]);
			  result.add(dis);
		}
		return result;
	}
	
	/**
	 * 根据县区列出所有的商圈
	 * @param districtID 县区id
	 * @return 商圈列表
	 */
	public List<BusinessArea> listBusinessareaInfoByDistrictID(int districtID){
		SQLQuery q;
		q = session.createSQLQuery("select t_businessarea.businessArea_id,t_businessarea.businessArea_name from t_businessarea where t_businessarea.district_id = ?");
		q.setParameter(0, districtID);
		List l = q.list();
		List<BusinessArea> result=new ArrayList<BusinessArea>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  BusinessArea buss=new BusinessArea();
			  buss.setBusinessAreaId((Integer)row[0]);
			  buss.setBusinessAreaName((String)row[1]);
			  result.add(buss);
		}
		return result;
	}
	
	/**
	 * 根据商圈列出所有的商家
	 * @param bussID 商圈id
	 * @return 商家列表
	 */
	public List<Vendor> listVendorInfoByDistrictID(int bussID){
		SQLQuery q;
		q = session.createSQLQuery("select t_vendor.vendor_id,t_vendor.vendor_name from t_vendor where t_vendor.vendor_business_areaid = ?");
		q.setParameter(0, bussID);
		List l = q.list();
		List<Vendor> result=new ArrayList<Vendor>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  Vendor ven=new Vendor();
			  ven.setVendorID((Integer)row[0]);
			  ven.setVendorName((String)row[1]);
			  result.add(ven);
		}
		return result;
	}

}