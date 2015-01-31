package com.weini.manage.business;

import java.util.List;

import com.weini.manage.business.GeneralServive;
import com.weini.manage.dao.AdminDao;
import com.weini.manage.dao.BoxDao;
import com.weini.manage.dao.BoxpageDao;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.tools.HibernateSessionManager;

public class BoxService extends GeneralServive{
	
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
		return boxpageDao.listBoxpage();
	}
	/**
	 *列出所有的盒子模型 
	 * @return
	 */
	public List listBox() {
		return boxDao.listBox();
	}
	
	
}
