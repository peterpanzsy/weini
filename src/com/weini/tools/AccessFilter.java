package com.weini.tools;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class AccessFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,

    FilterChain filterChain) throws IOException, ServletException

    {

        HttpServletRequest request = (HttpServletRequest)arg0;

        HttpServletResponse response = (HttpServletResponse)arg1;

        HttpSession session = request.getSession();
        System.out.println("filter");
        System.out.println(request.getRequestURI());

        //System.err.println("公钥加密——私钥解密");
        String publicKey;
        String privateKey;
        Map<String, Object> keyMap = null;
        try {
            keyMap = RSACoder.initKey();
            //publicKey = RSACoder.getPublicKey(keyMap);
            //privateKey = RSACoder.getPrivateKey(keyMap);
            publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFc1fHLGvW+5Ix0xzFRyBHyXdT8/oxk+RWwBYj\n" +
                    "YtbBgGCRsirMXcUw00m0MRwFOAi5y9Fy8a8ErXAHdiCwDzW7zW/mD//pgwHDk2SdLxz0z3YBb3lB\n" +
                    "ycN2hCOe1g35HYyuohdPvhtEorId6wzZeaMuTMdubyyS38bYBZSHkxPe+wIDAQAB";
            privateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIVzV8csa9b7kjHTHMVHIEfJd1Pz\n" +
                    "+jGT5FbAFiNi1sGAYJGyKsxdxTDTSbQxHAU4CLnL0XLxrwStcAd2ILAPNbvNb+YP/+mDAcOTZJ0v\n" +
                    "HPTPdgFveUHJw3aEI57WDfkdjK6iF0++G0Sish3rDNl5oy5Mx25vLJLfxtgFlIeTE977AgMBAAEC\n" +
                    "gYAi4Q+7LgANk3kVbrEhWsK0IJMArU7iMF5I0jG3E/k/X/ddfSy0d3m3ljG4V/GT555YOU5H9aUh\n" +
                    "2tbiDFzkx0TqrQOoHC9uYGaAZbvU47UCyBAuoFkVXfziB1eQL15wpT5EsrOYqVY87TEU+etsqsM8\n" +
                    "PHIoIBjRoAWXDfgKIwEumQJBAMkZzvWamqTWzCo+saF3FfteTuVjjj11a4TU82Yc5PnCWqKaBPEt\n" +
                    "r/mrRT8JZ/1znkt8cUguqvN4XYCgiAZAoHUCQQCp4bVcykVZojvfRfQrNDfbcj3K95cyD4p+RlJ/\n" +
                    "hTt7Gk1JuAmFGhWO23E/6EOGcJcMkiKtLC5c+hDU/AHlV5OvAkA9E1mHviy5Y4MeUWwhXcmPTlUn\n" +
                    "1dSdVcwRy5sgqCXitORR/fUCSp3nddzSCElM8JBi3KiLA6Fn0GaVaivlujsBAkEAoGWhzaiVbhoF\n" +
                    "mbv83EYDb0kgGuFGele+FZfkEM8E6ChfTPlc07VbIXUEKqjsCKWJmK7p2sPaSqM4/T+rspTLtQJB\n" +
                    "AMZOSWkjJgidWFtUjkf+JFajpUps5dc91z9iBE+d+cx4uX1EQebAO31ikBneziZuiPdempCdbNyZ\n" +
                    "jnKQeBLlAmA=";
        //System.err.println("公钥: \n\r" + publicKey);
        //System.err.println("私钥： \n\r" + privateKey);

        String inputStr = request.getRequestURI().split("weini")[1];
        System.out.println("encrpted:"+inputStr);
 /*       if(inputStr.indexOf("[B@13637093")>=0){
            byte[] data=inputStr;
            System.out.println(data);
            byte[] decodedData=RSACoder.decryptByPrivateKey(data,privateKey);
            String outputStr=new String(decodedData);
            System.out.println("解密URL："+outputStr);
            response.sendRedirect("/"+outputStr);
            return;
        }*/
        byte[] data = inputStr.getBytes();
        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);
        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData,privateKey);
        String outputStr = new String(decodedData);
        String encodeStr=new String(encodedData);
        System.err.println("加密后: " + encodeStr+"\n\r" + "解密后: " + outputStr);//加密后: [B@13637093 解密后: /pages/sign-in.jsp

        } catch (Exception e) {
            e.printStackTrace();
        }
//        if(session.getAttribute("user")== null && request.getRequestURI().indexOf("sign-in.jsp")==-1){
//
//            response.sendRedirect("sign-in.jsp");
//
//            return ;
//
//        }

        filterChain.doFilter(arg0, arg1);

    }

    public void init(FilterConfig arg0) throws ServletException {

    }

}