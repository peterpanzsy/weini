package com.weini.manage.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.weini.manage.entity.TVersion;

public class VersionDao {
	protected Session session;
	public VersionDao(Session sess){
		session = sess;
	}
	/**
	 * 根据手机类型返回最新版本和上一个版本
	 * @param type 手机类型 0：Android 1：ios
	 * @return 
	 */
	public List<TVersion> getVersionInfoByType(int type){
		List<TVersion> res = new ArrayList<TVersion>();
		Query q = session.createSQLQuery("SELECT version_info,"
				+ "version_loc from t_version where version_type = ? ORDER BY version_id DESC limit 2;");
		q.setParameter(0, type);
		List l = q.list();
		if(l != null && l.size() > 0 && l.size() < 3){
			for(int i = 0;i<l.size();i++){
				Object[] row = (Object[])l.get(i);
				TVersion temp = new TVersion();
				temp.setVersionInfo((String)row[0]);
				temp.setVersionLoc((String)row[1]);
				res.add(temp);
			}
			
		}
		return res;
	}
	/**
	 * 根据id删除版本信息
	 * @param id 版本id
	 * @return 执行影响结果
	 */
	public int delVersionInfoById(int id){
		Query q = session.createSQLQuery("delete from t_version where version_id = ?");
		q.setParameter(0, id);
		return q.executeUpdate();
	}
	/**
	 * 更新版本信息
	 * @param temp 版本信息类
	 * @param isAdd 是否增加 true:增加;false:更新
	 * @return
	 */
	public int updateVersionInfo(TVersion temp, boolean isAdd){
		Query q = null;
		if(isAdd){
			q = session.createSQLQuery("insert into t_version(version_info,version_loc,version_type) values(?,?,?)");
		}else{
			q = session.createSQLQuery("update t_version set version_info = ?,version_loc = ?,version_type = ? where version_id = ?");
		}
		q.setString(0, temp.getVersionInfo());
		q.setString(1,temp.getVersionLoc());
		q.setInteger(2,temp.getVersionType());
		if(isAdd){
			q.setInteger(3, temp.getVersionId());
		}
		return q.executeUpdate();
	}
}
