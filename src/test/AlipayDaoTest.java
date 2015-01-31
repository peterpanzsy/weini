package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.AlipayDao;
import com.weini.manage.entity.TAlipay;
import com.weini.manage.entity.TUser;
import com.weini.tools.HibernateSessionManager;

public class AlipayDaoTest {

	Session session ;
	Transaction transaction;
	AlipayDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new AlipayDao(session);
		transaction = session.beginTransaction();
	}

	
	@Test
	public void updateTest1() {
		TAlipay ali = new TAlipay("aaa","111",2);
		Assert.assertTrue(dao.updateAlipay(ali));
		transaction.commit();
		session.close();
	}
	@Test
	public void updateTest2() {
		TAlipay ali = new TAlipay("bbb","111",2);
		ali.setAlipayId(2);
		Assert.assertTrue(dao.updateAlipay(ali));
		transaction.commit();
		session.close();
	}
	@Test
	public void delAlipayTest1() {
		TAlipay ali = new TAlipay("bbb","111",2);
		ali.setAlipayId(2);
		Assert.assertTrue(dao.delAlipay(ali));
		transaction.commit();
		session.close();
	}
	@Test
	public void delAlipayTest2() {
//		TAlipay ali = new TAlipay("bbb","111",2);
//		ali.setAlipayId(2);
		Assert.assertTrue(dao.delAlipayByUserId(2));
		transaction.commit();
		session.close();
	}
	@Test
	public void findAlipayByUserTest1() {
		TAlipay ali = dao.findAlipayByUser(2);
		System.out.println(ali.toString());
		Assert.assertNotNull(ali);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void findAlipayByUserTest2() {
		TUser user = new TUser();
		user.setUserId(2);
		TAlipay ali = dao.findAlipayByUser(user);
		System.out.println(ali.toString());
		Assert.assertNotNull(ali);
		transaction.commit();
		session.close();
	}
	
}
