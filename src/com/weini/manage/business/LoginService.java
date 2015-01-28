package com.weini.manage.business;

import java.util.ArrayList;
import java.util.List;

import com.weini.manage.business.GeneralServive;
import com.weini.manage.dao.AdminDao;
import com.weini.manage.dao.UserDao;
import com.weini.manage.dao.VendorDao;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TVendor;

public class LoginService extends GeneralServive{
	private AdminDao admindao  = new AdminDao(this.session);
	private UserDao userdao = new UserDao(this.session);
	private VendorDao vendao = new VendorDao(this.session);
	
	public TAdmin searchAdmin(String username,String pass){
		TAdmin res = this.admindao.searchAdmin(username, pass);
		this.close();
		return res;
	}
	public List<TAuth> getAuthbyRoleList(int roleid){
		List<TAuth> res = this.admindao.getAuthbyRoleList(roleid);
		this.close();
		return res;
	}
	public TUser searchUser(String username,String pass){
		TUser res = this.userdao.searchUser(username, pass);
		this.close();
		return res;
	}
	public TVendor searchVendor(String username,String pass){
		TVendor res = this.vendao.searchVendor(username, pass);
		this.close();
		return res;
	}
	
}
