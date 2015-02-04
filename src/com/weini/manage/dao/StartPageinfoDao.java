package com.weini.manage.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.weini.manage.entity.TStartpageinfo;
import com.weini.manage.entity.TTrackpage;

public class StartPageinfoDao {
	protected Session session;
	public StartPageinfoDao(Session sess){
		this.session = sess;
	}
	/**
	 * 获取当前启用的启动界面图片
	 * @return 成功返回信息，否则返回null
	 */
	public TStartpageinfo getNowStartPageinfoByType(int type){
		TStartpageinfo res = null;
		Query q = session.createSQLQuery("SELECT startpage_id,startpage_starttime,startpage_endtime,"
				+ "startpage_imageloc from t_startpageinfo where startpage_status = 1 and startpage_phonetype = ?;");
		q.setInteger(0, type);
		List l = q.list();
		if(l != null && l.size() == 1){
			res = new TStartpageinfo();
			Object[] row = (Object[])l.get(0);
			res.setStartpageId((int)row[0]);
			res.setStartpageStarttime(((Timestamp)row[1]));
			res.setStartpageEndtime(((Timestamp)row[2]));
			res.setStartpageImageloc((String)row[3]);
		}
		return res;
	}
	/**
	 * 根据给定的startid删除对应的启动图片
	 * @param startid 给定的id
	 * @return 执行影响的行数
	 */
	public int delStartPageinfo(int startid){
		Query q = session.createSQLQuery("DELETE FROM t_startpageinfo where startpage_id = ?;");
		q.setParameter(0,startid);
		return q.executeUpdate();
	}
	/**
	 * 根据传入的溯源文案信息来添加或者更新数据库
	 * @param temp 溯源文案类信息
	 * @param isAdd 是否是增加  true:增加，false：更新
	 * @return
	 */
	public int updateStartPageinfo(TStartpageinfo temp,boolean isAdd){
		Query q = null;
		if(isAdd){
			q = session.createSQLQuery("INSERT INTO t_startpageinfo(startpage_starttime,"
					+ "startpage_endtime,startpage_imageloc,startpage_phonetype,startpage_status) VALUES (?,?,?,?,0);");
		}else{
			q = session.createSQLQuery("updage t_startpageinfo SET startpage_starttime = ?,"
					+ "SET startpage_endtime = ?,SET startpage_imageloc = ?,SET startpage_phonetype = ?,SET startpage_status = 0 where startpage_id = ?;");
		}
		q.setParameter(0,temp.getStartpageStarttime());
		q.setParameter(1,temp.getStartpageEndtime());
		q.setParameter(2,temp.getStartpageImageloc());
		q.setParameter(3,temp.getStartpagePhonetype());
		if(!isAdd){
			q.setParameter(3,temp.getStartpageId());
		}
		return q.executeUpdate();
	}
	/**
	 * 根据给定的startid设置启动页面的状态
	 * @param startid 启动页面id
	 * @param status 启动页面状态
	 * @return 返回执行结果
	 */
	public int updateStartPageStatus(int startid,boolean status){
		Query q = session.createSQLQuery("update t_startpageinfo set startpage_status = ? where startpage_id = ?;");
		if(status){
			q.setParameter(0,1);
		}else{
			q.setParameter(0,0);
		}
		q.setParameter(1, startid);
		return q.executeUpdate();
	}
	

}
