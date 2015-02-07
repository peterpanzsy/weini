package com.weini.manage.business;


import java.util.ArrayList;
import java.util.List;

import com.weini.manage.dao.AddressDao;
import com.weini.manage.dao.DispatchingDao;
import com.weini.manage.entity.TDispatching;
import com.weini.tools.HibernateSessionManager;

public class DispatchingService extends GeneralService{
	
	private DispatchingDao disDao =new DispatchingDao(this.session);;
	private AddressDao addDao = new AddressDao(this.session);
	
	public DispatchingService() {
		super();
	}


	public boolean addDistaching(Integer dispatchingProvince,
			Integer dispatchingCity, Integer dispatchingDistrict,
			Integer dispatchingBusinessAreaid,
			Integer dispatchingOfficeBuilding, String dispatchingAddressDetail,
			Integer userId, String dispatchingPhoneNum) {
		HibernateSessionManager.getThreadLocalTransaction();
		TDispatching temp = new TDispatching(dispatchingProvince, dispatchingCity, dispatchingDistrict,
				dispatchingBusinessAreaid, dispatchingOfficeBuilding,dispatchingAddressDetail,userId,dispatchingPhoneNum);
		System.out.println(temp.toString());
		boolean flag = disDao.addDispatching(temp);
		this.close();
		return flag;
	}


	public List<TDispatching> findDispatchingByUserId(Integer userId) {
		List<TDispatching> res = null;
		try{
			res =disDao.findDispatchingByUserId(userId);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	
}
