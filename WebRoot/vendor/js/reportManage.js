$(document).ready(function() {
 
	//渠道分析
  	 $.ajax({
         url: 'getChannelAnalysis.action',
         type: 'POST',
         async: false,
         dataType: 'json',
     })
     .done(function(json) {
    	 
    	 var dat = json.dataChannel;
    	 var result = new Array();
    	 for(var i = 0; i<dat.length;i++){
    		 var tmp = new Array(dat[i].index1,dat[i].index2);
    		 result.push(tmp);
    	 }
    	 //console.log(result);
 		$('#channelAnalysis').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '渠道分析'
            },
            tooltip: {
              pointFormat: '{}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                    }
                }
            },
            credits: {
                enabled: false
            },
            series: [{
                type: 'pie',
                name: '',
                data: result           
            }]
        });
     })
     .fail(function() {
         alert("渠道分析没有数据！");
     });
  	 
 	//用户下单耗时分析
  	 $.ajax({
         url: 'getTimeAnalysis.action',
         type: 'POST',
         async: false,
         dataType: 'json',
     })
     .done(function(json) {
    	 
    	 var dat = json.timeData;
    	 var result = new Array();
    	 for(var i = 0; i<dat.length;i++){
    		 var tmp = new Array(dat[i].index1,dat[i].index2);
    		 result.push(tmp);
    	 }
    	 
 		$('#timeAnalysis').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '用户下单耗时时间分析'
            },
            tooltip: {
              pointFormat: '{}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                    }
                }
            },
            credits: {
                enabled: false
            },
            series: [{
                type: 'pie',
                name: '',
                data: result           
            }]
        });
     })
     .fail(function() {
         alert("用户下单耗时没有数据！");
     });

    
	//订单统计
    $.ajax({
         url: 'getOrderAnalysis.action',
         type: 'POST',
         data: {orderStaType:5},
         async: false,
         dataType: 'json',
        })
        .done(function(json) {
            var categoriesX = new Array();
            var result = new Array();
            var dat = json.orderSum;
            for(var i = dat.length-1;i>=0;i--){
            	categoriesX.push(dat[i].index1);
            	result.push(dat[i].index2);
            }
            $('#orderAnalysis').highcharts({
                title: {
                    text: '订单统计',
                    x: -20 //center
                },

                xAxis: {
                    categories: categoriesX,
                    //gridLineWidth: 1, 
                    labels: {
                    	  rotation:-35,
                        step: 1,
                        staggerLines: 1,
                        align:'right'
                      } 
                },
                yAxis: {
                    title: {
                        text: '订单个数'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                	pointFormat: ' : {point.y}个'
                	
                },
                legend: {
                    enabled:false
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: '',
                    data: result
                }]
            }); 
        })
        .fail(function() {
            alert("订单统计没有数据！");
    });      
        
    $("button.order").click(function(){        
        var orderSta = eval($(this).attr('data-type'));
        
        switch (orderSta){
            case 1:             
                
                $.ajax({
                     url: 'getOrderAnalysis.action',
                     type: 'POST',
                     data: {orderStaType:1},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {
                	 var categoriesX = new Array();
                     var result = new Array();
                     var dat = json.orderSum;
                     for(var i = dat.length-1;i>=0;i--){
                     	categoriesX.push(dat[i].index1);
                     	result.push(dat[i].index2);
                     }
                    var orderAnalysisChart = $('#orderAnalysis').highcharts();
                    orderAnalysisChart.series[0].remove();
                    orderAnalysisChart.xAxis[0].setCategories(categoriesX);
                    orderAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     alert("！"+orderSta);
                });               

                break;
            case 2:
                $.ajax({
                     url: 'getOrderAnalysis.action',
                     type: 'POST',
                     data: {orderStaType:2},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {
                	 var categoriesX = new Array();
                     var result = new Array();
                     var dat = json.orderSum;
                     for(var i = dat.length-1;i>=0;i--){
                     	categoriesX.push(dat[i].index1);
                     	result.push(dat[i].index2);
                     }
                    var orderAnalysisChart = $('#orderAnalysis').highcharts();
                    orderAnalysisChart.series[0].remove();
                    orderAnalysisChart.xAxis[0].setCategories(categoriesX);
                    orderAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     alert("！"+orderSta);
                });  
                
                break;
            case 3:
                $.ajax({
                     url: 'getOrderAnalysis.action',
                     type: 'POST',
                     data: {orderStaType:3},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {
                	 var categoriesX = new Array();
                     var result = new Array();
                     var dat = json.orderSum;
                     for(var i = dat.length-1;i>=0;i--){
                     	categoriesX.push(dat[i].index1);
                     	result.push(dat[i].index2);
                     }
                    var orderAnalysisChart = $('#orderAnalysis').highcharts();
                    orderAnalysisChart.series[0].remove();
                    orderAnalysisChart.xAxis[0].setCategories(categoriesX);
                    orderAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     alert("！"+orderSta);
                });                  
                break;
            case 4:
                $.ajax({
                     url: 'getOrderAnalysis.action',
                     type: 'POST',
                     data: {orderStaType:4},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {
                	 var categoriesX = new Array();
                     var result = new Array();
                     var dat = json.orderSum;
                     for(var i = dat.length-1;i>=0;i--){
                     	categoriesX.push(dat[i].index1);
                     	result.push(dat[i].index2);
                     }
                    var orderAnalysisChart = $('#orderAnalysis').highcharts();
                    orderAnalysisChart.series[0].remove();
                    orderAnalysisChart.xAxis[0].setCategories(categoriesX);
                    orderAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     alert("！"+orderSta);
                });  
                break;
            case 5:
                $.ajax({
                     url: 'getOrderAnalysis.action',
                     type: 'POST',
                     data: {orderStaType:5},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {
                	 var categoriesX = new Array();
                     var result = new Array();
                     var dat = json.orderSum;
                     for(var i = dat.length-1;i>=0;i--){
                     	categoriesX.push(dat[i].index1);
                     	result.push(dat[i].index2);
                     }
                    var orderAnalysisChart = $('#orderAnalysis').highcharts();
                    orderAnalysisChart.series[0].remove();
                    orderAnalysisChart.xAxis[0].setCategories(categoriesX);
                    orderAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     alert("！"+orderSta);
                });  
                break;
        }
    });



    
    //购买力分析
    $.ajax({
         url: '',
         type: 'POST',
         data: {buyStaType:1},
         async: false,
         dataType: 'json',
        })
        .done(function(json) {
            var categoriesX ;
            var result; 
            $('#buyAnalysis').highcharts({
                title: {
                    text: '平均购买力统计',
                    x: -20 //center
                },

                xAxis: {
                    categories: categoriesX
                },
                yAxis: {
                    title: {
                        text: 'Temperature (°C)'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    valueSuffix: '°C'
                },
                legend: {
                    enabled:false
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: '',
                    data: result
                }]
            }); 
        })
        .fail(function() {
            //alert("！");
    });    
    var buyAnalysisChart = $('#buyAnalysis').highcharts();    
    $("button.buy").click(function(){        
        var buySta = eval($(this).attr('data-type'));
        
        switch (buySta){
            case 1:             
                
                $.ajax({
                     url: '',
                     type: 'POST',
                     data: {buyStaType:1},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {

                    buyAnalysisChart.series[0].remove();
                    buyAnalysisChart.xAxis[0].setCategories();
                    buyAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     alert("！");
                });               

                break;
            case 2:
                $.ajax({
                     url: '',
                     type: 'POST',
                     data: {buyStaType:2},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {
                    
                    buyAnalysisChart.series[0].remove();
                    buyAnalysisChart.xAxis[0].setCategories();
                    buyAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     alert("！");
                });  
                
                break;
            case 3:
                $.ajax({
                     url: '',
                     type: 'POST',
                     data: {buyStaType:3},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {
                    
                    buyAnalysisChart.series[0].remove();
                    buyAnalysisChart.xAxis[0].setCategories();
                    buyAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     alert("！");
                });                  
                break;
            case 4:
                $.ajax({
                     url: '',
                     type: 'POST',
                     data: {buyStaType:4},
                     async: false,
                     dataType: 'json',
                 })
                 .done(function(json) {
                    
                    buyAnalysisChart.series[0].remove();
                    buyAnalysisChart.xAxis[0].setCategories();
                    buyAnalysisChart.addSeries({data:result}); 
                })
                 .fail(function() {
                     //alert("！");
                });  
                break;
            
        }
    });
        
    
        //var series = orderAnalysisChart.series[0];
        

        //用户偏好分析页面
        if($('#buyproviceID option').length < 2){
             $.ajax({
                     url: 'listProvice.action',
                     type: 'POST',
                     dataType: 'json',
                 })
                 .done(function(data) {
                        var obj = data.provices;
                        var varItem = new Option("请选择省份",-1);
                        $('#buyproviceID').append(varItem);
                        for ( var i = 0; i < obj.length; i++ ){
                            var varItem = new Option(obj[i].provinceName,obj[i].provinceId);
                            $('#buyproviceID').append(varItem);                        
                        }
                 })
                 .fail(function() {
                     alert("获取省份出错！");
            });
        }
    
          //获取buyproviceID,然后加载省下面的城市
        $('#buyproviceID').change(function(){
            var index = $('#buyproviceID option:selected').val();
            DeleteOptions("#buycityID");
            DeleteOptions("#buydistrictID");
            DeleteOptions("#buybussAreaID");
            DeleteOptions("#buyvendorID");
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
                            $('#buycityID').append(varItem);                       
                        }
                  })
           .fail(function() {
                      alert("获取城市出错！");
                  });
            
        });
        
      //获取buycityID,然后加载城市下面的县区
        $('#buycityID').change(function(){
            var index = $('#buycityID option:selected').val();
            DeleteOptions("#buydistrictID");
            DeleteOptions("#buybussAreaID");
            DeleteOptions("#buyvendorID");
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
                            $('#buydistrictID').append(varItem);                       
                        }
                  })
           .fail(function() {
                      alert("获取县区出错！");
                  });
            
        });
      //获取buydistrictID,然后加载县城下面的商圈
        $('#buydistrictID').change(function(){
            var index = $('#buydistrictID option:selected').val();
            DeleteOptions("#buybussAreaID");
            DeleteOptions("#buyvendorID");
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
                            $('#buybussAreaID').append(varItem);                       
                        }
                  })
           .fail(function() {
                      alert("获取商圈出错！");
                  });
            
        });
        
      //获取buybussAreaID,然后加载商圈下面的商家
        $('#buybussAreaID').change(function(){
            var index = $('#buybussAreaID option:selected').val();
            DeleteOptions("#buyvendorID");
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
                            $('#buyvendorID').append(varItem);                         
                        }
                  })
           .fail(function() {
                      alert("获取商家出错！");
                  });
            
        });
        function DeleteOptions(id){
            var length = $(id).find("option").length;
            for(var i=length -1; i > 0; i--)
            {
                $(id).find("option:last").remove();
            }
        }
    $("#buyStat").click(function(){
        var buss = $("#buybussAreaID option:selected").val();
        if(buss == -1 ||buss == null)
            alert("请选择商圈");
        else{
            $.ajax({
                 url: 'getAverageBuy.action',
                 type: 'POST',
                 async: false,
                 data:{bussID:buss},
                 dataType: 'json',
             })
             .done(function(json) {
                 
                 var dat = json.averageBuySum;
                 var resultBuy = new Array();
                 for(var i = 0; i<dat.length;i++){
                     var tmp = new Array(dat[i].index1,dat[i].index2);
                     resultBuy.push(tmp);
                 }
                 //console.log(resultBuy);
                $('#buyAnalysis').highcharts({
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: '购买力分析'
                    },
                    tooltip: {
                    	
                      pointFormat: '<b>盒子模式{point.x}</b>: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                color: '#000000',
                                connectorColor: '#000000',
                                format: '<b>盒子模式{point.x}</b>: {point.percentage:.1f} %'
                            }
                        }
                    },
                    credits: {
                        enabled: false
                    },
                    series: [{
                        type: 'pie',
                       
                        data: resultBuy           
                    }]
                });
             })
             .fail(function() {
                 alert("购买力分析没有数据！");
             });
        }
    });
    //用户偏好分析统计信息
    var againBuyTable=$('#againBuyTable').DataTable({
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
            /*        "ajax": {
        	"url":"",
        	"type": "POST",
        	"data":{
        		"role":role
        	}
        	},*/

        "sAjaxDataProp":"dataList",
      
        "columnDefs": [
        {
            "targets": 0,//第一列
            "data":1,
            
        },
        {
            "targets": 1,//第二列
            "data":2

        },{
        	"targets":2,
        	"data":3
        },{
        	"targets":2,
        	"data":4
        }]
    } );
    
    
    //用户第一次购买盒子模式
     $.ajax({
         url: 'getFirstBuyModelSum.action',
         type: 'POST',
         async: false,
         dataType: 'json',
     })
     .done(function(json) {
         
         var dat = json.firBuyModelSum;
         var result = new Array();
         
         for(var i = 0; i<dat.length;i++){
             var tmp = new Array(dat[i].index1,dat[i].index2);
             result.push(tmp);
         }
         
        $('#firstBuyAnalysis').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '第一次购买盒子模式'
            },
            tooltip: {
              pointFormat: '{}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                    }
                }
            },
            credits: {
                enabled: false
            },
            series: [{
                type: 'pie',
                name: '',
                data: result           
            }]
        });
     })
     .fail(function() {
         alert("第一次购买盒子模式没有数据！");
     });

    //统计信息
    $.ajax({
        url: 'getContinueBuyUserSum.action',
        type: 'POST',
        async: false,
        dataType: 'json',
        success: function (json) { 
            var realUser = json.realBuyUserSum;
            var realMoney = json.realTotalMoney;
            var modelNum = json.conBuyUseSum;
            for(var i = 0; i < modelNum.length; i++){
                if(modelNum[i].index1 == 1){
                    $("#oneModelNum").text(modelNum[i].index2+"人");  
                }
                if(modelNum[i].index1 == 3){
                    $("#threeModelNum").text(modelNum[i].index2+"人");  
                }
                if(modelNum[i].index1 == 5){
                    $("#fiveModelNum").text(modelNum[i].index2+"人");  
                }
            }
            $("#realBuyUser").text(realUser+"人");
            $("#realBuyMoney").text(realMoney+"元");

        },
　　　　　　//请求失败遇到异常触发
　　　　error: function () { 
            
        },
     })
});