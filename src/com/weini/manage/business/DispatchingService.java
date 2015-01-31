package com.weini.manage.business;


import com.weini.manage.business.GeneralServive;
import com.weini.manage.dao.DispatchingDao;
import com.weini.manage.entity.TDispatching;

public class DispatchingService extends GeneralServive{
	
	private DispatchingDao disDao = new DispatchingDao(this.session);
	
	public DispatchingService() {
		super();
	}

	public boolean addDistaching(TDispatching temp) {
		return disDao.updateDispatching(temp);
	}
	
	
	
}
