package com.weini.manage.action;

import com.opensymphony.xwork2.ActionSupport;


public class ClientStartUpdateAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *应用启动时，获取最新的系统版本信息
	 *@param 手机系统类型
	 * @return 返回最新版本和前一版本
	 */
	public String getLastVersion(){
		return SUCCESS;
	}
	/**
	 * 应用启动时，查看是否需要加载图片
	 * @param 手机本地的图片id
	 * @return 如果有，返回图片信息；否则，返回null
	 */
	public String getStartPageUpdate(){
		return SUCCESS;
	}
	/**
	 * 应用启动时，获取盒子模式页面的信息
	 * @param 传入手机本地盒子页面的id
	 * @return 如果有返回页面信息；否则，返回null
	 */
	public String getBoxPageInfo(){
		return SUCCESS;
	}
	/**
	 * 应用启动时，获取溯源页面的文案信息
	 * @param 传入手机本地的溯源页面文案的id
	 * @return 如果有，返回页面信息；否则，返回null
	 */
	public String getTrackPageInfo(){
		return SUCCESS;
	}
}
