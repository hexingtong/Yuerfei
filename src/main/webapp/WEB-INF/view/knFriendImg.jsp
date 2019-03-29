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
    <title>标签展示</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx }/js/paging.js"></script>
    <script type="text/javascript" src="${ctx }/js/highcharts.js"></script>
</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
<!--标签展示右边-->
            <div class="indexcontent-right4" style="display: block;">
                <div class="indexcontent-right-main">
                    <div class="indexcontent-right-top">
                        <img src="${ctx }/images/Full screen button.svg">
                        <div class="indexcontent-right-top-right">
                            <img src="${ctx }/images/quit.svg">
                            <p>退出</p>
                        </div>
                    </div>
                    <div id="container" style="min-width:800px;height:800px"></div>
                    <div id="container2" style="min-width: 340px; height: 600px; margin: 0 auto"></div>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                <%--$(document).ready(function() {--%>
                    <%--var chart = {--%>
                        <%--type: 'column'--%>
                    <%--};--%>
                    <%--var title= {--%>
                        <%--text: '最近30天推广的pv和uv'--%>
                    <%--};--%>
                    <%--var  xAxis ={--%>
                        <%--categories: [<c:forEach items="${jsonData}" var="Person">--%>
                            <%--"${Person.day}",--%>
                            <%--</c:forEach>--%>
                        <%--],--%>

                        <%--maxZoom:30,--%>
                        <%--labels: {--%>
                            <%--x:0,//调节x偏移--%>
                            <%--rotation: 45, //旋转,效果就是影响标签的显示方向--%>
                        <%--},--%>
                        <%--opposite : false,// 天显示X轴上与下--%>
                        <%--type: 'datetime',--%>
                        <%--title : {--%>
                            <%--align : 'high',--%>
                            <%--text : '天',--%>
                            <%--style : {--%>
                                <%--color : '#000',--%>
                                <%--fontSize : '11px'--%>
                            <%--}--%>
                        <%--},--%>
                    <%--};--%>

                    <%--var  credits ={--%>
                        <%--enabled : false--%>
                    <%--};--%>
                    <%--var yAxis={--%>
                        <%--min: 0,--%>
                        <%--tickPositions: [0, 10, 20, 30,40,50] ,// 指定竖轴坐标点的值--%>
                        <%--title: {--%>
                            <%--text: 'pv uv数'--%>
                        <%--},--%>
                        <%--stackLabels: {--%>
                            <%--enabled: true,--%>
                            <%--style: {--%>
                                <%--fontWeight: 'bold',--%>
                                <%--color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'--%>
                            <%--}--%>
                        <%--}--%>
                    <%--};--%>
                    <%--var tooltip={--%>
                        <%--shared:true,--%>
                        <%--crosshairs:true,--%>
                        <%--dateTimeLabelFormats:{--%>
                            <%--day:"%Y-%m-%d",--%>
                        <%--},--%>
                    <%--};--%>
                    <%--var plotOptions = {--%>
                        <%--series: {--%>
                            <%--pointPadding:0.2--%>
                        <%--},--%>
                        <%--column: {--%>
                            <%--//percent置顶--%>
                            <%--stacking: 'normal',--%>
                            <%--pointPadding: 0.2,--%>
                            <%--pointWidth: 15 , //柱子的宽度30px--%>
                            <%--// 如果x轴一个点有两个柱，则这个属性设置的是这两个柱的间距。--%>
                            <%--groupPadding : 0.5,--%>
                        <%--}--%>
                    <%--};--%>
                    <%--var legend = {--%>
                        <%--align: 'center',--%>
                        <%--x: -30,--%>
                        <%--verticalAlign: 'bottom',--%>
                        <%--y: 25,--%>
                        <%--floating: true,--%>
                        <%--backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',--%>
                        <%--shadow: false--%>
                    <%--};--%>
                    <%--var series= [{--%>
                        <%--name: 'pv',--%>
                        <%--color:'#fe0100',--%>
                        <%--data: [--%>
                            <%--<c:forEach items="${jsonData}" var="Person">--%>
                            <%--${Person.visitCount},--%>
                            <%--</c:forEach>--%>
                        <%--]--%>

                    <%--}, {--%>
                        <%--name: 'uv',--%>
                        <%--color:'#ff9803',--%>
                        <%--data: [ <c:forEach items="${jsonData}" var="Person">--%>
                            <%--${Person.uv},--%>
                            <%--</c:forEach>]--%>
                    <%--}--%>
                    <%--]--%>
<%--//    });--%>
                    <%--var json = {};--%>
                    <%--json.chart = chart;--%>
                    <%--json.title = title;--%>
                    <%--json.xAxis = xAxis;--%>
                    <%--json.yAxis = yAxis;--%>
                    <%--json.legend = legend;--%>
                    <%--json.tooltip = tooltip;--%>
                    <%--json.plotOptions = plotOptions;--%>
                    <%--json.credits = credits;--%>
                    <%--json.series = series;--%>
                    <%--$('#container2').highcharts(json);--%>
                <%--});--%>

                var chart = Highcharts.chart('container',{
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: '最近一个月的pv和uv'
                    },
                    subtitle: {
                        text: '数据来源:https://12i.cn/interfaceApi.aspx'
                    },
                    xAxis: {
                        categories: [
                            <c:forEach items="${jsonData}" var="Person">
                           '${Person.day}',
                            </c:forEach>
                        ],
                        crosshair: true
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'pv和uv'
                        }
                    },
                    tooltip: {
                        // head + 每个 point + footer 拼接成完整的 table
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions: {
                        column: {
                            borderWidth: 0
                        }
                    },
                    series: [{
                        name: 'pv',
                        data: [
                            <c:forEach items="${jsonData}" var="Person">
                            ${Person.visitCount},
                            </c:forEach>

                        ]
                    }, {
                        name: 'uv',
                        data: [  <c:forEach items="${jsonData}" var="Person">
                            ${Person.uv},
                            </c:forEach>]
                    }
                    ]
                });






            </script>


</body>
</html>