package com.weini.manage.dao;

import org.hibernate.Session;

import com.weini.tools.HibernateSessionManager;

public abstract class GeneralDao {
	
	protected  Session session ;
	
	public GeneralDao() {
		session = HibernateSessionManager.getThreadLocalSession();
	}
	
	public void close() {
		HibernateSessionManager.commitThreadLocalTransaction();
		HibernateSessionManager.closeThreadLocalSession();
	}
	public void roll() {
		HibernateSessionManager.rollbackThreadLocalTransaction();
		HibernateSessionManager.closeThreadLocalSession();
	}


	public void initDao()
	{	
		session = HibernateSessionManager.getThreadLocalSession();
	}	
}
