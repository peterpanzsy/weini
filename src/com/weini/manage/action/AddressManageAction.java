package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.AddressService;
import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TOfficebuilding;
import com.weini.manage.entity.TProvince;


public class AddressManageAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AddressService addressSer;
	private List<TProvince> provices;
	private int indexID;
	private List<TCity> citys;
	private List<TDistrict> diss;
	private List<TBusinessarea> busses;
	private List<TOfficebuilding> offes;
	
	/**
	 * 
	 * @return
	 */
	public String listProvice(){
		addressSer = new AddressService();
		this.provices = addressSer.listProvinces();
		return "SUCCESS";
	}

	/**
	 * 列出所有的省份
	 * @return
	 */
	public String listCity(){
		addressSer = new AddressService();
		this.citys = addressSer.listCitysByProvinceID(this.indexID);
		return "SUCCESS";
	}
	
	/**
	 * 列出城市根据选择的省份
	 * @return
	 */
	public String listDistrict(){
		addressSer = new AddressService();
		this.diss = addressSer.listDistrictsByCityID(indexID);
		return "SUCCESS";
	}
	/**
	 * 列出商圈根据所选择的城市
	 * @return
	 */
	public String listbussArea(){
		addressSer = new AddressService();
		this.busses = addressSer.listBussByDistrictID(indexID);
		return "SUCCESS";
	}
	/**
	 * 列出写字楼根据所选择的商圈
	 */
	public String listOfficeBuilding(){
		addressSer = new AddressService();
		this.offes = addressSer.listOfficeBuildingByBusId(indexID);
		return "SUCCESS";
	}

	public List<TProvince> getProvices() {
		return provices;
	}

	public void setProvices(List<TProvince> provices) {
		this.provices = provices;
	}

	public int getIndexID() {
		return indexID;
	}

	public void setIndexID(int indexID) {
		this.indexID = indexID;
	}

	public List<TCity> getCitys() {
		return citys;
	}

	public void setCitys(List<TCity> citys) {
		this.citys = citys;
	}

	public List<TDistrict> getDiss() {
		return diss;
	}

	public void setDiss(List<TDistrict> diss) {
		this.diss = diss;
	}

	public List<TBusinessarea> getBusses() {
		return busses;
	}

	public void setBusses(List<TBusinessarea> busses) {
		this.busses = busses;
	}

	public List<TOfficebuilding> getOffes() {
		return offes;
	}

	public void setOffes(List<TOfficebuilding> offes) {
		this.offes = offes;
	}
	
}
