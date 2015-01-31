package com.weini.manage.business;

import java.util.List;

import com.weini.manage.business.GeneralServive;
import com.weini.manage.dao.AdminDao;
import com.weini.manage.dao.BoxDao;
import com.weini.manage.dao.BoxpageDao;
import com.weini.manage.dao.MenuDao;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.manage.entity.TMenuinfo;
import com.weini.tools.HibernateSessionManager;

public class MenuService extends GeneralServive{
	
	private MenuDao menuDao = new MenuDao(this.session);
	
	public MenuService() {
		super();
	}

	public TMenuinfo findMenuById(Integer menuinfoId) {
		TMenuinfo menu= menuDao.findMenuDetailByMenuID(menuinfoId);
		if(menu==null){
			return null;               //没有记录
		}else{
			menu.setDishesList(menuDao.findAllDishByMenuinfoId(menuinfoId));   //设置子菜品
			return menu;
		}
	}
	
	
	
}
