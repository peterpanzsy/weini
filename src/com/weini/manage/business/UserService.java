package com.weini.manage.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.weini.manage.dao.MenuDao;
import com.weini.manage.dao.UserDao;
import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TUserextra;
import com.weini.tools.HibernateSessionManager;
import com.weini.tools.SMSUtil;
import com.weini.tools.TwoEntity;

public class UserService extends GeneralService{
	private UserDao userdao  = new UserDao(this.session);
	private MenuDao menudao = new MenuDao(this.session);
	/**
	 * 根据用户Id来查找用户的信息
	 * @param userId
	 * @return  TwoEntity 由2个对象组成 TUser，TUserextra 
	 */
	public TwoEntity findUserInfo(int userId) {
		HibernateSessionManager.getThreadLocalTransaction();
		TwoEntity two = null;
		try {
			TUser user = userdao.findByUserID(userId);
			if(user != null && (user.getUserRegdate()!=null)){
				try {
					user.setCountDays(daysBetween(user.getUserRegdate(),new Date()));
					if(user.getUserHeat() != -1 && user.getUserHeat()!=null){
						user.setNotEat(menudao.getMenutype(user.getUserHeat()));
					}
				} catch (Exception e) {
					user.setCountDays(0);
				}
				TUserextra userextra = userdao.findUserextraByUserId(user);
				two = new TwoEntity(user,userextra);
				this.close();
				return two;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.roll();
		return two;
	}
	/**
	 * 修改用户个人信息
	 * @param user  用户
	 * @return  成功返回1，失败返回0
	 */
	public int updateUser(TUser user) {
		HibernateSessionManager.getThreadLocalTransaction();
		try {
			if(userdao.updateUser(user)){
				//更新成功
				this.close();
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.roll();
		return 0;
	}   
	/**
	 * 修改用户的生日
	 * @param userId
	 * @param userBirthday
	 * @return
	 */
	public int updateUserBirthday(Integer userId, Date userBirthday) {
		HibernateSessionManager.getThreadLocalTransaction();
		try {
			TUser user = userdao.findByUserID(userId);
			if(user != null){
				TUserextra userextra = userdao.findUserextraByUserId(user);
				if(userextra == null){
					userextra = new TUserextra();
					userextra.setUserId(userId);
				}
				userextra.setUserextraBirthday(userBirthday);
				if(userdao.updateUserextra(userextra)){
					//更新成功
					this.close();
					return 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.roll();
		return 0;
		
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
   public boolean updateUserName(int userID,String name){
	   HibernateSessionManager.getThreadLocalTransaction();
	   try{
		   if(this.userdao.updateUserName(userID,name) > 0){
			   this.close();
			   return true;
		   }
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   this.roll();
	   return false;
   }
	
}
