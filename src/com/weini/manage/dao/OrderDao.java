package com.weini.manage.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;

public class OrderDao extends GeneralDao {

	public OrderDao() {
		super();
	}

	public List searchLimit7(int userId) {
		SQLQuery q;
		String sql = ("SELECT t3.menuinfo_id,t3.menuinfo_name,t2.S_order_dispatchingStartT "
				+ "FROM t_menuinfo t3 ,"
				+ "(SELECT S_order_id,menu_id,S_order_dispatchingStartT FROM t_s_order t "
				+ "WHERE t.F_order_id IN (SELECT order_id FROM t_order WHERE user_id = ? )"
				+ "AND t.S_order_consumeStatus = 1 ) t2 "
				+ "WHERE t3.menuinfo_id = t2.menu_id "
				+ "ORDER BY t2.S_order_dispatchingStartT DESC " + "LIMIT 0,6 ;");
		q = session.createSQLQuery(sql);
		q.setInteger(0, userId);
		List l = q.list();
		List re = new ArrayList();
		for (int i = 0; i < l.size(); i++) {
			Object[] row = (Object[]) l.get(i);
			re.add(row);
		}
		return re;
	}

	public List searchMonth(Integer userId, int year, int month) {
		SQLQuery q;
		String sql = ("SELECT t3.menuinfo_id,t3.menuinfo_name,t2.S_order_dispatchingStartT "
				+ "FROM t_menuinfo t3 ,"
				+ "(SELECT S_order_id,menu_id,S_order_dispatchingStartT FROM t_s_order t "
				+ "WHERE t.F_order_id IN (SELECT order_id FROM t_order WHERE user_id = ? ) "
				+ "AND t.S_order_consumeStatus = 1 ) t2 "
				+ "WHERE t3.menuinfo_id = t2.menu_id "
				+       "AND YEAR(t2.S_order_dispatchingStartT) = ? "
				+		"AND MONTH(t2.S_order_dispatchingStartT) = ? "
				+ "ORDER BY t2.S_order_dispatchingStartT DESC ;");
		q = session.createSQLQuery(sql);
		q.setInteger(0, userId);
		q.setInteger(1,year);
		q.setInteger(2, month);
		List l = q.list();
		List re = new ArrayList();
		for (int i = 0; i < l.size(); i++) {
			Object[] row = (Object[]) l.get(i);
			re.add(row);
		}
		return re;
	}

}
