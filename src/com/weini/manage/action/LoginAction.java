package com.weini.manage.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weini.manage.entity.TAdmin;
import com.weini.manage.entity.TAuth;
import com.weini.manage.entity.TUser;
import com.weini.manage.entity.TUserextra;
import com.weini.manage.entity.TVendor;
import com.weini.manage.business.LoginService;
import com.weini.tools.Configure;
import com.weini.tools.Tools;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 6382054055046543790L;
	String  username;
	String  password;
	String flag;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	private int userId;
	//---------------wpr----------
	private int identifyCode; //短信验证码
	private String phoneNum; //用户手机号
	private int code=0; //返回的状态码
//	private String result;
	
//    TAdmin admin;
//    List<TAuth> authList;
    /**
     * 管理员登录
     * @return
     */
	public String adminLogin()   {
		TAdmin admin=new TAdmin();
		//add by zsy to log remote access ip
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String remoteip=request.getRemoteHost();
		//above add by zsy to log remote access ip		
		if(username==null||username.equals("")){
	        ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("wrong", "手机号为空");	
			return "fail";
		}
		if(password==null||password.equals("")){
	        ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("wrong", "密码为空");	
			return "fail";
		}
		System.out.println(username+password);
//		String adminPassword_md5 = CipherUtil.generatePassword(password);
		String adminPassword_md5 = password;
		admin=(new LoginService()).searchAdmin(username, adminPassword_md5);
		if(admin==null){
	        ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put("wrong", "帐户或者密码错误，或者您的账号正在审核中。");	
			return "fail";
		}
		List<TAuth> authList=(new LoginService()).getAuthbyRoleList(admin.getRoleID());
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("user", admin);
        session.put("authList", authList);
		return "succ";
	}
	/**
	 * 管理员登出
	 * @return
	 */
	public String adminLogout(){
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.remove("user");
        session.remove("authList");
        flag="true";
		return SUCCESS;
	}
	/**
	 * 普通用户登录
	 * @return
	 */
	public String userLogin()   {
		String result = "FAIL";
		//add by zsy to log remote access ip
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String remoteip=request.getRemoteHost();
		//above add by zsy to log remote access ip
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		if(phoneNum==null||phoneNum.equals("")){
			code = 0;
			flag = "用户名为空";
//	        session.put("wrong", "用户名为空");
		}else if(password==null||password.equals("")){
	        code = 0;
	        flag = "密码为空";
//			session.put("wrong", "密码为空");	
		}else{
//			String adminPassword_md5 = CipherUtil.generatePassword(password);
			String adminPassword_md5 = password;
			TUser user = new TUser();
			user=(new LoginService()).searchUser(phoneNum, adminPassword_md5);
			if(user==null){
				code = 0;
				flag ="帐户或者密码错误，或者您的账号正在审核中。";
//		        session.put("wrong", "帐户或者密码错误，或者您的账号正在审核中。");	
			}else{
				session.put(Configure.sessionUserName, user);
				this.userId = user.getUserId();
				code = 1;
				result = "SUCCESS";
			}
		}
		return result;
	}
	/**
	 * 普通用户登出
	 * @return
	 */
	public String userlogout(){
		return "SUCCESS";
	}
	public String vendorlogin(){
		this.username = "pl";
		this.password = "123";
		//add by zsy to log remote access ip
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String remoteip=request.getRemoteHost();
		//above add by zsy to log remote access ip
		 ActionContext actionContext = ActionContext.getContext();
	     Map session = actionContext.getSession();
		if(username==null||username.equals("")){
	        session.put("wrong", "用户名为空");	
			return "fail";
		}
		if(password==null||password.equals("")){
	        session.put("wrong", "密码为空");	
			return "fail";
		}
//		String adminPassword_md5 = CipherUtil.generatePassword(password);
		String adminPassword_md5 = password;
		TVendor vendor = new TVendor();
		vendor=(new LoginService()).searchVendor(username, adminPassword_md5);
		if(vendor==null){
	        session.put("wrong", "帐户或者密码错误，或者您的账号正在审核中。");	
			return "fail";
		}
        session.put("user", vendor);
		return "SUCCESS";
	}
	/**
	 * 商家登出
	 * @return
	 */
	public String vendorLogout(){
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.remove("user");
        flag="true";
		return "SUCCESS";
	}
	
	/**
	 * 获取手机验证码
	 * @return
	 */
	public String dynamicCode(){
		LoginService loginService = new LoginService();
		identifyCode = loginService.sendCode(phoneNum);
		if(identifyCode!=-1){
			ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        session.put(Configure.identifyCode, identifyCode);
			code = 1;
		}else{
			code = 0;
		}
		return SUCCESS;
	} 
	/**
	 * 已注册的用户登录
	 * @return 仅当验证码正确且用户已注册过的情况下返回code=1，成功状态
	 */
	public String reguserLogin()  {
		String result = "fail";
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Integer iden = (Integer)session.get(Configure.identifyCode);
		if(iden != null && (iden == identifyCode)){
				LoginService loginService = new LoginService();
				TUser user = loginService.findReguserLogin(phoneNum);
				if(user!=null){
					session.remove(Configure.identifyCode);
					session.put(Configure.sessionUserName, user);
					code = 1;
					userId = user.getUserId();
					result = SUCCESS;
				}else{
					code =0;
					flag ="手机号未注册";
					result = "fail";
				}
		}else{
			flag ="验证码不正确";
			code = 0;
			result = "fail";
		}
		return result;
	}
	/**
	 *检查用户是否登录  
	 * @return code： 0:未登录，1：登录
	 */
	public String checkUserIsLogin(){
		code  = 0;
		int userID = Tools.getUserID();
		if(userID == -1){
			System.err.println("用户没有登录");
			code = 0; 
			flag = "用户没有登录";
			return "FAIL";
		}else{
			code = 1;
		}
		return "SUCCESS";
	}
	/**
	 * 用户注册
	 * 如果用户注册成功，就直接登录
	 * @return  0-注册失败 ，1-注册成功,2-用户已注册,3-验证码不正确
	 * 如果注册成功，返回userID,用户id用户密码
	 */
	public String userRegist(){
		code = 0;
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Integer iden = (Integer)session.get(Configure.identifyCode);
		if(iden != null && (iden == identifyCode)){
			LoginService loginService = new LoginService();
			code = loginService.userRegist(phoneNum, password);
			if(code == 1)
				session.remove(Configure.identifyCode);
				TUser user = (new LoginService()).searchUser(phoneNum, password);
				//增加用户其他信息
				TUserextra uextra = new TUserextra();
				uextra.setUserId(user.getUserId());
				if(!(new LoginService()).insertUserExtra(uextra)){
					code = 0;
				}else{
					session.put(Configure.sessionUserName,user);
				}
		}else{
			code = 3;
		}
		return SUCCESS;
	}
	/**
	 * 修改密码  0-修改失败 ，1-改密码成功,2-用户未注册,3-验证码不正确
	 * @return
	 */
	public String userChangePassword(){
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Object obj = session.get("identifyCode");
		if(obj!=null&&(Integer)obj==identifyCode){
			LoginService loginService = new LoginService();
			code = loginService.userChangePassword(phoneNum, password);
			if(code == 1)
				session.remove("identifyCode");
		}else{
			code = 3;
		}
		return SUCCESS;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdentifyCode() {
		return identifyCode;
	}
	public void setIdentifyCode(int identifyCode) {
		this.identifyCode = identifyCode;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
