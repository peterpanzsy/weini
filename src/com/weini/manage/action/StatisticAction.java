package com.weini.manage.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.StatisticService;
import com.weini.tools.Tools;
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
	private int provinceID;
	private int cityID;
	private int districtID;
	private int bussID;
	private List<TwoEntity> averageBuySum;
	private double RealTotalMoney;
	private int RealBuyUserSum;
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
	 * @return 实际购买用户，实际购买金额
	 */
	public String getChangeAnalysis(){
		staSer = new StatisticService();
		this.RealTotalMoney = staSer.getRealTotalMoney();
		this.RealBuyUserSum = staSer.getRealBuyUserSum();
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
		this.averageBuySum = staSer.getOrderSumByDispatching(provinceID, cityID, districtID, bussID);
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
	public double getRealTotalMoney() {
		return RealTotalMoney;
	}
	public void setRealTotalMoney(double realTotalMoney) {
		RealTotalMoney = realTotalMoney;
	}
	public int getRealBuyUserSum() {
		return RealBuyUserSum;
	}
	public void setRealBuyUserSum(int realBuyUserSum) {
		RealBuyUserSum = realBuyUserSum;
	}
	public int getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public int getDistrictID() {
		return districtID;
	}
	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}
	public int getBussID() {
		return bussID;
	}
	public void setBussID(int bussID) {
		this.bussID = bussID;
	}

	
}
