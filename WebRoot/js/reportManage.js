$(document).ready(function() {
 
	//渠道分析
	$.getJSON("getUserType.action", function(json){
		if(json = null){
			json="";
		}
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
        	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
                data: json
            }]
        });
	});
	//时间点分析
	$.getJSON("getUserType.action", function(json){
		$('#timeAnalysis').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '时间点分析'
            },
            tooltip: {
              pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
                data: json           
            }]
        });
	});   
    
	//订单统计
	$.getJSON("getUserType.action", function(json){
		
        $('#orderAnalysis').highcharts({
            title: {
                text: '订单统计',
                x: -20 //center
            },

            xAxis: {
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
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
                /*layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0*/
            	enabled:false
            },
            credits: {
                enabled: false
            },
            series: [{
                name: '',
                data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            }]
        });		
	});
        
        

        
        $('#buyAnalysis').highcharts({
            title: {
                text: '平均购买力统计',
                x: -20 //center
            },

            xAxis: {
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
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
                /*layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0*/
            	enabled:false
            },
            credits: {
                enabled: false
            },
            series: [{
                name: 'Tokyo',
                data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            }]
        });
        
        var orderAnalysisChart = $('#orderAnalysis').highcharts();
        //var series = orderAnalysisChart.series[0];
        
    $("button.order").click(function(){        
        var orderSta = eval($(this).attr('data-type'));
        
        switch (orderSta){
            case 1:
            	orderAnalysisChart.series[0].remove();
            	orderAnalysisChart.addSeries({data:[7]});
            	//orderAnalysisChart.series[0].setData([7]);
                
                //orderAnalysisChart.series.data = [7];
                break;
            case 2:
            	orderAnalysisChart.series[0].remove();
            	orderAnalysisChart.addSeries({data:[7,8]});
            	
                break;
            case 3:
            	orderAnalysisChart.series[0].remove();
            	orderAnalysisChart.addSeries({data:[7,8,12]});
            	
                break;
            case 4:
            	orderAnalysisChart.series[0].remove();
            	orderAnalysisChart.addSeries({data:[7,8,12,7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,10]});
            	
                break;
            case 5:
            	
                break;
        }
    });
    
    
    
    //用户偏好分析统计信息
    var againBuyTable=$('#againBuyTable').DataTable( {
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