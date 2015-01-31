package test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.BoxDao;
import com.weini.manage.entity.TBox;
import com.weini.manage.entity.TBoxpage;
import com.weini.tools.HibernateSessionManager;

public class BoxDaoTest {

	Session session ;
	Transaction transaction;
	BoxDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new BoxDao(session);
		transaction = session.beginTransaction();
	}
	@Test
	public void listBoxpageTest() {
		List<TBox> list = dao.listBox();
		for(TBox b:list){
			System.out.println(b.toString());
		}
		transaction.commit();
		session.close();
	}
	
	@Test
	public void addBoxpageTest1() {
		TBox box = new TBox(1,78.0f,1,"tupian4","aaa","bbb","bbb","bbb","ccc",4);
		Assert.assertTrue(dao.addBox(box));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void updateBoxpageTest1() {
		TBox box = new TBox(1,78.0f,1,"tupian4","bbb","bbb","bbb","bbb","ccc",4);
		box.setBoxId(4);
		Assert.assertTrue(dao.updateBox(box));
		transaction.commit();
		session.close();
	}
	@Test
	public void delBoxpageTest1() {
		TBox box = new TBox();
		box.setBoxId(4);
		Assert.assertTrue(dao.delBox(box));
		transaction.commit();
		session.close();
	}
}
