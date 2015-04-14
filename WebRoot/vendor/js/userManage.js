 $(document).ready(function() {
	    /*
	     * 用户列表管理
	     */
        var userTable=$('#userTable').DataTable( {
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
        		},
        	"sPaginationType": "full_numbers",
        	"bProcessing": true,
            "ajax": {
            	"url":"listUser.action",
            	"type": "POST"
            	},
 
            "sAjaxDataProp":"dataList",
            "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
//        		if(aData.vendorIsopen==true){
//        			aData.vendorIsopen="是";
//        		}else{
//        			aData.vendorIsopen="否";
//        		}
//    			return aData;
    		},
            	
            "columnDefs": [
                           {
                "targets": -2,//编辑
                "dataList": null,
                "defaultContent": "<button id='editrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button>"
            },
            {
                "targets": -1,//删除
                "dataList": null,
                "defaultContent": "<button id='delrow' class='btn btn-primary' type='button'><i class='fa fa-trash-o'></i></button>"
            },
	        {
	            "targets": 0,//第一列
	            "data":"userID",
	            "visible": false
	        },
	        {
	            "targets": 1,//第二列
	            "data":"order"
//	            "visible": false,
//	            "searchable": false
	        },{
	        	"targets":2,
	        	"data":"userName"
	        },
	        {
	            "targets": 3,//第一列
	            "data":"userGender",
	            "visible": true
	        },
	        {
	            "targets": 4,//第二列
	            "data":"userAddress"
	        },{
	        	"targets":5,
	        	"data":"userPhoneNumber"
//	        	"createdCell": function (td, cellData, rowData, row, col) {
//	        	      if ( cellData ==true ) {
//	        	        $(td).html( "是");
//	        	      }else{
//	        	    	$(td).html("否");
//	        	      }
//	        	    }
	        },{
	        	"targets":6,
	        	"data":"userPhoneType"
	        },
	        {
	            "targets": 7,
	            "data":"userScale"
	        },{
	        	"targets":8,
	        	"data":"bankCardNumber"
	        },
	        {
	            "targets":9,
	            "data":"alipayUserAccount",
	            "visible": false
	        },
	        {
	            "targets": 10,
	            "data":"weChatPay"
	        },{
	        	"targets":11,
	        	"data":"pointTotal"
	        },{
	        	"targets":12,
	        	"data":"userRegdate"
	        }]
        } );
      
        //表格行的选择显示效果
        $('#userTable tbody').on( 'click', 'tr', function () {           
            if ($(this).hasClass('selected')) {
              $(this).removeClass('selected');             
              }
		   else{
			   vendorTable.$('tr.selected').removeClass('selected');
		      $(this).addClass('selected');
		   }
        } );
        // 数据删除
        $('#userTable tbody').on( 'click', 'button#delrow', function () {
        	 var statu = confirm("您是否确定删除当前数据?");
             if(!statu){
                 return false;
             }
            var data = userTable.row( $(this).parents('tr') ).data();
            $.ajax({
                url: 'delUser.action',
                type: 'POST',
                dataType: 'json',
                data: {userID: data.userID},
            })
            .done(function(data) {
                	alert("删除成功！");
                	userTable.ajax.reload();
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
        $('#userTable tbody').on( 'click', 'button#editrow', function () {
            var data = userTable.row( $(this).parents('tr') ).data();
            putValue(data);
	        $("#mark").val("edit");
	        $("#e_Attributes").dialog("open"); 
	        updateUserValidation();
        });
        //添加
        $("#addRow").click(function () {
        	userTable.$('tr.selected').removeClass('selected');
            putNullValue();
            $("#mark").val("add");
            $("#e_Attributes").dialog("open");
            updateUserValidation();
        });
        function putNullValue(){
//        	$("#e_Attributes tr input").val("");
        	$(":input[name='userID']").val("");
        	$(":input[name='userName']").val("");
        	$(":input[name='userGender']").val("");
        	$(":input[name='userAddress']").val("");
        	$(":input[name='userPhoneNumber']").val("");
        	$(":input[name='userPhoneType']").val("");
        	$(":input[name='userScale']").val("");
        	$(":input[name='userBank']").val("");
        	$(":input[name='userAlipay']").val("");
        	$(":input[name='userWechatPay']").val("");
        	$(":input[name='userPoint']").val("");
        	$(":input[name='userRegdate']").val("");
        }
        function putValue(data) {
        	$(":input[name='userID']").val(data.userID);
        	$(":input[name='userName']").val(data.userName);
        	$(":input[name='userGender']").val(data.userGender);
        	$(":input[name='userAddress']").val(data.userGender);
        	$(":input[name='userPhoneNumber']").val(data.userPhoneNumber);
        	$(":input[name='userPhoneType']").val(data.userPhoneType);
        	$(":input[name='userScale']").val(data.userScale);
        	$(":input[name='userBank']").val(data.userBank);
        	$(":input[name='userAlipay']").val(data.userAlipay);
        	$(":input[name='userWechatPay']").val(data.userWechatPay);
        	$(":input[name='userPoint']").val(data.userPoint);
        	$(":input[name='userRegdate']").val(data.userRegdate);
        }
       
        
        jQuery.validator.addMethod("isphone", function(value, element) {
        	  var length = value.length;
        	  var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
        	  return this.optional(element) || (phone.test(value));
        	 }, "请填写正确的电话号码");
        
        //添加或者修改数据的验证与提交
        function updateUserValidation(){
       	 $("#updateUserForm").validate({
 			debug:true,
 			onsubmit:true,
 			onfocusout:false,
 			onkeyup:true,
 	     	rules: {
 	     		userName: "required",
 	     		userGender: {
 	     		    required: true
 	     		   },
 	     		userAddress: {
 	     			required:true
 	     		},
 	     		userPhoneNumber:{
 	     			required:true,
 	     			isphone:true
 	     		},
 	     		userPhoneType:{
 	     			digits:true
 	     		},
 	     		userScale:{
 	     			required: true
 	     		}
 	     	},
 		  	submitHandler:function(){
 		  		$.ajax({
 		  			type : 'POST',
 		  			url : 'updateUser.action',
 		  			data : {			
 		  				userID:$("#userID").val(),	
 		  				userName:$("#userName").val(),
 		  				userGender:$("#userGender").val(),
 		  				userAddress:$("#userAddress").val(),
 		  				userPhoneNumber:$("#userPhoneNumber").val(),
 		  				userPhoneType:$("#userPhoneType").val(),
 		  				userScale:$("#userScale").val(),
 		  				userBank:$("#userBank").val(),
 		  				userAlipay:$("#userAlipay").val(),
 		  				userWeChatPay:$("#userWeChatPay").val(),
 		  				userPoint:$("#userPoint").val(),
 		  				userRegdate:$("#userRegdate").val(),
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
 		  				userTable.ajax.reload();	
 		  			},
 		  			error:function(msg){
 		  				dialogClose();
 		  				alert(msg);	  				
 		  			}
 		  		});
 			}
 	        });           
        }
        
        
    } );
