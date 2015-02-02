package test;

import org.junit.Assert;
import org.junit.Test;

import cn.ihuyi._106.SubmitResult;

import com.weini.tools.SMSUtil;

public class SMSToolTest {
	@Test
	public void sendMsg(){
		int mobile_code = (int)((Math.random()*9+1)*100000);
		System.out.println(mobile_code);
		boolean result = SMSUtil.sendMsg("18710871983", mobile_code);
		Assert.assertTrue(result);
	}
}
