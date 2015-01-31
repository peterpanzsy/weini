package com.weini.manage.business;

import java.util.ArrayList;
import java.util.List;

import com.weini.manage.business.GeneralService;
import com.weini.manage.dao.OrderDao;
import com.weini.manage.dao.UserDao;
import com.weini.tools.ThreeEntity;
import com.weini.tools.Tools;
import com.weini.tools.TwoEntity;

public class StatisticService extends GeneralService{
	private UserDao userdao  = new UserDao(this.session);
	private OrderDao orderdao = new OrderDao(this.session);
	/**
	 * 返回用户类型的百分比
	 * @return 
	 */
 	public List<TwoEntity> getUserType(){
 		int[] temp = new int[3];
 		List<TwoEntity> res = new ArrayList<TwoEntity>();
 		boolean flag = false;
 		try{
 			flag = userdao.getUserTypeSum(temp);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
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
 		List<TwoEntity> res = new ArrayList<TwoEntity>();
 		int[] temp = new int[6];
 		boolean flag = false;
 		try{
 			flag = orderdao.getUserOrderTimeSum(temp);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
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
 		double res = 0;
 		try{
 			res = this.orderdao.getOrderTotalMoney();
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		this.close();
 		return res;
 	}
 	/**
 	 * 根据时间统计用户下单数，如果某一天不存在数据，则置为0
 	 * @param num 统计的天数
 	 * @return 月份与统计数的list
 	 */
 	public List<TwoEntity> getOrderSumByTime(int num){
 		List<TwoEntity> res = null;
 		String end = Tools.getSomeDayDate(0);
 		String start = Tools.getSomeDayDate(0-num);
 		try{
 			res = this.orderdao.getOrderSumByDate(start, end, true);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		if(res != null && res.size() < num){
 			List<TwoEntity> templist = new ArrayList<TwoEntity>();
 			String tempDate = "";
 			int j = 0;
 			TwoEntity tempEntity = new TwoEntity("##",-1);
 			if(res.size()!=0)
 			 { tempEntity= res.get(j);}
 			for(int i = -1; i >= -num; i--){
 				tempDate = Tools.getSomeDayDate(i);
 				if(tempDate.equalsIgnoreCase(tempEntity.getIndex1().toString())){
 					templist.add(tempEntity);
 					j++;
 					if(j < res.size()){
 						tempEntity = res.get(j);
 					}
 				}else{
 					templist.add(new TwoEntity(tempDate,0));
 				}
 			}
 			res = templist;
 		}
 		this.close();
 		return res;
 		
 	}
 	/**
 	 * 获取真正购买用户的数量
 	 * @return
 	 */
	public int getRealBuyUserSum(){
		int res = 0;
		try{
			res = this.orderdao.getRealBuyUserSum();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	/**
	 * 根据选择的地区来统计这个地区的各个模式的订购数量
	 * @param privinceID 省ID;
	 * @param cityID 城市ID;
	 * @param district 行政区ID;
	 * @param bussID 商圈ID;
	 * @return 这个商圈各个订单模式的统计
	 */
	public List<TwoEntity> getOrderSumByDispatching(int bussID){
		List<TwoEntity> res = null;
		try{
			res = this.orderdao.getOrderModelSumByDispatch(bussID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		if(res != null && res.size() > 0){
			float sum = 0;
			for(int i = 0; i < res.size(); i++){
				sum += (int)res.get(i).getIndex2();
			}
			if(sum != 0){
				for(int i = 0; i < res.size(); i++){
					TwoEntity temp = res.get(i);
					temp.setIndex2((int)temp.getIndex2() / sum * 100);
				}
			}
		}
		return res;
	}
	public List<TwoEntity> getFirstBuyModelSum(){
		List<TwoEntity> res = null;
		try{
			res = this.orderdao.getOrderFirstModelSum();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		if(res != null && res.size() > 0){
			float sum = 0;
			if(res.size() > 0){
				for(int i = 0;i < res.size(); i++){
					sum += (int)res.get(i).getIndex2();
				}
				if(sum != 0){
					for(int i = 0; i < res.size(); i++){
						TwoEntity temp = res.get(i);
						temp.setIndex2((int)temp.getIndex2() / sum * 100);
					}
				}
			}
		}
		return res;
	}
	public List<TwoEntity> getConBuyModelSum(){
		List<TwoEntity> res = null;
		try{
			res = this.orderdao.getUserSumSecondOrder();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public List<ThreeEntity> getAllFirstOrder(){
		List<ThreeEntity> res = null;
		try{
			res = this.orderdao.getAllFirstOrder();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
}
