package com.weini.manage.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TOfficebuilding;
import com.weini.manage.entity.TVendor;
import com.weini.manage.entity.TProvince;

public class AddressDao{
	protected  Session session ;
	
	public AddressDao(Session sess) {
		this.session = sess;
	}
	/**
	 * 列出所有的省份信息
	 * @return 省份信息列表
	 */
	public List<TProvince> listProivces(){
		SQLQuery q;
		q = session.createSQLQuery("select * from t_province");
		List l = q.list();
		List<TProvince> result=new ArrayList<TProvince>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  TProvince pro=new TProvince();
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
	public List<TCity> listCitysByProviceID(int proviceID){
		SQLQuery q;
		q = session.createSQLQuery("select t_city.city_id,t_city.city_name from t_city where t_city.province_id = ?");
		q.setParameter(0, proviceID);
		List l = q.list();
		List<TCity> result=new ArrayList<TCity>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  TCity city=new TCity();
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
	public List<TDistrict> listDistrictsByCityID(int cityID){
		SQLQuery q;
		q = session.createSQLQuery("select t_district.district_id,t_district.district_name from t_district where t_district.city_id = ?");
		q.setParameter(0, cityID);
		List l = q.list();
		List<TDistrict> result=new ArrayList<TDistrict>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  TDistrict dis=new TDistrict();
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
	public List<TBusinessarea> listBusinessareasByDistrictID(int districtID){
		SQLQuery q;
		q = session.createSQLQuery("select t_businessarea.businessArea_id,t_businessarea.businessArea_name from t_businessarea where t_businessarea.district_id = ?");
		q.setParameter(0, districtID);
		List l = q.list();
		List<TBusinessarea> result=new ArrayList<TBusinessarea>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  TBusinessarea buss=new TBusinessarea();
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
	public List<TVendor> listVendorsByDistrictID(int bussID){
		SQLQuery q;
		q = session.createSQLQuery("select t_vendor.vendor_id,t_vendor.vendor_name from t_vendor where t_vendor.vendor_business_areaid = ?");
		q.setParameter(0, bussID);
		List l = q.list();
		List<TVendor> result=new ArrayList<TVendor>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  TVendor ven=new TVendor();
			  ven.setVendorId((Integer)row[0]);
			  ven.setVendorName((String)row[1]);
			  result.add(ven);
		}
		return result;
	}
	//----------------wang------------//
	/**
	 * 根据商圈列出所有的写字楼
	 * @param bussId
	 * @return
	 */
	public List<TOfficebuilding> listOfficebuildingByBusinessAreaId(int bussId){
		List  l =session.createSQLQuery("select officeBuilding_id,officeBuilding_name from t_officebuilding t where businessArea_id = ?").setInteger(0,bussId).list();
		List<TOfficebuilding> result=new ArrayList<TOfficebuilding>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  TOfficebuilding off=new TOfficebuilding();
			  off.setOfficeBuildingId((Integer)row[0]);
			  off.setOfficeBuildingName((String)row[1]);
			  result.add(off);
		}
		return result;
	}
	/**
	 * 根据省份Id来查找省份名称
	 * @param dispatchingProvince
	 * @return
	 */
	public String findProvince(Integer dispatchingProvince) {
		SQLQuery q = session.createSQLQuery("select province_name from t_province where province_id = ?");
		q.setInteger(0,dispatchingProvince);
		return (String) q.uniqueResult();
	}
	/**
	 * 根据城市Id来查找城市名称
	 * @param dispatchingCity
	 * @return
	 */
	public String findCity(Integer dispatchingCity) {
		SQLQuery q = session.createSQLQuery("select city_name from t_city where city_id = ?");
		q.setInteger(0,dispatchingCity);
		return (String) q.uniqueResult();
	}
	/**
	 * 根据区县Id来查找区县名称
	 * @param dispatchingDistrict
	 * @return
	 */
	public String findDistrict(Integer dispatchingDistrict) {
		SQLQuery q = session.createSQLQuery("select district_name from t_district where district_id = ?");
		q.setInteger(0,dispatchingDistrict);
		return (String) q.uniqueResult();
	}
	/**
	 * 根据商业区Id来查找商业区名称
	 * @param dispatchingBusinessAreaid
	 * @return
	 */
	public String findBusiness(Integer dispatchingBusinessAreaid) {
		SQLQuery q = session.createSQLQuery("select businessArea_name from t_businessarea where businessArea_id = ?");
		q.setInteger(0,dispatchingBusinessAreaid);
		return (String) q.uniqueResult();
	}
	/**
	 * 根据写字楼Id得到写字楼的名称
	 * @param dispatchingOfficeBuilding
	 * @return
	 */
	public String findOffice(Integer dispatchingOfficeBuilding) {
		SQLQuery q = session.createSQLQuery("select officeBuilding_name from t_officebuilding where officeBuilding_id = ?");
		q.setInteger(0,dispatchingOfficeBuilding);
		return (String) q.uniqueResult();
	}
}
