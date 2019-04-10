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
    <title>产品属性表</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/zxf_page.css"/>
    <script type="text/javascript" src="${ctx }/js/zxf_page.js"></script>
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script src="${ctx }/js/paging.js" type="text/javascript" charset="utf-8"></script>
    <style>

    </style>
</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
<!--产品属性右边-->
        <div class="indexcontent-right3">
            <div class="indexcontent-right-main">
                <%@ include file="top.jsp" %>
                <div class="indexcontent-right-bottom" style="height: 837px;">
                    <div class="indexcontent-right-bottom-main">
                        <div class="indexcontent-right-bottom-main-header">
                            <div class="indexcontent-header-title">产品属性列表</div>
                            <%--<div class="indexcontent-header-search">--%>
                                <%--<input placeholder="请输入搜索关键词">--%>
                                <%--<div class="search-img">--%>
                                    <%--<img src="./images/SEARCH.svg">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        </div>
                        <div class="indexcontent-right-bottom-main-content">
                            <div class="refresh" style="display: flex;color:#fff;">
                                <div style="border:1px solid  rgb(239,242,250);color:#fff;background:#2290FF;" onclick="location.reload()" >刷新</div>
                                <div class="add" style="margin-left:-30px;background:#FF8D2F;color:#fff;" id="add">新增</div>
                            </div>
                            <div class="product-tab">
                                <div class="product-thead">
                                    <ul>
                                        <li>属性图片</li>
                                        <li>属性名称</li>
                                        <li>添加时间</li>
                                        <li>操作</li>
                                    </ul>
                                </div>
                                <div class="product-tbody">
                                    <%--<div class="product-tbody-item">--%>
                                        <%--<ul>--%>
                                            <%--<li><img src="./images/Group 17@3x.svg"></li>--%>
                                            <%--<li>新户专享</li>--%>
                                            <%--<li>2019-02-23 15:29:50</li>--%>
                                            <%--<li>--%>
                                                <%--<div class="set">--%>
                                                    <%--<div class="clickEditor">编辑</div>--%>
                                                    <%--<div>删除</div>--%>
                                                <%--</div>--%>
                                            <%--</li>--%>
                                        <%--</ul>--%>
                                    <%--</div>--%>
                                    <%--<div class="product-tbody-items">--%>
                                        <%--<ul>--%>
                                            <%--<li><img src="./images/Group 16@3x.svg"></li>--%>
                                            <%--<li>新户专享</li>--%>
                                            <%--<li>2019-02-23 15:29:50</li>--%>
                                            <%--<li>--%>
                                                <%--<div class="set">--%>
                                                    <%--<div class="clickEditor">编辑</div>--%>
                                                    <%--<div>删除</div>--%>
                                                <%--</div>--%>
                                            <%--</li>--%>
                                        <%--</ul>--%>
                                    <%--</div>--%>
                                    <%--<div class="product-tbody-item">--%>
                                        <%--<ul>--%>
                                            <%--<li><img src="./images/Group 15@3x.svg"></li>--%>
                                            <%--<li>新户专享</li>--%>
                                            <%--<li>2019-02-23 15:29:50</li>--%>
                                            <%--<li>--%>
                                                <%--<div class="set">--%>
                                                    <%--<div class="clickEditor">编辑</div>--%>
                                                    <%--<div>删除</div>--%>
                                                <%--</div>--%>
                                            <%--</li>--%>
                                        <%--</ul>--%>
                                    <%--</div>--%>
                                    <%--<div class="product-tbody-items">--%>
                                        <%--<ul>--%>
                                            <%--<li><img src="./images/Group 14@3x.svg"></li>--%>
                                            <%--<li>新户专享</li>--%>
                                            <%--<li>2019-02-23 15:29:50</li>--%>
                                            <%--<li>--%>
                                                <%--<div class="set">--%>
                                                    <%--<div class="clickEditor">编辑</div>--%>
                                                    <%--<div>删除</div>--%>
                                                <%--</div>--%>
                                            <%--</li>--%>
                                        <%--</ul>--%>
                                    <%--</div>--%>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
            <script>
                //调到新增
                $("#add").click(function () {
                    $(location).attr('href', '<%=basePath %>/GoodsAttribute/toAdd')
                });

                function TagUpadete(id) {
                    $(location).attr('href', '<%=basePath %>/GoodsAttribute/toEdit?id='+id+'')
                }
                // function Up() {
                //     windows.location.person.reload();
                // }
                //
                //删除会员
                function Tagdelect(id){
                    //询问框
                    layer.confirm('是否删除', {
                        btn: ['是','否'] //按钮
                    }, function(){
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"${ctx }/GoodsAttribute/delete",
                            data:{id:id},
                            success:function(result){
                                if(result==1){
                                    layer.msg('删除成功', {icon: 1,time: 5000});
                                    window.location.reload();
                                }
                                if(resul==0){
                                    layer.msg('删除失败')
                                }
                            },error:function(XMLhttpServlet){
                                if (XMLhttpServlet.status==401){
                                    $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                                }
                            }
                        })
                    }, function(){

                    });
                }
                $(document).ready(function(){

                    var total2=0;
                    //数据框的值
                    var sousuo2="";
                    //
                    var imgd='<%=basePath %>';
                    //点击按钮
                    $('#button').click(function(){
                        sousuo2=$("input[name='placeholder2']").val();
                        alert("获取搜索的值"+sousuo2)
                        $(".product-tbody-item").empty();
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"<%=basePath %>/GoodsAttribute/getGoodsList",
                            data:{pageNo:1,pageSize:7,phone:sousuo2},
                            success: function(result){

                                total2=result.total;
                                var  I=result.rows.length;
                                var o = $(".product-tbody-item");
                                if (result.length!==0) {
                                    for(var G=0;G<I;G++){
                                        var D ='<div class="product-tbody-item">'+
                                            '<ul class="ul">' +
                                            '<li><img src="'+imgd+result.rows[G].img+'"/></li>'+
                                            '<li>'+result.rows[G].title+'</li>' +
                                            '<li>'+result.rows[G].addTime+'</li>'+
                                            '<li>'+
                                            '<div class="set">'
                                            +'<div class="clickEditor"  onclick="TagUpadete(this.id,this.name)" name="'+result.rows[G].img+'"  id="'+result.rows[G].id+'">编辑</div>' +
                                            '<div onclick="Tagdelect(this.id)" id="'+result.rows[G].id+'">删除</div>' +
                                            '</div>'+
                                            '</li>'+
                                            '</ul>'+
                                            '</div>';
                                        var K=$(D);
                                        biaoshi=false;
                                        o.append(K);

                                    }
                                }
                                $(".product-tbody-item").paging(options)
                            },
                            error:function(XMLhttpServlet){
                                if (XMLhttpServlet.status==401){
                                    $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                                }
                            }
                        });
                        //ajax结束


                    })

                    var options = {
                        list:".ul",//列表标识
                        currentPage:1,//初始页（选传，默认1）
                        pageSize:5,//每页列表数
                        //listTotal:5,//列表总数（选传），不传为list总数
                        callback:function(currentPage){//翻页回调（可填，可做ajax请求）,不传为纯html切换
                            loadData2(ajaxDemo2(currentPage))
                        }
                    }

                    //点击进入会员管理刷新页面
                    $.ajax({
                        type:"post",
                        dateType:"json",
                        url:"<%=basePath %>/GoodsAttribute/getGoodsList",
                        data:{pageNo:1,pageSize:7},
                        success: function(result){
                            total2=result.total;
                            var  I=result.rows.length;
                            var o = $(".product-tbody");
                            if (result.length!==0) {
                                for(var G=0;G<I;G++){
                                    var D ='<div class="product-tbody-item">'+
                                        '<ul class="ul">' +
                                        '<li><img src="'+imgd+result.rows[G].img+'"/></li>'+
                                        '<li>'+result.rows[G].title+'</li>' +
                                        '<li>'+result.rows[G].addTime+'</li>'+
                                        '<li>'+
                                        '<div class="set">'
                                        +'<div class="clickEditor"  onclick="TagUpadete(this.id,this.name)"  name="'+result.rows[G].img+'" id="'+result.rows[G].id+'">编辑</div>' +
                                        '<div onclick="Tagdelect(this.id)" id="'+result.rows[G].id+'">删除</div>' +
                                        '</div>'+
                                        '</li>'+
                                        '</ul>'+
                                        '</div>';
                                    var K=$(D);
                                    biaoshi=false;
                                    o.append(K);

                                }
                            }
                            $(".product-tbody").paging(options)
                        },
                        error:function(XMLhttpServlet){
                            if (XMLhttpServlet.status==401){
                                $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                            }
                        }
                    });
                    //ajax结束


                    //会员得到数据
                    function ajaxDemo2(page,pageSize){
                        if(!pageSize)var pageSize = 7;
                        if(sousuo2==""||sousuo2.valueOf("")){
                            //没有搜索的时候
                            $.post('<%=basePath %>/GoodsAttribute/getGoodsList',{pageNo:page,pageSize:pageSize,phone:sousuo2},function(data){
                                loadData2(data);
                            })

                        }else {
                            //搜索有值的时候
                            $.post('<%=basePath %>/GoodsAttribute/getGoodsList',{pageNo:page,pageSize:pageSize},function(data){
                                loadData2(data);
                            })

                        }

                    }
                    //会员拼接数据
                    function loadData2(data){
                        console.log("callback")
                        $(".product-tbody").empty();
                        var I=data.rows.length;
                        var o = $(".product-tbody");
                        if (data.length!==0) {
                            for(var G=0;G<I;G++){
                                var D ='<div class="product-tbody-item">'+
                                    '<ul class="ul">' +
                                    '<li><img src="'+imgd+data.rows[G].img+'"/></li>'+
                                    '<li>'+data.rows[G].title+'</li>' +
                                    '<li>'+data.rows[G].addTime+'</li>'+
                                    '<li>'+
                                    '<div class="set">'
                                    +'<div class="clickEditor"  onclick="TagUpadete(this.id,this.name)" name="'+data.rows[G].img+'" id="'+data.rows[G].id+'">编辑</div>' +
                                    '<div onclick="Tagdelect(this.id)" id="'+data.rows[G].id+'">删除</div>' +
                                    '</div>'+
                                    '</li>'+
                                    '</ul>'+
                                    '</div>';
                                var K=$(D);
                                biaoshi=false;
                                o.append(K);
                            }
                        }
                    }
                });


            </script>
</body>
</html>