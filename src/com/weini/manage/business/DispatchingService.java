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


	public List<DispatchingAddress> findDispatchingByUserId(Integer userId) {
		List<DispatchingAddress> res = new ArrayList<DispatchingAddress>();
		try{
			List<TDispatching> tdis =disDao.findDispatchingByUserId(userId);
			if(tdis != null && tdis.size() > 0){
				for(int i = 0;i < tdis.size(); i++){
					DispatchingAddress temp = new DispatchingAddress();
					TDispatching tdistemp = tdis.get(i);
					temp.setDispatchingId(tdistemp.getDispatchingId());
					temp.setDispatchingProvince(this.addDao.findProvince(tdistemp.getDispatchingProvince()));
					temp.setDispatchingCity(this.addDao.findCity(tdistemp.getDispatchingCity()));
					temp.setDispatchingDistrict(this.addDao.findDistrict(tdistemp.getDispatchingDistrict()));
					temp.setDispatchingBusinessAreaid(this.addDao.findBusiness(tdistemp.getDispatchingBusinessAreaid()));
					temp.setDispatchingOfficeBuilding(this.addDao.findOffice(tdistemp.getDispatchingOfficeBuilding()));
					temp.setDispatchingAddressDetail(tdistemp.getDispatchingAddressDetail());
					temp.setDispatchingPhoneNum(tdistemp.getDispatchingPhoneNum());
					res.add(temp);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	
}
