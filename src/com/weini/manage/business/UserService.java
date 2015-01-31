package com.weini.manage.business;

import java.util.List;

import com.weini.manage.business.GeneralService;
import com.weini.manage.dao.AddressDao;
import com.weini.manage.dao.UserDao;
import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TProvince;
import com.weini.tools.HibernateSessionManager;

public class UserService extends GeneralService{
	private UserDao userdao  = new UserDao(this.session);
	/**
	 * 更新用户的忌口和饭量信息
	 * @param userID 用户id
	 * @param heatID 用户忌口id
	 * @param appeID 用户饭量
	 * @return 执行结果
	 */
	public boolean updateUserHeatandAppe(int userID,int heatID,int appeID){
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		try{
			int res = this.userdao.updateUserHeatAndAppe(userID, heatID, appeID);
			if(res > 0){
				flag = true;
				this.close();
			}else{
				this.roll();
			}
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
		}
		return flag;
	}
}
