package com.weini.manage.business;


import java.util.ArrayList;
import java.util.List;

import com.weini.manage.dao.AddressDao;
import com.weini.manage.dao.DispatchingDao;
import com.weini.manage.entity.DispatchingAddress;
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


	public List findDispatchingByUserId(Integer userId) {
		HibernateSessionManager.getThreadLocalTransaction();
		List l =disDao.findDispatchingByUserId(userId);
		List<Object[]> re = new ArrayList<>();
		for(int i=0;i<l.size();i++){
			TDispatching d =(TDispatching) l.get(i);
//			DispatchingAddress add = new DispatchingAddress();
//			add.setDispatchingId(d.getDispatchingId());
//			add.setDispatchingProvince(addDao.findProvince(d.getDispatchingProvince()));
//			add.setDispatchingCity(addDao.findCity(d.getDispatchingCity()));
//			add.setDispatchingDistrict(addDao.findDistrict(d.getDispatchingDistrict()));
//			add.setDispatchingBusinessAreaid(addDao.findBusiness(d.getDispatchingBusinessAreaid()));
//			add.setDispatchingOfficeBuilding(addDao.findOffice(d.getDispatchingOfficeBuilding()));
//			add.setDispatchingPhoneNum(d.getDispatchingPhoneNum());
//			add.setDispatchingAddressDetail(d.getDispatchingAddressDetail());
//			System.out.println(add.toString());
			Object[] row = new Object[8];
			row[0]=d.getDispatchingId();
			row[1]=addDao.findProvince(d.getDispatchingProvince());
			row[2]=addDao.findCity(d.getDispatchingCity());
			row[3]=addDao.findDistrict(d.getDispatchingDistrict());
			row[4]=addDao.findBusiness(d.getDispatchingBusinessAreaid());
			row[5]=addDao.findOffice(d.getDispatchingOfficeBuilding());
			row[6]=d.getDispatchingAddressDetail();
			row[7]=d.getDispatchingPhoneNum();
			re.add(row);
		}
		this.close();
		return re;
	}
	
}
