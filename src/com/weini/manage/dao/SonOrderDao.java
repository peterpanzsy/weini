package com.weini.manage.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TVendor;
import com.weini.manage.entity.TProvince;

public class SonOrderDao{
	protected  Session session ;
	
	public SonOrderDao(Session sess) {
		this.session = sess;
	}
	public List<Object[]> getSOrderByOrderID(int orderID){
		List<Object[]> res = new ArrayList<Object[]>();
		Query q = session.createSQLQuery("select S_order_id,menu_id,S_order_whichday,S_order_consumeStatus,"
				+ "S_order_consumeEvaluate,S_order_dispatchingStartT,S_order_logisticsEvaluate,S_order_predictTime,"
				+ "S_order_isdispatchingStateOpen,S_order_isRefund,S_order_notice from t_s_order where F_order_id = 1;");
		List<Object> l = q.list();
		for(int i = 0; i< l.size();i++){
			Object[] row = (Object[])(l.get(i));
			res.add(row);
		}
		return res;
	}
}
