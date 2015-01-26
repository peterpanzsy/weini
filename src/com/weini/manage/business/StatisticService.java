package com.weini.manage.business;

import java.util.ArrayList;
import java.util.List;

import com.weini.manage.business.GeneralServive;
import com.weini.manage.dao.OrderDaopl;
import com.weini.manage.dao.UserDaopl;
import com.weini.tools.TwoEntity;

public class StatisticService extends GeneralServive{
	private UserDaopl userdao  = new UserDaopl(this.session);
	private OrderDaopl orderdao = new OrderDaopl(this.session);
	/**
	 * 返回用户类型的百分比
	 * @return 
	 */
 	public List<TwoEntity> getUserType(){
 		int[] temp = new int[3];
 		List<TwoEntity> res = new ArrayList<TwoEntity>();
 		boolean flag = userdao.getUserTypeSum(temp);
 		this.close();
 		if(flag && temp[0] > 0){
 			res.add(new TwoEntity("Android",(float)temp[1] / temp[0]*100));
 			res.add(new TwoEntity("IOS",(float)temp[2] / temp[0]*100));
 			return res;
 		}else{
 			return null;
 		}
 	}
 	/**
 	 * 获取用户下订单时间分布的百分比
 	 * @return
 	 */
 	public List<TwoEntity> getUserOrderTime(){
 		System.out.println("orderTime");
 		List<TwoEntity> res = new ArrayList<TwoEntity>();
 		int[] temp = new int[6];
 		boolean flag = orderdao.getUserOrderTimeSum(temp);
 		this.close();
 		if(flag && temp[0] > 0){
 			if(temp[1]!=0)
 				res.add(new TwoEntity("0-10s",(float)temp[1] / temp[0]*100));
 			if(temp[2]!=0)
 				res.add(new TwoEntity("10-20s",(float)temp[2] / temp[0]*100));
 			if(temp[3]!=0)
 				res.add(new TwoEntity("20-30s",(float)temp[3] / temp[0]*100));
 			if(temp[4]!=0)
 				res.add(new TwoEntity("30-60s",(float)temp[4] / temp[0]*100));
 			if(temp[5]!=0)
 				res.add(new TwoEntity(">60s" ,(float)temp[5] / temp[0]*100));
 			return res;
 		}else{
 			return null;
 		}
 	}
 	/**
 	 * 获取实际购买的金额，盒子模式中如果存在某一天使用，而其他天退款，则求总金额的平均值来计算这一天
 	 * 主要存在两种情况
 	 * 1、全部消耗完毕
 	 * 2、消耗一半
 	 * @return
 	 */
 	public double getRealTotalMoney(){
 		return 0;
 	}
	
}
