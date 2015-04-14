 $(document).ready(function() {
	    /*
	     *  订单列表
	     *  当日订单，所有订单，根据参数判断
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
        		},
        	"sPaginationType": "full_numbers",
        	"bProcessing": true,
            "ajax": {
            	"url":"listOrderVendor.action",
            	"type": "POST",
            	"data":{
            		"vendorId":$("#vendorId").val(),
                    "dateFlag":$("#dateFlag").val()
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

     /**
      * websocket与server建立持久连接,用于接收新订单提醒.刷新页面后会话不会关掉，但后台调用session发送数据会报异常，从而关闭session.
      */
     var webSocket;
     var messages = $("#messages");
     openSocket();

     function openSocket(){
         // Ensures only one connection is open at a time
         if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
             //writeResponse("WebSocket is already opened.");
             return;
         }
         // Create a new instance of the websocket
         webSocket = new WebSocket("ws://localhost:8080/weini/newOrderSocket?vendorId="+$("#vendorId").val());

         /**
          * Binds functions to the listeners for the websocket.
          */
         webSocket.onopen = function(event){
             // For reasons I can't determine, onopen gets called twice
             // and the first time event.data is undefined.
             // Leave a comment if you know the answer.
             if(event.data === undefined)
                 return;

             writeResponse(event.data);
         };

         webSocket.onmessage = function(event){
             writeResponse(event.data);
         };

         webSocket.onclose = function(event){
             writeResponse("Connection closed");
         };
     }

     /**
      * Sends the value of the text input to the server
      */
     function send(){
         var text = document.getElementById("messageinput").value;
         webSocket.send(text);
     }

     function closeSocket(){
         webSocket.close();
     }

     function writeResponse(text){
         orderTable.ajax.reload();
         $('#chatAudio')[0].play();
         messages.val(text);
     }



 } );
