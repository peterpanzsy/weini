package com.weini.manage.business;

import com.weini.manage.dao.OrderAdminDao;
import com.weini.manage.entity.TOrder;

import java.util.List;

public class OrderAdminService extends GeneralService{
	private OrderAdminDao orderAdminDao = new OrderAdminDao(this.session);

	public List<TOrder> getOrderList(){
		List<TOrder> res = null;
	    res = this.orderAdminDao.getOrderList();

		this.close();
		return res;
	}
}
