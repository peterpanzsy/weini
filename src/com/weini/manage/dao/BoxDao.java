package com.weini.manage.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.weini.manage.entity.TBox;

public class BoxDao {
	
	protected  Session session ;
	
	public BoxDao(Session sess) {
		this.session = sess;
	}
	/**
	 * 返回所有的盒子模式
	 * @return
	 */
	public List<TBox>  listBox() {
		return  session.createSQLQuery("select * from t_box").addEntity(TBox.class).list();
//		return  session.createSQLQuery("select * from t_box").list();
	}
	/**
	 * 	添加盒子模式
	 * @param box
	 * @return
	 * 			true:添加成功
	 * 			false:添加失败
	 */
	public Boolean addBox(TBox box){
		try {
			session.save(box);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 更新盒子
	 * @param box
	 * @return
	 *			true:更新成功
	 * 			false:更新失败
	 */
	public Boolean updateBox(TBox box){
		try {
			session.update(box);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 删除盒子
	 * @param box
	 * @return
	 * 			true:删除成功
	 * 			false:删除失败
	 */
	public Boolean delBox(TBox box){
		try {
			session.delete(box);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
