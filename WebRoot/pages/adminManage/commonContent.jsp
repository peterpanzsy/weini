<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<h1>权限设置</h1>
<ul id="authul" class="list-group margin-bottom-30">
     <li class="list-group-item"><input type="checkbox" name="orderCheck" value=""> 订单管理</li>
     <li class="list-group-item"><input type="checkbox" name="goodCheck" value=""> 商品管理</li>
     <li class="list-group-item"><input type="checkbox" name="vendorCheck" value=""> 商家管理</li>
     <li class="list-group-item"><input type="checkbox" name="userCheck" value=""> 用户管理</li>
     <li class="list-group-item"><input type="checkbox" name="adminCheck" value=""> 管理员账户管理</li>
     <li class="list-group-item"><input type="checkbox" name="reportCheck" value=""> 报表查看</li>
 </ul>
<h1>账户管理</h1>
<div class="row margin-bottom-30">
  <div class="col-md-12">   
	<div class="margin-bottom-30">
		<button  id="addRow">增加用户</button> 
	</div>
	<table id="adminTable" class="display table table-striped table-bordered" cellspacing="0" cellspacing="0" width="100%">
	    <thead>
	        <tr>	
	        	<th>ID</th>
	            <th>序号</th>
	            <th>用户名</th>
	            <th>编辑</th>
	            <th>删除</th>
	        </tr>
	    </thead>
	
	    <tfoot>
	        <tr>
	        	<th>ID</th>
	            <th>序号</th>
	            <th>用户名</th>
	            <th>编辑</th>
	            <th>删除</th>
	        </tr>
	    </tfoot>
	</table>     
  </div>
</div> 


<div id="e_Attributes"><!-- 声明dialog,异步更新 -->
	<form id="updateAdminForm" method="post" style="margin-top:-10px;"> 
        <table class="table">
             <tbody>
                <tr style="display:none">                          
                     <td>Name</td>
                     <td>
                         <input id="adminID" name="adminID" type="text" value="" style="width:200px" class="required"/>*</td>
                </tr>
                 <tr>
                     <td>用户名</td>
                     <td>
                        <input id="adminName" name="adminName" type="text" style="width:200px" class="required"/>*</td>
                 </tr>
                 <tr>
                     <td>密码</td>
                     <td>
                        <input id="adminPassword" name="adminPassword" type="password" style="width:128px" class="required"/>*</td>
                </tr>
                <tr>
                     <td>确认密码</td>
                     <td>
                        <input id="confirmPassword" name="confirmPassword" type="password" style="width:128px" class="required"/>*</td>
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
