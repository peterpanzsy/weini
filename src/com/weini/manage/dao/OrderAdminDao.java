package com.weini.manage.dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.weini.manage.entity.*;


public class OrderAdminDao {

	 protected Session session ;
	 public OrderAdminDao(Session sess){
		 this.session = sess;
	 }
	public int getOrderTotal(Date start,Date end){
        int res=0;
        SQLQuery q = session.createSQLQuery("select count(*) from t_order t where Date(t.`order_orderTime`)>? and Date(t.`order_orderTime`)<?");
        q.setParameter(0,start);
        q.setParameter(1,end);
        res = ((BigInteger)q.uniqueResult()).intValue();
        return res;
    }
    public double getOrderSum(Date start,Date end){
        double sum=0;
        SQLQuery q = session.createSQLQuery("select sum(t.box_price) from t_order t where Date(t.`order_orderTime`)>? and Date(t.`order_orderTime`)<?");
        q.setParameter(0,start);
        q.setParameter(1,end);
        sum = (Double)q.uniqueResult();
        DecimalFormat df = new DecimalFormat("##.00");
        sum = Double.parseDouble(df.format(sum));
        return sum;
    }
	public List<TOrder> getOrderList(String start,String end) {//获取账户列表
		SQLQuery q = null;
        if(start!=null && end!=null && !start.equals("") && !end.equals("")){
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            try {
                Date startDate = format.parse(start);
                Date endDate = format.parse(end);
                q = session.createSQLQuery("select t.order_num,t.`order_menuinfo_id`,t.`user_id`,t.box_id,t.`box_price`,t.`order_notice`,t.`order_isFirst`" +
                        ",t.`order_dispatching_id`,t.`order_payStatus`,t.`S_order_ConsumeStatus`,t.`order_status`,t.`order_settleStatus`" +
                        ",t.`order_startTime`,t.`order_orderTime`,t.`order_payTime`," +
                        "tuser.`user_phoneNumber`,tuser.`user_name`,tmenu.`menuinfo_name`,tdispatch.`dispatching_addressDetail`" +
                        " from t_order t,t_user tuser,`t_box` tbox,`t_menuinfo` tmenu,`t_dispatching` tdispatch " +
                        "where t.`box_id`=tbox.`box_id` and t.`order_dispatching_id`=tdispatch.`dispatching_id` and t.`user_id`=tuser.`user_id` and t.`order_menuinfo_id`=tmenu.`menuinfo_id`" +
                        "and Date(t.`order_orderTime`)>? and Date(t.`order_orderTime`)<?");
                q.setParameter(0,startDate);
                q.setParameter(1,endDate);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }else{
            q = session.createSQLQuery("select t.order_num,t.`order_menuinfo_id`,t.`user_id`,t.box_id,t.`box_price`,t.`order_notice`,t.`order_isFirst`" +
                ",t.`order_dispatching_id`,t.`order_payStatus`,t.`S_order_ConsumeStatus`,t.`order_status`,t.`order_settleStatus`" +
                ",t.`order_startTime`,t.`order_orderTime`,t.`order_payTime`," +
                "tuser.`user_phoneNumber`,tuser.`user_name`,tmenu.`menuinfo_name`,tdispatch.`dispatching_addressDetail`" +
                " from t_order t,t_user tuser,`t_box` tbox,`t_menuinfo` tmenu,`t_dispatching` tdispatch where t.`box_id`=tbox.`box_id` and t.`order_dispatching_id`=tdispatch.`dispatching_id` and t.`user_id`=tuser.`user_id` and t.`order_menuinfo_id`=tmenu.`menuinfo_id`");
        }
        List l = q.list();
		List<TOrder> re=new ArrayList<TOrder>();
		for(int i=0;i<l.size();i++)
		{
			Object[] row = (Object[])l.get(i);
            String orderNum = (String)row[0];
            Integer userId = (Integer)row[2];
            Integer orderMenuinfoId = (Integer)row[1];
            Integer boxId = (Integer)row[3];
            Timestamp orderStartTime = (Timestamp) row[12];
            Timestamp orderOrderTime = (Timestamp)row[13];
            Integer orderPayStatus = (Integer)row[8];
            Integer SOrderConsumeStatus = (Integer)row[9];
            Timestamp orderPayTime = (Timestamp)row[14];
            Float boxPrice = (Float)row[4];
            Integer orderIsFirst = (Integer)row[6];
            Integer orderDispatchingId = (Integer)row[7];
            Integer orderSettleStatus = (Integer)row[11];
            Integer orderStatus = (Integer)row[10];
            String orderNotice = (String)row[5];

            String userPhone = (String)row[15];
            String userName=(String)row[16];
            String menuName=(String)row[17];
            String tdispatchAddress=(String)row[18];
			TOrder order=new TOrder(orderNum,userId,orderMenuinfoId,boxId,orderStartTime,orderOrderTime,orderPayStatus,
                    SOrderConsumeStatus,orderPayTime,boxPrice,orderIsFirst,orderDispatchingId,orderSettleStatus,orderStatus,orderNotice);
			TUser tUser=new TUser();
            tUser.setUserPhoneNumber(userPhone);
            tUser.setUserName(userName);
            TMenuinfo tMenuinfo=new TMenuinfo();
            tMenuinfo.setMenuinfoName(menuName);
            TDispatching tDispatching=new TDispatching();
            tDispatching.setDispatchingAddressDetail(tdispatchAddress);
            order.setTUser(tUser);
            order.setTMenuinfo(tMenuinfo);
            order.setTDispatching(tDispatching);
            re.add(order);
		}
		return re;
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