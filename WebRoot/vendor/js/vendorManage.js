 $(document).ready(function() {

	 $('input#vendorShophourStart').timepicker({
		    timeFormat: 'HH:mm:ss',
	        // year, month, day and seconds are not important
	        minTime: new Date(0, 0, 0, 6, 0, 0),
	        maxTime: new Date(0, 0, 0, 23, 0, 0),
	        // time entries start being generated at 6AM but the plugin 
	        // shows only those within the [minTime, maxTime] interval
	        startHour: 6,
	        // the value of the first item in the dropdown, when the input
	        // field is empty. This overrides the startHour and startMinute 
	        // options
	        startTime: new Date(0, 0, 0, 6, 0, 0),
	        // items in the dropdown are separated by at interval minutes
	        interval: 10
	 });
	 $('input#vendorShophourEnd').timepicker({
		    timeFormat: 'HH:mm:ss',
	        // year, month, day and seconds are not important
	        minTime: new Date(0, 0, 0, 6, 0, 0),
	        maxTime: new Date(0, 0, 0, 23, 0, 0),
	        // time entries start being generated at 6AM but the plugin 
	        // shows only those within the [minTime, maxTime] interval
	        startHour: 6,
	        // the value of the first item in the dropdown, when the input
	        // field is empty. This overrides the startHour and startMinute 
	        // options
	        startTime: new Date(0, 0, 0, 6, 0, 0),
	        // items in the dropdown are separated by at interval minutes
	        interval: 10
	 });
	    /*
	     * 商家列表管理
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
            "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
        		if(aData.vendorIsopen==true){
        			aData.vendorIsopen="是";
        		}else{
        			aData.vendorIsopen="否";
        		}
    			return aData;
    		},
            	
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
	            "visible": true
	        },
	        {
	            "targets": 4,//第二列
	            "data":"vendorPhonenum"
	        },{
	        	"targets":5,
	        	"data":"vendorIsopen",
	        	"createdCell": function (td, cellData, rowData, row, col) {
	        	      if ( cellData ==true ) {
//	        	        $(td).css('color', 'red');
	        	        $(td).html( "是");
	        	      }else{
	        	    	$(td).html("否");
	        	      }
	        	    }
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
	        	"data":"vendorShophourStart"
	        },{
	        	"targets":12,
	        	"data":"vendorShophourEnd"
	        },{
	        	"targets":13,
	        	"data":"vendorPaytype"
	        },{
	        	"targets":14,
	        	"data":"vendorAccount"
	        },{
	        	"targets":15,
	        	"data":"vendorBusinessArea"
	        },{
	        	"targets":16,
	        	"data":"vendorDetail"
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
        	$(":input[name='vendorEmploynum']").val("");
        	$(":input[name='vendorCooknum']").val("");
        	$(":input[name='vendorShophourStart']").val("");
        	$(":input[name='vendorShophourEnd']").val("");
        	$(":input[name='vendorDetail']").val("");
        }
        function putValue(data) {
        	$(":input[name='vendorID']").val(data.vendorID);
        	$(":input[name='vendorName']").val(data.vendorName);
        	$(":input[name='vendorMail']").val(data.vendorMail);
        	$(":input[name='vendorPhonenum']").val(data.vendorPhonenum);
        	$("input[name='vendorIsopen'][value='"+data.vendorIsopen+"']").attr("checked",true);
        	$(":input[name='vendorEmploynum']").val(data.vendorEmploynum);
        	$(":input[name='vendorCooknum']").val(data.vendorCooknum);
        	$(":input[name='vendorShophourStart']").val(data.vendorShophourStart);
        	$(":input[name='vendorShophourEnd']").val(data.vendorShophourEnd);
        	$(":input[name='vendorDetail']").val(data.vendorDetail);
        }
       
        
        jQuery.validator.addMethod("isphone", function(value, element) {
        	  var length = value.length;
        	  var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
        	  return this.optional(element) || (phone.test(value));
        	 }, "请填写正确的电话号码");
        
        //添加或者修改数据的验证与提交
        function updateVendorValidation(){
       	 $("#updateVendorForm").validate({
 			debug:true,
 			onsubmit:true,
 			onfocusout:false,
 			onkeyup:true,
 	     	rules: {
 	     		vendorName: "required",
 	     		vendorMail: {
 	     		    required: true,
 	     		    email: true
 	     		   },
 	     		vendorPhonenum: {
 	     			required:true,
 	     			isphone : true
 	     		},
 	     		vendorEmploynum:{
 	     			digits:true
 	     		},
 	     		vendorCooknum:{
 	     			digits:true
 	     		},
 	     		vendorShophourStart:{
 	     			required: true,
 	     		},
 	     		vendorShophourEnd:{
 	     			required: true,
 	     		}
 	     	},
 	       messages: {
 	    	    vendorName: "请输入商家名称！",
 	    	    vendorMail: {
 	    		    required: "请输入邮箱！",
 		        	email: "请输入正确的email地址！"
 		        },
 		        vendorPhonenum: {
 		    	    required: "请输入电话号码！",
 		    	    isphone : "请输入正确的电话号码！"
 		        },
 		        vendorEmploynum:{
	     			digits:"请输入整数！"
	     		},
	     	    vendorCooknum:{
	     			digits:"请输入整数！"
	     		},
				vendorShophourStart:{
					required:"请输入开始营业时间！"
				},
	     	    vendorShophourEnd:{
	     	    	required:"请输入结束营业时间！"
	     		}
 		    },
 		  	submitHandler:function(){
 		  	   var isopen=$('input[name="vendorIsopen"]:checked').val();
 	 		    if(isopen=="是"){
 	 		    	isopen=true;
 	 		    }else{
 	 		    	isopen=false;
 	 		    };
 		  		$.ajax({
 		  			type : 'POST',
 		  			url : 'updateVendor.action',
 		  			data : {			
 		  				vendorID:$("#vendorID").val(),	
 		  				vendorName:$("#vendorName").val(),
 		  				vendorMail:$("#vendorMail").val(),
 		  				vendorPhonenum:$("#vendorPhonenum").val(),
 		  				vendorIsopen:isopen,
// 		  				vendorIsopen:$("#vendorIsopen").value,
 		  				vendorEmploynum:$("#vendorEmploynum").val(),
 		  				vendorCooknum:$("#vendorCooknum").val(),
 		  				vendorShophourStart:$("#vendorShophourStart").val(),
 		  				vendorShophourEnd:$("#vendorShophourEnd").val(),
 		  				vendorDetail:$("#vendorDetail").val(),
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
 		  				alert(msg);	  				
 		  			}
 		  		});
 			}
 	        });           
        }
        
        
    } );
