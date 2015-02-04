package com.weini.manage.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.weini.manage.entity.TBoxpage;

public class BoxModelDao {
	protected Session session;
	public BoxModelDao(Session sess){
		session = sess;
	}
	/**
	 * 获取boxpage状态为1的记录
	 * @return
	 */
	public TBoxpage getBoxpageinfo(){
		TBoxpage res = null;
		Query q = session.createSQLQuery("SELECT boxpage_id,boxpage_title,boxpage_tiptext,boxpage_oneText,"
				+ "boxpage_onedesctext,boxpage_threetext,boxpage_threedesctext,boxpage_fiveboxtext,"
				+ "boxpage_fivedesctext from t_boxpage where boxpage_status = 1;");
		List l = q.list();
		if(l != null && l.size() == 1){
			Object[] row = (Object[])(l.get(0));
			res = new TBoxpage();
			res.setBoxpageId((int)row[0]);
			res.setBoxpageTitle((String)row[1]);
			res.setBoxpageTiptext((String)row[2]);
			res.setBoxpageOneText((String)row[3]);
			res.setBoxpageOnedesctext((String)row[4]);
			res.setBoxpageThreetext((String)row[5]);
			res.setBoxpageThreedesctext((String)row[6]);
			res.setBoxpageFiveboxtext((String)row[7]);
			res.setBoxpageFivedesctext((String)row[8]);
		}
		return res;
	}
	/**
	 * 根据盒子模式id获取盒子模式价格
	 * @param boxID 盒子模式id
	 * @return
	 */
	public List<Object> getBoxPriceAndTypeByBoxID(int boxID){
		List<Object> res = new ArrayList<Object>();
		Query q = session.createSQLQuery("select box_price,box_type from t_box where box_id = ?;");
		q.setInteger(0,boxID);
		List l = q.list();
		if(l.size() > 0){
			Object[] row = (Object[])l.get(0);
			res.add((float)row[0]);
			res.add((int)row[1]);
		}
		return res;
	}
}
