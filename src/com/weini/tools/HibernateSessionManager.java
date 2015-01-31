package com.weini.tools;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionManager {
	
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	
	private static ServiceRegistry serviceRegistry = null;
	
	static {
		try {
			// 首先获取配置信息
			configuration =  new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			// 创建Session Factory			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException e) {
			// System.out.println("SessionFactory创建失败");
			e.printStackTrace();
		}
	}
	

	private static final ThreadLocal<Session> ThreadLocal_Session = new ThreadLocal<Session>();
	private static final ThreadLocal<Transaction> ThreadLocal_Transaction = new ThreadLocal<Transaction>();
	
	/**
	 * 获取当前线程中的Session
	 */
	public static Session getThreadLocalSession(){
		
		Session session =  ThreadLocal_Session.get();
		
		if(null == session || (false==session.isOpen())){
			session = sessionFactory.openSession();
			ThreadLocal_Session.set(session);
		}
		
		return session;
	}
	
	/**
	 * 启动或者加入当前线程中Session的Transaction
	 */
	public static Transaction getThreadLocalTransaction(){
		Transaction transaction = ThreadLocal_Transaction.get();
		if(null == transaction){
			transaction = getThreadLocalSession().beginTransaction();
			ThreadLocal_Transaction.set(transaction);
		}
			
		return transaction;
	}
	
	/**
	 * 提交当前线程中Session的Transaction
	 */
	public static void commitThreadLocalTransaction(){
		try {
			Transaction transaction = ThreadLocal_Transaction.get();
			if(null != transaction)
				transaction.commit();
//			ThreadLocal_Transaction.set(null);
			ThreadLocal_Transaction.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 回滚当前线程中Session的Transaction事物
	 */
	public static void rollbackThreadLocalTransaction(){
		try {
			Transaction transaction = ThreadLocal_Transaction.get();
			if(null != transaction && transaction.isActive())
				transaction.rollback();
//			ThreadLocal_Transaction.set(null);
			ThreadLocal_Transaction.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭当前线程中的Session
	 */
	public static void closeThreadLocalSession(){
		Session session =  ThreadLocal_Session.get();
		
		try {
			if(null != session)
				if(true == session.isOpen())
					session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
//		ThreadLocal_Session.set(null);
		ThreadLocal_Session.remove();
	}
}