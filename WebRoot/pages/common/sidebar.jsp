<%@ page language="java" import="java.util.*,com.weini.manage.business.*" pageEncoding="utf-8"%>
  <%
Admin userlogin=(Admin)(session.getAttribute("user"));
List<Auth> authlist=(List<Auth>)session.getAttribute("authList");
List<String> anamelist=new ArrayList<String>();
if (userlogin==null){
	response.sendRedirect("../pages/sign-in.jsp");
	return;
}
else{
	
	for(Auth auth:authlist){//获取权限列表
		anamelist.add(auth.getName());
	}
}
%>
<div class="navbar-collapse collapse templatemo-sidebar">
  <ul class="templatemo-sidebar-menu">
  	<li><a><i class="fa "></i>欢迎您！<%out.print(userlogin.getAdminName());%></a></li>
    <li>
      <form class="navbar-form">
        <input type="text" class="form-control" id="templatemo_search_box" placeholder="搜索...">
        <span class="btn btn-default">查询</span>
      </form>
    </li>
    <li class="active"><a href="pages/index.jsp"><i class="fa fa-home"></i>首页</a></li>
    <% 
	if(anamelist.contains("order")){
	%>
    <li id="orderManage" class="sub">
      <a href="javascript:;">
        <i class="fa fa-database"></i> 订单信息 <div class="pull-right"><span class="caret"></span></div>
      </a>
      <ul class="templatemo-submenu">
        <li class="open"><a href="#">订单模式</a></li>
        <li><a href="#">订单区域</a></li>
        <li><a href="#">订单商家</a></li>             
        <li><a href="#">订单金额</a></li>
        <li><a href="#">订单统计</a></li>             
        <li><a href="#">订单追踪</a></li>
         <li><a href="#">订单状况</a></li>
      </ul>
    </li>
    <%
		}
    if(anamelist.contains("good")){
    %>
    <li id="goodManage" class="sub">
      <a href="javascript:;">
        <i class="fa fa-database"></i> 商品管理 <div class="pull-right"><span class="caret"></span></div>
      </a>
      <ul class="templatemo-submenu">
        <li><a href="#">使用概况</a></li>
        <li><a href="#">添加商品</a></li>
        <li><a href="#">优惠活动</a></li>             
        <li><a href="#">积分兑换商品</a></li>
        <li><a href="#">已确认订单</a></li>
        <li><a href="#">未确认订单</a></li>
      </ul>
    </li>
    <%
		}
    if(anamelist.contains("vendor")){
    %>
    <li id="vendorManage" class="sub">
      <a href="javascript:;">
        <i class="fa fa-database"></i> 商家管理 <div class="pull-right"><span class="caret"></span></div>
      </a>
      <ul class="templatemo-submenu">
        <li><a href="#">添加商家</a></li>
        <li><a href="#">商家审核</a></li>
        <li><a href="#">商家信息</a></li>             
        <li><a href="#">商家后台管理</a></li>
      </ul>
    </li>
    <%
		}
    if(anamelist.contains("user")){
    %>
    <li id="userManage" class="sub">
      <a href="javascript:;">
        <i class="fa fa-database"></i> 用户管理 <div class="pull-right"><span class="caret"></span></div>
      </a>
      <ul class="templatemo-submenu">
        <li><a href="#">用户信息</a></li>
        <li><a href="#">积分信息</a></li>
        <li><a href="#">用户位置定位</a></li>             
        <li><a href="#">用户增长量统计</a></li>
      </ul>
    </li>
    <%
		}
    if(anamelist.contains("admin")){
    %>
    <li id="adminManage" class="sub">
      <a href="javascript:;">
        <i class="fa fa-database"></i> 账户管理 <div class="pull-right"><span class="caret"></span></div>
      </a>
      <ul class="templatemo-submenu">
        <li id="rootAdminLi"><a href="pages/adminManage/rootAdmin.jsp">超级管理员</a></li>
        <li id="financeAdminLi"><a href="pages/adminManage/financeAdmin.jsp">财务管理员</a></li>
        <li id="goodAdminLi"><a href="pages/adminManage/goodAdmin.jsp">产品管理员</a></li>             
        <li id="ordinaryAdminLi"><a href="pages/adminManage/ordinaryAdmin.jsp">普通管理员</a></li>
      </ul>
    </li>
    <%
		}
    if(anamelist.contains("report")){
    %>
    <li id="reportManage" class="sub">
      <a href="javascript:;">
        <i class="fa fa-database"></i> 报表数据统计 <div class="pull-right"><span class="caret"></span></div>
      </a>
      <ul class="templatemo-submenu">
        <li><a href="#">渠道分析</a></li>
        <li><a href="#">时间分析</a></li>
        <li><a href="#">用户偏好分析</a></li>             
        <li><a href="#">金额结算</a></li>
        <li><a href="#">转换率分析</a></li>             
        <li><a href="#">订单统计（数量）</a></li>
         <li><a href="#">平均购买力</a></li>
      </ul>
    </li>
    <%
		}
    %>
    <li><a href="pages/data-visualization.jsp"><i class="fa fa-cubes"></i><span class="badge pull-right">9</span>Data Visualization</a></li>
    <li><a href="pages/maps.jsp"><i class="fa fa-map-marker"></i><span class="badge pull-right">42</span>Maps</a></li>
    <li><a href="pages/tables.jsp"><i class="fa fa-users"></i><span class="badge pull-right">NEW</span>Manage Users</a></li>
    <li><a href="pages/preferences.jsp"><i class="fa fa-cog"></i>Preferences</a></li>
    <li><a href="javascript:void(0);" onclick="logout()"><i class="fa fa-sign-out"></i>注销</a></li>
  </ul>
</div><!--/.navbar-collapse -->

<!-- Modal -->
  <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
          <h4 class="modal-title" id="myModalLabel">您确定要注销?</h4>
        </div>
        <div class="modal-footer">
          <button class="btn btn-primary" onclick="logout()">是</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
        </div>
      </div>
    </div>
  </div>
<script>

</script>  
