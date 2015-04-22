package com.weini.manage.action;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.VendorService;
import com.weini.manage.entity.TVendor;


public class VendorAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String adminPassword;
	String confirmPassword;
	String mark;
	int id;
	List<TVendor> dataList;
	int result;
	
	private int order;
    private int vendorID;
    private String vendorName;
    private String vendorMail;
    private String vendorPhonenum;
    private String vendorPassword;
    private Boolean vendorIsopen;
    private int vendorTotalmoney;
    private int vendorPaidmoney;
    private int vendorRemainedmoney;
    private int vendorEmploynum;
    private int vendorCooknum; 
    private String vendorShophourStart;
    private String vendorShophourEnd;
    private int vendorPaytype;
    private String vendorAccount;
    private String vendorBusinessArea;
    private String vendorDis;
    private String vendorCity;
    private String vendorProvince;
    private String vendorDetail;

    public String listVendor(){
        dataList = (new VendorService()).getVendorList();
        return SUCCESS;
    }
    /**
     * 更新或添加账户
     * vendorID:商家id
     * vendorName：商家名称
     * vendorMail：商家邮箱
     * vendorPhonenum：商家电话号码
     * vendorIsopen：商家是否营业
     * vendorEmploynum:商家员工数
     * vendorCooknum：商家厨师数
     * vendorShophourStart：商家开始营业时间
     * vendorShophourEnd：商家结束营业时间
     * vendorDetail：商家详细描述
     * mark add:增加账户;edit编辑账户
     * @return
     */
	public String updateVendor(){ 
		TVendor vendor = new TVendor();
		if(mark.equalsIgnoreCase("edit")){
			vendor.setVendorId(vendorID);
		}
		vendor.setVendorName(vendorName);
		vendor.setVendorMail(vendorMail);
		vendor.setVendorPhonenum(vendorPhonenum);
		if(vendorIsopen){
			vendor.setVendorIsopen(1);
		}else{
			vendor.setVendorIsopen(0);
		}
		vendor.setVendorEmployernum(vendorEmploynum);
		vendor.setVendorCooknum(vendorCooknum);
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			Date shopStart = format.parse(vendorShophourStart);
			Date shopEnd = format.parse(vendorShophourEnd);
			vendor.setVendorShophourStart(new Timestamp(shopStart.getTime()));
			vendor.setVendorShophourEnd(new Timestamp(shopEnd.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
			result = 0;
			return "SUCCESS";
		}
		vendor.setVendorDetail(vendorDetail);
		if((new VendorService()).updateVendor(vendor)){
			result = 1;
		}else{
			result = 0;
		}
		return "SUCCESS";
	}
	public String delVendor(){//删除账户		
		if((new VendorService().delVendor(vendorID))){
			result = 1;
		}else{
			result = 0;
		}
		return "SUCCESS";
	}


    public List<TVendor> getDataList() {
        return dataList;
    }

    public void setDataList(List<TVendor> dataList) {
        this.dataList = dataList;
    }

    public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getVendorID() {
		return vendorID;
	}
	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorMail() {
		return vendorMail;
	}
	public void setVendorMail(String vendorMail) {
		this.vendorMail = vendorMail;
	}
	public String getVendorPhonenum() {
		return vendorPhonenum;
	}
	public void setVendorPhonenum(String vendorPhonenum) {
		this.vendorPhonenum = vendorPhonenum;
	}
	public String getVendorPassword() {
		return vendorPassword;
	}
	public void setVendorPassword(String vendorPassword) {
		this.vendorPassword = vendorPassword;
	}
	public Boolean getVendorIsopen() {
		return vendorIsopen;
	}
	public void setVendorIsopen(Boolean vendorIsopen) {
		this.vendorIsopen = vendorIsopen;
	}
	public int getVendorTotalmoney() {
		return vendorTotalmoney;
	}
	public void setVendorTotalmoney(int vendorTotalmoney) {
		this.vendorTotalmoney = vendorTotalmoney;
	}
	public int getVendorPaidmoney() {
		return vendorPaidmoney;
	}
	public void setVendorPaidmoney(int vendorPaidmoney) {
		this.vendorPaidmoney = vendorPaidmoney;
	}
	public int getVendorRemainedmoney() {
		return vendorRemainedmoney;
	}
	public void setVendorRemainedmoney(int vendorRemainedmoney) {
		this.vendorRemainedmoney = vendorRemainedmoney;
	}
	public int getVendorEmploynum() {
		return vendorEmploynum;
	}
	public void setVendorEmploynum(int vendorEmploynum) {
		this.vendorEmploynum = vendorEmploynum;
	}
	public int getVendorCooknum() {
		return vendorCooknum;
	}
	public void setVendorCooknum(int vendorCooknum) {
		this.vendorCooknum = vendorCooknum;
	}
	public int getVendorPaytype() {
		return vendorPaytype;
	}
	public String getVendorShophourStart() {
		return vendorShophourStart;
	}
	public void setVendorShophourStart(String vendorShophourStart) {
		this.vendorShophourStart = vendorShophourStart;
	}
	public String getVendorShophourEnd() {
		return vendorShophourEnd;
	}
	public void setVendorShophourEnd(String vendorShophourEnd) {
		this.vendorShophourEnd = vendorShophourEnd;
	}
	public void setVendorPaytype(int vendorPaytype) {
		this.vendorPaytype = vendorPaytype;
	}
	public String getVendorAccount() {
		return vendorAccount;
	}
	public void setVendorAccount(String vendorAccount) {
		this.vendorAccount = vendorAccount;
	}
	public String getVendorBusinessArea() {
		return vendorBusinessArea;
	}
	public void setVendorBusinessArea(String vendorBusinessArea) {
		this.vendorBusinessArea = vendorBusinessArea;
	}
	public String getVendorDis() {
		return vendorDis;
	}
	public void setVendorDis(String vendorDis) {
		this.vendorDis = vendorDis;
	}
	public String getVendorCity() {
		return vendorCity;
	}
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public String getVendorProvince() {
		return vendorProvince;
	}
	public void setVendorProvince(String vendorProvince) {
		this.vendorProvince = vendorProvince;
	}
	
	public String getVendorDetail() {
		return vendorDetail;
	}
	public void setVendorDetail(String vendorDetail) {
		this.vendorDetail = vendorDetail;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
}
