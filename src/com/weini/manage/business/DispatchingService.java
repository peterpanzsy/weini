package com.weini.manage.business;


import java.util.ArrayList;
import java.util.List;

import com.weini.manage.dao.AddressDao;
import com.weini.manage.dao.DispatchingDao;
import com.weini.manage.dao.UserDao;
import com.weini.manage.entity.DispatchingAddress;
import com.weini.manage.entity.TDispatching;
import com.weini.tools.HibernateSessionManager;

public class DispatchingService extends GeneralService{
	
	private DispatchingDao disDao =new DispatchingDao(this.session);;
	private AddressDao addDao = new AddressDao(this.session);
	private UserDao userDao = new UserDao(this.session);
	
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
	public boolean updateDistaching(int dispatchingId,Integer dispatchingProvince,
			Integer dispatchingCity, Integer dispatchingDistrict,
			Integer dispatchingBusinessAreaid,
			Integer dispatchingOfficeBuilding, String dispatchingAddressDetail,
			Integer userId, String dispatchingPhoneNum) {
		HibernateSessionManager.getThreadLocalTransaction();
		TDispatching temp = new TDispatching(dispatchingProvince, dispatchingCity, dispatchingDistrict,
				dispatchingBusinessAreaid, dispatchingOfficeBuilding,dispatchingAddressDetail,userId,dispatchingPhoneNum);
		temp.setDispatchingId(dispatchingId);
		boolean flag = disDao.updateDispatching(temp);
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
	/**
	 * 根据地址id获取地址的详细信息
	 * @param disId 地址id 
	 * @return
	 */
	public DispatchingAddress findDispatchingByDisId(int disId) {
		DispatchingAddress res = null;
		try{
			TDispatching tdis =disDao.findDispatchingById(disId);
			if(tdis != null){
				res = new DispatchingAddress();
				res.setDispatchingId(tdis.getDispatchingId());
				res.setDispatchingProvince(this.addDao.findProvince(tdis.getDispatchingProvince()));
				res.setDispatchingCity(this.addDao.findCity(tdis.getDispatchingCity()));
				res.setDispatchingDistrict(this.addDao.findDistrict(tdis.getDispatchingDistrict()));
				res.setDispatchingBusinessAreaid(this.addDao.findBusiness(tdis.getDispatchingBusinessAreaid()));
				res.setDispatchingOfficeBuilding(this.addDao.findOffice(tdis.getDispatchingOfficeBuilding()));
				res.setDispatchingAddressDetail(tdis.getDispatchingAddressDetail());
				res.setDispatchingPhoneNum(tdis.getDispatchingPhoneNum());
			}
		}catch(Exception e){
			e.printStackTrace();
			res = null;
		}
		this.close();
		return res;
	}
	/**
	 * 删除订餐地址
	 * @param disId 地址id
	 * @return 执行结果
	 */
	public boolean delDispatching(int disId){
		HibernateSessionManager.getThreadLocalTransaction();
		boolean flag = false;
		try{
			flag = this.disDao.delDispatching(disId);
			this.close();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
			flag = false;
		}
		return flag;
	}
	/**
	 * 修改用户的默认订餐地址
	 * @param disId 地址id
	 * @param userId 用户id
	 * @return 执行结果
	 */
	public boolean setUserDefaultDispatching(int disId,int userId){
		HibernateSessionManager.getThreadLocalTransaction();
		boolean flag = false;
		try{
			if(this.userDao.updateUserDefaultDispatchingId(userId, disId) > 0){
				this.close();
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
			flag = false;
		}
		return flag;
	}
	
}
