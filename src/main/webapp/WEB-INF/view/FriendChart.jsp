<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<%--<% String path = request.getContextPath(); %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新增推广链接产品</title>
    <script src='https://libs.baidu.com/jquery/1.10.2/jquery.min.js'></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script type="text/javascript" src="https://img.highcharts.com.cn/highcharts/highcharts.js"></script>
    <script type="text/javascript" src="https://img.highcharts.com.cn/highcharts/modules/exporting.js"></script>
    <script type="text/javascript" src="https://img.highcharts.com.cn/highcharts/modules/data.js"></script>
    <script type="text/javascript" src="https://img.highcharts.com.cn/highcharts/modules/series-label.js"></script>
    <script type="text/javascript" src="https://img.highcharts.com.cn/highcharts/modules/oldie.js"></script>
    <script type="text/javascript" src="https://img.highcharts.com.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
    <style>

    </style>
</head>
<body>

        <div id="container" style="min-width:400px;height:400px"></div>



<script>
    var chart = Highcharts.chart('container', {
        chart: {
            type: 'line'
        },
        title: {
            text: 'PvUv'
        },
        subtitle: {
            text: '数据来源: WorldClimate.com'
        },
        xAxis: {
            categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
        },
        yAxis: {
            title: {
                text: '气温 (°C)'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    // 开启数据标签
                    enabled: true
                },
                // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                enableMouseTracking: false
            }
        },
        series: [{
            name: '东京',
            data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }, {
            name: '伦敦',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }]
    });

</script>
</body>
</html>
