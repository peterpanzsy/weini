package com.weini.manage.business;

import java.util.ArrayList;
import java.util.List;

import com.weini.manage.business.GeneralService;
import com.weini.manage.dao.BoxDao;
import com.weini.manage.dao.BoxpageDao;
import com.weini.manage.entity.TBox;

public class BoxService extends GeneralService{
	
	private BoxDao boxDao = new BoxDao(this.session);
	private BoxpageDao boxpageDao = new BoxpageDao(this.session);
	
	public BoxService() {
		super();
	}
	
	/**
	 * 获取所有文案
	 * @return
	 */
	public List listBoxpage() {
		List list =boxpageDao.listBoxpage();
		this.close();
		return list;
	}
	/**
	 *列出所有的盒子模型 
	 * @return
	 */
	public List<TBox> listBox() {
//		List l = new ArrayList<>();
		List<TBox> list = boxDao.listBox();
//		
//		for(TBox b:list){
//			Object[] temp = new Object[];
//			temp[0] = b.getBoxId() 
//		}
		this.close();
		return list;
	}
	
	
}
