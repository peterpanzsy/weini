<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<head>
  <base href="<%=basePath%>">
  <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
  <title>味你，数据管理平台</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width">        
  <link rel="stylesheet" href="css/templatemo_main.css">
  <!-- DataTables CSS -->
  <link rel="stylesheet" type="text/css" href="DataTables-1.10.4/css/jquery.dataTables.css">
  <link rel="stylesheet" href="jquery-ui-1.11.2/themes/smoothness/jquery-ui.css">

  
</head>
<body>
  <div id="main-wrapper">
  <%@ include file="../common/head.jsp"  %> 
    <div class="template-page-wrapper">
   	  <%@ include file="../common/sidebar.jsp"  %>
      <div class="templatemo-content-wrapper">
        <div class="templatemo-content">
          <ol class="breadcrumb">
            <li><a href="pages/index.jsp">返回首页</a></li>
            <li><a href="pages/goodManage/existGood.jsp">商品管理</a></li>
            <li class="active">现有商品</li>
          </ol>
          <div style="text-align:center;"><h1>商品列表</h1></div>
<div class="row margin-bottom-30">
  <div class="col-md-12">   
	<table id="goodTable" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
	    <thead>
	        <tr>	
	        	<th>menuID</th>
	            <th>序号</th>
	            <th>商品名称</th>
	            <th>商家名称</th>
	            <th>所属商圈</th>
	            <th>详细情况</th>
	            <th>删除</th>
	            <th>编辑</th>
	        </tr>
	    </thead>
	
	    <tfoot>
	        <tr>
	        	<th>menuID</th>
	            <th>序号</th>
	            <th>商品名称</th>
	            <th>商家名称</th>
	            <th>所属商圈</th>
	            <th>详细情况</th>
	            <th>删除</th>
	            <th>编辑</th>
	        </tr>
	    </tfoot>
	</table>     
  </div>
</div> 
       </div>
      </div>
   	<%@ include file="../common/footer.jsp"  %>
    </div>
   </div>


<input id="role" value="root" style="display:none" />
  	<!-- <script src="js/jquery.min.js"></script> -->
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/jquery-1.11.1.min.js"></script>  
  	<script src="js/bootstrap.min.js"></script>
  	<script src="jquery-validation-1.11.1/dist/jquery.validate.js" type="text/javascript"></script>
  	<script src="jquery-ui-1.11.2/jquery-ui.js"></script>
  	
    <script src="js/templatemo_script.js"></script>
  	<!-- DataTables -->
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/jquery.dataTables.min.js"></script>
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/dataTables.bootstrap.js"></script>  
    <script type="text/javascript" charset="utf8" src="js/existOrDeletedGood.js"></script>
</body>
</html>