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
    <script type="text/javascript" src="Highcharts-4.0.1/highcharts-3d.js"></script>
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
            <li><a href="javascript:;">返回订单信息</a></li>
            <li class="active">订单数量统计</li>
          </ol>
          <!-- 统计图表 -->
          <div class="templatemo-charts">
            <div class="row">
              <div class="col-md-12 col-sm-12">
                <div class="panel panel-success">
                  <div class="panel-heading"><b>&nbsp;各商家覆盖写字楼统计</b>
                    <div class="btn-group-xs " style="display: inline;">
                      <select id="bussinessID" style="width:100px;height:20px;color: rgb(0, 0, 0);" class="required" >
                        <option selected = "selected" value="-1">请选择商家</option>
                      </select>
                      <button type="button" class="btn btn-default date-line-type" id = "busAreaStat"data-type="5">订单分布</button>
                    </div>
                  </div>
                      
                  <div class="panel-body" style="">
                    <div class="templatemo-chart-box col-lg-4 col-md-3 ">
                    <div id="busAreaModel1" style="min-width:33%;height:300px"></div>
                    
                  </div>
                  
                  <div class="templatemo-chart-box col-lg-4 col-md-3 ">           
                    <div id="busAreaModel2" style="min-width:33%;height:300px"></div>
                  </div>
                  <div class="templatemo-chart-box col-lg-4 col-md-3 ">           
                    <div id="busAreaModel3" style="min-width:33%;height:300px"></div>
                  </div>
                  </div>
                </div>                       
              </div>
              
            </div>
            <div class="row">
              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                <div class="col-md-6 col-sm-6">
                <div class="panel panel-primary">
                  <div class="panel-heading">当天订单统计
                    <div class="btn-group-xs " style="display: inline;">
                    </div>
                  </div>
                  <div class="panel-body" style="">
                    <div class="clearfix setPos" id="leak-chart-lines-panel"></div>
                    <div class="row">
                      <div id="continueBuyAnalysis" class ="col-md-12" ></div>
                        <h4>当天订购体验餐模式的订单数</h4>
                        <table id="curOrderModel" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
                          <thead>
                              <tr>  
                                <th style="width:33%;">1天体验餐</th>
                                <th style="width:33%;">盒子3天</th>
                                <th style="width:33%;">盒子1周</th>                     
                              </tr>
                              
                          </thead>
                          <tbody>
                            <tr>
                               <td id="oneOrderNumber">0个</td>
                               <td id="threeOrderNumber">0个</td>
                               <td id="weekOrderNumber">0个</td>
                            </tr>
                            
                          </tbody>
                        </table> 
                      <h4>当天订单追踪情况</h4>
                      <table id="curOrderTrace" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
                          <thead>
                              <tr>  
                                <th style="width:25%;">制作</th>
                                <th style="width:25%;">派出</th>
                                <th style="width:25%;">途中</th>
                                <th style="width:25%;">签收</th>                  
                              </tr>
                              
                          </thead>
                          <tbody>
                            <tr>                              
                               <td id="making">个</td>
                               <td id="dispatching">个</td>
                               <td id="onWay">个</td>
                               <td id="signIn">个</td>
                            </tr>                  
                            
                          </tbody>
                        </table> 
                        <h4>当天订单状况</h4>
                        <table id="curOrderState" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
                          <thead>
                              <tr>  
                                <th style="width:33%;" rowspan="2">未付款</th>
                                <th style="width:66%;text-align: center;" colspan="2">已付款</th>                   
                              </tr>
                              <tr>  
                                <th style="width:33%;" >未消费</th>
                                <th style="width:33%;">已消费</th>                   
                              </tr>
                          </thead>
                          <tbody>
                            <tr>                              
                               <td id="unPay">个</td>
                               <td id="unConsume">个</td>
                               <td id="consumed">个</td>
                            </tr>
                            
                            
                            
                          </tbody>
                        </table> 
                    </div>
                  </div>
                </div>
              </div> 
              <div class="col-md-6 col-sm-6">
                <div class="panel panel-primary">
                  <div class="panel-heading">订单统计
                    <div class="btn-group-xs " style="display: inline;">
                        <select id="orderNumproviceID" style="width:80px;height:20px;color: rgb(0, 0, 0);" class="required" >
                         </select>
                         <select id="orderNumcityID" style="width:80px;height:20px;color: rgb(0, 0, 0);" class="required" >
                         <option selected = "selected" value="-1">请选择城市</option>
                         </select>
                         <select id="orderNumdistrictID" style="width:80px;height:20px;color: rgb(0, 0, 0);" class="required" >
                         <option selected = "selected" value="-1">请选择县区</option>
                         </select>
                         
                         </select>
                         <button type="button" class="btn btn-default date-line-type" id = "orderNumStat"data-type="5" style="float:right;">统计结果</button>
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
          </div>
       
       </div>
      </div>
   	<%@ include file="../common/footer.jsp"  %>
    </div>
   </div>	
  	<!-- DataTables -->
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/jquery.dataTables.min.js"></script>
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/dataTables.bootstrap.js"></script>  
	  <script src="js/orderManage_chen.js"></script>
  </body>
</html>
