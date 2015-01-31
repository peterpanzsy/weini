package com.weini.manage.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.weini.manage.entity.TBoxpage;

public class BoxPageinfoDao {
	protected Session session;
	public BoxPageinfoDao(Session sess){
		session = sess;
	}
	/**
	 * 获取boxpage状态为1的记录
	 * @return
	 */
	public List<Object> getBoxpageinfo(){
		List<Object> res = new ArrayList<Object>();
		Query q = session.createSQLQuery("SELECT boxpage_id,boxpage_title,boxpage_tiptext,boxpage_oneText,"
				+ "boxpage_onedesctext,boxpage_threetext,boxpage_threedesctext,boxpage_fiveboxtext,"
				+ "boxpage_fivedesctext from t_boxpage where boxpage_status = 1;");
		List l = q.list();
		if(l.size() == 1){
			Object[] row = (Object[])(l.get(0));
			for(Object temp:row){
				res.add(temp);
			}
		}
		return res;
	}
}
