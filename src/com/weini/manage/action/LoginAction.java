package com.weini.manage.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.manage.entity.TVendor;
import com.weini.manage.business.LoginService;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 6382054055046543790L;
	String  username;
	String password;
	String flag;
//    TAdmin admin;
//    List<TAuth> authList;
    /**
     * 管理员登录
     * @return
     */
	public String adminLogin()   {
		TAdmin admin=new TAdmin();
		//add by zsy to log remote access ip
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String remoteip=request.getRemoteHost();
		//above add by zsy to log remote access ip
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		if(username==null||username.equals("")){
	        session.put("wrong", "用户名为空");	
			return "fail";
		}
		if(password==null||password.equals("")){
	        session.put("wrong", "密码为空");	
			return "fail";
		}
//		String adminPassword_md5 = CipherUtil.generatePassword(password);
		String adminPassword_md5 = password;
		admin=(new LoginService()).searchAdmin(username, adminPassword_md5);
		if(admin==null){
	        session.put("wrong", "帐户或者密码错误，或者您的账号正在审核中。");	
			return "fail";
		}
		List<TAuth> authList=(new LoginService()).getAuthbyRoleList(admin.getRoleID());
        session.put("user", admin);
        session.put("authList", authList);
		return "succ";
	}
	/**
	 * 管理员登出
	 * @return
	 */
	public String adminLogout(){
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.remove("user");
        session.remove("authList");
        flag="true";
		return SUCCESS;
	}
	/**
	 * 普通用户登录
	 * @return
	 */
////	TODO 还没有进行修改，需和前台商量
//	public String userLogin()   {
//		//add by zsy to log remote access ip
//		HttpServletRequest request = ServletActionContext.getRequest(); 
//		String remoteip=request.getRemoteHost();
//		//above add by zsy to log remote access ip
//		ActionContext actionContext = ActionContext.getContext();
//        Map session = actionContext.getSession();
//		if(username==null||username.equals("")){
//	        session.put("wrong", "用户名为空");	
//			return "fail";
//		}
//		if(password==null||password.equals("")){
//	        session.put("wrong", "密码为空");	
//			return "fail";
//		}
////		String adminPassword_md5 = CipherUtil.generatePassword(password);
//		String adminPassword_md5 = password;
//		TUser user = new TUser();
//		user=(new LoginService()).searchUser(username, adminPassword_md5);
//		if(user==null){
//	        session.put("wrong", "帐户或者密码错误，或者您的账号正在审核中。");	
//			return "FAIL";
//		}
//        session.put("user", user);
//		return "SUCCESS";
//	}
	/**
	 * 普通用户登出
	 * @return
	 */
	public String userlogout(){
		return "SUCCESS";
	}
	public String vendorlogin(){
		this.username = "pl";
		this.password = "123";
		//add by zsy to log remote access ip
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String remoteip=request.getRemoteHost();
		//above add by zsy to log remote access ip
		 ActionContext actionContext = ActionContext.getContext();
	     Map session = actionContext.getSession();
		if(username==null||username.equals("")){
	        session.put("wrong", "用户名为空");	
			return "fail";
		}
		if(password==null||password.equals("")){
	        session.put("wrong", "密码为空");	
			return "fail";
		}
//		String adminPassword_md5 = CipherUtil.generatePassword(password);
		String adminPassword_md5 = password;
		TVendor vendor = new TVendor();
		vendor=(new LoginService()).searchVendor(username, adminPassword_md5);
		if(vendor==null){
	        session.put("wrong", "帐户或者密码错误，或者您的账号正在审核中。");	
			return "fail";
		}
        session.put("user", vendor);
		return "SUCCESS";
	}
	/**
	 * 商家登出
	 * @return
	 */
	public String vendorLogout(){
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.remove("user");
        flag="true";
		return "SUCCESS";
	}
	
	/**
	 * 获取手机验证码
	 * @return
	 */
	public String getPhoneVeriCode(){
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	
}
