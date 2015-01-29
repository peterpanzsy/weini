package com.weini.manage.business;

import java.util.List;

import com.weini.manage.business.GeneralServive;
import com.weini.manage.dao.AddressDao;
import com.weini.manage.dao.MenuDao;
import com.weini.manage.dao.VendorDao;
import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TMenuinfo;
import com.weini.manage.entity.TProvince;
import com.weini.manage.entity.TVendor;
import com.weini.tools.HibernateSessionManager;

public class MenuinfoService extends GeneralServive {
	private MenuDao menuDao;
	private VendorDao vendorDao;
	private AddressDao addressDao;
	public MenuinfoService(){
		this.menuDao = new MenuDao(this.session);
		this.vendorDao = new VendorDao(this.session);
		this.addressDao = new AddressDao(this.session);
	}
	public List<TMenuinfo> listMenuInfo(boolean isExistGood){
		List<TMenuinfo> res = null;
		try{
			res = menuDao.listMenuInfo(isExistGood);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public boolean updateMenuInfo(TMenuinfo menu,boolean isAdd){
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		try{
			int res = menuDao.updateGoodInfo(menu, isAdd);
			if(res > 0){
				flag = true;
				this.close();
			}else{
				this.roll();
			}
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
		}
		return flag;
	}
	/**
	 * 获取菜品的编辑信息
	 * @param indexID 菜品id
	 * @return 
	 */
	public TMenuinfo getEditMenuinfo(int indexID){
		TMenuinfo menu = null;
		try{
			menu = menuDao.findMenuDetailByMenuID(indexID);
			menu.setVendorName(vendorDao.findVendorNameByID(menu.getVendorId()));
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return menu;
	}
	public boolean changeMenuStatus(int menuID,boolean status){
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		try{
			int res = menuDao.changeMenuStatus(menuID, status);
			if(res > 0){
				this.close();
				flag = true;
			}else{
				this.roll();
			}
		}catch(Exception e){
			e.printStackTrace();
			this.roll();
		}
		return flag;
	}
	public List<TCity> listCitysByProvinceID(int proID){
		List<TCity> res = null;
		try{
			res = addressDao.listCitysByProviceID(proID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public List<TDistrict> listDistrictsByCityID(int cityID){
		List<TDistrict> res = null;
		try{
			res = addressDao.listDistrictsByCityID(cityID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public List<TBusinessarea> listBussByDistrictID(int disID){
		List<TBusinessarea> res = null;
		try{
			res = addressDao.listBusinessareasByDistrictID(disID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public List<TVendor> listVendorsByBussID(int busID){
		List<TVendor> res = null;
		try{
			res = vendorDao.listVendorsByBussID(busID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public List<TProvince> listProvinces(){
		List<TProvince> res = null;
		try{
			res = addressDao.listProivces();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	
 	
	
}
