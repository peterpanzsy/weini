package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.DispatchingService;
import com.weini.manage.entity.TDispatching;
import com.weini.manage.entity.TDispatchingstatus;
import com.weini.tools.Tools;

public class DispatchingManageAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	DispatchingService disService ;
	
	//请求的参数列表
	private int dispatchingId;
	private int dispatchingProvince;
	private int dispatchingCity;
	private int dispatchingDistrict;
	private int dispatchingBusinessAreaid;
	private int dispatchingOfficeBuilding;
	private String dispatchingAddressDetail;
	private String dispatchingPhoneNum;
	//分派id
	//返回的参数列表
	private List list;
	private TDispatching dis;
	private TDispatchingstatus disstatus;
	private int code=0;//默认不成功
	private String result;
	
	/**
	 * 向数据库中添加TDispathing
	 * @return
	 */
	public String addDispatching(){
		int userID = Tools.getUserID();
		if(userID == -1){
			System.err.println("用户没有登录");
			code = 0; 
			result = "用户没有登录";
			return "FAIL";
		}
		disService = new DispatchingService();
		if(disService.addDistaching(dispatchingProvince, dispatchingCity, dispatchingDistrict,
				dispatchingBusinessAreaid, dispatchingOfficeBuilding,dispatchingAddressDetail,userID,dispatchingPhoneNum)){
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 根据用户Id列出所有的送餐地址
	 * @return
	 */
	public String listDispatching(){
		code = 0;
		int userID = Tools.getUserID();
		if(userID == -1){
			System.err.println("用户没有登录");
			code = 0; 
			result = "用户没有登录";
			return "FAIL";
		}
		list = new DispatchingService().findDispatchingByUserId(userID);
		if(list != null && list.size() > 0){
			code = 1;
		}
		return "SUCCESS";
		
	}
	/**
	 * 删除用户的送餐地址
	 * @return 0:失败；1成功
	 */
	public String delDispatching(){
		code = 0;
		if(dispatchingId <= 0){
			result = "送餐地址不存在";
			return "FAIL";
		}
		if((new DispatchingService()).delDispatching(dispatchingId)){
			code = 1;
		}else{
			result = "执行失败";
			return "FAIL";
		}
		return "SUCCESS";
	}
	/**
	 * 删除用户的送餐地址
	 * 
	 * @return 0:失败；1成功
	 */
	public String ChangeUserDefaultDispatchingId(){
		code = 0;
		int userId = Tools.getUserID();
		if(userId == -1){
			result = "用户未登录";
			return "FAIL";
		}
		if(dispatchingId <= 0){
			result = "送餐地址不存在";
			return "FAIL";
		}
		if((new DispatchingService()).setUserDefaultDispatching(dispatchingId, userId)){
			code = 1;
		}else{
			result = "执行失败";
			return "FAIL";
		}
		return "SUCCESS";
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
