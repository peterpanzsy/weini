 $(document).ready(function() { 
	    
      //添加
        $("#submit").click(function () {
//            //putNullValue();
//        	//判断商品名称是否为空
//        	if($('#menuName').val() == ""){
//        		alert("商品名称不能为空");
//        		return false;
//        	}
//            //判断商家是否选择
//        	var index = $('#vendorID option:selected').val();
//        	if(index == -1){
//        		alert("请选择商家");
//        		return false;
//        	}
//        	//商品图片验证
//        	if($('#img1').attr("src") == "" || $('#img2').attr("src") == ""
//        		|| $('#img3').attr("src") == "" || $('#img4').attr("src") == ""){
//        		alert("请选择商品图片");
//        		return false;
//        	}
//        	//商品详细详细验证
//        	if($('#menuDetail').val() == ""){
//        		alert("请填写商品详细");
//        		return false;
//        	}
        	//提交表单
        	 $.ajax({
                 url: 'addGood.action',
                 type: 'POST',
                 dataType: 'json',
                 data: {menuName: $('#menuName').val(),
                	 vendorId: $('#vendorID option:selected').val(),
                	 img1: $('#img1').attr("src"),
                	 img2: $('#img2').attr("src"),
                	 img3: $('#img3').attr("src"),
                	 img4: $('#img4').attr("src"),
                	 menuDetail: $('#menuDetail').val(),
                 },
        	 })
        	 .done(function(data) {
        		 if(!data.uploadSuccess){
        			 $('#menuName').val = menuName;
        			 $('#img1').attr("src")
        			 
        		 }
        		 alert(data.info);
             })
             .fail(function() {
                 alert("添加商品出错！");
             });
        });
//        //初始化默认值
//        function putNullValue(){
//        	$(":input[name='menuName']").val("");
//        	$(":input[name='menuDetail']").val("");
//        }
        
//      //添加或者修改数据的验证与提交
//        function updateAdminValidation(){
//       	 $("#addGoodForm").validate({
// 			debug:true,
// 			onsubmit:true,
// 			onfocusout:false,
// 			onkeyup:true,
// 	     	rules: {
// 	     		menuName: "required",
//// 	     	   adminPassword: {
//// 			        required: true,
//// 			        minlength: 5
//// 			       },
////		       confirmPassword: {
////		        required: true,
////		        minlength: 5,
////		        equalTo: "#adminPassword"
////		       }
// 	     	},
// 	       messages: {
// 	    	  menuName: "请输入商品名称",
//// 	    	   adminPassword: {
//// 		        required: "请输入密码",
//// 		        minlength: jQuery.format("密码不能小于{0}个字 符")
//// 		       },
//// 		       confirmPassword: {
//// 		        required: "请输入确认密码",
//// 		        minlength: "确认密码不能小于5个字符",
//// 		        equalTo: "两次输入密码不一致不一致"
//// 		       }
// 		    },
// 		  	submitHandler:function(){
// 		  		alert("submit");
// 		  		$.ajax({
// 		  			type : 'POST',
// 		  			url : 'updateAdmin.action',
// 		  			data : {			
// 		  				adminID:$("#adminID").val(),	
// 		  				role:$("#role").val(),
// 		  				adminName:$("#adminName").val(),
// 		  				adminPassword:$("#adminPassword").val(),
// 		  				confirmPassword:$("#confirmPassword").val(),
// 		  				mark:$("#mark").val()
// 		  			},
// 		  			success : function(data) {
// 		  				switch(data.mark){
// 		  				case "add":
// 		  					alert("添加成功！");
// 		  					break;
// 		  				case "edit":
// 		  					alert("修改成功！");
// 		  					break;
// 		  				}
// 		  				dialogClose();
// 		  				adminTable.ajax.reload();	
// 		  			},
// 		  			error:function(msg){
// 		  				dialogClose();
// 		  				alter(msg);	  				
// 		  			}
// 		  		});
// 			}
// 	        });           
//        }
        //页面加载后调用函数，加载省份
        window.onload = function(){
             if($('#proviceID option').length < 2){
               	 $.ajax({
                         url: 'listProvice.action',
                         type: 'POST',
                         dataType: 'json',
                     })
                     .done(function(data) {
                         	var obj = data.provices;
                         	var varItem = new Option("请选择省份",-1);
     						$('#proviceID').append(varItem);
                         	for ( var i = 0; i < obj.length; i++ ){
         						var varItem = new Option(obj[i].provinceName,obj[i].provinceId);
         						$('#proviceID').append(varItem);     					
         					}
                     })
                     .fail(function() {
                         alert("获取省份出错！");
                     });
             }  	    
       }
        
      //获取proviceID,然后加载省下面的城市
        $('#proviceID').change(function(){
     		var index = $('#proviceID option:selected').val();
     		DeleteOptions("#cityID");
     		DeleteOptions("#districtID");
     		DeleteOptions("#bussAreaID");
     		DeleteOptions("#vendorID");
     		if(index == -1){
     			alert("选择错误");
     			return false;
     		}
            $.ajax({
                      url: 'listCity.action',
                      type: 'POST',
                      dataType: 'json',
                      data: {indexID: index},
            })
            .done(function(data) {
                   var obj = data.citys;
                    for ( var i = 0; i < obj.length; i++ ){
      						var varItem = new Option(obj[i].cityName,obj[i].cityId);
      						$('#cityID').append(varItem);     					
      					}
                  })
           .fail(function() {
                      alert("获取城市出错！");
                  });
     		
        });
        
      //获取cityID,然后加载城市下面的县区
        $('#cityID').change(function(){
     		var index = $('#cityID option:selected').val();
     		DeleteOptions("#districtID");
     		DeleteOptions("#bussAreaID");
     		DeleteOptions("#vendorID");
     		if(index == -1){
     			alert("选择错误");
     			return false;
     		}
            $.ajax({
                      url: 'listDistrict.action',
                      type: 'POST',
                      dataType: 'json',
                      data: {indexID: index},
            })
            .done(function(data) {
                   var obj = data.diss;
                    for ( var i = 0; i < obj.length; i++ ){
      						var varItem = new Option(obj[i].districtName,obj[i].districtId);
      						$('#districtID').append(varItem);     					
      					}
                  })
           .fail(function() {
                      alert("获取县区出错！");
                  });
     		
        });
      //获取districtID,然后加载县城下面的商圈
        $('#districtID').change(function(){
     		var index = $('#districtID option:selected').val();
     		DeleteOptions("#bussAreaID");
     		DeleteOptions("#vendorID");
     		if(index == -1){
     			alert("选择错误");
     			return false;
     		}
            $.ajax({
                      url: 'listbussArea.action',
                      type: 'POST',
                      dataType: 'json',
                      data: {indexID: index},
            })
            .done(function(data) {
                   var obj = data.busses;
                    for ( var i = 0; i < obj.length; i++ ){
      						var varItem = new Option(obj[i].businessAreaName,obj[i].businessAreaId);
      						$('#bussAreaID').append(varItem);     					
      					}
                  })
           .fail(function() {
                      alert("获取商圈出错！");
                  });
     		
        });
        
      //获取bussAreaID,然后加载商圈下面的商家
        $('#bussAreaID').change(function(){
     		var index = $('#bussAreaID option:selected').val();
     		DeleteOptions("#vendorID");
     		if(index == -1){
     			alert("选择错误");
     			return false;
     		}
            $.ajax({
                      url: 'searchVendor.action',
                      type: 'POST',
                      dataType: 'json',
                      data: {indexID: index},
            })
            .done(function(data) {
                   var obj = data.vendors;
                    for ( var i = 0; i < obj.length; i++ ){
      						var varItem = new Option(obj[i].vendorName,obj[i].vendorID);
      						$('#vendorID').append(varItem);     					
      					}
                  })
           .fail(function() {
                      alert("获取商家出错！");
                  });
     		
        });
        function DeleteOptions(id)
        {
        	var length = $(id).find("option").length;
            for(var i=length -1; i > 0; i--)
            {
            	 $(id).find("option:last").remove();
            }
        }
        //图片1
    	$('#uploadify1').uploadify({
                'swf'      : 'uploadify/uploadify.swf',
                'uploader' : 'uploadPicture.action',
                'auto': true,
                'multi' : false,
                'folder' : 'uploads',
                'displayData' : 'speed',
                'cancelImg' : 'uploadify/uploadify-cancel.png',
                'buttonText': '选择商品图片',
                "fileSizeLimit" : 3*1024*1024,
                "fileTypeExts": '*.jpg;*.bmp;*.gif;*.png',
                fileObjName: 'uploadify',
                onUploadSuccess: function (fileObj, data,response) {
                	var jsonObject = jQuery.parseJSON(data);
                    alert(jsonObject.info);
                    if(jsonObject.uploadSuccess){
                    	$('#img1').attr("src",""+jsonObject.picNewPath);
                    }
        		}
    	});
    	//图片2
    	$('#uploadify2').uploadify({
            'swf'      : 'uploadify/uploadify.swf',
            'uploader' : 'uploadPicture.action',
            'auto': true,
            'multi' : false,
            'folder' : 'uploads',
            'displayData' : 'speed',
            'cancelImg' : 'uploadify/uploadify-cancel.png',
            'buttonText': '选择商品图片',
            "fileSizeLimit" : 3*1024*1024,
            "fileTypeExts": '*.jpg;*.bmp;*.gif;*.png',
            fileObjName: 'uploadify',
            onUploadSuccess: function (fileObj, data,response) {
            	var jsonObject = jQuery.parseJSON(data);
                alert(jsonObject.info);
                if(jsonObject.uploadSuccess){
                	$('#img2').attr("src",""+jsonObject.picNewPath);
                }
    		}
	});
    	//图片3
    	$('#uploadify3').uploadify({
            'swf'      : 'uploadify/uploadify.swf',
            'uploader' : 'uploadPicture.action',
            'auto': true,
            'multi' : false,
            'folder' : 'uploads',
            'displayData' : 'speed',
            'cancelImg' : 'uploadify/uploadify-cancel.png',
            'buttonText': '选择商品图片',
            "fileSizeLimit" : 3*1024*1024,
            "fileTypeExts": '*.jpg;*.bmp;*.gif;*.png',
            fileObjName: 'uploadify',
            onUploadSuccess: function (fileObj, data,response) {
            	var jsonObject = jQuery.parseJSON(data);
                alert(jsonObject.info);
                if(jsonObject.uploadSuccess){
                	$('#img3').attr("src",""+jsonObject.picNewPath);
                }
    		}
	});
    	//图片4
    	$('#uploadify4').uploadify({
            'swf'      : 'uploadify/uploadify.swf',
            'uploader' : 'uploadPicture.action',
            'auto': true,
            'multi' : false,
            'folder' : 'uploads',
            'displayData' : 'speed',
            'cancelImg' : 'uploadify/uploadify-cancel.png',
            'buttonText': '选择商品图片',
            "fileSizeLimit" : 3*1024*1024,
            "fileTypeExts": '*.jpg;*.bmp;*.gif;*.png',
            fileObjName: 'uploadify',
            onUploadSuccess: function (fileObj, data,response) {
            	var jsonObject = jQuery.parseJSON(data);
                alert(jsonObject.info);
                if(jsonObject.uploadSuccess){
                	$('#img4').attr("src",""+jsonObject.picNewPath);
                }
    		}
	});
 });
