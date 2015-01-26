package com.weini.manage.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.StatisticService;
import com.weini.manage.business.Vendor;
import com.weini.manage.business.VendorDao;
import com.weini.tools.TwoEntity;


public class StatisticAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatisticService staSer;
	private List<TwoEntity> dataChannel;
	
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
		dataChannel = staSer.getUserOrderTime();
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
	public String changeAnalysis(){
		return "SUCCESS";
	}
	/**
	 * 订单统计
	 * 
	 * @return
	 */
	public String orderSum(){
		return "SUCCESS";
	}
	/**
	 * 平均购买力
	 * @return
	 */
	public String averageBuy(){
		return "SUCCESS";
	}
	public List<TwoEntity> getDataChannel() {
		return dataChannel;
	}
	public void setDataChannel(List<TwoEntity> dataChannel) {
		this.dataChannel = dataChannel;
	}

	
}
