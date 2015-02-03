package com.weini.manage.dao;

import java.util.List;

import org.hibernate.Session;

import com.weini.manage.entity.TBoxpage;

/**
 * 和文案有关的内容
 * @author wpr
 * 
 */
public class BoxpageDao {
	protected Session session;

	public BoxpageDao(Session sess) {
		this.session = sess;
	}

	/**
	 * 查询所有的盒子模式的文案列表
	 * 
	 * @return
	 */
	public List<Object[]> listBoxpage() {
//		SQLQuery q;
//		q = session.createSQLQuery("SELECT boxpage_id,boxpage_title,boxpage_tiptext,boxpage_oneText,boxpage_onedesctext,boxpage_threetext,"
//				+ "boxpage_threedesctext,boxpage_fiveboxtext,boxpage_fivedesctext "
//				+ "FROM t_boxpage ");
//		List l = q.list();
//		List<TBoxpage> re = new ArrayList<TBoxpage>();
//		for (int i = 0; i < l.size(); i++) {
//			Object[] row = (Object[]) l.get(i);
//			TBoxpage boxpage = new TBoxpage();
//			boxpage.setBoxpageId((Integer)row[0]);
//			boxpage.setBoxpageTitle((String)row[1]);
//			boxpage.setBoxpageTiptext((String)row[2]);
//			boxpage.setBoxpageOneText((String)row[3]);
//			boxpage.setBoxpageOnedesctext((String)row[4]);
//			boxpage.setBoxpageThreetext((String)row[5]);
//			boxpage.setBoxpageThreedesctext((String)row[6]);
//			boxpage.setBoxpageFiveboxtext((String)row[7]);
//			boxpage.setBoxpageFivedesctext((String)row[8]);
//			re.add(boxpage);
//		}
//		return re;
//		return session.createSQLQuery("select * from t_boxpage").addEntity(TBoxpage.class).list();
		return session.createSQLQuery("select * from t_boxpage").list();
	}
	/**
	 * 	添加文案
	 * @param boxpage
	 * @return
	 * 			true:添加成功
	 * 			false:添加失败
	 */
	
	public Boolean addBoxpage(TBoxpage boxpage){
		try {
			session.save(boxpage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 更新文案
	 * @param boxpage
	 * @return
	 *			true:更新成功
	 * 			false:更新失败
	 */
	public Boolean updateBoxpage(TBoxpage boxpage){
		try {
			session.update(boxpage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 删除文案
	 * @param boxpage
	 * @return
	 * 			true:删除成功
	 * 			false:删除失败
	 */
	public Boolean delBoxpage(TBoxpage boxpage){
		try {
			session.delete(boxpage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
