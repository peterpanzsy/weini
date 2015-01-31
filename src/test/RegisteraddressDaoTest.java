package test;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.RegisteraddressDao;
import com.weini.manage.entity.TRegisteraddress;
import com.weini.tools.HibernateSessionManager;

public class RegisteraddressDaoTest {
	Session session ;
	Transaction transaction;
	RegisteraddressDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new RegisteraddressDao(session);
		transaction = session.beginTransaction();
	}
	
	@Test
	public void findByUserId() {
//		TRegisteraddress radd = new TRegisteraddress(2,"理工大",2);
//		Assert.assertTrue(dao.findByUserId(2));
		TRegisteraddress radd = dao.findByUserId(1);
		System.out.println(radd.toString());
		transaction.commit();
		session.close();
	}
	@Test
	public void findByUserId2() {
//		TRegisteraddress radd = new TRegisteraddress(2,"理工大",2);
//		Assert.assertTrue(dao.findByUserId(2));
		TRegisteraddress radd = dao.findByUserId(5);
		Assert.assertNull(radd);
		transaction.commit();
		session.close();
	}
	@Test
	public void addRegisteraddressTest() {
		TRegisteraddress radd = new TRegisteraddress(2,"理工大",2);
		Assert.assertTrue(dao.addRegisteraddress(radd));
		transaction.commit();
		session.close();
	}
	@Test
	public void updateRegisteraddressTest() {
		TRegisteraddress radd = new TRegisteraddress(3,"理工大",2);
		radd.setRegisterAddressId(2);
		Assert.assertTrue(dao.updateRegisteraddress(radd));
		transaction.commit();
		session.close();
	}
	@Test
	public void delRegisteraddressTest() {
		TRegisteraddress radd = new TRegisteraddress(3,"理工大",2);
		radd.setRegisterAddressId(2);
		Assert.assertTrue(dao.delRegisteraddress(radd));
		transaction.commit();
		session.close();
	}
}
