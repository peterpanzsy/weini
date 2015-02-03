package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.BoxService;

public class BoxManageAction extends ActionSupport {
	
	BoxService boxService = new BoxService();
	
	private List<Object[]> list;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取盒子模式的列表
	 * @return 盒子模式列表
	 */
	public String listAllBox(){
		list = boxService.listBox();
		return SUCCESS;
	}
	/**
	 * 获得所有文案
	 * @return
	 */
	public String listAllBoxpage(){
		list = boxService.listBoxpage();
		return SUCCESS;
	}
	public List<Object[]> getList() {
		return list;
	}
	public void setList(List<Object[]> list) {
		this.list = list;
	}
	
}
