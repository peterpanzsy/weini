package com.weini.manage.business;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.weini.manage.business.GeneralService;
import com.weini.manage.dao.AdminDao;
import com.weini.manage.dao.UserDao;
import com.weini.manage.dao.VendorDao;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TUserextra;
import com.weini.manage.entity.TVendor;
import com.weini.tools.HibernateSessionManager;
import com.weini.tools.SMSUtil;

public class LoginService extends GeneralService{
	private AdminDao admindao  = new AdminDao(this.session);
	private UserDao userdao = new UserDao(this.session);
	private VendorDao vendao = new VendorDao(this.session);
	
	public TAdmin searchAdmin(String username,String pass){
		TAdmin res = null;
			try{
				res = this.admindao.searchAdmin(username, pass);
			}catch(Exception e){
				e.printStackTrace();
			}
		this.close();
		return res;
	}
	public List<TAuth> getAuthbyRoleList(int roleid){
		List<TAuth> res = null;
		try{
			res = this.admindao.getAuthbyRoleList(roleid);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public TUser searchUser(String username,String pass){
		TUser res = null;
		try{
			res = this.userdao.searchUser(username, pass);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public TVendor searchVendor(String username,String pass){
		TVendor res = null;
		try{
			res = this.vendao.searchVendor(username, pass);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	/**
	 * 发送手机验证码的业务逻辑，
	 * @param phoneNum 发送的手机号码
	 * @return	发送成功的话，返回发送的验证码；发送失败的话，返回null
	 */
	public int sendCode(String phoneNum) {
		int mobile_code = (int)((Math.random()*9+1)*100000);
		int temp = mobile_code;
		boolean result = SMSUtil.sendMsg(phoneNum, mobile_code);
		if(!result){
			temp=-1;
		}
		this.close();
		return temp;
	}
	/**
	 * 已注册的用户登录
	 * @param phoneNum 
	 * @return
	 */
	public TUser findReguserLogin(String phoneNum) {
		TUser user ;
		if(!phoneMatch(phoneNum)){
			user = null;
		}else{
			try {
				user = userdao.searchUser(phoneNum);
			} catch (Exception e) {
				this.roll();
				user = null;
				e.printStackTrace();
			}
		}
		this.close();
		return user;
	}
	/**
	 * 手机号码验证
	 * @param phoneNum 手机号
	 * @return  验证成功返回true，否则返回flase
	 */
	private boolean phoneMatch(String phoneNum){
	    Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");      
		Matcher m = p.matcher(phoneNum);  
		return m.find();  
	}
	/**
	 * 新用户注册
	 * @param phoneNum 手机号
	 * @param password 密码
	 * @return 0-注册失败 ，1-注册成功,2-用户已注册
	 */
	public int userRegist(String phoneNum, String password) {
		HibernateSessionManager.getThreadLocalTransaction();
		TUser user = null;
		int flag = 0;
		if(phoneMatch(phoneNum)){
			try {
				user = userdao.searchUser(phoneNum);
				if(user==null){
					//增加用户
					user = new TUser();
					user.setUserPhoneNumber(phoneNum);
					user.setUserPwd(password);
					user.setUserName("味你新用户");
					user.setUserRegdate(new Date());
					if(userdao.addUser(user)){
						flag = 1;
						this.close();
						return flag;
					}
				}else{
					flag = 2;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.roll();
		flag = 0 ;
		return flag;
	}
	/**
	 * 用户修改密码
	 * @param phoneNum 手机号
	 * @param password 密码
	 * @return 0-修改失败 ，1-修改成功,2-用户未注册
	 */
	public int userChangePassword(String phoneNum, String password) {
		HibernateSessionManager.getThreadLocalTransaction();
		TUser user = null;
		int flag = 0;
		if(phoneMatch(phoneNum)){
			try {
				user = userdao.searchUser(phoneNum);
				if(user!=null){
					user.setUserPwd(password);
					if(userdao.updateUser(user)){
						flag = 1;
					}else{
						flag = 0;
					}
				}else{
					flag = 2;
				}
			} catch (Exception e) {
				flag = 0;
				this.roll();
				e.printStackTrace();
			}
		}
		this.close();
		return 0;
	}
	public boolean insertUserExtra(TUserextra uextra){
		HibernateSessionManager.getThreadLocalTransaction();
		boolean flag = false;
		try{
			if(this.userdao.addUserextra(uextra)){
				flag = true;
				this.close();
				return flag;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		this.roll();
		return flag;
	}
}
