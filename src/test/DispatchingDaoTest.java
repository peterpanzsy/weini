package test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.BoxDao;
import com.weini.manage.dao.DispatchingDao;
import com.weini.manage.dao.VendorDao;
import com.weini.manage.entity.TBox;
import com.weini.manage.entity.TBoxpage;
import com.weini.manage.entity.TDispatching;
import com.weini.manage.entity.TDispatchingstatus;
import com.weini.manage.entity.TVendor;
import com.weini.manage.entity.TVendorextra;
import com.weini.tools.HibernateSessionManager;

public class DispatchingDaoTest {

	Session session ;
	Transaction transaction;
	DispatchingDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new DispatchingDao(session);
		transaction = session.beginTransaction();
	}

	
	/*@Test
	public void updateTest1() {
		TDispatching dis = new TDispatching(1,1,0,3,0,"aaa",1);
		Assert.assertTrue(dao.updateDispatching(dis));
		transaction.commit();
		session.close();
	}
	@Test
	public void updateTest2() {
		TDispatching dis = new TDispatching(1,1,0,3,0,"bbb",1);
//		dis.setDispatchingId(3);
		Assert.assertTrue(dao.updateDispatching(dis));
		transaction.commit();
		session.close();
	}*/
	@Test
	public void findByIdTest1() {
		transaction.commit();
		session.close();
	}
	@Test
	public void findByIdTest2() {
		transaction.commit();
		session.close();
	}
	@Test
	public void delTest() {
		Assert.assertTrue(dao.delDispatching(3));
		transaction.commit();
		session.close();
	}
/*	@Test
	public void delTest2() {
		TDispatching dis = new TDispatching(1,1,0,3,0,"bbb",1);
		dis.setDispatchingId(3);
		Assert.assertTrue(dao.delDispatching(dis));
		transaction.commit();
		session.close();
	}*/
	@Test
	public void findDispatchingByIdTest() {
		TDispatching dis= dao.findDispatchingById(1);
		System.out.println(dis);
		Assert.assertNotNull(dis);
		transaction.commit();
		session.close();
	}
	@Test
	public void findDispatchingByUserIdTest() {
		List<TDispatching> dis= dao.findDispatchingByUserId(1);
		for(TDispatching d:dis)
			System.out.println(d);
		Assert.assertNotNull(dis);
		transaction.commit();
		session.close();
	}
	@Test
	public void updateDispatchingstatusTest(){
		TDispatchingstatus ds = new TDispatchingstatus("aaa","aaa");
		Assert.assertTrue(dao.updateDispatchingstatus(ds));
		transaction.commit();
		session.close();
	}
	@Test
	public void updateDispatchingstatusTest2(){
		TDispatchingstatus ds = new TDispatchingstatus("bbb","bbb");
		ds.setDispatchingStatusId(2);
		Assert.assertTrue(dao.updateDispatchingstatus(ds));
		transaction.commit();
		session.close();
	}
	@Test
	public void delDispatchingstatusTest2(){
		Assert.assertTrue(dao.delDispatchingstatus(2));
		transaction.commit();
		session.close();
	}
	@Test
	public void delDispatchingstatusTest3(){
		TDispatchingstatus ds = new TDispatchingstatus("bbb","bbb");
		ds.setDispatchingStatusId(2);
		Assert.assertTrue(dao.delDispatchingstatus(ds));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void findDispitchingstautsByIdTest3(){
		TDispatchingstatus ds = dao.findDispitchingstautsById(1);
		System.out.println(ds.toString());
		Assert.assertNotNull(ds);
		transaction.commit();
		session.close();
	}
	@Test
	public void findAllTDispatchingstatusTest3(){
		List<TDispatchingstatus> list = dao.findAllDispatchingstatus();
		for(TDispatchingstatus ds:list){
			System.out.println(ds.toString());
			Assert.assertNotNull(ds);
		}
		transaction.commit();
		session.close();
	}
}
