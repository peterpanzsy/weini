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
                     alert("！"+orderStaType);
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
                     alert("！"+orderStaType);
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
                     alert("！"+orderStaType);
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
                     alert("！"+orderStaType);
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
                     alert("！"+orderStaType);
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
            alert("！");
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
                     alert("！");
                });  
                break;
            
        }
    });
        
    
        //var series = orderAnalysisChart.series[0];
        

    
    
    
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
    
    
    
});