package com.weini.manage.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.BusinessArea;
import com.weini.manage.business.City;
import com.weini.manage.business.District;
import com.weini.manage.business.Menuinfo;
import com.weini.manage.business.Vendor;
import com.weini.manage.dao.GoodManageDao;
import com.weini.manage.business.Province;
import com.weini.tools.Configure;
import com.weini.tools.Tools;


public class GoodManageAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GoodManageDao gooddao;
	private List<Menuinfo> goodlist;
	private List<Province> provices;
	private int indexID;
	private List<City> citys;
	private List<District> diss;
	private List<BusinessArea> busses;
	private List<Vendor> vendors;
	private boolean isExistGood;
	private boolean aflag;
	//图片上传
	private File uploadify;  
    private String uploadifyFileName;
    private String info;
    private String picNewPath;
    private boolean uploadSuccess;
    //增加商品
    private Menuinfo menu;
    //商品信息
    private String menuName;
    private int vendorId;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String menuDetail;
    
	/**
	 * 列出所有的菜品
	 */
	public String listGood(){
		gooddao = new GoodManageDao();
		this.goodlist = gooddao.listGoodInfo(isExistGood);
		gooddao.close();
		return "SUCCESS";
	}
	/**
	 * 增加菜品
	 * @return 增加的结果
	 */
	public String addGood(){
		gooddao = new GoodManageDao();
		Menuinfo menu = new Menuinfo();
		this.uploadSuccess = false;
		//商品名称不能为空
		if(menuName == null || menuName.equals("")){
			this.info = "商品名称不能为空";
			return "SUCCESS";
		}
		//商家不能为空
		if(vendorId <= 0){
			this.info = "商家不能为空";
			return "SUCCESS";
		}
		//商品图片不能为空
		if(img1 == null || img1.equals("") || img2 == null || img2.equals("")
				|| img3 == null || img3.equals("") || img4 == null || img4.equals("")){
			this.info = "商品图片不能为空";
			return "SUCCESS";
		}
		//商家详细不能为空
		if(menuDetail == null || menuDetail.equals("")){
			this.info = "商品描述不能为空";
			return "SUCCESS";
		}
		menu.setMenuinfoName(menuName);
		menu.setVendorId(vendorId);
		menu.setMenuinfoImage1(img1);
		menu.setMenuinfoImage2(img2);
		menu.setMenuinfoImage3(img3);
		menu.setMenuinfoImage4(img4);
		menu.setMenuinfoDetail(menuDetail);
		//设置日期
		menu.setMenuinfoDate(new Timestamp(System.currentTimeMillis()));
		boolean res = gooddao.addGoodInfo(menu);
		if(res){
			this.uploadSuccess = true;
			this.info = "增加成功";
			gooddao.close();
		}else{
			this.info = "增加失败";
			gooddao.roll();
		}
		return "SUCCESS";
	}
	
	public String delGood(){//删除菜品
		gooddao = new GoodManageDao();
		this.aflag = gooddao.changeGoodStatus(indexID,false);
		gooddao.close();
		return "SUCCESS";
	}
	
	public String recoverGood(){//删除菜品
		gooddao = new GoodManageDao();
		this.aflag = gooddao.changeGoodStatus(indexID,true);
		gooddao.close();
		return "SUCCESS";
	}
	/**
	 * 列出所有的省份
	 * @return
	 */
	public String listCity(){
		gooddao = new GoodManageDao();
		this.citys = gooddao.listCityInfoByProviceID(this.indexID);
		gooddao.close();
		return "SUCCESS";
	}
	
	/**
	 * 列出城市根据选择的省份
	 * @return
	 */
	public String listDistrict(){
		gooddao = new GoodManageDao();
		this.diss = gooddao.listDistrictInfoByCityID(indexID);
		gooddao.close();
		return "SUCCESS";
	}
	/**
	 * 列出商圈根据所选择的城市
	 * @return
	 */
	public String listbussArea(){
		gooddao = new GoodManageDao();
		this.busses = gooddao.listBusinessareaInfoByDistrictID(indexID);
		gooddao.close();
		return "SUCCESS";
	}
	
	/**
	 * 列出商家根据所选择的商圈
	 * @return 商家列表
	 */
	public String listVendor(){
		gooddao = new GoodManageDao();
		this.vendors = gooddao.listVendorInfoByDistrictID(indexID);
		gooddao.close();
		return "SUCCESS";
	}
	
	/**
	 * 
	 * @return
	 */
	public String listProvice(){
		gooddao = new GoodManageDao();
		this.provices = gooddao.listProivceInfo();
		gooddao.close();
		return "SUCCESS";
	}

	public String uploadPicture() throws IOException{
		this.uploadSuccess = false;
		String savePath = ServletActionContext.getServletContext().getRealPath(Configure.goodPicPath);//上传完后文件存放位置  
        String newsuffix = "";
		//获取后缀名
		if((this.uploadifyFileName != null) && (this.uploadifyFileName.length() > 0)){
			int dot = uploadifyFileName.lastIndexOf(".");  
            if((dot >-1) && (dot < (uploadifyFileName.length() - 1)))  
            {  
                 newsuffix = uploadifyFileName.substring(dot + 1);
            }  
		}
		//判断类型
		if(newsuffix == "" || !Configure.goodPicSuffix.contains(newsuffix)){
			this.info = "上传失败，文件格式不对！";
			return "SUCCESS";
		}
        //判断大小
		if(this.uploadify == null || (this.uploadify.length() > Configure.goodPicMaxSize )){
			this.info = "上传失败，文件大于3M";
			return "SUCCESS";
		}
		String desPathTemp =  File.separator+Tools.getUUID() + "." + newsuffix;
		if(!Tools.copyFile(this.uploadify.getAbsolutePath(), savePath + desPathTemp ,true)){
			this.info = "上传失败";
			return "SUCCESS";
		}
		this.uploadSuccess = true;
		this.picNewPath = Configure.goodPicPath.substring(1) + desPathTemp;
		this.info = "上传成功";
		return "SUCCESS";
	}
	public List<Menuinfo> getGoodlist() {
		return goodlist;
	}

	public void setGoodlist(List<Menuinfo> goodlist) {
		this.goodlist = goodlist;
	}

	public List<Province> getProvices() {
		return provices;
	}

	public void setProvices(List<Province> provices) {
		this.provices = provices;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public List<District> getDiss() {
		return diss;
	}

	public void setDiss(List<District> diss) {
		this.diss = diss;
	}

	public List<BusinessArea> getBusses() {
		return busses;
	}

	public void setBusses(List<BusinessArea> busses) {
		this.busses = busses;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public boolean getIsExistGood() {
		return isExistGood;
	}

	public void setIsExistGood(boolean isExistGood) {
		this.isExistGood = isExistGood;
	}

	public int getIndexID() {
		return indexID;
	}

	public void setIndexID(int indexID) {
		this.indexID = indexID;
	}

	public boolean getAflag() {
		return aflag;
	}

	public void setAflag(boolean aflag) {
		this.aflag = aflag;
	}

	public File getUploadify() {
		return uploadify;
	}

	public void setUploadify(File uploadify) {
		this.uploadify = uploadify;
	}

	public String getUploadifyFileName() {
		return uploadifyFileName;
	}

	public void setUploadifyFileName(String uploadifyFileName) {
		this.uploadifyFileName = uploadifyFileName;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPicNewPath() {
		return picNewPath;
	}

	public void setPicNewPath(String picNewPath) {
		this.picNewPath = picNewPath;
	}

	public boolean getUploadSuccess() {
		return uploadSuccess;
	}

	public void setUploadSuccess(boolean uploadSuccess) {
		this.uploadSuccess = uploadSuccess;
	}
	public Menuinfo getMenu() {
		return menu;
	}
	public void setMenu(Menuinfo menu) {
		this.menu = menu;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getMenuDetail() {
		return menuDetail;
	}
	public void setMenuDetail(String menuDetail) {
		this.menuDetail = menuDetail;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}


	
}
