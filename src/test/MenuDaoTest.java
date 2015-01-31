package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weini.manage.dao.MenuDao;
import com.weini.manage.entity.TDishes;
import com.weini.manage.entity.TMenuCookinfo;
import com.weini.manage.entity.TMenuDishes;
import com.weini.manage.entity.TMenuinfo;
import com.weini.manage.entity.TMenutype;
import com.weini.tools.HibernateSessionManager;

public class MenuDaoTest {

	Session session ;
	Transaction transaction;
	MenuDao dao;
	@Before
	public void init(){
		session = HibernateSessionManager.getThreadLocalSession();
		dao = new MenuDao(session);
		transaction = session.beginTransaction();
	}
	@Test
	public void findMenuDetailByMenuIDTest() {
		TMenuinfo list = dao.findMenuDetailByMenuID(1);
		System.out.println(list.toString());
		Assert.assertNotNull(list);
		transaction.commit();
		session.close();
	}
	@Test
	public void findMenuDetailByMenuIDTest2() {
		TMenuinfo list = dao.findMenuDetailByMenuID(100);
		Assert.assertNull(list);
		transaction.commit();
		session.close();
	}
	@Test
	public void updatePointTest() {
		Assert.assertTrue(dao.updatePoint(1,4.5f));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void findAllDishByMenuinfoIdTest() {
		List<TDishes> list = dao.findAllDishByMenuinfoId(1);
		for(TDishes t:list){
			System.out.println(t);
		}
		transaction.commit();
		session.close();
	}
	
	
	@Test
	public void addDishesTest() {
		TDishes dish = new TDishes("bbb","bbb","ccc");
		dish.setDishesId(5);
		Assert.assertTrue(dao.updateDishes(dish));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void addMenuDishesTest() {
		Assert.assertTrue(dao.addMenuDishes(3, 1));
		transaction.commit();
		session.close();
	}
	@Test
	public void delMenuDishesTest() {
		Assert.assertTrue(dao.delMenuDishes(3, 1));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delMenuDishesTest2() {
		Assert.assertFalse(dao.delMenuDishes(3, 1));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void addMenuCookTest() {
		Assert.assertTrue(dao.addMenuCook(4, 1));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delMenuCookTest() {
		Assert.assertTrue(dao.delMenuCook(3, 1));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delMenuCookByCookIdTest() {
		Assert.assertTrue(dao.delMenuCookByCookId(1));
		transaction.commit();
		session.close();
	}
	@Test
	public void delMenuCookByMenuIdTest() {
		Assert.assertTrue(dao.delMenuCookByMenuId(1));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void listMenutypeTest() {
		List<TMenutype> list = dao.listMenutype();
		for(TMenutype t:list){
			System.out.println(t.getMenutypeDesc());
		}
		transaction.commit();
		session.close();
	}
	
	
	@Test
	public void updateMenuCookTest() {
		TMenuCookinfo t = new TMenuCookinfo(1,5);
		t.setMenuCookinfoid(7);
		Assert.assertTrue(dao.updateMenuCook(t));
		transaction.commit();
		session.close();
	}
	@Test
	public void updateMenuDishTest() {
		TMenuDishes t = new TMenuDishes(1,6);
		t.setMenuDishesId(7);;
		Assert.assertTrue(dao.updateMenuDishes(t));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void getMenutypeTest() {
		System.out.println(dao.getMenutype(1));
		transaction.commit();
		session.close();
	}
	

}
