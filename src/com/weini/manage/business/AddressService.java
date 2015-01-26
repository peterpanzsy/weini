package com.weini.manage.business;

import java.util.List;

import com.weini.manage.business.GeneralServive;
import com.weini.manage.dao.AddressDao;
import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TProvince;

public class AddressService extends GeneralServive{
	private AddressDao addressdao  = new AddressDao(this.session);
	
	public List<TProvince> listProvinces(){
		return this.addressdao.listProivces();
	}
		
	public List<TCity> listCitysByProvinceID(int proID){
		return this.addressdao.listCitysByProviceID(proID);
	}
	public List<TDistrict> listDistrictsByCityID(int cityID){
		return this.addressdao.listDistrictsByCityID(cityID);
	}
	public List<TBusinessarea> listBussByDistrictID(int disID){
		return this.addressdao.listBusinessareasByDistrictID(disID);
	}
}
