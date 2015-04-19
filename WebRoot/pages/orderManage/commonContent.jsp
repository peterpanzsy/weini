<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<h1>订单管理</h1>
<div class="row margin-bottom-30">
  <div class="col-md-12">   
	<div class="margin-bottom-30">
        <p></p>
        开始日期: <input type="text" id="dateStart">
        &nbsp;
        结束日期: <input type="text" id="dateEnd">&nbsp;
     <%--   <button onclick="orderSearch();">订单查询</button>&nbsp;--%>
        <button onclick="orderCount();">订单统计</button>
        &nbsp;订单总数：<input id="orderTotal" text="" disabled="disabled" />个 &nbsp;
        订单总金额：<input id="orderSum" text="" disabled="disabled" />元
	</div>
	<table id="orderTable" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
	    <thead>
	        <tr>	
	        	<th>序号</th>
	            <th>订单编号</th>
	            <th>菜单</th>
                <th>客户</th>
	            <th>盒子编号</th>
	            <th>盒子价格</th>
                <th>注意</th>
	            <th>是否第一单</th>
	            <th>配送信息</th>
                <th>付款状态</th>
                <th>消费状态</th>
	            <th>订单状态</th>
                <th>解决状态</th>
                <th>订单开始时间</th>
                <th>下单时间</th>
                <th>付款时间</th>
	        </tr>
	    </thead>
	</table>     
  </div>
</div> 



