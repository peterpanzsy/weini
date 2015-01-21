//package com.weini.manage.action;
//
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//
//import org.apache.struts2.ServletActionContext;
//
//import com.opensymphony.xwork2.ActionSupport;
//import com.weini.manage.business.Menu;
//import com.weini.manage.dao.MenuDao;
//
//public class CSMenuAction extends ActionSupport{
//	private String fileName;
//	private int num;
//	private int menuId;
//	private String result;
//	private InputStream in =null;
//	private Menu menu;
//	private Float point; //用户评分
//	String realPath = null;
//	
//	public InputStream getDownloadFile() throws Exception  {
//		return in;
//	}
//	public String execute(){
//		if(num<1||num>4){
//			result ="参数错误";
//			return "FAIL";
//		}
//		MenuDao dao = new MenuDao();
//		this.setFileName(dao.getFileName(menuId, num));
//		dao.close();
//		realPath = "/MenuImages/"+fileName;
//		in = ServletActionContext.getServletContext().getResourceAsStream(realPath);
//		if(null==in){
//			result = "文件不存在";
//			return "FAIL";
//		}
//		return "SUCCESS";
//	}
//
//	public String detailMsg(){
//		MenuDao dao = new MenuDao();
//		menu = dao.menuDetail(menuId);
//		dao.close();
//		if(menu==null){
//			result = "文件不存在";
//			return "FAIL";
//		}
//		return "DETAIL";
//	}
//	
//	public String evaluate(){
//		MenuDao dao = new MenuDao();
//		int t = dao.updatePoint(menuId,point);
//		dao.close();
//		if(t!=0){
//			result ="评论成功";
//		}else{
//			result="网络堵车，请重试";
//		}
//		return "FAIL";
//	}
//
//	public String getFileName() {
//		return fileName;
//	}
//
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//
//	public int getNum() {
//		return num;
//	}
//
//	public void setNum(int num) {
//		this.num = num;
//	}
//	public int getMenuId() {
//		return menuId;
//	}
//	public void setMenuId(int menuId) {
//		this.menuId = menuId;
//	}
//	public Menu getMenu() {
//		return menu;
//	}
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}
//	public Float getPoint() {
//		return point;
//	}
//	public void setPoint(Float point) {
//		this.point = point;
//	}
//	public String getResult() {
//		return result;
//	}
//	public void setResult(String result) {
//		this.result = result;
//	}
//}
