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
		List<TProvince> res = null;
		try{
			res = this.addressdao.listProivces();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
		
	public List<TCity> listCitysByProvinceID(int proID){
		List<TCity> res = null;
		try{
			res = this.addressdao.listCitysByProviceID(proID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public List<TDistrict> listDistrictsByCityID(int cityID){
		List<TDistrict> res = null;
		try{
			res = this.addressdao.listDistrictsByCityID(cityID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	public List<TBusinessarea> listBussByDistrictID(int disID){
		List<TBusinessarea> res = null;
		try{
			res = this.addressdao.listBusinessareasByDistrictID(disID);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
}
