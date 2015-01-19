package com.weini.manage.dao;


import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.weini.manage.business.Menu;

public class MenuDao extends GeneralDao{
	public MenuDao() {
		super();
	}
	public String getFileName(int menuId,int num){
		SQLQuery q;
		String sql = ("SELECT menuinfo_image"+num+" FROM t_menuinfo t WHERE t.menuinfo_id = ?;" );
		q =session.createSQLQuery(sql);
		q.setInteger(0, menuId);
		return (String) q.uniqueResult();
	}
	/**
	 * 得到menu的详细信息
	 * @param menuId
	 * @return
	 */
	public Menu menuDetail(int menuId) {
		Menu m = new Menu();
		SQLQuery q;
		String sql = ("SELECT menuinfo_id,menuinfo_detail,menuinfo_name,menuinfo_point FROM t_menuinfo t "
				+ "WHERE t.menuinfo_id =?;" );
		q =session.createSQLQuery(sql);
		q.setInteger(0, menuId);
		Object[] row = (Object[]) q.uniqueResult();
		m.setMenuId((Integer)row[0]);
		m.setDetail((String)row[1]);
		m.setName((String)row[2]);
		m.setPoint((Float)row[3]);
		return m;
	}
	public Integer updatePoint(int menuId, Float point) {
		Query q3 = session.createSQLQuery("UPDATE t_menuinfo SET menuinfo_point =(menuinfo_point*menuinfo_usernum+ ?)/(menuinfo_usernum+1), menuinfo_usernum = (menuinfo_usernum+1) WHERE menuinfo_id = ?;");
		q3.setFloat(0, point);
		q3.setInteger(1, menuId);
		int result=q3.executeUpdate();
		return result;
	}
}
