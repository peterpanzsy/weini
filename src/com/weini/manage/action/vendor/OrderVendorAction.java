package com.weini.manage.action.vendor;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.vendor.OrderVendorService;
import com.weini.manage.entity.TOrder;


public class OrderVendorAction extends ActionSupport{
    int vendorId;
    String dateFlag;
	List<TOrder> dataList;
	String result;
    OrderVendorService orderVendorService=new OrderVendorService();

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getDateFlag() {
        return dateFlag;
    }

    public void setDateFlag(String dateFlag) {
        this.dateFlag = dateFlag;
    }

    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String listOrder(){
		dataList=orderVendorService.getOrderList(vendorId,dateFlag);
        return "SUCCESS";
	}

    public List<TOrder> getDataList() {
        return dataList;
    }

    public void setDataList(List<TOrder> dataList) {
        this.dataList = dataList;
    }
}
