<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
	<title>味你，商家管理平台</title>
	<meta name="viewport" content="width=device-width">   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="">     
	<link rel="stylesheet" href="css/templatemo_main.css">
	<script src="vendor/js/jquery.min.js"></script>
    <script src="vendor/js/bootstrap.min.js"></script>
    <script src="vendor/js/Chart.min.js"></script>
    <script src="vendor/js/templatemo_script.js"></script>
</head>
<body>
	<%@ include file="common/head.jsp"  %> 
    <div class="template-page-wrapper">
    	<%@ include file="common/sidebar.jsp"  %>
        <div class="templatemo-content-wrapper">
            <div class="templatemo-content" style="padding:2px;">
                <img src="images/weini.jpg" border="1" />
            </div>
        </div>
       <%@ include file="common/footer.jsp"  %>
    </div>
</body>
</html>