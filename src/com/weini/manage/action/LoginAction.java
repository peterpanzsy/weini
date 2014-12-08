package com.weini.manage.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.Admin;
import com.weini.manage.business.Auth;
import com.weini.manage.dao.AdminDao;
import com.weini.tools.CipherUtil;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 6382054055046543790L;
	String  username;
	String password;
	String flag;
	AdminDao adminDao;
    Admin admin;
    List<Auth> authList;
    
    
	public List<Auth> getAuthList() {
		return authList;
	}
	public void setAuthList(List<Auth> authList) {
		this.authList = authList;
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String login()   {
		
		Admin admin=new Admin();
		//add by zsy to log remote access ip
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String remoteip=request.getRemoteHost();
//		============================================================
		username = "root";
		password = "root";
		//TODO 注释为了方便测试
		//above add by zsy to log remote access ip		
//		if(username==null||username.equals("")){
//	        ActionContext actionContext = ActionContext.getContext();
//	        Map session = actionContext.getSession();
//	        session.put("wrong", "用户名为空");	
//			return "fail";
//		}
//		if(password==null||password.equals("")){
//	        ActionContext actionContext = ActionContext.getContext();
//	        Map session = actionContext.getSession();
//	        session.put("wrong", "密码为空");	
//			return "fail";
//		}
//		===========================================================
//		===========================================================
//		TODO 注释为了方便测试
//		String adminPassword_md5 = CipherUtil.generatePassword(password); 
		String adminPassword_md5 = password;
//		===========================================================
		
		adminDao=new AdminDao();
		admin=adminDao.searchAdmin(username, adminPassword_md5);
		if(admin==null){
	        ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("wrong", "帐户或者密码错误，或者您的账号正在审核中。");	
			return "fail";
		}
		authList=adminDao.getAuthbyRoleList(admin.getRoleID());
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("user", admin);
        session.put("authList", authList);
        adminDao.close();
		return "succ";
	}
	public String logout(){
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.remove("user");
        session.remove("authList");
        flag="true";
		return SUCCESS;
	}
	
}
