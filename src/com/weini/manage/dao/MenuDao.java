package com.weini.manage.dao;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TMenuinfo;
import com.weini.tools.HibernateSessionManager;

public class MenuDao{
	protected  Session session ;
	
	public MenuDao(Session sess) {
		this.session = sess;
	}
	/**
	 * 获取菜品图片文件的路径
	 * @param menuId 菜品id
	 * @param num 图片id
	 * @return 返回图片路径
	 */
	public String getFileName(int menuId,int num){
		SQLQuery q;
		String sql = ("SELECT menuinfo_image"+num+" FROM t_menuinfo t WHERE t.menuinfo_id = ?" );
		q =session.createSQLQuery(sql);
		q.setInteger(0, menuId);
		return (String) q.uniqueResult();
	}
//	/**
//	 * 根据菜品id得到menu的详细信息
//	 * @param menuId
//	 * @return
//	 */
//	public TMenuinfo menuDetail(int menuId) {
//		TMenuinfo m = new TMenuinfo();
//		SQLQuery q;
//		String sql = ("SELECT menuinfo_id,menuinfo_detail,menuinfo_name,menuinfo_point FROM t_menuinfo t "
//				+ "WHERE t.menuinfo_id =?;" );
//		q =session.createSQLQuery(sql);
//		q.setInteger(0, menuId);
//		Object[] row = (Object[]) q.uniqueResult();
//		m.setMenuId((Integer)row[0]);
//		m.setDetail((String)row[1]);
//		m.setName((String)row[2]);
//		m.setPoint((Float)row[3]);
//		return m;
//	}
	/**
	 * 开启事务
	 * 更新菜品的评分
	 * @param menuId 菜品id
	 * @param point 菜品评分
	 * @return 返回执行结果
	 */
	public Integer updatePoint(int menuId, Float point) {
		Query q3 = session.createSQLQuery("UPDATE t_menuinfo SET menuinfo_point =(menuinfo_point*menuinfo_usernum+ ?)/(menuinfo_usernum+1), menuinfo_usernum = (menuinfo_usernum+1) WHERE menuinfo_id = ?;");
		q3.setFloat(0, point);
		q3.setInteger(1, menuId);
		int result=q3.executeUpdate();
		return result;
	}
	/**
	 * 根据menuID获取menu的详细信息
	 * @param menuId 菜品id
	 * @return 返回菜品类
	 */
	public TMenuinfo findMenuDetailByMenuID(int menuId) {
		TMenuinfo m = new TMenuinfo();
		SQLQuery q;
		String sql = ("SELECT menuinfo_id,menuinfo_name,vendor_id,menuinfo_image1,menuinfo_image2,"
				+ "menuinfo_image3,menuinfo_image4,menuinfo_detail,menuinfo_date,menuinfo_status,menuinfo_point FROM t_menuinfo t "
				+ "WHERE t.menuinfo_id =?;" );
		q =session.createSQLQuery(sql);
		q.setInteger(0, menuId);
		Object[] row = (Object[]) q.uniqueResult();
		m.setMenuinfoId((Integer)row[0]);
		m.setMenuinfoName((String)row[1]);
		m.setVendorId((Integer)row[2]);
		m.setMenuinfoImage1((String)row[3]);
		m.setMenuinfoImage2((String)row[4]);
		m.setMenuinfoImage3((String)row[5]);
		m.setMenuinfoImage4((String)row[6]);
		m.setMenuinfoDetail((String)row[7]);
		m.setMenuinfoDate((Timestamp)row[8]);
		m.setMenuinfoStatus((Integer)row[9]);
		m.setMenuinfoPoint((Float)row[10]);
		return m;
	}
	/**
	 * 列出所有的删除或者未删除的菜品信息
	 * @param isExistGood 菜品是否被删除
	 * @return 所有的菜品
	 */
	public List<TMenuinfo> listMenuInfo(boolean isExist){
		SQLQuery q;
		q = session.createSQLQuery("select menu.menuinfo_id, menu.menuinfo_name, vendor.vendor_name, barea.businessArea_name from t_menuinfo menu,t_vendor vendor,t_businessarea barea where menu.menuinfo_status = ? and menu.vendor_id = vendor.vendor_id and vendor.vendor_business_areaid = barea.businessArea_id ");
		q.setParameter(0, isExist);
		List l = q.list();
		List<TMenuinfo> re=new ArrayList<TMenuinfo>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  TMenuinfo menu=new TMenuinfo();
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
	 * 开启事务
	 * 修改菜品状态菜品
	 * @param id 菜品id
	 * @return 修改结果
	 */
	public boolean changeMenuStatus(int id,boolean isDelete) {
		boolean flag = false;
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
	/**
	 * 开启事务
	 * 更新菜品信息
	 * @param menu 菜品对象
	 * @param isAdd 增加菜品true，否则为false
	 * @return
	 */
	public boolean updateGoodInfo(TMenuinfo menu,boolean isAdd) {
		boolean flag = false;
		Query q;
		if(isAdd){
			q = session.createSQLQuery("insert into t_menuinfo(vendor_id, menuinfo_image1,menuinfo_image2,menuinfo_image3,menuinfo_image4,menuinfo_detail,menuinfo_name,menuinfo_date,menuinfo_status) value (?,?,?,?,?,?,?,?,1)");
		}else{
			q = session.createSQLQuery("update t_menuinfo set vendor_id = ?, menuinfo_image1 = ?,menuinfo_image2 = ?,menuinfo_image3 = ?,menuinfo_image4 = ?,menuinfo_detail = ?,menuinfo_name = ?,menuinfo_date = ? where t_menuinfo.menuinfo_id = ?");
		}
		 
		q.setParameter(0, menu.getVendorId());
		q.setParameter(1, menu.getMenuinfoImage1());
		q.setParameter(2, menu.getMenuinfoImage2());
		q.setParameter(3, menu.getMenuinfoImage3());
		q.setParameter(4, menu.getMenuinfoImage4());
		q.setParameter(5, menu.getMenuinfoDetail());
		q.setParameter(6, menu.getMenuinfoName());
		q.setParameter(7, menu.getMenuinfoDate());		
		//更新的话，应该添加商品id
		if(!isAdd){
			q.setParameter(8,menu.getMenuinfoId());
		}
		int result;
		try{
			result=q.executeUpdate();
			if(result > 0) flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
}
