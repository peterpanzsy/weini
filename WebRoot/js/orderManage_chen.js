/**
 * 订单信息
 */
$(document).ready(function() {

	//订单模式 一天、三天、五天 的订单数统计
	$('#boxOrderSta').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '盒子模式订单数统计'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        credits: {
                enabled: false
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                ['other',       28.2]
            
            ]
        }]
    });

	//订单模式 一天、三天、五天 的订单金额统计
    $('#boxMoneySta').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '盒子模式订单金额统计'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        credits: {
                enabled: false
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                {
                    name: 'Chrome',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['Safari',    8.5],
                ['Opera',     6.2],
                ['Others',   0.7]
            ]
        }]
    });

    
    //订单金额统计
    $.ajax({
         url: /*'getOrderAnalysis.action'*/'',
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
            $('#orderSumAnalysis').highcharts({
                title: {
                    text: '订单金额统计',
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
                        text: '订单金额/元'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    pointFormat: ' : {point.y}元'
                    
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
            alert("订单金额统计没有数据！");
    });      
        
    $("button.orderSum").click(function(){        
        var orderSta = eval($(this).attr('data-type'));
        
        switch (orderSta){
            case 1:             
                
                $.ajax({
                     url: /*'getOrderAnalysis.action'*/'',
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
                    var orderAnalysisChart = $('#orderSumAnalysis').highcharts();
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
                     url: /*'getOrderAnalysis.action'*/'',
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
                    var orderAnalysisChart = $('#orderSumAnalysis').highcharts();
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
                     url: /*'getOrderAnalysis.action'*/'',
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
                    var orderAnalysisChart = $('#orderSumAnalysis').highcharts();
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
                     url: /*'getOrderAnalysis.action'*/'',
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
                    var orderAnalysisChart = $('#orderSumAnalysis').highcharts();
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
                     url: /*'getOrderAnalysis.action'*/'',
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
                    var orderAnalysisChart = $('#orderSumAnalysis').highcharts();
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


    //以行政区域作为统计划分 统计订单个数
    if($('#orderNumproviceID option').length < 2){
         $.ajax({
                 url: 'listProvice.action',
                 type: 'POST',
                 dataType: 'json',
             })
             .done(function(data) {
                    var obj = data.provices;
                    var varItem = new Option("请选择省份",-1);
                    $('#orderNumproviceID').append(varItem);
                    for ( var i = 0; i < obj.length; i++ ){
                        var varItem = new Option(obj[i].provinceName,obj[i].provinceId);
                        $('#orderNumproviceID').append(varItem);                        
                    }
             })
             .fail(function() {
                 alert("获取省份出错！");
        });
    }

          //获取orderNumproviceID,然后加载省下面的城市
        $('#orderNumproviceID').change(function(){
            var index = $('#orderNumproviceID option:selected').val();
            DeleteOptions("#orderNumcityID");
            DeleteOptions("#orderNumdistrictID");
            
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
                            $('#orderNumcityID').append(varItem);                       
                        }
                  })
           .fail(function() {
                      alert("获取城市出错！");
                  });
            
        });
        
      //获取orderNumcityID,然后加载城市下面的县区
        $('#orderNumcityID').change(function(){
            var index = $('#orderNumcityID option:selected').val();
            DeleteOptions("#orderNumdistrictID");
            
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
                            $('#orderNumdistrictID').append(varItem);                       
                        }
                  })
           .fail(function() {
                      alert("获取县区出错！");
                  });
            
        });
      //获取orderNumdistrictID,然后加载县城下面的商圈
        $('#orderNumdistrictID').change(function(){
            var index = $('#orderNumdistrictID option:selected').val();
            
            if(index == -1){
                alert("选择错误");
                return false;
            }            
            
        });
        

        function DeleteOptions(id){
            var length = $(id).find("option").length;
            for(var i=length -1; i > 0; i--)
            {
                $(id).find("option:last").remove();
            }
        }

    //不同商家的销量 各个写字楼的覆盖
    $('#busAreaModel1').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '盒子模式1订单数统计'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        credits: {
                enabled: false
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                ['other',       28.2]
            
            ]
        }]
    });   

    $('#busAreaModel2').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '盒子模式3订单数统计'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        credits: {
                enabled: false
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                ['other',       28.2]
            
            ]
        }]
    });  

    $('#busAreaModel3').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '盒子模式7订单数统计'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        credits: {
                enabled: false
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                ['other',       28.2]
            
            ]
        }]
    });  
})