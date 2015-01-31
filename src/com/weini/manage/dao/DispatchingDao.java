package com.weini.manage.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TDispatching;
import com.weini.manage.entity.TDispatchingstatus;

public class DispatchingDao {
	protected  Session session ;
	
	public DispatchingDao(Session sess) {
		this.session = sess;
	}
	/**
	 * 保存或更新t_dispatching的TDispatching对象
	 * @param dis
	 * @return
	 */
	public boolean updateDispatching(TDispatching dis){
		try {
			session.saveOrUpdate(dis);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 保存或更新t_dispatching的TDispatching对象
	 * @param dis
	 * @return
	 */
	public boolean addDispatching(TDispatching dis){
		try {
			session.save(dis);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 删除dis
	 * @param dis
	 * @return
	 */
	public boolean delDispatching(TDispatching dis){
		try {
			session.delete(dis);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 通过主键来删除
	 * @param disId
	 * @return
	 */
	public boolean delDispatching(Integer disId){
		SQLQuery q = session.createSQLQuery("delete from t_dispatching where dispatching_id = ?");
		q.setInteger(0,disId);
		try {
			if(q.executeUpdate()>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 通过dispatchingId来查找TDispatching对象
	 * @param dispatchingId
	 * @return
	 */
	public TDispatching findDispatchingById(Integer dispatchingId){
		return (TDispatching) session.createQuery("from TDispatching t where t.dispatchingId = ?").setInteger(0,dispatchingId).uniqueResult(); 
	}
	/**
	 * 得到和用户有关的地址
	 * @param userId  用户Id
	 * @return 找到返回地址列表
	 */
	public List<TDispatching> findDispatchingByUserId(Integer userId){
		return session.createQuery("from TDispatching t where t.userId = ?").setInteger(0, userId).list();
	}
	
	//---------------- t_dispatchingstatus有关的内容---------------------//
	
	/**
	 * 添加或者更新	TDispatchingstatus对象
	 * @param ds
	 * @return
	 */
	public boolean updateDispatchingstatus(TDispatchingstatus ds){
		try {
			session.saveOrUpdate(ds);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 删除ds
	 * @param ds
	 * @return
	 */
	public boolean delDispatchingstatus(TDispatchingstatus ds){
		try {
			session.delete(ds);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据DispatchingstatueId来删除
	 * @param dsId
	 * @return
	 */
	public boolean delDispatchingstatus(Integer dsId){
		SQLQuery q = session.createSQLQuery("delete from t_dispatchingstatus where dispatchingStatus_id = ?");
		q.setInteger(0,dsId);
		try {
			if(q.executeUpdate()>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据dispatchingId来查找TDispatchingstatus对象
	 * @param dsId
	 * @return 存在返回对象，不存在返回null
	 */
	public TDispatchingstatus findDispitchingstautsById(Integer dsId){
		return  (TDispatchingstatus) session.createQuery("from TDispatchingstatus t where t.dispatchingStatusId = ?").setInteger(0,dsId).uniqueResult(); 
	}
	/**
	 * 查找所有的TDispatchingStatus
	 * @return
	 */
	public List<TDispatchingstatus> findAllDispatchingstatus(){
		return session.createQuery("from TDispatchingstatus").list();
	}
}
