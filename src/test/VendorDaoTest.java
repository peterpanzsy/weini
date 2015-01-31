package test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.BoxDao;
import com.weini.manage.dao.VendorDao;
import com.weini.manage.entity.TBox;
import com.weini.manage.entity.TBoxpage;
import com.weini.manage.entity.TVendor;
import com.weini.manage.entity.TVendorextra;
import com.weini.tools.HibernateSessionManager;

public class VendorDaoTest {

	Session session ;
	Transaction transaction;
	VendorDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new VendorDao(session);
		transaction = session.beginTransaction();
	}

	
	@Test
	public void updateTest1() {
		TVendorextra t = new TVendorextra();
		t.setVendorId(2);
		t.setVendorextraName("bbb");
		t.setVendorextraId(6);;
		Assert.assertTrue(dao.updateVendorextra(t));
		transaction.commit();
		session.close();
	}
	@Test
	public void findByIdTest1() {
		TVendorextra t = dao.findTVendorextraByVendor(2);
		Assert.assertNotNull(t);
		transaction.commit();
		session.close();
	}
	@Test
	public void findByIdTest2() {
		TVendor t1 = new TVendor();
		t1.setVendorId(2);
		TVendorextra t = dao.findTVendorextraByVendor(t1);
		Assert.assertNotNull(t);
		transaction.commit();
		session.close();
	}
	@Test
	public void delTest() {
		Assert.assertTrue(dao.delVendorextra(4));
		transaction.commit();
		session.close();
	}
}
