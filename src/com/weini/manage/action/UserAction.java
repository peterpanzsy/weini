package com.weini.manage.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.UserService;
import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TUserextra;
import com.weini.tools.Configure;
import com.weini.tools.Tools;
import com.weini.tools.TwoEntity;


public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	String mark;
	List<TUser> dataList;
	
	private int order;
    private String userName;
    private String userAddress;
	private String userPhoneNumber;
    private int userPhoneType;
    private int userScale;
    
    private String bankName;
    private String bankUserName;
    private String bankCardNumber;
    private String subBankName;
    private String subBankAddress;
	
    private String alipayUserName;
    private String alipayUserAccount;
    
	private String weChatPay;
	
	private String userRegdate;
	
	private int pointTotal;
	//--------wang------------//
	//请求的参数
	private int menutypeId; //修改忌口
    private int userGender;
    private String userBirthday;
	//返回的参数
	private TUser tuser;
	private TUserextra tuserextra;
	private int code=0;  //状态，0-失败 ，1-成功
	private String result;  //错误信息
//	private Object[] obj;
	
//	public String listUser(){//根据角色获取账户列表		
//		UserDaoDEL dao=new UserDaoDEL();
//		dataList=dao.getUserList();
//		dao.close();
//		return "SUCCESS";
//	}
//	public String updateVendor(){//更新或者添加账户 
//	
//		return "SUCCESS";
//	}
//	public String delUser(){//删除账户		
//		UserDaoDEL dao=new UserDaoDEL();
//		dao.delUser(userID);
//		dao.close();
//		return "SUCCESS";
//	}
	/**
	 * 用户修改密码
	 * @return
	 */
	public String changePwd(){
		return SUCCESS;
	}
	/**
	 * 获取用户的个人信息
	 * @return
	 */
	public String findUserInfo(){
		userService = new UserService();
		int userID = Tools.getUserID();
		if(userID == -1){
			System.err.println("用户没有登录");
			code = 0; 
			result="用户没有登录";
			return "FAIL";
		}
		try {
			TwoEntity two = userService.findUserInfo(userID);
			tuser = (TUser)two.getIndex1();
			tuserextra = (TUserextra)two.getIndex2();
			if(tuser==null){
				code = 0; 
				result="没有记录";
				return "FAIL";
			}
			code = 1;
		} catch (Exception e) {
			e.printStackTrace();
			code = 0; 
			result="参数有误";
			return "FAIL";
		}
		return SUCCESS;
	}
	/**
	 * 修改用户忌口
	 * @return
	 */
	public String updateUserNotEat(){
		code = 0;
		Map session = ActionContext.getContext().getSession();
		TUser user = (TUser) session.get(Configure.sessionUserName);
		if(user == null){
			code = 0; 
			result="用户没有登录";
			return "FAIL";
		}
		user.setUserHeat(menutypeId);
		code = (new UserService()).updateUser(user);
		if(code == 1){
			session.put(Configure.sessionUserName, user);
		}
		return "SUCCESS";
	}
	/**
	 * 修改用户性别
	 * @return
	 */
	public String updateUserGender(){
		code = 0;
		Map session = ActionContext.getContext().getSession();
		TUser user = (TUser) session.get(Configure.sessionUserName);
		if(user == null){
			code = 0; 
			result="用户没有登录";
			return "FAIL";
		}
		user.setUserGender(userGender);
		code = (new UserService()).updateUser(user);
		if(code == 1){
			session.put(Configure.sessionUserName, user);
		}
		return "SUCCESS";
	}
	/**
	 * 修改用户生日
	 * @return
	 */
	public String updateUserBirthday(){
		userService = new UserService();
		int userID = Tools.getUserID();
		if(userID == -1){
			code = 0; 
			result="用户没有登录";
			return "FAIL";
		}
		Date date = null;
		try{
			date = new SimpleDateFormat("yyyy-MM-dd").parse(userBirthday);
		}catch(Exception e){
			e.printStackTrace();
			code = 0; 
			result="参数错误";
			return "FAIL";
		}
		code = userService.updateUserBirthday(userID,date);
		return "SUCCESS";
	}
	/**
	 * 上传用户图像
	 * @return
	 */
	public String updateUserImage(){
		userService = new UserService();
		int userID = Tools.getUserID();
		if(userID == -1){
			code = 0; 
			result="用户没有登录";
			return "FAIL";
		}
		
//		code = userService.updateUserBirthday(userID,date);
		return "SUCCESS";
	}
	/**
	 * 更新用户昵称
	 * @return
	 */
	public String updateUserName(){
		code = 0;
		Map session = ActionContext.getContext().getSession();
		TUser user = (TUser) session.get(Configure.sessionUserName);
		if(user == null){
			code = 0; 
			result="用户没有登录";
			return "FAIL";
		}
		user.setUserName(userName);
		code = (new UserService()).updateUser(user);
		if(code == 1){
			session.put(Configure.sessionUserName, user);
		}
		return "SUCCESS";
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getUserGender() {
		return userGender;
	}
	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankUserName() {
		return bankUserName;
	}
	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}
	public String getBankCardNumber() {
		return bankCardNumber;
	}
	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
	public String getSubBankName() {
		return subBankName;
	}
	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}
	public String getSubBankAddress() {
		return subBankAddress;
	}
	public void setSubBankAddress(String subBankAddress) {
		this.subBankAddress = subBankAddress;
	}
	public String getAlipayUserName() {
		return alipayUserName;
	}
	public void setAlipayUserName(String alipayUserName) {
		this.alipayUserName = alipayUserName;
	}
	public String getAlipayUserAccount() {
		return alipayUserAccount;
	}
	public void setAlipayUserAccount(String alipayUserAccount) {
		this.alipayUserAccount = alipayUserAccount;
	}
	public String getWeChatPay() {
		return weChatPay;
	}
	public void setWeChatPay(String weChatPay) {
		this.weChatPay = weChatPay;
	}
	public int getPointTotal() {
		return pointTotal;
	}
	public void setPointTotal(int pointTotal) {
		this.pointTotal = pointTotal;
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
	public int getMenutypeId() {
		return menutypeId;
	}
	public void setMenutypeId(int menutypeId) {
		this.menutypeId = menutypeId;
	}
	public String getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<TUser> getDataList() {
		return dataList;
	}
	public void setDataList(List<TUser> dataList) {
		this.dataList = dataList;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public int getUserPhoneType() {
		return userPhoneType;
	}
	public void setUserPhoneType(int userPhoneType) {
		this.userPhoneType = userPhoneType;
	}
	public int getUserScale() {
		return userScale;
	}
	public void setUserScale(int userScale) {
		this.userScale = userScale;
	}
	public TUser getTuser() {
		return tuser;
	}
	public void setTuser(TUser tuser) {
		this.tuser = tuser;
	}
	public TUserextra getTuserextra() {
		return tuserextra;
	}
	public void setTuserextra(TUserextra tuserextra) {
		this.tuserextra = tuserextra;
	}
}
