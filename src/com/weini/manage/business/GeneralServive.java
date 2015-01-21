package com.weini.manage.business;

import org.hibernate.Session;

import com.weini.tools.HibernateSessionManager;

public abstract class GeneralServive {
	
	protected  Session session ;
	
	public GeneralServive() {
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
