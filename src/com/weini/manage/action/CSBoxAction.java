package com.weini.manage.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.Box;
import com.weini.manage.business.BoxType;
import com.weini.manage.business.BusinessArea;
import com.weini.manage.business.User;
import com.weini.manage.dao.CSBoxDao;
/**
 * 处理盒子模型有关的所有Action
 * @author z
 *
 */
public class CSBoxAction extends ActionSupport{

	private Integer cityId;
	private String result;
	private Integer typeId;
	private Integer busId;
	
	List dataList; 
	
	public String boxType(){
		CSBoxDao dao=new CSBoxDao();
		dataList=dao.getBoxList(cityId);
		dao.close();
		
		result ="success";
		return "TYPESUCCESS";
	}
	
	/**
	 * 得到盒子模型对应的商业区
	 * @return
	 */
	public String supportArea(){
		System.out.println(typeId);
		CSBoxDao dao=new CSBoxDao();
		dataList=dao.getAreaList(typeId);
		dao.close();
		for(Object u:dataList){
			System.out.println(((BusinessArea)u).getBusinessAreaName());
		} 
		return "AREASUCCESS";
	}

	public String officeBuilding(){
		System.out.println(busId);
		CSBoxDao dao = new CSBoxDao();
		dataList = dao.getOfficeBuildingList(busId);
		dao.close();
		return "OFFICESUCCESS";
	}
	public String getResult() {
		return result;
	}

	public Integer getCityId() {
		return cityId;
	}


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public void setDataList(List<BoxType> dataList) {
		this.dataList = dataList;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public List getDataList() {
		return dataList;
	}
	


}
