package com.weini.manage.business;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.weini.manage.dao.VendorDao;
import com.weini.manage.entity.TVendor;
import com.weini.tools.HibernateSessionManager;

/**
 * Created by zsy on 15/4/13.
 */
public class VendorService extends GeneralService {
	private VendorDao vdao = new VendorDao(this.session);

	public List<TVendor> getVendorList() {
		List<TVendor> res = vdao.listVendor();
		this.close();
		return res;
	}

	/**
	 * 增加商家信息
	 * 
	 * @param vendor
	 *            商家信息类
	 * @return 返回执行结果
	 */
	public boolean updateVendor(TVendor vendor) {
		HibernateSessionManager.getThreadLocalTransaction();
		boolean flag = false;
		try{
			vdao.updateVendor(vendor);
			this.close();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
			flag = false;
		}
		return flag;
	}
	public boolean delVendor(int vendorID){
		HibernateSessionManager.getThreadLocalTransaction();
		boolean flag = false;
		try{
			TVendor vendor = new TVendor();
			vendor.setVendorId(vendorID);
			vdao.delVendor(vendor);
			this.close();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
			flag = false;
		}
		return flag;
		
		
	}

}
