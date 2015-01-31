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
		List<TMenuinfo> res;
		res = menuDao.listMenuInfo(isExistGood);
		this.close();
		return res;
	}
	public boolean updateMenuInfo(TMenuinfo menu,boolean isAdd){
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		flag = menuDao.updateGoodInfo(menu, isAdd);
		if(flag){
			this.close();
		}else{
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
		TMenuinfo menu = new TMenuinfo();
		menu = menuDao.findMenuDetailByMenuID(indexID);
		menu.setVendorName(vendorDao.findVendorNameByID(menu.getVendorId()));
		this.close();
		return menu;
	}
	public boolean changeMenuStatus(int menuID,boolean status){
		boolean flag = false;
		HibernateSessionManager.getThreadLocalTransaction();
		flag = menuDao.changeMenuStatus(menuID, status);
		if(flag){
			this.close();
		}else{
			this.roll();
		}
		return flag;
	}
	public List<TCity> listCitysByProvinceID(int proID){
		List<TCity> res;
		res = addressDao.listCitysByProviceID(proID);
		this.close();
		return res;
	}
	public List<TDistrict> listDistrictsByCityID(int cityID){
		List<TDistrict> res;
		res = addressDao.listDistrictsByCityID(cityID);
		this.close();
		return res;
	}
	public List<TBusinessarea> listBussByDistrictID(int disID){
		List<TBusinessarea> res;
		res = addressDao.listBusinessareasByDistrictID(disID);
		this.close();
		return res;
	}
	public List<TVendor> listVendorsByBussID(int busID){
		List<TVendor> res;
		res = vendorDao.listVendorsByBussID(busID);
		this.close();
		return res;
	}
	public List<TProvince> listProvinces(){
		List<TProvince> res = addressDao.listProivces();
		this.close();
		return res;
	}
	
	public TMenuinfo findMenuById(Integer menuinfoId) {
		TMenuinfo menu= menuDao.findMenuDetailByMenuID(menuinfoId);
		if(menu==null){
			this.close();
			return null;               //没有记录
		}else{
			menu.setDishesList(menuDao.findAllDishByMenuinfoId(menuinfoId));   //设置子菜品
			this.close();
			return menu;
		}
	}
}
