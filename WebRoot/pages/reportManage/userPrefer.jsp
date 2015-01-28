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
            <li class="active">用户偏好统计</li>
          </ol>
          <!-- 统计图表 -->
          <div class="templatemo-charts">

            <div class="row">

              <div class="col-md-12 col-sm-12">
                <div class="panel panel-success">
                  <div class="panel-heading"><b>&nbsp;第一次购买盒子模式</b>
                    <div class="btn-group-xs " style="display: inline;">
                    </div>
                  </div>                      
                  <div class="panel-body" style="">
                    <div class="clearfix setPos" id="leak-chart-lines-panel"></div>
                    <div class="row">
                      <div id="firstBuyAnalysis" class ="col-md-5" style=""></div>
                      <div class = "col-md-7">
                        <table id="againBuyTable" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
                          <thead>
                              <tr>  
                                <th>盒子模式</th>
                                  <th>XXXX</th>
                                  <th>xxxx</th>
                                  <th>xxx</th>                    
                              </tr>
                          </thead>
                        </table> 
                      </div>
                    </div>
                  </div>
                </div>                       
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 col-sm-6">
                <div class="panel panel-primary">
                  <div class="panel-heading">统计信息
                    <div class="btn-group-xs " style="display: inline;">
                    </div>
                  </div>
                  <div class="panel-body" style="">
                    <div class="clearfix setPos" id="leak-chart-lines-panel"></div>
                    <div class="row">
                      <div id="continueBuyAnalysis" class ="col-md-12" ></div>
                      	<table id="againBuyTable" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
                          <thead>
                              <tr>  
                                <th style="width:50%;">继续购买盒子模式</th>
                                <th style="width:50%;">购买人数</th>	                   
                              </tr>
                              
                          </thead>
                          <tbody>
                          	<tr>
                          	   <td>一天模式</td>
                          	   <td id="oneModelNum">0人</td>
                          	</tr>
                          	<tr>
                          	   <td>三天模式</td>
                          	   <td id="threeModelNum">0人</td>
                          	</tr>
                          	<tr>
                          	   <td>五天模式</td>
                          	   <td id="fiveModelNum">0人</td>
                          	</tr>
                          </tbody>
                        </table> 
                    
                    	<table id="otherTable" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
                          <thead>
                              <tr>  
                                <th style="width:50%;">统计栏目</th>
                                <th style="width:50%;">值</th>	                   
                              </tr>
                              
                          </thead>
                          <tbody>
                          	<tr>
                          	   <td>实际购买用户</td>
                          	   <td id="realBuyUser">4人</td>
                          	</tr>
                          	<tr>
                          	   <td>实际购买金额</td>
                          	   <td id="realBuyMoney">8元</td>
                          	</tr>
                          	
                          </tbody>
                        </table> 
                    
                    </div>
                  </div>
                </div>
              </div> 
              <div class="col-md-6 col-sm-6">
                <div class="panel panel-primary">
                  <div class="panel-heading">平均购买力
                    <div class="btn-group-xs " style="display: inline;">
                        <select id="buyproviceID" style="width:80px;height:20px;color: rgb(0, 0, 0);" class="required" >
                         </select>
                         <select id="buycityID" style="width:80px;height:20px;color: rgb(0, 0, 0);" class="required" >
                         <option selected = "selected" value="-1">请选择城市</option>
                         </select>
                         <select id="buydistrictID" style="width:80px;height:20px;color: rgb(0, 0, 0);" class="required" >
                         <option selected = "selected" value="-1">请选择县区</option>
                         </select>
                         <select id="buybussAreaID" style="width:80px;height:20px;color: rgb(0, 0, 0);" class="required" >
                         <option selected = "selected" value="-1">请选择商圈</option>
                         </select>
                         <button type="button" class="btn btn-default date-line-type" id = "buyStat"data-type="5">统计结果</button>
                    </div>
                  </div>
                  <div class="panel-body" style="">
                    <div class="clearfix setPos" id="leak-chart-lines-panel"></div>
                    <div id="buyAnalysis" style="min-width:100%;height:300px"></div>
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
