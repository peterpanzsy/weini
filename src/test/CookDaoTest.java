package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.CookDao;
import com.weini.manage.entity.TCookinfo;
import com.weini.manage.entity.TVendor;
import com.weini.tools.HibernateSessionManager;

public class CookDaoTest {

	Session session ;
	Transaction transaction;
	CookDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new CookDao(session);
		transaction = session.beginTransaction();
	}

	@Test
	public void updateTest1() {
		TCookinfo cook = new TCookinfo("eee","picture E",2);
		Assert.assertTrue(dao.updateCook(cook));
		transaction.commit();
		session.close();
	}
	@Test
	public void updateTest2() {
		TCookinfo cook = new TCookinfo("fff","picture E",2);
		cook.setCookinfoId(3);
		Assert.assertTrue(dao.updateCook(cook));
		transaction.commit();
		session.close();
	}
	@Test
	public void delTest2() {
		TCookinfo cook = new TCookinfo("fff","picture E",2);
		cook.setCookinfoId(3);
		Assert.assertTrue(dao.delCook(cook));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void findCookByVendorIdTest() {
		TVendor t = new TVendor();
		t.setVendorId(2);
		List<TCookinfo> list = dao.findCookByVendor(t);
		for(TCookinfo t1:list){
			System.out.println(t1.toString());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void findAllCookTest() {
		List<TCookinfo> list = dao.findAllCook();
		for(TCookinfo t1:list){
			System.out.println(t1.toString());
		}
		transaction.commit();
		session.close();
	}


}
