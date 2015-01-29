package com.weini.manage.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.MenuinfoService;
import com.weini.manage.entity.TBusinessarea;
import com.weini.manage.entity.TCity;
import com.weini.manage.entity.TDistrict;
import com.weini.manage.entity.TMenuinfo;
import com.weini.manage.entity.TProvince;
import com.weini.manage.entity.TVendor;
import com.weini.tools.Configure;
import com.weini.tools.Tools;


public class GoodManageAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TMenuinfo> goodlist;
	private List<TProvince> provices;
	private int indexID;
	private List<TCity> citys;
	private List<TDistrict> diss;
	private List<TBusinessarea> busses;
	private List<TVendor> vendors;
	private boolean isExistGood;
	private boolean aflag;
	//图片上传
	private File uploadify;  
    private String uploadifyFileName;
    private String info;
    private String picNewPath;
    private boolean uploadSuccess;
    //增加商品
    private TMenuinfo menu;
    //商品信息
    private String menuName;
    private int vendorId;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String menuDetail;
    //判断是增加商品还是编辑商品
    private boolean isAdd;
    
	/**
	 * 列出所有的菜品
	 */
	public String listGood(){
		this.goodlist = (new MenuinfoService()).listMenuInfo(isExistGood);
		return "SUCCESS";
	}
	/**
	 * 更新菜品信息
	 * @return 更新结果
	 */
	public String updateGood(){
		TMenuinfo menu = new TMenuinfo();
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
		System.err.println("update");
		menu.setMenuinfoName(menuName);
		menu.setVendorId(vendorId);
		menu.setMenuinfoImage1(img1);
		menu.setMenuinfoImage2(img2);
		menu.setMenuinfoImage3(img3);
		menu.setMenuinfoImage4(img4);
		menu.setMenuinfoDetail(menuDetail);
		if(!isAdd){
			menu.setMenuinfoId(indexID);
		}
		//设置日期
		boolean res = false;
		try{
		menu.setMenuinfoDate(new Timestamp(System.currentTimeMillis()));
		res = (new MenuinfoService()).updateMenuInfo(menu,isAdd);
		System.out.println(indexID);
		System.out.println(res);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(res){
			this.uploadSuccess = true;
			this.info = "增加成功";
		}else{
			this.info = "增加失败";
		}
		return "SUCCESS";
	}
	
	public String addGood(){//增加菜品
		this.isAdd = true;
		return "SUCCESS";
	}
	
	public String editGood(){//编辑菜品
		this.isAdd = false;
		menu = (new MenuinfoService()).getEditMenuinfo(indexID);
		return "SUCCESS";
	}
	
	public String delGood(){//删除菜品
		this.aflag = (new MenuinfoService()).changeMenuStatus(indexID,false);
		return "SUCCESS";
	}
	
	public String recoverGood(){//恢复已删除菜品
		this.aflag = (new MenuinfoService()).changeMenuStatus(indexID,true);
		return "SUCCESS";
	}
	
	/**
	 * 获取菜品的详细信息
	 * @param 菜品id
	 * @return 菜品信息
	 */
	public String getGoodDetail(){
		return SUCCESS;
	}
	//TODO 应该放到VendorAction
	/**
	 * 根据所选择的商圈列出商家
	 * @return 商家列表
	 */
	public String listVendor(){
		this.vendors = (new MenuinfoService()).listVendorsByBussID(indexID);
		return "SUCCESS";
	}
	// TODO 处理异常
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
	public List<TMenuinfo> getGoodlist() {
		return goodlist;
	}

	public void setGoodlist(List<TMenuinfo> goodlist) {
		this.goodlist = goodlist;
	}

	public List<TProvince> getProvices() {
		return provices;
	}

	public void setProvices(List<TProvince> provices) {
		this.provices = provices;
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

	public List<TVendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<TVendor> vendors) {
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
	public TMenuinfo getMenu() {
		return menu;
	}
	public void setMenu(TMenuinfo menu) {
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
	public boolean getIsAdd() {
		return isAdd;
	}
	public void setIsAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}


	
}
