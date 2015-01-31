package com.weini.manage.action;

import java.math.BigDecimal;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.StatisticService;
import com.weini.tools.ThreeEntity;
import com.weini.tools.TwoEntity;


public class StatisticAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatisticService staSer;
	private List<TwoEntity> dataChannel;
	private List<TwoEntity> timeData;
	private int orderStaType;
	private List<TwoEntity> orderSum;
	private int bussID;
	private List<TwoEntity> averageBuySum;
	private double realTotalMoney;
	private int realBuyUserSum;
	private List<TwoEntity> conBuyUseSum;
	private List<TwoEntity> firBuyModelSum;
	private List<ThreeEntity> firOrderList; 
	
	/**获取用户的渠道分析
	 * 
	 * @return 返回用户的百分比
	 */
	public String getChannelAnalysis(){
		staSer = new StatisticService();
		dataChannel = staSer.getUserType();
		return "SUCCESS";
	}
	/**
	 * 获取时间点分析
	 * @return 返回百分比
	 * <10s
	 * 10-20
	 * 20-30
	 * 30-60
	 * >60
	 */
	public String getTimeAnalysis(){
		staSer = new StatisticService();
		timeData = staSer.getUserOrderTime();
		return "SUCCESS";
	}
	/**
	 * 获取用户的偏好的统计
	 * @return 用户偏好的统计
	 */
	public String perferUser(){
		return "SUCCESS";
	}
	/**
	 * 用户转换率的分析
	 * 与第二次购买模式分布请求合并
	 * @return 实际购买用户，实际购买金额
	 */
	public String getChangeAnalysis(){
		staSer = new StatisticService();
		double temp = staSer.getRealTotalMoney();
		BigDecimal b = new BigDecimal(temp);
		this.realTotalMoney = b.setScale(6,BigDecimal.ROUND_HALF_UP).doubleValue();
		staSer = new StatisticService();
		this.realBuyUserSum = staSer.getRealBuyUserSum();
		return "SUCCESS";
	}
	/**
	 * 订单统计
	 * 
	 * @return
	 */
	public String getOrderAnalysis(){
		staSer = new StatisticService();
		if(this.orderStaType == 1){
			this.orderSum = staSer.getOrderSumByTime(1);
		}else if(this.orderStaType == 2){
			this.orderSum = staSer.getOrderSumByTime(3);
		}else if(this.orderStaType == 3){
			this.orderSum = staSer.getOrderSumByTime(7);
		}else if(this.orderStaType == 4){
			this.orderSum = staSer.getOrderSumByTime(15);
		}else{
			this.orderSum = staSer.getOrderSumByTime(30);
		}
		return "SUCCESS";
	}
	/**
	 * 平均购买力
	 * @return
	 */
	public String getAverageBuy(){
		staSer = new StatisticService();
		this.averageBuySum = staSer.getOrderSumByDispatching(bussID);
		return "SUCCESS";
	}
	public String getContinueBuyUserSum(){
		staSer = new StatisticService();
		this.conBuyUseSum = staSer.getConBuyModelSum();
		this.getChangeAnalysis();
		return "SUCCESS";
	}
	public String getFirstBuyModelSum(){
		staSer = new StatisticService();
		this.firBuyModelSum = staSer.getFirstBuyModelSum();
		return "SUCCESS";
		
	}
	/**
	 * 获取用户第一次下单，获取的字段主要有用户名，所属商圈，订单id
	 * @return
	 */
	public String getAllFirstOrder(){
		staSer = new StatisticService();
		this.firOrderList = staSer.getAllFirstOrder();
		return "SUCCESS";
		
	}
	public List<TwoEntity> getDataChannel() {
		return dataChannel;
	}
	public void setDataChannel(List<TwoEntity> dataChannel) {
		this.dataChannel = dataChannel;
	}
	public List<TwoEntity> getTimeData() {
		return timeData;
	}
	public void setTimeData(List<TwoEntity> timeData) {
		this.timeData = timeData;
	}
	public int getOrderStaType() {
		return orderStaType;
	}
	public void setOrderStaType(int orderStaType) {
		this.orderStaType = orderStaType;
	}
	public List<TwoEntity> getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(List<TwoEntity> orderSum) {
		this.orderSum = orderSum;
	}
	public List<TwoEntity> getAverageBuySum() {
		return averageBuySum;
	}
	public void setAverageBuySum(List<TwoEntity> averageBuySum) {
		this.averageBuySum = averageBuySum;
	}
	public int getBussID() {
		return bussID;
	}
	public void setBussID(int bussID) {
		this.bussID = bussID;
	}
	public List<TwoEntity> getFirBuyModelSum() {
		return firBuyModelSum;
	}
	public void setFirBuyModelSum(List<TwoEntity> firBuyModelSum) {
		this.firBuyModelSum = firBuyModelSum;
	}
	public double getRealTotalMoney() {
		return realTotalMoney;
	}
	public void setRealTotalMoney(double realTotalMoney) {
		this.realTotalMoney = realTotalMoney;
	}
	public int getRealBuyUserSum() {
		return realBuyUserSum;
	}
	public void setRealBuyUserSum(int realBuyUserSum) {
		this.realBuyUserSum = realBuyUserSum;
	}
	public List<TwoEntity> getConBuyUseSum() {
		return conBuyUseSum;
	}
	public void setConBuyUseSum(List<TwoEntity> conBuyUseSum) {
		this.conBuyUseSum = conBuyUseSum;
	}
	public List<ThreeEntity> getFirOrderList() {
		return firOrderList;
	}
	public void setFirOrderList(List<ThreeEntity> firOrderList) {
		this.firOrderList = firOrderList;
	}

	
}
