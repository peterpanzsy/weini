<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>味你，数据管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/templatemo_main.css">
	
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script src="js/templatemo_script.js"></script>
    <script src = "js/Chart.js"></script>
    <script src = "Highcharts-4.0.1/highcharts.js"></script>
    <script src="Highcharts-4.0.1/modules/exporting.js"></script>
    <script src="js/reportManage.js"></script>
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
            <li><a href="javascript:;">返回统计详情</a></li>
            <li class="active">统计详情</li>
          </ol>
          <!-- 统计图表 -->
          <div class="templatemo-charts">
            <div class="row">
              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                <div class="row templatemo-chart-row">

                  <div class="templatemo-chart-box col-lg-6 col-md-3 ">
                    <!-- <canvas id="templatemo-pie-chart"></canvas> -->
                    <div id="channelAnalysis" style="min-width:45%;height:300px"></div>
                    
                  </div>
                  
                  <div class="templatemo-chart-box col-lg-6 col-md-3 ">           
                   <!--  <canvas id="templatemo-doughnut-chart"></canvas>
                    <h4>时间点分析</h4> -->
                    <div id="timeAnalysis" style="min-width:45%;height:300px"></div>
                  </div> 
                </div>                  
              </div>
            </div>
            <div class="row">
              <div class="col-md-12 col-sm-12">
                <div class="panel panel-success">
                  <div class="panel-heading"><b>&nbsp;订单统计</b>
                    <div class="btn-group-xs " style="display: inline;">
                        <button type="button" class="btn btn-default date-line-type order" data-type="1">近一天</button>
                        <button type="button" class="btn btn-default date-line-type order" data-type="2">近三天</button>
                        <button type="button" class="btn btn-default date-line-type order" data-type="3">近一周</button>
                        <button type="button" class="btn btn-default date-line-type order" data-type="4">近半月</button>
                        <button type="button" class="btn btn-default date-line-type order" data-type="5">近一月</button>
                    </div>
                  </div>
                      
                  <div class="panel-body" style="">
                    <div class="clearfix setPos" id="leak-chart-lines-panel"></div>
                    <div id="orderAnalysis" style="min-width:100%;height:300px"></div>
                  </div>
                </div>                       
              </div>
              
            </div>
            
              
            </div>
          </div>
       
       </div>
      </div>
   	<%@ include file="../common/footer.jsp"  %>
    </div>
   </div>	
  	<!-- DataTables -->
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/jquery.dataTables.min.js"></script>
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/dataTables.bootstrap.js"></script>  
	  <script src="js/reportManage.js"></script>
  </body>
</html>
