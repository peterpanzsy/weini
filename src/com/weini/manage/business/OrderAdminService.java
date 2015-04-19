package com.weini.manage.business;

import java.util.Date;
import java.util.List;

import com.weini.manage.dao.OrderAdminDao;
import com.weini.manage.entity.TOrder;

public class OrderAdminService extends GeneralService{
	private OrderAdminDao orderAdminDao = new OrderAdminDao(this.session);

	public List<TOrder> getOrderList(String start,String end){
		List<TOrder> res = null;
	    res = this.orderAdminDao.getOrderList(start,end);
		this.close();
		return res;
	}
    public int getOrderTotal(Date start,Date end){
        int res = this.orderAdminDao.getOrderTotal(start,end);
        return res;
    }
    public double getOrderSum(Date start,Date end){
        double res = this.orderAdminDao.getOrderSum(start,end);
        return res;
    }
}
