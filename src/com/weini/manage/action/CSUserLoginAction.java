package com.weini.manage.action;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.User;
import com.weini.manage.dao.UserDao;

public class CSUserLoginAction extends ActionSupport{
	private String phoneNumber;
	private String password;
	private String result;
	private User u;
	
	public String login(){
		if(phoneNumber==null||phoneNumber.equals("")){
			result = "用户名不能为空";
			return "FAIL";
		}
		if(password==null||password.equals("")){
			result = "密码不可为空";
			return "FAIL";
		}
		UserDao dao = new UserDao();
		u = dao.searchUser(phoneNumber, password);
		dao.close();
		if(u == null){
			result = "手机号或密码不正确";
			return "FAIL";
		}
		result = "登录成功";
		System.out.println("这里执行了");
		System.out.println(u.getUserName());
		return "LOGINSUCCESS";
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}

}
