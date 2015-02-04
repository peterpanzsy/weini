package com.weini.manage.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.weini.manage.dao.OrderDao;
import com.weini.tools.HibernateSessionManager;
import com.weini.tools.Tools;


public class OtherService extends GeneralService {
	private OrderDao orderdao = new OrderDao(this.session);
	/**
	 * 获取订单编号
	 * @return '20150130111111'
	 */
	public synchronized String getOrderNumSting(){
		String res = "00000000";
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		HibernateSessionManager.getThreadLocalTransaction();
		try{
			List<String> temp = this.orderdao.getOrderNum();
			if(temp.size() != 0){
				String date = temp.get(0);
				int num = Integer.valueOf(temp.get(1));
	//			如果日期相等
				if(today.equalsIgnoreCase(date)){
					if(this.orderdao.updateOrderNum((num+1)+"") > 0){
						res = today + this.orderNumToString(num);
						this.close();
					}else{
						this.roll();
					}
				}else{
					//日期不等
					date = today;
					if(this.orderdao.updateOrderIndexAll(date, "000001") > 0){
						res = today + "000000";
						this.close();
					}else{
						this.roll();
					}
				}
			}
		}catch(Exception e){
			System.out.println("订单编号出错！");
			e.printStackTrace();
			this.roll();
		}
		return res;
	}
	private String orderNumToString(int num){
		String res = "";
		res = num + "";
		while(res.length() < 6){
			res = "0" + res;
		}
		return res;
	}
}
