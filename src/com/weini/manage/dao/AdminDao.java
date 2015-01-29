package com.weini.manage.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.tools.HibernateSessionManager;


public class AdminDao  {
	 
	 protected Session session ;
	 public AdminDao(Session sess){
		 this.session = sess;
	 }
	 public List<TAuth> getAuthbyRoleList(int roleid) {//根据角色获取权限列表
		SQLQuery q;
		q = session.createSQLQuery("select t.role_authority_authorityid,t2.authority_name from t_role_authority t,t_authority t2 where t.role_authority_authorityid=t2.authority_id and t.role_authority_roleid=?");
		q.setParameter(0, roleid);
		List l = q.list();
		List<TAuth> re=new ArrayList<TAuth>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  Integer aid = (Integer)row[0];
			  String aName = (String)row[1];  
			  TAuth auth=new TAuth(aid, aName); 
			  re.add(auth);
		}
		return re;
	}
	
	public int updateAuthByRole(int roleid,String auth,String aflag){//添加或删除角色的权限
		int authid=0;
		if(auth.equals("orderCheck")){
			authid=1;
		}else if(auth.equals("goodCheck")){
			authid=2;
		}else if(auth.equals("vendorCheck")){
			authid=3;
		}else if(auth.equals("userCheck")){
			authid=4;
		}else if(auth.equals("adminCheck")){
			authid=5;
		}else if(auth.equals("reportCheck")){
			authid=6;
		}
		Query q = null;
		switch(aflag){
			case "add":
				q = session.createSQLQuery("insert into t_role_authority(role_authority_roleid,role_authority_authorityid) values (?,?)");
				break;
			case "delete":
				q = session.createSQLQuery("delete from t_role_authority where role_authority_roleid=? and role_authority_authorityid=?");
				break;
		}
		q.setParameter(0, roleid);
		q.setParameter(1, authid);
		return q.executeUpdate();
	}
	
	public List<TAdmin> getAdminList(int roleid) {//获取账户列表
		SQLQuery q;
		q = session.createSQLQuery("select t.admin_id,t.admin_username,t.admin_pwd from t_admin t,t_admin_role t2 where t.admin_id=t2.admin_role_adminid and t2.admin_role_roleid=? order by t.admin_id desc");
		q.setParameter(0, roleid);
		List l = q.list();
		List<TAdmin> re=new ArrayList<TAdmin>();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);
			  int uid = (Integer)row[0];
			  String uName = (String)row[1];  
			  String pwd=(String)row[2];
			  TAdmin user=new TAdmin(uid,i+1, uName,pwd); 
			  re.add(user);
		}
		return re;
	}
	public int updateAdmin(int id,String adminName,String adminPassword,int roleid,String mark){//添加或修改账户信息
		int result=0;
		switch(mark){
			case "add":
				Query q = session.createSQLQuery("insert into t_admin(admin_username,admin_pwd) values (?,?)");
				q.setParameter(0, adminName);
				q.setParameter(1, adminPassword);
				result=q.executeUpdate();
				Query q2 = session.createSQLQuery("select LAST_INSERT_ID()");
				int adminid = ((BigInteger) q2.uniqueResult()).intValue();
				q = session.createSQLQuery("insert into t_admin_role (admin_role_adminid,admin_role_roleid) values (?,?)");
				q.setParameter(0,adminid);
				q.setParameter(1, roleid);
				result=q.executeUpdate();
				break;
			case "edit":
				Query q3 = session.createSQLQuery("update t_admin set admin_username=?,admin_pwd=? where admin_id=?");
				q3.setParameter(0, adminName);
				q3.setParameter(1, adminPassword);
				q3.setParameter(2, id);
				result=q3.executeUpdate();
				break;
		}
		return result;
	}
	public int delAdmin(int id) {//删除账户以及其角色关系
		Query q = session.createSQLQuery(" delete from t_admin where admin_id=?");
		q.setParameter(0, id);
		int result = q.executeUpdate();		
		Query q1 = session.createSQLQuery(" delete from t_admin_role where admin_role_adminid=?");
		q1.setParameter(0, id);
		int result1 = q1.executeUpdate();	
		return (result1 * result);
	}
	
	public TAdmin searchAdmin(String name,String pass){
		TAdmin adminR=null;
        Query query = session.createSQLQuery("select t.admin_id,t.admin_username,t.admin_pwd,t2.admin_role_roleid from t_admin t,t_admin_role t2 where t.admin_id=t2.admin_role_adminid and t.admin_username=? and t.admin_pwd=?");	
        query.setParameter(0, name);
        query.setParameter(1, pass);
        List<TAdmin> users=new ArrayList<TAdmin>();
		List l = query.list();
		for(int i=0;i<l.size();i++)
		{
			  Object[] row = (Object[])l.get(i);;
			  int adminID = (Integer) row[0];
			  String username = (String)row[1];  
			  String password = (String)row[2];
			  int roleid = (Integer) row[3];
			  TAdmin admin=new TAdmin();
			  admin.setAdminID(adminID);
			  admin.setAdminName(username);
			  admin.setAdminPassword(password);
			  admin.setRoleID(roleid);
			  users.add(admin);
		}
		if(!users.isEmpty()){
			adminR=new TAdmin();
			adminR=(TAdmin)users.get(0);
		}
		return adminR;
	}

}