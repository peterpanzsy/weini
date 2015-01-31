<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<h1>商家管理</h1>
<div class="row margin-bottom-30">
  <div class="col-md-12">   
	<div class="margin-bottom-30">
		<button  id="addRow">增加商家</button> 
	</div>
	<table id="vendorTable" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
	    <thead>
	        <tr>	
	        	<th>ID</th>
	            <th>序号</th>
	            <th>商家名</th>
	            <th>邮箱</th>
	            <th>电话</th>
	            <th>是否营业</th>
	            <th>总金额</th>
	            <th>已付金额</th>
	            <th>待付金额</th>
	            <th>员工规模</th>
	            <th>厨师规模</th>
	            <th>开始营业时间</th>
	            <th>结束营业时间</th>
	            <th>支付方式</th>
	            <th>默认账户</th>
	            <th>商圈</th>
	            <th>详情</th>
	            <th>编辑</th>
	            <th>删除</th>
	        </tr>
	    </thead>
	</table>     
  </div>
</div> 


<div id="e_Attributes"><!-- 声明dialog,异步更新 -->
	<form id="updateVendorForm" method="post" style="margin-top:-10px;"> 
        <table class="table">
             <tbody>
                <tr style="display:none">                          
                     <td>ID</td>
                     <td>
                         <input id="vendorID" name="vendorID" type="text" value="" style="width:200px" class="required"/>*</td>
                </tr>
                 <tr>
                     <td>用户名</td>
                     <td>
                        <input id="vendorName" name="vendorName" type="text" style="width:200px" class="required"/>*</td>
                 </tr>
                 <tr>
                     <td>邮箱</td>
                     <td>
                        <input id="vendorMail" name="vendorMail" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>电话</td>
                     <td>
                        <input id="vendorPhonenum" name="vendorPhonenum" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                 <tr>
                     <td>是否营业</td>
                     <td>
                     	<input type="radio" name="vendorIsopen" value="是" > 是
                     	<input type="radio" name="vendorIsopen" value="否" > 否
                        <!-- <input id="vendorIsopen" name="vendorIsopen" type="text" style="width:200px" class="required"/>*</td> -->
                 </tr>
                 <tr>
                     <td>雇员规模</td>
                     <td>
                        <input id="vendorEmploynum" name="vendorEmploynum" type="text" style="width:128px"/>*</td>
                </tr>
                <tr>
                     <td>厨师规模</td>
                     <td>
                        <input id="vendorCooknum" name="vendorCooknum" type="text" style="width:128px" />*</td>
                </tr>
                <tr>
                     <td>开始营业时间</td>
                     <td>
                        <input id="vendorShophourStart" name="vendorShophourStart" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>结束营业时间</td>
                     <td>
                        <input id="vendorShophourEnd" name="vendorShophourEnd" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>商家详情</td>
                     <td>
                        <input id="vendorDetail" name="vendorDetail" type="text" style="width:128px"/></td>
               </tr>
               <tr>
                    <td>
                       <input id="submit" type="submit" name="submit" value="提交" />
                       <input id="mark" type="hidden" name="mark" />
                   </td>
                </tr>
            </tbody>
        </table>
	</form>
</div>
