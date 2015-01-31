package test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.UserDao;
import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TUserextra;
import com.weini.tools.HibernateSessionManager;

public class UserDaoTest {

	Session session ;
	Transaction transaction;
	UserDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new UserDao(session);
		transaction = session.beginTransaction();
	}
	@Test
	public void listUserTest() {
		List<TUser> list = dao.listUser();
		for(TUser b:list){
			System.out.println(b.toString());
		}
		transaction.commit();
		session.close();
	}
	@Test
	public void findUserByIdTest1(){
		TUser user = dao.findByUserID(2);
		System.out.println(user.toString());
		transaction.commit();
		session.close();
	}
	
	@Test
	public void findUserByIdTest2(){
		TUser user = dao.findByUserID(5);
		Assert.assertNull(user);
		transaction.commit();
		session.close();
	}
	@Test
	public void findUserextraByIdTest1(){
		TUserextra user = dao.findUserextraByUserId(2);
		System.out.println(user);
		transaction.commit();
		session.close();
	}
	@Test
	public void findUserextraByIdTest2(){
		TUserextra user = dao.findUserextraByUserId(3);
		Assert.assertNull(user);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void findUserextraByIdTest3(){
		TUser user = new TUser();
		user.setUserId(1);
		TUserextra u = dao.findUserextraByUserId(user);
		System.out.println(u);
		transaction.commit();
		session.close();
	}
	@Test
	public void findUserextraByIdTest4(){
		TUser user = new TUser();
		user.setUserId(5);
		TUserextra u = dao.findUserextraByUserId(user);
		Assert.assertNull(u);
		transaction.commit();
		session.close();
	}
	
/*	@Test
	public void addUserTest1() {
		TUser user = new TUser("aa","bb",0,"cc","123",1,1,1,1,"dd",2,new Date(),"狗肉",1,1);
		Assert.assertTrue(dao.addUser(user));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void updateUserTest1() {
		TUser user = new TUser("wpr","bb",0,"cc","123",1,1,1,1,"dd",2,new Date(),"狗肉",1,1);
		user.setUserId(3);
		Assert.assertTrue(dao.updateUser(user));
		transaction.commit();
		session.close();
	}*/
	@Test
	public void delUserTest1() {
		TUser user = new TUser();
		user.setUserId(3);
		Assert.assertTrue(dao.delUser(user));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void addUserextraTest1() {
		TUserextra user = new TUserextra(2,"图片2","aa",new Date());
		Assert.assertTrue(dao.addUserextra(user));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void updateUserextraTest1() {
		TUserextra user = new TUserextra(2,"图片3","bb",new Date());
		user.setUserextraId(2);
		Assert.assertTrue(dao.updateUserextra(user));
		transaction.commit();
		session.close();
	}
	@Test
	public void delUserextraTest1() {
		TUserextra user = new TUserextra();
		user.setUserId(2);
		user.setUserextraId(2);
		Assert.assertTrue(dao.delUserextra(user));
		transaction.commit();
		session.close();
	}
}
