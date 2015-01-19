package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.dao.OrderDao;

public class CSOrderAction extends ActionSupport{
	private Integer userId;
	private List dataList; 
	
	public String orderListLimit7(){
		OrderDao dao = new OrderDao();
		dataList = dao.searchLimit7(userId);
		return "SUCCESS";
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	
}
