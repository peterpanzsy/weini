package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.StartUpdateService;


public class ClientStartUpdateAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int phoneType;
	private List<Object[]> dataResult;
	private List<Object> startPage;
	private List<Object> boxPage;
	private int index;
	private List<Object> trackPage;
	/**
	 *应用启动时，获取最新的系统版本信息
	 *@param 手机系统类型
	 * @return 返回最新版本和前一版本
	 */
	public String getLastVersion(){
		dataResult = (new StartUpdateService()).getVersionUpdate(phoneType);
		return "SUCCESS";
	}
	/**
	 * 应用启动时，查看是否需要加载图片
	 * @param 手机本地的图片id
	 * @return 如果有，返回图片信息；否则，返回null
	 */
	public String getStartPageUpdate(){
		startPage = (new StartUpdateService()).getStartPageinfo(phoneType,index);
		return "SUCCESS";
	}
	/**
	 * 应用启动时，获取盒子模式页面的信息
	 * @param 传入手机本地盒子页面的id
	 * @return 如果有返回页面信息；否则，返回null
	 */
	public String getBoxPageInfo(){
		boxPage = (new StartUpdateService()).getBoxPageinfo(index);
		return "SUCCESS";
	}
	/**
	 * 应用启动时，获取溯源页面的文案信息
	 * @param 出入所需的溯源文案id
	 * @return 如果有，返回页面信息；否则，返回null
	 */
	public String getTrackPageInfo(){
		trackPage = (new StartUpdateService()).getTrackPageinfo(index);
		return "SUCCESS";
	}
	public int getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(int phoneType) {
		this.phoneType = phoneType;
	}
	public List<Object[]> getDataResult() {
		return dataResult;
	}
	public void setDataResult(List<Object[]> dataResult) {
		this.dataResult = dataResult;
	}
	public List<Object> getStartPage() {
		return startPage;
	}
	public void setStartPage(List<Object> startPage) {
		this.startPage = startPage;
	}
	public List<Object> getBoxPage() {
		return boxPage;
	}
	public void setBoxPage(List<Object> boxPage) {
		this.boxPage = boxPage;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<Object> getTrackPage() {
		return trackPage;
	}
	public void setTrackPage(List<Object> trackPage) {
		this.trackPage = trackPage;
	}
	
}
