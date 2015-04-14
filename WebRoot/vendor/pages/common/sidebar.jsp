<%@ page language="java" import="java.util.*,com.weini.manage.entity.*" pageEncoding="utf-8"%>

 <%
 	TVendor userlogin=(TVendor)(session.getAttribute("vendor"));
  if (userlogin==null){
  	response.sendRedirect(request.getContextPath()+"/vendor/pages/sign-in.jsp");
  	return;
  }
 %>
<input id="vendorId" value="<%out.print(userlogin.getVendorId());%>" style="display: none" />
<div class="navbar-collapse collapse templatemo-sidebar">
  <ul class="templatemo-sidebar-menu">
  	<li><a><i class="fa "></i>欢迎您！<%out.print(userlogin.getVendorName());%></a></li>
    <li>
    </li>
   <%-- <li class="active"><a href="vendor/pages/index.jsp"><i class="fa fa-home"></i>首页</a></li>--%>

    <li id="orderManage" class="sub">
      <a href="javascript:;">
        <i class="fa fa-database"></i> 订单管理 <div class="pull-right"><span class="caret"></span></div>
      </a>
      <ul class="templatemo-submenu">
        <li id="manageOrderLi"><a href="vendor/pages/orderManage/manageOrder.jsp">当日订单</a></li>
        <li id="historyOrderLi"><a href="vendor/pages/orderManage/historyOrder.jsp">历史订单</a></li>
       <%-- <li><a href="#">订单统计</a></li>--%>
      <%--  <li><a href="#">订单结算</a></li>--%>
      </ul>
    </li>

    <li id="goodManage" class="sub">
      <a href="javascript:;">
        <i class="fa fa-database"></i> 商品管理 <div class="pull-right"><span class="caret"></span></div>
      </a>
      <ul class="templatemo-submenu">
        <!-- <li id="utiliSurveyli"><a href="vendor/pages/goodManage/utilizationSurvey.jsp">使用概况</a></li> -->
        <li id="existGoodli"><a href="vendor/pages/goodManage/existGood.jsp">有效菜单列表</a></li>
        <li id="deletedGoodli"><a href="vendor/pages/goodManage/deletedGood.jsp">暂不供应菜单列表</a></li><%--
        <li id="addGoodli"><a href="addGood">添加商品</a></li>
        <li><a href="vendor/pages/goodManage/addGood.jsp">优惠活动</a></li>
        <li><a href="vendor/pages/goodManage/addGood.jsp">积分兑换商品</a></li>--%>
      </ul>
    </li>
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
