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
    <title>首页</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/zxf_page.css"/>
    <script type="text/javascript" src="${ctx }/js/zxf_page.js"></script>
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
    <div id="indexBox">
        <div class="indexcontent">
            <%@ include file="left.jsp" %>
                <%--<jsp:include page="${ctx }/left.jsp" flush="true"/><!--动态包含-->--%>
            <div class="right-collection">
                <!--首页右边-->
                <div class="indexcontent-right" style="display: block;">
                    <div class="indexcontent-right-main">
                        <%@ include file="top.jsp" %>
                        <div class="indexcontent-right-bottom" style="height: 884px;">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header" style="border:none;">

                                </div>
                                <button  id="liu">留存</button>
                                <button id="yonhu">新增用户</button>
                                <button id="huoyue">用户活跃数</button>
                                    <div id="container" style="min-width:400px;height:500px"></div>
                                    <div class="message"></div>



                            </div>
                        </div>
                    </div>
                </div>
            </div>
                <script>

                    function index() {
                        $(location).attr('href', '${ctx }/admin12/TagEditor?id='+id+'')
                    }
                    //标签删除
                    function Tagdelect(id){
                        //询问框
                        layer.confirm('是否删除', {
                            btn: ['是','否'] //按钮
                        }, function(){
                            $.ajax({
                                type:"post",
                                dateType:"json",
                                url:"${ctx }/Tag/TagDelete",
                                data:{id:id},
                                success:function(result){
                                    var jsonData=JSON.parse(result);
                                    if(jsonData.code==200){
                                        layer.msg('删除成功', {icon: 1,time: 5000});
                                        window.location.reload();
                                    }
                                    if(jsonDate.code==404){
                                        layer.msg('删除失败')
                                    }
                                },error:function(result){
                                    layer.msg(result.code);
                                }
                            })
                        }, function(){

                        });
                    }
                    $(document).ready(function(){
//dedao
                        var chart = Highcharts.chart('container', {
                            chart: {
                                type: 'line'
                            },
                            title: {
                                text: '超市产品的数据'
                            },
                            subtitle: {
                                text: '数据来源: WorldClimate.com'
                            },
                            xAxis: {
                                categories: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
                            },
                            yAxis: {
                                title: {
                                    text: '数量'
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
                                name: 'pv',
                                data: [1, 0, 5, 8,8,9,8]
                            }, {
                                name: 'uv',
                                data: [5, 6, 9,9,8,7,5 ]
                            }]
                        });

                    });


                    //留存点击事件

                    $('#liu').on('click',function(){
                        $("#container").hide();
                    })




                </script>
</body>
</html>
