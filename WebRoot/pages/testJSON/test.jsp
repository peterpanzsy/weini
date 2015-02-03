<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSONTest For Client</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery.min.js"></script>

  </head>
<style>
.url{width:300px;}
.content{width:80%;height:60%;}
</style>
<body>
	<form id="testJSON" method="post">
		<div>
			ACTION：<input type="text" value=".action" 
			class="url" id="url" />&nbsp;&nbsp;
		</div>
		<a href="javascript:excute();">提交</a><br/>
		<div>
			返回的JSON：
			<textarea id="content" class="content" name="id" >
				
			</textarea>
		</div>
	</form>
	
</body>
<script>
function excute(){
	var url = document.getElementById('url').value;
		$.ajax({
         url : url,
         type : "post",
         dataType : "json",
         data : {
		//此处来放置参数信息
		// "phoneNumber":1,
		// "password": "zsy"
			//"typeId":2
		//"cityId":1
		//"busId":2
		//"userId":1,
		//"date":"2015-01-23"
		/* "menuId":1,
		"point":"4.5" */
		//"num":1
       /*  "phoneNum":"15844097083",
       "identifyCode":645206 */
       	"phoneNum":"18710871983",
	  	"password":"wpr",
       	"identifyCode":530949 
         },
         success : function(data) {
				//TODO 这个地方用来改得到的数据信息就可以了
				console.log(data);
			},
			error:function(msg){
				alert("通讯错误，更新失败！！");						
			}
		});
};
</script>
</html>
