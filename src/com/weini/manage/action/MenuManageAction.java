package com.weini.manage.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.BoxService;
import com.weini.manage.business.MenuinfoService;
import com.weini.manage.entity.TBox;
import com.weini.manage.entity.TDishes;
import com.weini.manage.entity.TMenuinfo;
import com.weini.manage.entity.TMenutype;

public class MenuManageAction extends ActionSupport {
	
	MenuinfoService menuService ;
	
	private int code=0;  //状态，0-失败 ，1-成功
	private String result;  //错误信息
	private Integer menuinfoId;
	private TMenuinfo menu;
	private List list;
	private TMenutype menutype;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 得到所有存在的菜品信息
	 * @return
	 */
	public String listMenuinfo(){
		list = (new MenuinfoService()).getMenuInfoList();
		if(list != null){
			code = 1;
		}else{
			code = 0;
		}
		return "SUCCESS";
	}
	/**
	 * 根据菜品Id的到菜品的详细信息
	 * @return
	 */
	public String menuinfoDetail(){
		if(menuinfoId==null){
			code = 0; 
			result="参数不正确";
			return "FAIL";
		}
		menu = new MenuinfoService().findMenuById(menuinfoId);
		if(menu==null){
			code = 0; 
			result="没有记录";
			return "FAIL";
		}
		code = 1;
		return "SUCCESS";
	}

	
	public String listMenutype(){
		menuService = new MenuinfoService();
		list = menuService.listMenutype();
		if(list.size()==0){
			code = 0;
			return "fail";
		}
		code = 1 ;
		return SUCCESS;
	}

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getMenuinfoId() {
		return menuinfoId;
	}
	public void setMenuinfoId(Integer menuinfoId) {
		this.menuinfoId = menuinfoId;
	}
	public TMenuinfo getMenu() {
		return menu;
	}
	public void setMenu(TMenuinfo menu) {
		this.menu = menu;
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

	public TMenutype getMenutype() {
		return menutype;
	}

	public void setMenutype(TMenutype menutype) {
		this.menutype = menutype;
	}
}
