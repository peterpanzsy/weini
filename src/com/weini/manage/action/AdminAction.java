package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.AdminService;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
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
	List<TAdmin> dataList;
	List<TAuth> authList;
	String result;
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

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
	
	public String listAuthByRole(){//根据角色获取权限列表		
		authList=(new AdminService()).getAuthbyRoleList(getRoleid(role));
		return "SUCCESS";
	}
	public String updateAuthByRole(){//更新角色的权限列表	
		(new AdminService()).updateAuthByRole(getRoleid(role),auth,aflag);
		return "SUCCESS";
	}
	public String listAdmin(){//根据角色获取账户列表		
		dataList=(new AdminService()).getAdminList(getRoleid(role));
		return "SUCCESS";
	}

	public String updateAdmin(){//更新或者添加账户
		this.result = "false";
		if(this.adminPassword.equals(confirmPassword)){
			String adminPassword_md5 = CipherUtil.generatePassword(adminPassword);  
			if((new AdminService()).updateAdmin(adminID,adminName,adminPassword_md5,getRoleid(role),mark)){
				this.result = "true";
			}
		}
		return "SUCCESS";
	}
	public String delAdmin(){//删除账户		
		(new AdminService()).delAdmin(id);
		return "SUCCESS";
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<TAdmin> getDataList() {
		return dataList;
	}

	public void setDataList(List<TAdmin> dataList) {
		this.dataList = dataList;
	}

	public List<TAuth> getAuthList() {
		return authList;
	}

	public void setAuthList(List<TAuth> authList) {
		this.authList = authList;
	}
	
	
}
