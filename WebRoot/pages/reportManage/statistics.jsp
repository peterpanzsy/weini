<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'statistics.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/templatemo_main.css">
  </head>
  
  <body>
   <%@ include file="../common/head.jsp" %>
	<div class = "template-page-wrapper">
		<%@ include file = "../common/sidebar.jsp"  %>
		<div class = "templatemo-content-wrapper">
			<div class="templatemo-content">
				<ol class = "breadcrumb">
					<li><a href="pages/index.jsp">返回首页</a></li>
					<li><a href="javascript:;">返回统计详情</a></li>
					<li class="active">统计详情</li>
				</ol>
			</div>
		</div>	
	</div>
	<%@ include file="../common/footer.jsp"  %>
	<script src="js/templatemo_script.js"></script>
  </body>
</html>
