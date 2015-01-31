 $(document).ready(function() {
	 	/*
	 	 * 权限操作
	 	 */
	  	var role=$("#role").val();
	  	$.ajax({//获取当前角色的权限列表
	  		url:"listAuthByRole.action",
	  		type:"post",
	  		dataType:"json",
	  		data:{
	  			"role":role
	  		},
	  		success:function(data){
	  			$.each(data.authList,function(i,auth){
	  				switch(auth.name){
	  				case "order":
	  					$("[name='orderCheck']").attr("checked",'true');
	  					break;
	  				case "good":
	  					$("[name='goodCheck']").attr("checked",'true');
	  					break;
	  				case "vendor":
	  					$("[name='vendorCheck']").attr("checked",'true');
	  					break;	
	  				case "user":
	  					$("[name='userCheck']").attr("checked",'true');
	  					break;
	  				case "admin":
	  					$("[name='adminCheck']").attr("checked",'true');
	  					break;
	  				case "report":
	  					$("[name='reportCheck']").attr("checked",'true');
	  					break;
	  				}
	  			});
	  		}
	  	});
	    $("#authul :checkbox").click(function(){//监听权限checkbox   
	    	var flag="";
	        if($(this).attr("checked")){//若当前是选中状态，则改为取消状态，更新数据库   
	        	$(this).removeAttr("checked");
	        	flag="delete"; 
	        }else{   
	        	$(this).attr("checked",'true');
	        	flag="add"; 
	        }   
	        $.ajax({
	        	url:"updateAuthByRole.action",
	        	type:'post',
	        	dataType:'json',
	        	data:{
	        		"role":role,
	        		"auth":$(this).attr("name"),
	        		"aflag":flag
	        	},
	        	success:function(data){
	        		switch(data.aflag){
	        		case "add":
	        			alert("添加权限成功！");
	        			break;
	        		case "delete":
	        			alert("删除权限成功！");
	        			break;
	        		}
	        	}
	        });
	    }); 
	    /*
	     * 账户列表管理
	     */
        var adminTable=$('#adminTable').DataTable( {
        	"oLanguage": {
        		"sSearch":"搜索",
        		"sLengthMenu": "每页显示 _MENU_ 条记录",
        		"sZeroRecords": "抱歉， 没有找到",
        		"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
        		"sInfoEmpty": "没有数据",
        		"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
        		"oPaginate": {
        		"sFirst": "首页",
        		"sPrevious": "前一页",
        		"sNext": "后一页",
        		"sLast": "尾页"
        		},
        		"sZeroRecords": "没有检索到数据",
        		//"sProcessing": "<img src='./loading.gif' />"
        		},
        	"sPaginationType": "full_numbers",
        	"bProcessing": true,
            "ajax": {
            	"url":"listAdmin.action",
            	"type": "POST",
            	"data":{
            		"role":role
            	}
            	},
 
            "sAjaxDataProp":"dataList",
          /*  "aoColumns": [   {"mDataProp":"order"},
                             {"mDataProp":"adminName"}
                             ],*/
            "columnDefs": [{
                "targets": -2,//编辑
                "dataList": null,
                "defaultContent": "<button id='editrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button>"
            },{
                "targets": -1,//删除
                "dataList": null,
                "defaultContent": "<button id='delrow' class='btn btn-primary' type='button'><i class='fa fa-trash-o'></i></button>"
            },
	        {
	            "targets": 0,//第一列
	            "data":"adminID",
	            "visible": false
	        },
	        {
	            "targets": 1,//第二列
	            "data":"order"
//	            "visible": false,
//	            "searchable": false
	        },{
	        	"targets":2,
	        	"data":"adminName"
	        }]
        } );
      
        //表格行的选择显示效果
        $('#adminTable tbody').on( 'click', 'tr', function () {           
            if ($(this).hasClass('selected')) {
              $(this).removeClass('selected');             
              }
		   else{
			  adminTable.$('tr.selected').removeClass('selected');
		      $(this).addClass('selected');
		   }
        } );
        // 数据删除
        $('#adminTable tbody').on( 'click', 'button#delrow', function () {
        	 var statu = confirm("您是否确定删除当前数据?");
             if(!statu){
                 return false;
             }
            var data = adminTable.row( $(this).parents('tr') ).data();
            $.ajax({
                url: 'delAdmin.action',
                type: 'POST',
                dataType: 'json',
                data: {id: data.adminID},
            })
            .done(function(data) {
                	alert("删除成功！");
                	adminTable.ajax.reload();
            })
            .fail(function() {
                alert("发生错误！");
            });
        });
        // 数据编辑      
		$("#e_Attributes").dialog({//数据添加或者修改的对话框初始化
			           //modal: true,
			           autoOpen: false,
			          width: 400
			     });
		 function dialogClose() {
	           $("#e_Attributes").dialog("close");
	      }
		//编辑修改
        $('#adminTable tbody').on( 'click', 'button#editrow', function () {
            var data = adminTable.row( $(this).parents('tr') ).data();
            putValue(data);
	        $("#mark").val("edit");
	        $("#e_Attributes").dialog("open"); 
	        updateAdminValidation();
        });
        //添加
        $("#addRow").click(function () {
			adminTable.$('tr.selected').removeClass('selected');
            putNullValue();
            $("#mark").val("add");
            $("#e_Attributes").dialog("open");
            updateAdminValidation();
        });
        function putNullValue(){
//        	$("#e_Attributes tr input").val("");
        	$(":input[name='adminID']").val("");
        	$(":input[name='adminName']").val("");
        	$(":input[name='adminPassword']").val("");
        	$(":input[name='confirmPassword']").val("");
        }
        function putValue(data) {
        	$(":input[name='adminID']").val(data.adminID);
        	$(":input[name='adminName']").val(data.adminName);
//        	$(":input[name='adminPassword']").val(data.adminPassword);//密码是不可逆加密，所以不显示，必须重新输入
//        	$(":input[name='confirmPassword']").val(data.adminPassword);
        }
       
        //添加或者修改数据的验证与提交
        function updateAdminValidation(){
       	 $("#updateAdminForm").validate({
 			debug:true,
 			onsubmit:true,
 			onfocusout:false,
 			onkeyup:true,
 	     	rules: {
 	     	   adminName: "required",
 	     	   adminPassword: {
 			        required: true,
 			        minlength: 5
 			       },
		       confirmPassword: {
		        required: true,
		        minlength: 5,
		        equalTo: "#adminPassword"
		       }
 	     	},
 	       messages: {
 	    	   adminName: "请输入用户名",
 	    	   adminPassword: {
 		        required: "请输入密码",
 		        minlength: jQuery.format("密码不能小于{0}个字 符")
 		       },
 		       confirmPassword: {
 		        required: "请输入确认密码",
 		        minlength: "确认密码不能小于5个字符",
 		        equalTo: "两次输入密码不一致不一致"
 		       }
 		    },
 		  	submitHandler:function(){
 		  		$.ajax({
 		  			type : 'POST',
 		  			url : 'updateAdmin.action',
 		  			data : {			
 		  				adminID:$("#adminID").val(),	
 		  				role:$("#role").val(),
 		  				adminName:$("#adminName").val(),
 		  				adminPassword:$("#adminPassword").val(),
 		  				confirmPassword:$("#confirmPassword").val(),
 		  				mark:$("#mark").val()
 		  			},
 		  			success : function(data) {
 		  				switch(data.mark){
 		  				case "add":
 		  					alert("添加成功！");
 		  					break;
 		  				case "edit":
 		  					alert("修改成功！");
 		  					break;
 		  				}
 		  				dialogClose();
 		  				adminTable.ajax.reload();	
 		  			},
 		  			error:function(msg){
 		  				dialogClose();
 		  				alter(msg);	  				
 		  			}
 		  		});
 			}
 	        });           
        }
        
        
    } );
