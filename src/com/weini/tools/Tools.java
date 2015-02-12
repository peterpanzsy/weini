package com.weini.tools;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.weini.manage.entity.TUser;

public class Tools {
	 /**
	    *获得一个UUID
	    *@return StringUUID
	    */
	    public static String getUUID(){
	        String s=UUID.randomUUID().toString();
	        //去掉“-”符号
	        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
	    }
	    public static String createKeyFromProAndALg(int proid,int algid,String InOrOut){
	    	return String.valueOf(proid)+"_"+String.valueOf(algid)+"_"+InOrOut;
	    }
	    public static String createKeyFromProAndALg(int algid,String InOrOut){
	    	return String.valueOf(algid)+"_"+InOrOut;
	    }
		public static void copyFile(File sourceFile, File targetFile) throws IOException {
	        BufferedInputStream inBuff = null;
	        BufferedOutputStream outBuff = null;
	        try {
	            // 新建文件输入流并对它进行缓冲
	            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

	            // 新建文件输出流并对它进行缓冲
	            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

	            // 缓冲数组
	            byte[] b = new byte[1024 * 5];
	            int len;
	            while ((len = inBuff.read(b)) != -1) {
	                outBuff.write(b, 0, len);
	            }
	            // 刷新此缓冲的输出流
	            outBuff.flush();
	        } finally {
	            // 关闭流
	            if (inBuff != null)
	                inBuff.close();
	            if (outBuff != null)
	                outBuff.close();
	        }
	    }
	    public static boolean copyFile(String srcFileName, String destFileName,  
	            boolean overlay) {  
	        File srcFile = new File(srcFileName);  
	  
	        // 判断源文件是否存在  
	        if (!srcFile.exists()) {  
	           // MESSAGE = "源文件：" + srcFileName + "不存在！";  
	            
	            return false;  
	        } else if (!srcFile.isFile()) {  
	            //MESSAGE = "复制文件失败，源文件：" + srcFileName + "不是一个文件！";  
	          
	            return false;  
	        }  
	  
	        // 判断目标文件是否存在  
	        File destFile = new File(destFileName);  
	        if (destFile.exists()) {  
	            // 如果目标文件存在并允许覆盖  
	            if (overlay) {  
	                // 删除已经存在的目标文件，无论目标文件是目录还是单个文件  
	                new File(destFileName).delete();  
	            }  
	        } else {  
	            // 如果目标文件所在目录不存在，则创建目录  
	            if (!destFile.getParentFile().exists()) {  
	                // 目标文件所在目录不存在  
	                if (!destFile.getParentFile().mkdirs()) {  
	                    // 复制文件失败：创建目标文件所在目录失败  
	                    return false;  
	                }  
	            }  
	        }  
	  
	        // 复制文件  
	        int byteread = 0; // 读取的字节数  
	        InputStream in = null;  
	        OutputStream out = null;  
	  
	        try {  
	            in = new FileInputStream(srcFile);  
	            out = new FileOutputStream(destFile);  
	            byte[] buffer = new byte[1024];  
	  
	            while ((byteread = in.read(buffer)) != -1) {  
	                out.write(buffer, 0, byteread);  
	            }  
	            return true;  
	        } catch (FileNotFoundException e) {  
	            return false;  
	        } catch (IOException e) {  
	            return false;  
	        } finally {  
	            try {  
	                if (out != null)  
	                    out.close();  
	                if (in != null)  
	                    in.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    } 
	    public static String getWebRoot(){
	    	return new Tools().getWebRoots();
	    }
	    private String getWebRoots(){
			String path=this.getClass().getClassLoader().getResource("").getPath();
			//path.replaceAll("%20", " ");
			try {
				path = java.net.URLDecoder.decode(path,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			path=path.substring(0, path.lastIndexOf("/WEB-INF"));
			path=path+File.separator;
			return path;
	    }
	    public static String checkContent(String old){
	    	String newStr=old.replace("（","(" );
	    	 newStr=newStr.replace("）",")" );
	    	 int a;
	    	 //System.out.println(newStr+"   "+String.valueOf(getType(newStr)));
	    	 if(getType(newStr)==1){
	    		Double b=Double.parseDouble(newStr);
	    		newStr=String.valueOf(b.intValue());
	    	 }
	    	 return newStr;
	    }
	    //整型判断
	    /**
	     * @param str
	     * @return 1 代表是整数
	     *         2 代表是浮点数
	     *         3 代表是字符串
	     */
	    public static int getType(String str){
	     if(str==null )
	      return -1;
	     double a;
	     try{
	    	  a=Double.parseDouble(str);
	    	}catch(NumberFormatException  e){
	    		
	    		return 3;
	    	}
	     
	     int b=(int)a;  
	     double c=a%1;
	     if(c>-0.00000000001&&c<=0.00000000001){
	    	    
	    	 return 1;
	     }
	     return 2;
	    }
	    public static void main(String args[]) throws ParseException{
//	    	System.out.println(getType("4800.000000000001"));
//	    	System.out.println(getUUID());
//	    	Calendar cale = Calendar.getInstance();
//	    	cale.add(Calendar.DATE, -2);
//			System.out.println(cale.get(Calendar.DAY_OF_WEEK));
//	    	getDatesNotWeekend(3);
//	    	String time = "2015-12-13 12:12:12";
//	    	DateFormat format2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    	Date date = format2.parse(time);
//	    	Timestamp temp = new Timestamp(date.getTime());
//	    	System.out.println(temp.toString());
	    }
	    public static int getPrintSource(){
			Throwable t = new Throwable();
	    	StackTraceElement stack[] = t.getStackTrace();
	    	for (int i=0;i<stack.length;i++){
	    		if(stack[i]!=null&&stack[i].getFileName()!=null&&stack[i].getMethodName()!=null&&stack[i].getFileName().equalsIgnoreCase("CalcThread.java")&&stack[i].getMethodName().equalsIgnoreCase("run")){
	    			//t.printStackTrace();
	    			return 1;
	    		}
	    	}
	    	//print by web 
	    	return 2;
	    }
	    public static String getSomeDayDate(int type){
			Calendar cale = Calendar.getInstance();
			cale.add(Calendar.DATE, type);
			String tarday = new SimpleDateFormat("yyyy-MM-dd").format(cale.getTime());
			return tarday;
		}
	    /**
	     * 获取饭量的描述
	     * @param index 饭量大小索引
	     * @return
	     */
		public static String getUserAppetite(int index){
			String res = "中等";
			switch(index){
				case 1:
					res = "小份";
					break;
				case 2:
					res = "中等";
					break;
				case 3:
					res = "大份";
					break;
				default:
					res = "中等";
			}
			return res;
		}
		/**
	     * 获取饭量的描述
	     * @param index 饭量大小索引
	     * @return
	     */
		public static String getUserPungent(int index){
			String res = "吃辣";
			if(index == 1){
				res = "不吃辣";
			}
			return res;
		}
		public static List<String> getDatesNotWeekend(int num){
			List<String> res = new ArrayList<String>();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cale = Calendar.getInstance();
			for(int i = 0;i < num ;i++){
				int weekNo = cale.get(Calendar.DAY_OF_WEEK);
				while(weekNo == 1 || weekNo == 7){
					cale.add(Calendar.DATE, 1);
					weekNo = cale.get(Calendar.DAY_OF_WEEK);
				}
				res.add(format.format(cale.getTime()));
				cale.add(Calendar.DATE, 1);
			}
			return res;
			
		}
		/**
		 * 获取用户的id
		 * @return 错误返回-1
		 */
		public static int getUserID(){
			TUser user = (TUser) ActionContext.getContext().getSession().get(Configure.sessionUserName);
			int res = -1;
			if(user != null){
				res = user.getUserId();
			}else{
				System.err.println("用户没有登录！");
			}
			return res;
		}
		/**
		 * 上传文件
		 * @param sourceImageName 图片名字
		 * @param desFilePath 文件目的地址(相对路径)(例如："upload"+File.separator+"goodsPic")
		 * @param imageFile 图片文件
		 * @param rightSuffix 合法的后缀名 (null,表示无限制)
		 * @param imageSize 图像最大值 (-1,表示没有限制)
		 * @return 结果：第一个实体 0:出错；1：后缀名不合法 2：文件超过限制  3：上传成功
		 * 				如果成功，第二个实体表示文件路径
		 */
		public static List<Object> uploadFile(String sourceFileName,String desFilePath,File fileSource,List<String> rightSuffix,long fileSize){
			List<Object> res = new ArrayList<Object>();
			String savePath = ServletActionContext.getServletContext().getRealPath(desFilePath);//上传完后文件存放位置  
	        String newsuffix = "";
			//获取后缀名
			if((sourceFileName != null) && (sourceFileName.length() > 0)){
				int dot = sourceFileName.lastIndexOf(".");  
	            if((dot >-1) && (dot < (sourceFileName.length() - 1)))  
	            {  
	                 newsuffix = sourceFileName.substring(dot + 1);
	            }  
			}
			//判断类型
			if(rightSuffix != null){
				if(newsuffix == "" || !rightSuffix.contains(newsuffix)){
					//类型出错处理
					res.add(1);
					return res;
				}
			}
	        //判断大小
			if(fileSize != -1){
				if(fileSource == null || (fileSource.length() > fileSize )){
					//大小出错处理
					res.add(2);
					return res;
				}
			}
			String desPathTemp =  File.separator+Tools.getUUID() + "." + newsuffix;
			if(!Tools.copyFile(fileSource.getAbsolutePath(), savePath + desPathTemp ,true)){
				res.add(0);
				return res;
			}
			res.add(3);
			res.add(desFilePath + desPathTemp);
			return res;
		}
}
