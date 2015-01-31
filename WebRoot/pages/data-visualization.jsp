<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
	<title>味你，数据管理平台</title>
	<meta name="viewport" content="width=device-width">   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="">     
	<link rel="stylesheet" href="css/templatemo_main.css">
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/Chart.min.js"></script>
    <script src="js/templatemo_script.js"></script>
</head>
<body>
  <div id="main-wrapper">
    <%@ include file="common/head.jsp"  %>
    <div class="template-page-wrapper">
      <div class="navbar-collapse collapse templatemo-sidebar">
        <ul class="templatemo-sidebar-menu">
          <li>
            <form class="navbar-form">
              <input type="text" class="form-control" id="templatemo_search_box" placeholder="Search...">
              <span class="btn btn-default">Go</span>
            </form>
          </li>
          <li><a href="index.html"><i class="fa fa-home"></i>Dashboard</a></li>
          <li class="sub">
            <a href="javascript:;">
              <i class="fa fa-database"></i> Nested Menu <div class="pull-right"><span class="caret"></span></div>
            </a>
            <ul class="templatemo-submenu">
              <li><a href="#">Aenean</a></li>
              <li><a href="#">Pellentesque</a></li>
              <li><a href="#">Congue</a></li>             
              <li><a href="#">Interdum</a></li>
              <li><a href="#">Facilisi</a></li>
            </ul>
          </li>
          <li class="active"><a href="#"><i class="fa fa-cubes"></i><span class="badge pull-right">9</span>Data Visualization</a></li>
          <li><a href="maps.html"><i class="fa fa-map-marker"></i><span class="badge pull-right">42</span>Maps</a></li>
          <li><a href="tables.html"><i class="fa fa-users"></i><span class="badge pull-right">NEW</span>Manage Users</a></li>
          <li><a href="preferences.html"><i class="fa fa-cog"></i>Preferences</a></li>
          <li><a href="javascript:;" data-toggle="modal" data-target="#confirmModal"><i class="fa fa-sign-out"></i>Sign Out</a></li>
        </ul>
      </div><!--/.navbar-collapse -->

      <div class="templatemo-content-wrapper">
        <div class="templatemo-content">
          <ol class="breadcrumb">
            <li><a href="index.html">Admin Panel</a></li>
            <li><a href="#">Data Visualization</a></li>
            <li class="active">Charts</li>
          </ol>
            
          <div class="templatemo-charts">
            <div class="row">
              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="panel panel-info">
                  <div class="panel-heading">Pie Chart &amp; Doughnut Chart</div>
                </div>
                <div class="row templatemo-chart-row">

                  <div class="templatemo-chart-box col-lg-3 col-md-3 col-sm-4 col-xs-12">
                    <canvas id="templatemo-pie-chart"></canvas>
                    <h4>Pie Chart</h4>
                    <span class="text-muted">Maecenas non</span>  
                  </div>
                  
                  <div class="templatemo-chart-box col-lg-3 col-md-3 col-sm-4 col-xs-12">           
                    <canvas id="templatemo-doughnut-chart"></canvas>
                    <h4>Doughnut Chart</h4>
                    <span class="text-muted">Sodales orci aliquet</span> 
                  </div>
                  
                  <div class="templatemo-chart-box col-lg-3 col-md-3 col-sm-4 col-xs-12">           
                    <canvas id="templatemo-radar-chart"></canvas>
                    <h4>Radar Chart</h4>
                    <span class="text-muted">Lorem sed</span> 
                  </div>

                  <div class="templatemo-chart-box col-lg-3 col-md-3 col-sm-4 col-xs-12">           
                    <canvas id="templatemo-polar-chart"></canvas>
                    <h4>Polar Area Chart</h4>
                    <span class="text-muted">Curabitur</span> 
                  </div>

                </div>                  
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 col-sm-6">
                <div class="panel panel-success">
                  <div class="panel-heading">Line Chart</div>
                  <canvas id="templatemo-line-chart"></canvas>
                </div>                       
              </div>
              <div class="col-md-6 col-sm-6">
                <div class="panel panel-primary">
                  <div class="panel-heading">Bar Chart</div>
                  <canvas id="templatemo-bar-chart"></canvas>
                </div>
              </div> 
            </div>
          </div>
        </div>
      </div>
    </div>

</div>


    <script type="text/javascript"></script>
  </body>
</html>