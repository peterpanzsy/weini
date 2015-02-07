package com.weini.tools;


import cn.ihuyi._106.Sms;
import cn.ihuyi._106.SmsSoap;
import cn.ihuyi._106.SubmitResult;



public class SMSUtil {
	private static String account = "cf_wnkj";
	private static String password = "zangqing634134";

	/**
	 * 发送短信验证码的接口
	 * @param mobilePhone  手机号
	 * @param mobile_code   短信验证码
	 * @return
	 */
	public static boolean sendMsg(String mobilePhone,int mobile_code){
		
		Sms smsWS = new Sms();
		SmsSoap soap =smsWS.getSmsSoap();

		String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。"); 
		SubmitResult result = soap.submit(account, password, mobilePhone, content);
		
//		System.out.println("code:"+result.getCode()+"\nsmsid"+result.getSmsid()+"\nmsg"+result.getMsg());
		
		if(result.getCode()==2){
			return true;
		}else{
			//TODO 这个地方要做记录
			return false;
		}
	}
}
