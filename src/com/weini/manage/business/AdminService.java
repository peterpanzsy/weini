package com.weini.manage.business;

import java.util.List;

import com.weini.manage.business.GeneralService;
import com.weini.manage.dao.AdminDao;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.tools.HibernateSessionManager;

public class AdminService extends GeneralService{
	private AdminDao admindao  = new AdminDao(this.session);
	
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
	public List<TAdmin> getAdminList(int roleid){
		List<TAdmin> res = null;
		try{
			res = this.admindao.getAdminList(roleid);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public boolean updateAuthByRole(int roleid,String auth,String aflag){
		HibernateSessionManager.getThreadLocalTransaction();
		boolean flag = false;
		try{
			int res = this.admindao.updateAuthByRole(roleid, auth, aflag);
			if(res > 0){
				this.close();
				flag = true;
			}else{
				this.roll();
			}
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
		}
		return flag;
	}
	public boolean updateAdmin(int adminID, String adminName,String adminPass,int roleid,String mark){
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		try{
			int res = this.admindao.updateAdmin(adminID, adminName, adminPass,roleid, mark);
			if(res > 0){
				this.close();
				flag = true;
			}else{
				this.roll();
			}
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
		}
		return flag;
	}
	public boolean delAdmin(int adminID){
		HibernateSessionManager.getThreadLocalTransaction();
		boolean flag = false;
		try{
			int res = this.admindao.delAdmin(adminID);
			if(res > 0){
				this.close();
				flag = true;
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
