package com.weini.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import antlr.collections.List;

public class Configure {
	public static String goodPicPath = "uploads"+File.separator+"goodsPic";
	public static ArrayList<String> goodPicSuffix = new ArrayList<String>(Arrays.asList("jpg","bmp","gif","png"));
	public static long goodPicMaxSize = 3 * 1024 * 1024;// 3M
	public static String sessionUserName = "user";
	public static String identifyCode = "Code";
}
