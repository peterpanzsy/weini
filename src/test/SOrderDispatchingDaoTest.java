package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.After;
import com.weini.manage.dao.OrderDao;
import com.weini.manage.dao.RegisteraddressDao;
import com.weini.manage.dao.SorderDispatchingDao;
import com.weini.manage.entity.TRegisteraddress;
import com.weini.manage.entity.TSorderDispatching;
import com.weini.tools.HibernateSessionManager;

public class SOrderDispatchingDaoTest {
	Session session ;
	Transaction transaction;
	SorderDispatchingDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new SorderDispatchingDao(session);
		transaction = session.beginTransaction();
	}
	@Test
	public void addSorderDispatchingTest() {
		dao.addSorderDispatching(1,2, new Timestamp(new Date().getTime()));
		transaction.commit();
		session.close();
	}
	@Test
	public void updateSorderDispatchingTest() {
		TSorderDispatching sd = new TSorderDispatching(1, 3, new Timestamp(new Date().getTime()));
		Assert.assertTrue(dao.updateSorderDispatching(sd));
		transaction.commit();
		session.close();
	}
	@Test
	public void findSorderDispatchingBySOrderIdTest() {
		TSorderDispatching sd = dao.findSorderDispatchingBySOrderId(1);
		System.out.println(sd.toString());
		Assert.assertNotNull(sd);
		transaction.commit();
		session.close();
	}
}
