package com.weini.manage.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.weini.manage.dao.UserDao;
import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TUserextra;
import com.weini.tools.HibernateSessionManager;
import com.weini.tools.TwoEntity;

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
	/**
	 * 根据用户Id来查找用户的信息
	 * @param userId
	 * @return  TwoEntity 由2个对象组成 TUser，TUserextra 
	 */
	public TwoEntity findUserInfo(int userId) {
		TUser user = userdao.findByUserID(userId);
		if(user.getUserRegdate()!=null){
			try {
				user.setCountDays(daysBetween(user.getUserRegdate(),new Date()));
			} catch (Exception e) {
				user.setCountDays(0);
			}
		}
		TUserextra userextra = userdao.findUserextraByUserId(user);
		TwoEntity two = new TwoEntity(user,userextra);
		return two;
	}
	  /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
	 * @throws java.text.ParseException 
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException, java.text.ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
        return Integer.parseInt(String.valueOf(between_days));           
    }    
	
}
