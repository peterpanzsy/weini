package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.DispatchingService;
import com.weini.manage.entity.TDispatching;
import com.weini.manage.entity.TDispatchingstatus;

public class DispatchingManageAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	DispatchingService disService = new DispatchingService();
	
	//请求的参数列表
	private Integer dispatchingId;
	private Integer dispatchingProvince;
	private Integer dispatchingCity;
	private Integer dispatchingDistrict;
	private Integer dispatchingBusinessAreaid;
	private Integer dispatchingOfficeBuilding;
	private String dispatchingAddressDetail;
	private Integer userId;
	private String dispatchingPhoneNum;
	//返回的参数列表
	private List list;
	private TDispatching dis;
	private TDispatchingstatus disstatus;
	private int code=0;//默认不成功
	private Object[] obj;
	
	/**
	 * 向数据库中添加TDispathing
	 * @return
	 */
	public String addDispatching(){
		if(disService.addDistaching(dispatchingProvince, dispatchingCity, dispatchingDistrict,
				dispatchingBusinessAreaid, dispatchingOfficeBuilding,dispatchingAddressDetail,userId,dispatchingPhoneNum)){
			code = 1;
		}
		return SUCCESS;
	}
	/**
	 * 根据用户Id列出所有的送餐地址
	 * @return
	 */
	public String listDispatching(){
		list = disService.findDispatchingByUserId(userId);
		return SUCCESS;
	}
	public DispatchingService getDisService() {
		return disService;
	}
	public void setDisService(DispatchingService disService) {
		this.disService = disService;
	}
	public Integer getDispatchingId() {
		return dispatchingId;
	}
	public void setDispatchingId(Integer dispatchingId) {
		this.dispatchingId = dispatchingId;
	}
	public Integer getDispatchingProvince() {
		return dispatchingProvince;
	}
	public void setDispatchingProvince(Integer dispatchingProvince) {
		this.dispatchingProvince = dispatchingProvince;
	}
	public Integer getDispatchingCity() {
		return dispatchingCity;
	}
	public void setDispatchingCity(Integer dispatchingCity) {
		this.dispatchingCity = dispatchingCity;
	}
	public Integer getDispatchingDistrict() {
		return dispatchingDistrict;
	}
	public void setDispatchingDistrict(Integer dispatchingDistrict) {
		this.dispatchingDistrict = dispatchingDistrict;
	}
	public Integer getDispatchingBusinessAreaid() {
		return dispatchingBusinessAreaid;
	}
	public void setDispatchingBusinessAreaid(Integer dispatchingBusinessAreaid) {
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
	}
	public Integer getDispatchingOfficeBuilding() {
		return dispatchingOfficeBuilding;
	}
	public void setDispatchingOfficeBuilding(Integer dispatchingOfficeBuilding) {
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
	}
	public String getDispatchingAddressDetail() {
		return dispatchingAddressDetail;
	}
	public void setDispatchingAddressDetail(String dispatchingAddressDetail) {
		this.dispatchingAddressDetail = dispatchingAddressDetail;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDispatchingPhoneNum() {
		return dispatchingPhoneNum;
	}
	public void setDispatchingPhoneNum(String dispatchingPhoneNum) {
		this.dispatchingPhoneNum = dispatchingPhoneNum;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public TDispatching getDis() {
		return dis;
	}
	public void setDis(TDispatching dis) {
		this.dis = dis;
	}
	public TDispatchingstatus getDisstatus() {
		return disstatus;
	}
	public void setDisstatus(TDispatchingstatus disstatus) {
		this.disstatus = disstatus;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object[] getObj() {
		return obj;
	}
	public void setObj(Object[] obj) {
		this.obj = obj;
	}
}
