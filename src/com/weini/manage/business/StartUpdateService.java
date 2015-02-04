package com.weini.manage.business;

import java.util.List;

import com.weini.manage.dao.BoxModelDao;
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
	private BoxModelDao boxpagedao = new BoxModelDao(this.session);
	private TrackpageDao trackpagedao = new TrackpageDao(this.session);
	/**
	 * 根据手机类型，获取最新版本信息和上一个版本信息
	 * @param phoneType 手机类型
	 * @return 成功返回list 失败返回null
	 */
	public List<TVersion> getVersionUpdate(int phoneType){
		List<TVersion> res = null;
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
	public TStartpageinfo getStartPageinfo(int phoneType,int index){
		TStartpageinfo res = null;
		try{
			res = this.startpagedao.getNowStartPageinfoByType(phoneType);
			if(res != null && res.getStartpageId() == index){
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
	public TBoxpage getBoxPageinfo(int index){
		TBoxpage res = null;
		try{
			res = this.boxpagedao.getBoxpageinfo();
			if(res != null && res.getBoxpageId() == index){
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
	public TTrackpage getTrackPageinfo(int trackid){
		TTrackpage res = null;
		try{
			res = this.trackpagedao.getTrackpage(trackid);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.close();
		return res;
				
	}
}
