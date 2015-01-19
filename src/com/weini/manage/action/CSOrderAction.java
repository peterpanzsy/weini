package com.weini.manage.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.dao.OrderDao;

public class CSOrderAction extends ActionSupport{
	private Integer userId;
	private List dataList; 
	private String date;
	
	public String orderListLimit7(){
		OrderDao dao = new OrderDao();
		dataList = dao.searchLimit7(userId);
		dao.close();
		return "SUCCESS";
	}
	
	public String orderListMonth(){
		OrderDao dao = new OrderDao();
		String[] temp = date.split("-");
		int year = Integer.parseInt(temp[0]);
		int month =Integer.parseInt(temp[1]);
		dataList = dao.searchMonth(userId,year,month);
		dao.close();
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
