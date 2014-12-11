 $(document).ready(function() {
	    /*
	     * 账户列表管理
	     */
        var vendorTable=$('#vendorTable').DataTable( {
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
            	"url":"listVendor.action",
            	"type": "POST",
         /*   	"data":{
            		"role":role
            	}*/
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
	            "data":"vendorID",
	            "visible": false
	        },
	        {
	            "targets": 1,//第二列
	            "data":"order"
//	            "visible": false,
//	            "searchable": false
	        },{
	        	"targets":2,
	        	"data":"vendorName"
	        },
	        {
	            "targets": 3,//第一列
	            "data":"vendorMail",
	            "visible": false
	        },
	        {
	            "targets": 4,//第二列
	            "data":"vendorPhonenum"
	        },{
	        	"targets":5,
	        	"data":"vendorIsopen"
	        },{
	        	"targets":6,
	        	"data":"vendorTotalmoney"
	        },
	        {
	            "targets": 7,//第一列
	            "data":"vendorPaidmoney",
	            "visible": false
	        },{
	        	"targets":8,
	        	"data":"vendorRemainedmoney"
	        },
	        {
	            "targets":9,//第一列
	            "data":"vendorEmploynum",
	            "visible": false
	        },
	        {
	            "targets": 10,//第二列
	            "data":"vendorCooknum"
	        },{
	        	"targets":11,
	        	"data":"vendorShophour"
	        },{
	        	"targets":12,
	        	"data":"vendorPaytype"
	        },{
	        	"targets":13,
	        	"data":"vendorAccount"
	        },{
	        	"targets":14,
	        	"data":"vendorBusinessArea"
	        }]
        } );
      
        //表格行的选择显示效果
        $('#vendorTable tbody').on( 'click', 'tr', function () {           
            if ($(this).hasClass('selected')) {
              $(this).removeClass('selected');             
              }
		   else{
			   vendorTable.$('tr.selected').removeClass('selected');
		      $(this).addClass('selected');
		   }
        } );
        // 数据删除
        $('#vendorTable tbody').on( 'click', 'button#delrow', function () {
        	 var statu = confirm("您是否确定删除当前数据?");
             if(!statu){
                 return false;
             }
            var data = vendorTable.row( $(this).parents('tr') ).data();
            $.ajax({
                url: 'delVendor.action',
                type: 'POST',
                dataType: 'json',
                data: {vendorID: data.vendorID},
            })
            .done(function(data) {
                	alert("删除成功！");
                	vendorTable.ajax.reload();
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
        $('#vendorTable tbody').on( 'click', 'button#editrow', function () {
            var data = vendorTable.row( $(this).parents('tr') ).data();
            putValue(data);
	        $("#mark").val("edit");
	        $("#e_Attributes").dialog("open"); 
	        updateVendorValidation();
        });
        //添加
        $("#addRow").click(function () {
        	vendorTable.$('tr.selected').removeClass('selected');
            putNullValue();
            $("#mark").val("add");
            $("#e_Attributes").dialog("open");
            updateVendorValidation();
        });
        function putNullValue(){
//        	$("#e_Attributes tr input").val("");
        	$(":input[name='vendorID']").val("");
        	$(":input[name='vendorName']").val("");
        	$(":input[name='vendorMail']").val("");
        	$(":input[name='vendorPhonenum']").val("");
        	$(":input[name='vendorIsopen']").val("");
        	$(":input[name='vendorEmploynum']").val("");
        	$(":input[name='vendorCooknum']").val("");
        }
        function putValue(data) {
        	$(":input[name='vendorID']").val(data.vendorID);
        	$(":input[name='vendorName']").val(data.vendorName);
        	$(":input[name='vendorMail']").val(data.vendorMail);
        	$(":input[name='vendorPhonenum']").val(data.vendorPhonenum);
        	$(":input[name='vendorIsopen']").val(data.vendorIsopen);
        	$(":input[name='vendorEmploynum']").val(data.vendorEmploynum);
        	$(":input[name='vendorCooknum']").val(data.vendorCooknum);
        }
       
        //添加或者修改数据的验证与提交
        function updateVendorValidation(){
       	 $("#updateVendorForm").validate({
 			debug:true,
 			onsubmit:true,
 			onfocusout:false,
 			onkeyup:true,
 	     	rules: {
 	     		vendorName: "required",
 	     		vendorMail: "required",
 	     		vendorPhonenum: "required"
 	     	},
 	       messages: {
 	    	   vendorName: "请输入商家名称！",
 	    	   vendorMail: {
 		        required: "请输入邮箱！"
 		       },
 		       vendorPhonenum: {
 		        required: "请输入电话！"
 		       }
 		    },
 		  	submitHandler:function(){
 		  		$.ajax({
 		  			type : 'POST',
 		  			url : 'updateVendor.action',
 		  			data : {			
 		  				vendorID:$("#vendorID").val(),	
 		  				vendorName:$("#vendorName").val(),
 		  				vendorMail:$("#vendorMail").val(),
 		  				vendorPhonenum:$("#vendorPhonenum").val(),
 		  				vendorIsopen:$("#vendorIsopen").val(),
 		  				vendorEmploynum:$("#vendorEmploynum").val(),
 		  				vendorCooknum:$("#vendorCooknum").val(),
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
 		  				vendorTable.ajax.reload();	
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
