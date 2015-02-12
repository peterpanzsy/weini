package com.weini.manage.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TUserextra;


public class UserDao{
	protected Session session;
	public UserDao(Session sess){
		this.session = sess;
	} 
//	public List<User> getUserList(){
//		SQLQuery q;
//		q=session.createSQLQuery("select t1.user_id,t1.user_name,t1.user_gender,t1.user_address,t1.user_phoneNumber,t1.user_phoneType,t1.user_scale,"
//				+ "t2.bank_bankname,t2.bank_username,t2.bank_cardNumber,t2.bank_sub_bankname,t2.bank_sub_bankAddress,"
//				+ "t3.alipay_username,t3.alipay_userAccount,t1.user_weChatPay,t1.user_regdate,t4.point_total "
//				+ "from t_user t1,t_bank t2,t_alipay t3,t_point t4 where t1.user_id=t2.bank_userid and t1.user_id=t3.alipay_userid and t1.user_id=t4.user_id");
//		List l=q.list();
//		List<User> re=new ArrayList<User>();
//		for(int i=0;i<l.size();i++){
//			Object[] row=(Object[])l.get(i);
//			int uid=(Integer)row[0];
//			String uname=(String)row[1];
//			int ugender=Integer.valueOf(row[2].toString());
//			String uaddr=(String)row[3];
//			String uphone=(String)row[4];
//			int uphoneType=Integer.valueOf(row[5].toString());
//			int uscale=Integer.valueOf(row[6].toString());	
//			String bankname=(String)row[7];
//			String bankuname=(String)row[8];
//			String bankcardnum=(String)row[9];
//			String banksubbname=(String)row[10];
//			String banksubbaddr=(String)row[11];
//			String aliuname=(String)row[12];
//			String aliuacc=(String)row[13];
//			String wechat=(String)row[14];
//			Date regdate=(Date)row[15];
//			int pointTotal=Integer.valueOf(row[16].toString());	
//			User u=new User(i+1,uid, uname,ugender,uaddr,uphone,uphoneType,uscale,bankname,bankuname,bankcardnum,banksubbname,banksubbaddr,aliuname,aliuacc,wechat,regdate,pointTotal); 
//			re.add(u);
//		}
//		return re;
//	}
//
//	public int updateVendor(int id,String vname,String vmail,String vphone,Boolean isopen,int employernum,int cooknum,String vendorShophourStart,String vendorShophourEnd,String vendorDetail,String mark){//添加或修改账户信息
//		int result=0;
//		HibernateSessionManager.getThreadLocalTransaction();
//		switch(mark){
//			case "add":
//				Query q = session.createSQLQuery("insert into t_vendor(vendor_name,vendor_mail,vendor_phonenum,vendor_isopen,vendor_employernum,vendor_cooknum,vendor_shophour_start,vendor_shophour_end,vendor_detail) values (?,?,?,?,?,?,?,?,?)");
//				q.setParameter(0, vname);
//				q.setParameter(1, vmail);
//				q.setParameter(2, vphone);
//				q.setParameter(3, isopen);
//				q.setParameter(4, employernum);
//				q.setParameter(5, cooknum);
//				q.setParameter(6, vendorShophourStart);
//				q.setParameter(7, vendorShophourEnd);
//				q.setParameter(8, vendorDetail);
//				result=q.executeUpdate();
//				break;
//			case "edit":
//				Query q2 = session.createSQLQuery("update t_vendor set vendor_name=?,vendor_mail=?,vendor_phonenum=?,vendor_isopen=?,vendor_employernum=?,vendor_cooknum=?,vendor_shophour_start=?,vendor_shophour_end=?,vendor_detail=? where vendor_id=?");
//				q2.setParameter(0, vname);
//				q2.setParameter(1, vmail);
//				q2.setParameter(2, vphone);
//				q2.setParameter(3, isopen);
//				q2.setParameter(4, employernum);
//				q2.setParameter(5, cooknum);
//				q2.setParameter(6, vendorShophourStart);
//				q2.setParameter(7, vendorShophourEnd);
//				q2.setParameter(8, vendorDetail);
//				q2.setParameter(9, id);
//				result=q2.executeUpdate();
//				break;
//		}
//		return result;
//	}
//	public int delUser(int id) {//删除账户以及其角色关系
//		HibernateSessionManager.getThreadLocalTransaction();
//		Query q = session.createSQLQuery(" delete from t_user where user_id=?");
//		q.setParameter(0, id);
//		int result=q.executeUpdate();	
//		Query q1 = session.createSQLQuery(" delete from t_bank where bank_userid=?");
//		q1.setParameter(0, id);
//		int result1=q1.executeUpdate();
//		Query q2 = session.createSQLQuery(" delete from t_alipay where alipay_userid=?");
//		q1.setParameter(0, id);
//		int result2=q2.executeUpdate();
//		Query q3 = session.createSQLQuery(" delete from t_point where user_id=?");
//		q1.setParameter(0, id);
//		int result3=q3.executeUpdate();
//		
//		return result3;
//	}
	/**
	 * 列出所有用户
	 * @return
	 */
	public List<TUser> listUser(){
		return session.createSQLQuery("select * from t_user").addEntity(TUser.class).list();
	}
	/**
	 * 根据用户id查找用户
	 * @param userId
	 * @return 如果存在返回TUser对象
	 * 		        如果不存在返回null
	 */
	public TUser findByUserID(Integer userId){
		Query q = session.createQuery("from TUser t where t.userId = ? ");
		q.setInteger(0, userId);
		return  (TUser) q.uniqueResult();
	} 
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */

	public boolean addUser(TUser user){
		try {
			session.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public boolean updateUser(TUser user){
		try {
			session.update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public boolean delUser(TUser user){
		try {
			session.delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 根据用户手机号码和密码来查询是否有此用户
	 * @param phoneNum  手机号
	 * @param pass	密码
	 * @return
	 * 			如果存在，返回TUser
	 * 			否则，返回null
	 */
	public TUser searchUser(String phoneNum,String pass){
		return (TUser) session.createQuery("from TUser t where t.userPhoneNumber = ? and t.userPwd = ? ").setString(0, phoneNum).setString(1,pass).uniqueResult();
	}
	/**
	 * 根据手机号码来查找TUser用户，用来查询该手机号是否为以注册的用户
	 * @param phoneNum
	 * @return
	 */
	public TUser searchUser(String phoneNum){
		return (TUser) session.createQuery("from TUser t where t.userPhoneNumber = ?").setString(0, phoneNum).uniqueResult();
	}
	/**
	 * 获取用户类型的统计信息
	 * @param temp 统计数组，第一个表示总用户数，第二个表示Android用户，第三个表示ios用户
	 * @return
	 */
	public boolean getUserTypeSum(int[] temp){
		boolean flag = false;
		Query q = session.createSQLQuery("select count(user_id) from t_user group by user_phoneType");
		List l = q.list();
		if(l.size() > 1 ){
			temp[1] = ((BigInteger)(l.get(0))).intValue();
			temp[2] = ((BigInteger)(l.get(1))).intValue();
			temp[0] = temp[1] + temp[2]; 
			flag = true;
		}
		return flag;
	}
	/**
	 * 更新用户的忌口和饭量
	 * @param userID 用户id
	 * @param heatID 用户忌口id
	 * @param appeID 用户饭量id
	 * @return
	 */
	public int updateUserTaste(int userID,int heatID,int appeID,int userPungent){
		Query q = session.createSQLQuery("update t_user SET user_heat = ?,user_appetite = ?,user_pungent = ? WHERE user_id = ?;");
		q.setInteger(0,heatID);
		q.setInteger(1, appeID);
		q.setInteger(2,userID);
		return q.executeUpdate();
	}
	public String getUserHeatByID(int heatID){
		String res = "";
		Query q = session.createSQLQuery("select menutype_desc from t_menutype WHERE menutype_id  = ?;");
		q.setInteger(0,heatID);
		List l = q.list();
		if(l.size() == 1){
			res = (String)l.get(0);
		}
		return res;
	}
	//---------------和userextra有关的东西----------------------
	/**
	 * 根据用户id来查找用户的不常用信息
	 * @param userId
	 * @return  找到返回TUser，否则返回null
	 */
	public TUserextra findUserextraByUserId(Integer userId){
		return (TUserextra) session.createQuery("from TUserextra t where t.userId = ? ").setInteger(0,userId).uniqueResult();
	}
	/**
	 * 根据用户user来查找用户的不常用信息
	 * @param userId
	 * @return  找到返回TUser，否则返回null
	 */
	public TUserextra findUserextraByUserId(TUser user){
		return (TUserextra) session.createQuery("from TUserextra t where t.userId = ? ").setInteger(0,user.getUserId()).uniqueResult();
	}
	/**
	 * 添加用户的信息
	 * @param userextra
	 * @return
	 */
	public boolean addUserextra(TUserextra userextra){
		if(userextra.getUserId()==null){
			return false;
		}else{
			session.save(userextra);
			return true;
		}
	}
	/**
	 * 更新用户的信息
	 * @param userextra
	 * @return
	 */
	public boolean updateUserextra(TUserextra userextra){
		if(userextra.getUserId()==null){
			return false;
		}else{
			session.saveOrUpdate(userextra);
			return true;
		}
	}
	/**
	 * 删除用户信息
	 * @param userextra
	 * @return
	 */
	public boolean delUserextra(TUserextra userextra){
		if(userextra.getUserId()==null){
			return false;
		}else{
			session.delete(userextra);
			return true;
		}
	}
	/**
	 * 修改用户名
	 * @param userID 用户id
	 * @param userName 用户名
	 * @return
	 */
	public int updateUserName(int userID,String userName){
		Query q = session.createSQLQuery("update t_user SET user_name = ? where user_id = ?;");
		q.setString(0,userName);
		q.setInteger(1, userID);
		return q.executeUpdate();
	}
	/**
	 * 修改用户名
	 * @param userId 用户id
	 * @param disId 默认送餐地址id
	 * @return
	 */
	public int updateUserDefaultDispatchingId(int userId,int disId){
		Query q = session.createSQLQuery("update t_user SET user_dispatchdefault_id = ? where user_id = ?;");
		q.setInteger(0,disId);
		q.setInteger(1, userId);
		return q.executeUpdate();
	}
}