 $(document).ready(function() { 
	    /*
	     * 账户列表管理
	     */
	 var $pathname=window.location.pathname;
	 var url = "listGood.action?isExistGood=true";
	 var delOrRecoverButton = "<button id='delrow' class='btn btn-primary' type='button'><i class='fa fa-trash-o'></i></button>";
	 var isExist = true;
	 switch($pathname){
		case "/WeiNiManage/pages/goodManage/deletedGood.jsp":
			url = "listGood.action?isExistGood=false";
			delOrRecoverButton = "<button id='recrow' class='btn btn-primary' type='button'><span class='glyphicon glyphicon-new-window'></span></button>";
			isExist = false;
			break;
	 }
     var goodTable=$('#goodTable').DataTable( {
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
            	"url":url,
            	"type": "POST",
            	},
            "sAjaxDataProp":"goodlist",
          /*  "aoColumns": [   {"mDataProp":"order"},
                             {"mDataProp":"adminName"}
                             ],*/
            "columnDefs": [
            {
                "targets": 7,//编辑
                "dataList": null,
                "visible": isExist,
                "defaultContent": "<button id='editrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button>"
            },
             {
                "targets": 5,//使用情况
                "dataList": null,
                "defaultContent": "<a href='#' style='text-decoration:underline;color:black'>详细情况</a>"
            },
            {
                "targets": 6,//删除
                "dataList": null,
                "defaultContent": delOrRecoverButton
            },
	        {
	            "targets": 0,//menuID
	            "data":"menuinfoId",
	            "visible": false
	        },
	        {
	            "targets": 1,//序号
	            "data":"order",
	        },
	        {
	            "targets": 2,//商品名称
	            "data":"menuinfoName"
//	            "visible": false,
//	            "searchable": false
	        }
	        ,{
	        	"targets":3,//商家名称
	        	"data":"vendorName"
	        }
	        ,{
	        	"targets":4,//所属商圈
	        	"data":"bussinessName"
	        }
	        ]
        } );
        //表格行的选择显示效果
        $('#goodTable tbody').on( 'click', 'tr', function () {           
            if ($(this).hasClass('selected')) {
              $(this).removeClass('selected');             
              }
		   else{
			   goodTable.$('tr.selected').removeClass('selected');
		      $(this).addClass('selected');
		   }
        } );
     // 数据删除
        $('#goodTable tbody').on( 'click', 'button#delrow', function () {
        	 var statu = confirm("您是否确定删除当前数据?");
             if(!statu){
                 return false;
             }
            var data = goodTable.row( $(this).parents('tr') ).data();
            $.ajax({
                url: 'delGood.action',
                type: 'POST',
                dataType: 'json',
                data: {indexID: data.menuinfoId},
            })
            .done(function(data) {
            	if(data.aflag){
					alert("删除成功！");
            	}else{
					alert("删除失败！");
            	}
            	goodTable.ajax.reload();
            })
            .fail(function() {
                alert("发生错误！");
            });
        });
        
        //恢复商品
        $('#goodTable tbody').on( 'click', 'button#recrow', function () {
       	 var statu = confirm("您是否确定恢复当前商品?");
            if(!statu){
                return false;
            }
           var data = goodTable.row( $(this).parents('tr') ).data();
           $.ajax({
               url: 'recoverGood.action',
               type: 'POST',
               dataType: 'json',
               data: {indexID: data.menuinfoId},
           })
           .done(function(data) {
        	   if(data.aflag){
   					alert("恢复成功！");
        	   }else{
   					alert("恢复失败！");
       			}
           		goodTable.ajax.reload();
           })
           .fail(function() {
               alert("发生错误！");
           });
       });
      
        //添加
        $("#submit").click(function () {
            putNullValue();
            updateAdminValidation();
        });
        //初始化默认值
        function putNullValue(){
        	$(":input[name='menuName']").val("");
        	$(":input[name='menuDetail']").val("");
        }
        
      //添加或者修改数据的验证与提交
        function updateAdminValidation(){
       	 $("#addGoodForm").validate({
 			debug:true,
 			onsubmit:true,
 			onfocusout:false,
 			onkeyup:true,
 	     	rules: {
 	     		menuName: "required",
// 	     	   adminPassword: {
// 			        required: true,
// 			        minlength: 5
// 			       },
//		       confirmPassword: {
//		        required: true,
//		        minlength: 5,
//		        equalTo: "#adminPassword"
//		       }
 	     	},
 	       messages: {
 	    	  menuName: "请输入商品名称",
// 	    	   adminPassword: {
// 		        required: "请输入密码",
// 		        minlength: jQuery.format("密码不能小于{0}个字 符")
// 		       },
// 		       confirmPassword: {
// 		        required: "请输入确认密码",
// 		        minlength: "确认密码不能小于5个字符",
// 		        equalTo: "两次输入密码不一致不一致"
// 		       }
 		    },
 		  	submitHandler:function(){
 		  		alert("submit");
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
     // 数据删除
        $('#goodTable tbody').on( 'click', 'button#editrow', function () {
        	var data = goodTable.row( $(this).parents('tr') ).data();
        	 window.location = "editGood?indexID="+data.menuinfoId;
        });
        
        
        
        
        
        
        
        
        
        
    } );
