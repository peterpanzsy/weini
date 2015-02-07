package com.weini.manage.entity;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用来存送货地址，只用户查看，相当于一张临时表
 * @author wpr
 *
 */
public class DispatchingAddress {
	private Integer dispatchingId;
	private String dispatchingProvince;
	private String dispatchingCity;
	private String dispatchingDistrict;
	private String dispatchingBusinessAreaid;
	private String dispatchingOfficeBuilding;
	private String dispatchingAddressDetail;
	private String dispatchingPhoneNum;
	
	public DispatchingAddress(Integer dispatchingId,
			String dispatchingProvince, String dispatchingCity,
			String dispatchingDistrict, String dispatchingBusinessAreaid,
			String dispatchingOfficeBuilding, String dispatchingAddressDetail,
			String dispatchingPhoneNum) {
		this.dispatchingId = dispatchingId;
		this.dispatchingProvince = dispatchingProvince;
		this.dispatchingCity = dispatchingCity;
		this.dispatchingDistrict = dispatchingDistrict;
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
		this.dispatchingOfficeBuilding = dispatchingOfficeBuilding;
		this.dispatchingAddressDetail = dispatchingAddressDetail;
		this.dispatchingPhoneNum = dispatchingPhoneNum;
	}
	
	public DispatchingAddress() {
		super();
	}

	public Integer getDispatchingId() {
		return dispatchingId;
	}
	public void setDispatchingId(Integer dispatchingId) {
		this.dispatchingId = dispatchingId;
	}
	public String getDispatchingProvince() {
		return dispatchingProvince;
	}
	public void setDispatchingProvince(String dispatchingProvince) {
		this.dispatchingProvince = dispatchingProvince;
	}
	public String getDispatchingCity() {
		return dispatchingCity;
	}
	public void setDispatchingCity(String dispatchingCity) {
		this.dispatchingCity = dispatchingCity;
	}
	public String getDispatchingDistrict() {
		return dispatchingDistrict;
	}
	public void setDispatchingDistrict(String dispatchingDistrict) {
		this.dispatchingDistrict = dispatchingDistrict;
	}
	public String getDispatchingBusinessAreaid() {
		return dispatchingBusinessAreaid;
	}
	public void setDispatchingBusinessAreaid(String dispatchingBusinessAreaid) {
		this.dispatchingBusinessAreaid = dispatchingBusinessAreaid;
	}
	public String getDispatchingOfficeBuilding() {
		return dispatchingOfficeBuilding;
	}
	public void setDispatchingOfficeBuilding(String dispatchingOfficeBuilding) {
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
	@Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }
}