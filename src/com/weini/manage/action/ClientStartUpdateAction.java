package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.StartUpdateService;
import com.weini.manage.entity.TBoxpage;
import com.weini.manage.entity.TStartpageinfo;
import com.weini.manage.entity.TTrackpage;


public class ClientStartUpdateAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int phoneType;
	private List dataResult;
	private TStartpageinfo startPage;
	private TBoxpage boxPage;
	private int index;
	private int code;
	/**
	 *应用启动时，获取最新的系统版本信息
	 *@param 手机系统类型
	 * @return 返回最新版本和前一版本
	 */
	public String getLastVersion(){
		code = 0;
		setDataResult((new StartUpdateService()).getVersionUpdate(phoneType));
		if(this.dataResult != null && this.dataResult.size() > 0){
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 应用启动时，查看是否需要加载图片
	 * @param 手机本地的图片id
	 * @return 如果有，返回图片信息；否则，返回null
	 */
	public String getStartPageUpdate(){
		code = 0;
		startPage = (new StartUpdateService()).getStartPageinfo(phoneType,index);
		if(this.startPage != null){
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 应用启动时，获取盒子模式页面的信息
	 * @param 传入手机本地盒子页面的id
	 * @return 如果有返回页面信息；否则，返回null
	 */
	public String getBoxPageInfo(){
		code = 0;
		boxPage = (new StartUpdateService()).getBoxPageinfo(index);
		if(boxPage != null){
			code = 1;
		}
		return "SUCCESS";
	}

	public int getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(int phoneType) {
		this.phoneType = phoneType;
	}
	public TStartpageinfo getStartPage() {
		return startPage;
	}
	public void setStartPage(TStartpageinfo startPage) {
		this.startPage = startPage;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List getDataResult() {
		return dataResult;
	}
	public TBoxpage getBoxPage() {
		return boxPage;
	}
	public void setBoxPage(TBoxpage boxPage) {
		this.boxPage = boxPage;
	}
	public void setDataResult(List dataResult) {
		this.dataResult = dataResult;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
