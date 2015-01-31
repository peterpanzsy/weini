package com.weini.manage.business;

import java.util.List;

import com.weini.manage.dao.BoxPageinfoDao;
import com.weini.manage.dao.StartPageinfoDao;
import com.weini.manage.dao.TrackpageDao;
import com.weini.manage.dao.VersionDao;
import com.weini.manage.entity.TBoxpage;
import com.weini.manage.entity.TStartpageinfo;
import com.weini.manage.entity.TTrackpage;
import com.weini.manage.entity.TVersion;

public class StartUpdateService extends GeneralService {
	private VersionDao versiondao = new VersionDao(this.session);
	private StartPageinfoDao startpagedao = new StartPageinfoDao(this.session);
	private BoxPageinfoDao boxpagedao = new BoxPageinfoDao(this.session);
	private TrackpageDao trackpagedao = new TrackpageDao(this.session);
	/**
	 * 根据手机类型，获取最新版本信息和上一个版本信息
	 * @param phoneType 手机类型
	 * @return
	 */
	public List<Object[]> getVersionUpdate(int phoneType){
		List<Object[]> res = null;
		try{
			res = this.versiondao.getVersionInfoByType(phoneType);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	/**
	 * 获取启动页面信息，如果启动页面id和手机本地页面id相同，则返回null
	 * @param phoneType 手机类型
	 * @param index 手机本地启动页面id
	 * @return 
	 */
	public List<Object> getStartPageinfo(int phoneType,int index){
		List<Object> res = null;
		try{
			res = this.startpagedao.getNowStartPageinfoByType(phoneType);
			if(res.size() > 0 && (int)res.get(0) == index){
				res = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	/**
	 * 获取盒子模式的页面信息 
	 * @param index 手机本地的页面id
	 * @return
	 */
	public List<Object> getBoxPageinfo(int index){
		List<Object> res = null;
		try{
			res = this.boxpagedao.getBoxpageinfo();
			if(res.size() > 0 && (int)res.get(0) == index){
				res = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
	}
	/**
	 * 根据传入的文案id获取文案信息
	 * @param trackid 溯源文案id
	 * @return
	 */
	public List<Object> getTrackPageinfo(int trackid){
		List<Object> res = null;
		try{
			res = this.trackpagedao.getTrackpage(trackid);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
				
	}
}
