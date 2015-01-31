<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<h1>用户管理</h1>
<div class="row margin-bottom-30">
  <div class="col-md-12">   
	<div class="margin-bottom-30">
		<!-- <button  id="addRow">增加用户</button>  -->
	</div>
	<table id="userTable" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
	    <thead>
	        <tr>	
	        	<th>ID</th>
	            <th>序号</th>
	            <th>用户名</th>
	            <th>性别</th>
	            <th>地址</th>
	            <th>手机号</th>
	            <th>手机类型</th>
	            <th>等级</th>
	            <th>银行账号</th>
	            <th>支付宝账号</th>
	            <th>微信账号</th>
	            <th>积分</th>
	            <th>注册时间</th>
	     		<th>查看详情</th> 
	            <th>删除</th>
	        </tr>
	    </thead>
	</table>     
  </div>
</div> 


<div id="e_Attributes"><!-- 声明dialog,异步更新 -->
	<form id="updateUserForm" method="post" style="margin-top:-10px;"> 
        <table class="table">
             <tbody>
                <tr style="display:none">                          
                     <td>ID</td>
                     <td>
                         <input id="userID" name="userID" type="text" value="" style="width:200px" class="required"/>*</td>
                </tr>
                 <tr>
                     <td>用户名</td>
                     <td>
                        <input id="userName" name="userName" type="text" style="width:200px" class="required"/>*</td>
                 </tr>
                 <tr>
                     <td>性别</td>
                     <td>
                        <input id="userGender" name="userGender" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>地址</td>
                     <td>
                        <input id="userAddress" name="userAddress" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>手机号</td>
                     <td>
                        <input id="userPhoneNumber" name="userPhoneNumber" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>手机类型</td>
                     <td>
                        <input id="userPhoneType" name="userPhoneType" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>级别</td>
                     <td>
                        <input id="userScale" name="userScale" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>银行卡账号</td>
                     <td>
                        <input id="userBank" name="userBank" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>支付宝账号</td>
                     <td>
                        <input id="userAlipay" name="userAlipay" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>微信账号</td>
                     <td>
                        <input id="userWechatPay" name="userWechatPay" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>积分</td>
                     <td>
                        <input id="userPoint" name="userPoint" type="text" style="width:128px" class="required"/>*</td>
                </tr>
                 <tr>
                     <td>注册时间</td>
                     <td>
                        <input id="userRegdate" name="userRegdate" type="text" style="width:128px" class="required"/>*</td>
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
