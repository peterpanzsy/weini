package com.weini.manage.action;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.OrderAdminService;
import com.weini.manage.entity.TOrder;

import java.util.List;


public class OrderAdminAction extends ActionSupport{
	List<TOrder> dataList;
	String result;
    OrderAdminService orderAdminService=new OrderAdminService();



    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String listOrder(){//根据角色获取账户列表
		dataList=orderAdminService.getOrderList();
		return "SUCCESS";
	}

    public List<TOrder> getDataList() {
        return dataList;
    }

    public void setDataList(List<TOrder> dataList) {
        this.dataList = dataList;
    }
}
