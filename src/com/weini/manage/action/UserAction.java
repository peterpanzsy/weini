package com.weini.manage.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.business.UserService;
import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TUserextra;
import com.weini.tools.TwoEntity;


public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserService();
	
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
	
	private Date userRegdate;
	
	private int pointTotal;
	//--------wang------------//
	//请求的参数
	private int menutypeId; //修改忌口
	private Integer userId;
    private int userGender;
    private Date userBirthday;
	//返回的参数
	private TUser user;
	private TUserextra userextra;
	private int code=0;  //状态，0-失败 ，1-成功
	private String result;  //错误信息
	
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
	 * 用户注册
	 * @return
	 */
	public String addUser(){
		return SUCCESS;
	}
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
		try {
			TwoEntity two = userService.findUserInfo(userId);
			user = (TUser)two.getIndex1();
			userextra = (TUserextra)two.getIndex2();
			if(user==null){
				code = 0; 
				result="没有记录";
				return "fail";
			}
			code = 1;
		} catch (Exception e) {
			code = 0; 
			result="参数有误";
			return "fail";
		}
		return SUCCESS;
	}
	/**
	 * 修改用户忌口
	 * @return
	 */
	public String updateUserNotEat(){
		code = userService.updateUserHeat(userId, menutypeId);
		return SUCCESS;
	}
	/**
	 * 修改用户性别
	 * @return
	 */
	public String updateUserGender(){
		code = userService.updateUserGender(userId,userGender);
		return SUCCESS;
	}
	/**
	 * 修改用户生日
	 * @return
	 */
	public String updateUserBirthday(){
		System.out.println(userBirthday);
		code = userService.updateUserBirthday(userId,userBirthday);
		return SUCCESS;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
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
	public int getUserGender() {
		return userGender;
	}
	public void setUserGender(int userGender) {
		this.userGender = userGender;
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
	public Date getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(Date userRegdate) {
		this.userRegdate = userRegdate;
	}
	public int getPointTotal() {
		return pointTotal;
	}
	public void setPointTotal(int pointTotal) {
		this.pointTotal = pointTotal;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
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
	public TUserextra getUserextra() {
		return userextra;
	}
	public void setUserextra(TUserextra userextra) {
		this.userextra = userextra;
	}
	public int getMenutypeId() {
		return menutypeId;
	}
	public void setMenutypeId(int menutypeId) {
		this.menutypeId = menutypeId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
}
