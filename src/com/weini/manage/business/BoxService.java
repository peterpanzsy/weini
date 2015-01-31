package com.weini.manage.business;

import java.util.List;

import com.weini.manage.business.GeneralService;
import com.weini.manage.dao.AdminDao;
import com.weini.manage.dao.BoxDao;
import com.weini.manage.dao.BoxpageDao;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.tools.HibernateSessionManager;

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
	public List listBox() {
		List list = boxDao.listBox();
		this.close();
		return list;
	}
	
	
}
