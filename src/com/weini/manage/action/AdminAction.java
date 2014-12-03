package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.Admin;
import com.weini.manage.business.Auth;
import com.weini.manage.dao.AdminDao;
import com.weini.tools.CipherUtil;


public class AdminAction extends ActionSupport{
	int adminID;
	String adminName;
	String adminPassword;
	String confirmPassword;
	String mark;
	int id;
	String role;
	String auth;
	String aflag;//权限标识
	List<Admin> dataList;
	List<Auth> authList;
	

	public int getRoleid(String role){
		int roleid=0;
		if(role.equals("root")){
			roleid=1;
		}else if(role.equals("finance")){
			roleid=2;
		}else if(role.equals("good")){
			roleid=3;
		}else if(role.equals("ordinary")){
			roleid=4;
		}
		return roleid;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAflag() {
		return aflag;
	}
	public void setAflag(String aflag) {
		this.aflag = aflag;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public List<Auth> getAuthList() {
		return authList;
	}
	public void setAuthList(List<Auth> authList) {
		this.authList = authList;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Admin> getDataList() {
		return dataList;
	}
	public void setDataList(List<Admin> dataList) {
		this.dataList = dataList;
	}
	
	public String listAuthByRole(){//根据角色获取权限列表		
		AdminDao dao=new AdminDao();
		authList=dao.getAuthbyRoleList(getRoleid(role));
		dao.close();
		return "SUCCESS";
	}
	public String updateAuthByRole(){//更新角色的权限列表	
		AdminDao dao=new AdminDao();
		int res=dao.updateAuthByRole(getRoleid(role),auth,aflag);
		dao.close();
		return "SUCCESS";
	}
	public String listAdmin(){//根据角色获取账户列表		
		AdminDao dao=new AdminDao();
		dataList=dao.getAdminList(getRoleid(role));
		dao.close();
		return "SUCCESS";
	}
	public String updateAdmin(){//更新或者添加账户 
		String adminPassword_md5 = CipherUtil.generatePassword(adminPassword);  
		String confirmPassword_md5 = CipherUtil.generatePassword(confirmPassword);  
		AdminDao dao=new AdminDao();
		int res=dao.updateAdmin(adminID,adminName,adminPassword_md5,confirmPassword_md5,getRoleid(role),mark);
		dao.close();
		return "SUCCESS";
	}
	public String delAdmin(){//删除账户		
		AdminDao dao=new AdminDao();
		dao.delAdmin(id);
		dao.close();
		return "SUCCESS";
	}
	
	
}
