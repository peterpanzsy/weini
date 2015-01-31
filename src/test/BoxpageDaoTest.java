package test;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.BoxpageDao;
import com.weini.manage.entity.TBoxpage;
import com.weini.tools.HibernateSessionManager;

public class BoxpageDaoTest {

	Session session ;
	Transaction transaction;
	BoxpageDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new BoxpageDao(session);
		transaction = session.beginTransaction();
	}
	@Test
	public void listBoxpageTest() {
		List<TBoxpage> list = dao.listBoxpage();
		for(TBoxpage b:list){
			System.out.println(b.toString());
		}
		transaction.commit();
		session.close();
	}
	
//	@Test
//	public void addBoxpageTest1() {
//		TBoxpage box = new TBoxpage("aa","bb","cc","dd","ee","ff","gg","hh");
//		Assert.assertTrue(dao.addBoxpage(box));
//		transaction.commit();
//		session.close();
//	}
	
/*	@Test
	public void updateBoxpageTest1() {
		TBoxpage box = new TBoxpage("aa1","bb2","cc2","dd2","ee2","ff2","gg2","hh2");
		box.setBoxpageId(2);
		Assert.assertTrue(dao.updateBoxpage(box));
		transaction.commit();
		session.close();
	}*/
	@Test
	public void delBoxpageTest1() {
		TBoxpage box = new TBoxpage();
		box.setBoxpageId(3);
		Assert.assertTrue(dao.delBoxpage(box));
		transaction.commit();
		session.close();
	}
}
