function orderSearch(){
/*    $.ajax({
        'url':"listOrder.action",
        'method':'POST',
        'data':{
            "dateStart":$("#dateStart").val(),
            "dateEnd":$("#dateEnd").val()
        },
        success:function(data){
            $('#orderTable').DataTable().ajax.reload();
        },
        error:function(msg){
            alert(msg);
        }
    });*/
}
function orderCount(){
    $.ajax({
        "url":"countOrder.action",
        "method":"POST",
        "data":{
            "dateStart":$("#dateStart").val(),
            "dateEnd":$("#dateEnd").val()
        },
        success:function(data){
            $("#orderTotal").val(data.orderTotal);
            $("#orderSum").val(data.orderSum);
        },
        error:function(msg){
            alert(msg);
        }
    });
}
$(document).ready(function() {

        $("#dateStart").datepicker();
        $("#dateEnd").datepicker();

	    /*
	     *  订单列表
	     */
        var orderTable=$('#orderTable').DataTable( {
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
        		"sZeroRecords": "没有检索到数据"
        		//"sProcessing": "<img src='./loading.gif' />"
        		},
        	"sPaginationType": "full_numbers",
        	"bProcessing": true,
            "ajax": {
            	"url":"listOrder.action",
            	"type": "POST",
                "data":{
                    "dateStart":$("#dateStart").val(),
                    "dateEnd":$("#dateEnd").val()
                }
            	},
 
            "sAjaxDataProp":"dataList",
            "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
        		/*if(aData.vendorIsopen==true){
        			aData.vendorIsopen="是";
        		}else{
        			aData.vendorIsopen="否";
        		}*/
    			return aData;
    		},
            	
            "columnDefs": [
	        {
	            "targets": 0,//第一列
	            "data":"orderNum",
                "visible":false
	        },
	        {
	            "targets": 1,//第二列
	            "data":"orderNum"
//	            "visible": false,
//	            "searchable": false
	        },{
	        	"targets":2,
	        	"data":"TMenuinfo.menuinfoName"//"orderMenuinfoId"
	        },
	        {
	            "targets": 3,//第一列
	            "data":"TUser.userPhoneNumber",//"userId",
	            "visible": true
	        },
	        {
	            "targets": 4,//第二列
	            "data":"boxId"
	        },{
	        	"targets":5,
	        	"data":"boxPrice"
/*	        	"createdCell": function (td, cellData, rowData, row, col) {
	        	      if ( cellData ==true ) {
	        	        $(td).html( "是");
	        	      }else{
	        	    	$(td).html("否");
	        	      }
	        	    }*/
	        },{
	        	"targets":6,
	        	"data":"orderNotice"
	        },
	        {
	            "targets": 7,//第一列
	            "data":"orderIsFirst",
	            "visible": false
	        },{
	        	"targets":8,
	        	"data":"TDispatching.dispatchingAddressDetail"//"orderDispatchingId"
	        },
	        {
	            "targets":9,//第一列
	            "data":"orderPayStatus"
	        },
	        {
	            "targets": 10,//第二列
	            "data":"SOrderConsumeStatus"
	        },{
	        	"targets":11,
	        	"data":"orderStatus"
	        },{
                "targets":12,
                "data":"orderSettleStatus"
            },{
	        	"targets":13,
	        	"data":"orderStartTime",
                "createdCell": function (td, cellData, rowData, row, col) {
                        if(cellData!=null){
                        $(td).html(cellData.replace("T"," "));
                        }
                }
	        },{
	        	"targets":14,
	        	"data":"orderOrderTime",
                "createdCell": function (td, cellData, rowData, row, col) {
                    if(cellData!=null){
                    $(td).html(cellData.replace("T"," "));
                    }
                }
	        },{
	        	"targets":15,
	        	"data":"orderPayTime",
                "createdCell": function (td, cellData, rowData, row, col) {
                    if(cellData!=null){
                        $(td).html(cellData.replace("T"," "));
                    }
                }
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
        
    } );
