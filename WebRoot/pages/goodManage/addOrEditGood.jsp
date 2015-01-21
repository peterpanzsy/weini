<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<head>
  <base href="<%=basePath%>">
  <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
  <title>味你，数据管理平台</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width">        
  <link rel="stylesheet" href="css/templatemo_main.css">
  <!-- DataTables CSS -->
  <link rel="stylesheet" type="text/css" href="DataTables-1.10.4/css/jquery.dataTables.css">
  <link rel="stylesheet" href="jquery-ui-1.11.2/themes/smoothness/jquery-ui.css">
  <link rel="stylesheet" type="text/css" href="uploadify/uploadify.css">

  
</head>
<body>
  <div id="main-wrapper">
  <%@ include file="../common/head.jsp"  %> 
    <div class="template-page-wrapper">
   	  <%@ include file="../common/sidebar.jsp"%>
      <div class="templatemo-content-wrapper">
        <div class="templatemo-content">
          <ol class="breadcrumb">
            <li><a href="pages/index.jsp">返回首页</a></li>
            <li><a href="pages/goodManage/existGood.jsp">商品管理</a></li>
            <li class="active">
            	<s:if test="%{isAdd}">添加商品</s:if>
            	<s:else>编辑商品</s:else>
            	</li>
          </ol>
    <div style="text-align:center;padding-bottom:20px;">
    	<h1><s:if test="%{isAdd}">添加商品</s:if>
            	<s:else>编辑商品</s:else>
        </h1>
    </div>
	<form id="addGoodForm" method="post" style="margin-top:-10px;"> 
        <table class="table" align="center" >
             <tbody>
                <tr>                          
                     <td>商品名称</td>
                     <td>
						<input id="menuID" type="hidden" value="${indexID}">
						<input id="isAdd" type="hidden" value="${isAdd}">
                         <input id="menuName" name="menuName" type="text" value="${menu.menuinfoName }" style="width:200px" class="required"/>*</td>
                </tr>
                <tr>                          
                     <td>商圈地址</td>
                     <td>
                         <select id="proviceID" style="width:200px;height:30px;" class="required" >
                         </select>
                         <select id="cityID" style="width:200px;height:30px;" class="required" >
                         <option selected = "selected" value="-1">请选择城市</option>
                         </select>
                         <select id="districtID" style="width:200px;height:30px;" class="required" >
                         <option selected = "selected" value="-1">请选择县区</option>
                         </select>
                         <select id="bussAreaID" style="width:200px;height:30px;" class="required" >
                         <option selected = "selected" value="-1">请选择商圈</option>
                         </select>
					</td>
                </tr>
                 <tr>                          
                     <td>商家名称</td>
                     <td>
                         <select id="vendorID" style="width:200px;height:30px;" class="required">
                         <s:if test='%{menu != null}'>
                         <option selected = "selected" value="${menu.vendorId}">${menu.vendorName }</option>
                         </s:if>
                         <s:else>
                         <option selected = "selected" value="-1">请选择商家</option>
                         </s:else>
                         </select>*
                         
                     </td>
                 </tr>
                 <tr> 
                 	<td>商品图片：</td>
					<td>
						<div style = "width:200px;height:300px;float:left;">
							<div style="margin-bottom:10px;border:0.5px solid #000"><img id= "img1" src="${menu.menuinfoImage1}" width="200px" height="200px" border="1"/></div>
							<div style="height:100px;">
								<input type="file" name="uploadify1" id="uploadify1">
							</div>
						</div>
						<div style = "width:200px;height:250px;float:left;margin-left:10px;">
							<div style="margin-bottom:10px;border:0.5px solid #000"><img id= "img2" src="${menu.menuinfoImage2}" width="200px" height="200px" border="1"/></div>
							<div style="height:100px;">
								<input type="file" name="uploadify2" id="uploadify2">
							</div>
						</div>
						<div style = "width:200px;height:250px;float:left;margin-left:10px;">
							<div style="margin-bottom:10px;border:0.5px solid #000"><img id= "img3" src="${menu.menuinfoImage3}" width="200px" height="200px" border="0"/></div>
							<div style="height:100px;">
								<input type="file" name="uploadify3" id="uploadify3">
							</div>
						</div>
						<div style = "width:200px;height:250px;float:left;margin-left:10px;">
							<div style="margin-bottom:10px;border:0.5px solid #000"><img  id= "img4" src="${menu.menuinfoImage4}" width="200px" height="200px" /></div>
							<div style="height:100px;">
								<input type="file" name="uploadify4" id="uploadify4">
							</div>
						</div>
					</td>
				</tr>
                <tr>
                     <td>商品详细描述</td>
                     <td>
                        <textarea id="menuDetail" maxlength="200" style="width:800px;height:150px">${menu.menuinfoDetail }</textarea></td>
                </tr>
               <tr>
                    <td>
                       <input id="submit" type="submit" name="submit" value="Submit" />
                       <input id="mark" type="hidden" name="mark" />
                   </td>
               </tr>        
            </tbody>
        </table>
	</form>

       </div>
      </div>
   	<%@ include file="../common/footer.jsp"  %>
    </div>
   </div>


<input id="role" value="root" style="display:none" />
  	<!-- <script src="js/jquery.min.js"></script> -->
  	<script>
  	
    
   

  	
  	
  	
  	</script>
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/jquery-1.11.1.min.js"></script>  
  	<script src="js/bootstrap.min.js"></script>
  	<script src="jquery-validation-1.11.1/dist/jquery.validate.js" type="text/javascript"></script>
  	<script src="jquery-ui-1.11.2/jquery-ui.js"></script>
  	
    <script src="js/templatemo_script.js"></script>
  	<!-- DataTables -->
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/jquery.dataTables.min.js"></script>
  	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/js/dataTables.bootstrap.js"></script>  
    <script type="text/javascript" charset="utf8" src="js/addOrEditGood.js"></script>
    <!-- uploadify -->
    <script type="text/javascript" src="js/jquery.min.js"></script>  
	<script type="text/javascript" src="uploadify/jquery.uploadify.js"></script>  
	<script type="text/javascript" src="uploadify/jquery.uploadify.min.js"></script>  
</body>
</html>