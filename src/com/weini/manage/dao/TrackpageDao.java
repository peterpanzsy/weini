package com.weini.manage.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.weini.manage.entity.TTrackpage;

public class TrackpageDao {
	protected Session session;
	public TrackpageDao(Session sess){
		this.session = sess;
	}
	/**
	 * 根据id获取溯源信息
	 * @return 成功返回信息，否则返回null
	 */
	public TTrackpage getTrackpage(int trackid){
		TTrackpage res = null;
		Query q = session.createSQLQuery("SELECT trackpage_id,trackpage_currentstate,trackpage_curbackcolindex,"
				+ "trackpage_tiptext FROM t_trackpage where trackpage_id = ?;");
		q.setParameter(0, trackid);
		List l = q.list();
		if(l.size() == 1){
			Object[] row = (Object[])l.get(0);
			res = new TTrackpage();
			res.setTrackpageId((int)row[0]);
			res.setTrackpageCurrentstate((String)row[1]);
			res.setTrackpageCurbackcolindex((int)row[2]);
			res.setTrackpageTiptext((String)row[3]);
		}
		return res;
	}
	/**
	 * 根据给定的trakcid删除溯源文案信息
	 * @param trackid 给定的id
	 * @return 执行影响的行数
	 */
	public int delTrackpage(int trackid){
		Query q = session.createSQLQuery("DELETE FROM t_trackpage where trackpage_id = ?;");
		q.setParameter(0,trackid);
		return q.executeUpdate();
	}
	/**
	 * 根据传入的溯源文案信息来添加或者更新数据库
	 * @param temp 溯源文案类信息
	 * @param isAdd 是否是增加  true:增加，false：更新
	 * @return
	 */
	public int updateTrackpage(TTrackpage temp,boolean isAdd){
		Query q = null;
		if(isAdd){
			q = session.createSQLQuery("INSERT INTO t_trackpage(trackpage_currentstate,"
					+ "trackpage_curbackcolindex,trackpage_tiptext) VALUES (?,?,?);");
		}else{
			q = session.createSQLQuery("updage t_trackpage SET trackpage_currentstate = ?,"
					+ "SET trackpage_curbackcolindex = ?,SET trackpage_tiptext = ? where trackpage_id = ?;");
		}
		q.setParameter(0,temp.getTrackpageCurrentstate());
		q.setParameter(1,temp.getTrackpageCurbackcolindex());
		q.setParameter(2,temp.getTrackpageTiptext());
		if(!isAdd){
			q.setParameter(3,temp.getTrackpageId());
		}
		return q.executeUpdate();
	}
	

}
