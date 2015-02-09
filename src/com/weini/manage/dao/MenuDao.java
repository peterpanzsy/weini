package com.weini.manage.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TDishes;
import com.weini.manage.entity.TMenuCookinfo;
import com.weini.manage.entity.TMenuDishes;
import com.weini.manage.entity.TMenuinfo;

public class MenuDao{
	protected  Session session ;
	
	public MenuDao(Session sess) {
		this.session = sess;
	}

	/**
	 * 开启事务
	 * 更新菜品的评分
	 * @param menuId 菜品id
	 * @param point 菜品评分
	 * @return 返回执行结果
	 */
	public boolean updatePoint(int menuId, Float point) {
		Query q3 = session.createSQLQuery("UPDATE t_menuinfo SET menuinfo_point =(menuinfo_point*menuinfo_consumernum+ ?)/(menuinfo_consumernum+1), menuinfo_consumernum = (menuinfo_consumernum+1) WHERE menuinfo_id = ?;");
		q3.setFloat(0, point);
		q3.setInteger(1, menuId);
		try {
			if(q3.executeUpdate()>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据menuID获取menu的详细信息
	 * @param menuId 菜品id
	 * @return 返回菜品类
	 */
	public TMenuinfo findMenuDetailByMenuID(int menuId) {
		return (TMenuinfo) session.createQuery("from TMenuinfo t where t.menuinfoId = ?").setInteger(0, menuId).uniqueResult();
	}
	
	/**
	 * 根据商圈id获取menu的id列表
	 * @param bussAreaID 商圈id
	 * @return 返回菜品id列表
	 */
	public List<Integer> findMenuIdsByBussAreaID(int bussAreaID,int menuWestern) {
		List<Integer> res = null;
		Query q = session.createSQLQuery("SELECT menuinfo_id from t_menuinfo where menuinfo_bussinessAreaID  = ? and menuinfo_western = ? and menuinfo_status = 1;");
		q.setInteger(0,bussAreaID);
		q.setInteger(1, menuWestern);
		List l = q.list();
		if(l != null && l.size() > 0){
			res = new ArrayList<Integer>();
			for(int i = 0;i < l.size();i++){
				res.add((Integer)l.get(i));
			}
		}
		return res;

	}
	/**
	 * 列出所有的删除或者未删除的菜品信息
	 * @param isExistGood 菜品是否被删除
	 * @return 所有的菜品
	 */
	public List<TMenuinfo> listMenuInfo(boolean isExist){
		SQLQuery q;
		q = session.createSQLQuery("select menu.menuinfo_id, menu.menuinfo_name, vendor.vendor_name, barea.businessArea_name from t_menuinfo menu,t_vendor vendor,t_businessarea barea where menu.menuinfo_status = ? and menu.vendor_id = vendor.vendor_id and vendor.vendor_business_areaid = barea.businessArea_id ");
		q.setParameter(0, isExist);
		List l = q.list();
		List<TMenuinfo> re=new ArrayList<TMenuinfo>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  TMenuinfo menu=new TMenuinfo();
			  menu.setMenuinfoId((Integer)row[0]);
			  menu.setMenuinfoName((String)row[1]);
			  menu.setVendorName((String)row[2]);
			  menu.setBussinessName((String)row[3]);
			  menu.setOrder(i+1);
			  re.add(menu);
		}
		return re;
	}
	/**
	 * 开启事务
	 * 修改菜品状态菜品
	 * @param id 菜品id
	 * @return 修改结果
	 */
	public boolean changeMenuStatus(int id,boolean isDelete) {
		boolean flag = false;
		Query q = session.createSQLQuery(" update t_menuinfo set menuinfo_status = ? where menuinfo_id = ?");
		q.setParameter(0, isDelete);
		q.setParameter(1, id);
		int result;
		try{
		result=q.executeUpdate();
		if(result > 0) flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 开启事务
	 * 更新菜品信息
	 * @param menu 菜品对象
	 * @param isAdd 增加菜品true，否则为false
	 * @return
	 */
	public boolean updateGoodInfo(TMenuinfo menu,boolean isAdd) {
		boolean flag = false;
		Query q;
		if(isAdd){
			q = session.createSQLQuery("insert into t_menuinfo(vendor_id, menuinfo_image1,menuinfo_image2,menuinfo_image3,menuinfo_image4,menuinfo_detail,menuinfo_name,menuinfo_date,menuinfo_status) value (?,?,?,?,?,?,?,?,1)");
		}else{
			q = session.createSQLQuery("update t_menuinfo set vendor_id = ?, menuinfo_image1 = ?,menuinfo_image2 = ?,menuinfo_image3 = ?,menuinfo_image4 = ?,menuinfo_detail = ?,menuinfo_name = ?,menuinfo_date = ? where t_menuinfo.menuinfo_id = ?");
		}
		 
		q.setParameter(0, menu.getVendorId());
		q.setParameter(1, menu.getMenuinfoImage1());
		q.setParameter(2, menu.getMenuinfoImage2());
		q.setParameter(3, menu.getMenuinfoImage3());
		q.setParameter(4, menu.getMenuinfoImage4());
		q.setParameter(5, menu.getMenuinfoDetail());
		q.setParameter(6, menu.getMenuinfoName());
		q.setParameter(7, menu.getMenuinfoDate());		
		//更新的话，应该添加商品id
		if(!isAdd){
			q.setParameter(8,menu.getMenuinfoId());
		}
		int result;
		try{
			result=q.executeUpdate();
			if(result > 0) flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	//----------------------------和dishes有关的东东---------------------
	/**
	 * 根据菜单的id来得到构成菜单组成
	 * @param menuId 
	 * @return 午餐组成列表
	 */
	public List<TDishes> findAllDishByMenuinfoId(Integer menuId){
		List<TDishes> res = null;
		SQLQuery q =session.createSQLQuery("SELECT t1.dishes_id,t1.dishes_name,t1.dishes_series_1,t2.dishes_weight FROM t_dishes t1,"
				+ "t_menu_dishes as t2 WHERE t1.dishes_id IN (SELECT t2.dishes_id FROM t_menu_dishes as t2 WHERE t2.menuinfo_id=?)");
		q.setInteger(0, menuId);
		List l = q.list();
		if(l != null && l.size() > 0){
			res = new ArrayList<>();
			for(int i=0 ;i<l.size();i++){
				Object row[] = (Object[]) l.get(i);
				TDishes temp = new TDishes();
				temp.setDishesId((Integer)row[0]);
				temp.setDishesName((String)row[1]);
				temp.setDishesSeries1((String)row[2]);
				temp.setDishesWeight((String)row[3]);
				res.add(temp);
			}
		}
		return res;
	}
	/**
	 * 添加或更新dishes 之前不存在，添加；之前存在更新
	 * @param dish 
	 * @return
	 */
	public boolean updateDishes(TDishes dish){
		try {
			session.saveOrUpdate(dish);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 删除菜肴
	 * @param dish
	 * @return
	 */
	public boolean delDishes(TDishes dish){
		try {
			session.delete(dish);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 添加午餐和菜肴之间的对应关系,如果关系已存在不进行插入，否则直接插入
	 * @param dishId  菜肴Id
	 * @param menuId  午餐Id
	 * @return  如果之前关系已存在，或者插入失败，返回false
	 * 			插入成功 返回true
	 */
	public boolean addMenuDishes(Integer dishId,Integer menuId){
		SQLQuery q = session.createSQLQuery("INSERT INTO t_menu_dishes(menuinfo_id,dishes_id)"
				+ " SELECT ?,? FROM DUAL WHERE NOT EXISTS"
				+ "(SELECT * FROM t_menu_dishes WHERE menuinfo_id = ? AND dishes_id=?)");
		q.setInteger(0, menuId);
		q.setInteger(1, dishId);
		q.setInteger(2, menuId);
		q.setInteger(3, dishId);
		try {
			if(q.executeUpdate()!=0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 更新menuinfo和dishesinfo之间的关系
	 * @param t TMenuDishesinfo对象
	 * @return
	 */
	public boolean updateMenuDishes(TMenuDishes t){
		if(t.getMenuDishesId()!=null&&t.getDishesId()!=null&&t.getMenuinfoId()!=null){
			SQLQuery q =session.createSQLQuery(" UPDATE t_menu_dishes SET menuinfo_id= ?,dishes_id = ? WHERE menu_dishes_id= ? ");
			q.setInteger(0,t.getMenuinfoId());
			q.setInteger(1, t.getDishesId());
			q.setInteger(2, t.getMenuDishesId());
			try {
				if(q.executeUpdate()>0){
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		return false;
	}
	/**
	 * 删除午餐和菜肴之间的对应关系
	 * @param dishId
	 * @param menuId
	 * @return
	 */
	public boolean delMenuDishes(Integer dishId,Integer menuId){
		SQLQuery q = session.createSQLQuery("DELETE FROM t_menu_dishes WHERE menuinfo_id =? AND dishes_id =?");
		q.setInteger(0, menuId);
		q.setInteger(1, dishId);
		try {
			if(q.executeUpdate()!=0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除t_menu_dishes表中和dishId有关的所有内容
	 * @param dishId
	 * @param menuId
	 * @return
	 */
	public boolean delMenuDishesByDishId(Integer dishId){
		SQLQuery q = session.createSQLQuery("DELETE FROM t_menu_dishes dishes_id =?");
		q.setInteger(0, dishId);
		try {
			if(q.executeUpdate()!=0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除t_menu_dishes表中和menuId有关的所有内容
	 * @param dishId
	 * @param menuId
	 * @return
	 */
	public boolean delMenuDishesByMenuId(Integer menuId){
		SQLQuery q = session.createSQLQuery("DELETE FROM t_menu_dishes WHERE menuinfo_id =? ");
		q.setInteger(0, menuId);
		try {
			if(q.executeUpdate()!=0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//---------------------和MenuCook有关的东东-------------
	/**
	 * 设置cookinfo和menuinfo之间的关系，即表t_menu_cookinfo
	 * @param cookId
	 * @param menuId
	 * @return
	 */
	public boolean addMenuCook(Integer cookId,Integer menuId){
		SQLQuery q = session.createSQLQuery("INSERT INTO  t_menu_cookinfo(menuinfo_id,cookinfo_id)"
				+ " SELECT ?,? FROM DUAL WHERE NOT EXISTS"
				+ " (SELECT * FROM t_menu_cookinfo WHERE menuinfo_id = ? AND cookinfo_id= ?) ");
		q.setInteger(0, menuId);
		q.setInteger(1, cookId);
		q.setInteger(2, menuId);
		q.setInteger(3, cookId);
		try {
			if(q.executeUpdate()!=0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 更新menuinfo和cookinfo之间的关系
	 * @param t TMenuCookinfo对象
	 * @return
	 */
	public boolean updateMenuCook(TMenuCookinfo t){
		if(t.getMenuCookinfoid()!=null&&t.getCookinfoId()!=null&&t.getMenuinfoId()!=null){
			SQLQuery q =session.createSQLQuery(" UPDATE t_menu_cookinfo SET menuinfo_id= ?,cookinfo_id = ? WHERE menu_cookinfoid= ? ");
			q.setInteger(0,t.getMenuinfoId());
			q.setInteger(1, t.getCookinfoId());
			q.setInteger(2, t.getMenuCookinfoid());
			try {
				if(q.executeUpdate()>0){
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		return false;
	}
	/**
	 * 删除cookInfo和menuInfo之间的对应关系
	 * @param cookId
	 * @param menuId
	 * @return
	 */
	public boolean delMenuCook(Integer cookId,Integer menuId){
		SQLQuery q = session.createSQLQuery(" DELETE FROM t_menu_cookinfo WHERE menuinfo_id =? AND cookinfo_id =?");
		q.setInteger(0, menuId);
		q.setInteger(1, cookId);
		try {
			if(q.executeUpdate()!=0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除t_menu_cookinfo表中和cookId有关的所有内容
	 * @param cookId
	 * @return
	 */
	public boolean delMenuCookByCookId(Integer cookId){
		SQLQuery q = session.createSQLQuery("DELETE FROM t_menu_cookinfo WHERE cookinfo_id =?");
		q.setInteger(0, cookId);
		try {
			if(q.executeUpdate()!=0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除t_menu_cookinfo表中和menuId有关的所有内容
	 * @param menuId
	 * @return
	 */
	public boolean delMenuCookByMenuId(Integer menuId){
		SQLQuery q = session.createSQLQuery("DELETE FROM t_menu_cookinfo WHERE menuinfo_id = ? ");
		q.setInteger(0, menuId);
		try {
			if(q.executeUpdate()!=0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据menutypeId来查找menutypename
	 * @param userHeat
	 * @return
	 */
	public String getMenutype(Integer menutypeId) {
		SQLQuery q = session.createSQLQuery("select menutype_desc from t_menutype where menutype_id = ?");
		q.setInteger(0,menutypeId);
		return (String) q.uniqueResult();
	}
	/**
	 * 列出所有t_menutype内容
	 * @return
	 */
	public List<Object[]> listMenutype() {
		return session.createSQLQuery("select * from t_menutype").list();
	}
	/**
	 * 得到所有未删除的菜品信息
	 * @return
	 */
	public List<TMenuinfo> getMenuInfoList() {
		return session.createSQLQuery("select * from t_menuinfo t where t.menuinfo_status = ?").addEntity(TMenuinfo.class).setInteger(0, 1).list();
	}
}
