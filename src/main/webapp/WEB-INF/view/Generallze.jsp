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
    <title>推广链接</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/js/layui/css/layui.css">
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx }/js/paging.js"></script>
    <script type="text/javascript" src="${ctx }/js/layui/layui.js"></script>

    <style>
        /*翻页*/
        .pagenation {
            padding: 40px 30px 60px 0;
            color: #666;
            -webkit-touch-callout:none;
            -webkit-user-select:none;
            -khtml-user-select:none;
            -moz-user-select:none;
            -ms-user-select:none;
            user-select:none;}

        .pagenation .pagenum {
            float: left;
            min-width: 30px;
            padding: 3px 5px;
            text-align: center;
            margin-right: 5px;
            cursor: pointer;
            font-size: 14px;
            border-radius: 3px;
            background: #f5f5f5;
            border: 1px solid #ddd;
            box-sizing: border-box;
        }

        .pagenation .pagenum.indexpage, .pagenation .pagenum.lastpage, .pagenation .pagenum.nextpage {
            background: rgba(255,255,255,0);
            color: #d9cfce;
        }

        .pagenation .pagenum.indexpage.active, .pagenation .pagenum.lastpage.active, .pagenation .pagenum.nextpage.active {
            background-color: #f5f5f5;
            color: #999;
        }

        .pagenation .pagenum.indexpage.active a, .pagenation .pagenum.lastpage.active a, .pagenation .pagenum.nextpage.active a {
            color: #999;
        }

        .pagenation .pagenum.pagetext, .pagenation .pagenum.totalpage {
            border-radius: 0px;
            background: rgba(255,255,255,0);
            border: none;
        }

        .pagenation .pagenum a {
            color: #999;
            text-decoration: none;
            display: block;
            width: 100%;
            height: 100%;
        }

        .pagenation .pageswiperbox {
            min-width: 35px;
            max-width: 175px;
            overflow: hidden;
            word-break: keep-all;
            white-space: nowrap;
            text-overflow: ellipsis;
            float: left;
        }

        .pagenation .pageswiper {
            width: auto;
        }

        .pagenation .pageswiper .pagenum {
            display: inline-block;
            float: none;
        }

        .pagenation .pagenum.curpage {
            background: rgba(255,255,255,0);
            color: #FE7200;
            border: none;
        }

        .pagenation .pagenum.curpage a {
            color: #FE7200;
            display: block;
            width: 100%;
        }

        .pagenation .pageinput {
            text-align: center;
            border: 1px solid #e5e5e5;
            width: 40px;
            margin: 0 3px;
            line-height: 17px;
            box-sizing: border-box;
            vertical-align: top;
        }

        .pagenation .pagesubbtn {
            background: rgba(255,255,255,0);
        }

        .pagenation .pagesubbtn a {
            color: #d9cfce;
        }

        .pagenation .pagesubbtn.active {
            background: #f5f5f5;
        }

        .pagenation .pagesubbtn a {
            color: #999;
        }
    </style>
</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
<!--推广链接右边-->
            <div class="indexcontent-right7" style="display: block;">
                <div class="indexcontent-right-main">
                    <%@ include file="top.jsp" %>
                    </div>
                    <div class="indexcontent-right-bottom" style="height: 884px;">
                        <div class="indexcontent-right-bottom-main">
                            <div class="indexcontent-right-bottom-main-header">
                                <div class="indexcontent-header-title">推广链接列表</div>
                                <div class="indexcontent-header-search">
                                    <input class="sousuo" name="placeholder2" placeholder="请输入搜索关键词">
                                    <div class="search-img">
                                        <img id="button" src="${ctx }/images/SEARCH.svg">
                                    </div>
                                </div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <div class="refresh">
                                    <div style="border:1px solid  rgb(239,242,250);" class="label-editor" onclick="window.location.reload();">刷新</div>
                                    <div class="promote-add" onclick="friendinset()" style="margin-left:-30px;background: rgb(255,141,47);color:#fff;">新增</div>
                                    <div class="labelSelet" style="width:80%;height:90px;margin-left:20px;margin-top:10px;padding:0px;">
                                        <div class="labelSelet-main">

                                            <div class="selectDiv">
                                                <p>排序方式</p>
                                                <select class="select" id="index">
                                                    <option value="1">推荐级别</option>
                                                    <option value="2">添加时间</option>
                                                    <option value="3">点击量</option>
                                                </select>
                                            </div>
                                            <button id="ok" class="layui-btn layui-btn-normal">确定</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="promote-tab">
                                    <div class="promote-thead">
                                        <ul>
                                            <li>产品名称</li>
                                            <li>短链接</li>
                                            <li>添加时间</li>
                                            <li>PV</li>
                                            <li>UV</li>
                                            <li>注册</li>
                                            <li>操作</li>
                                        </ul>
                                    </div>
                                    <div class="promote-tbody1">

                                    </div>
                                </div>

                        </div>
                    </div>
                </div>
            </div>
            <script>

                $('#ok').click(function(){
                    var Index = document.getElementById("index").value;
                    $(".promote-tbody1").empty();
                    $.ajax({
                        type:"post",
                        dateType:"json",
                        url:"<%=basePath %>/friend/friendList",
                        data:{Index:Index},
                        success: function(result) {
                            var jsonData = JSON.parse(result);
                            total2 = jsonData.items[0].total;
                            var I = jsonData.items[0].rows.length;
                            var o = $(".promote-tbody1");
                            if (jsonData.length !== 0) {
                                for (var G = 0; G < I; G++) {
                                    var D = '<div class="promote-tbody-item">' +
                                        ' <ul class="ul">' +
                                        '<li>' + jsonData.items[0].rows[G].title + '</li>' +
                                        '<li>' + jsonData.items[0].rows[G].url + '</li>' +
                                        '<li>' + jsonData.items[0].rows[G].addTime + '</li>' +
                                        '<li>' + jsonData.items[0].rows[G].pv + '</li>' +
                                        '<li>' + jsonData.items[0].rows[G].uv + '</li>' +
                                        '<li>' + jsonData.items[0].rows[G].enrollment + '</li>' +
                                        '<li>' +
                                        '<div class="promotesets">' +
                                        '<div onclick="friendImg(this.id)" >图形数据</div>' +
                                        '<div class="promoteEditor"  onclick="friendUpadete(this.id)" id="' + jsonData.items[0].rows[G].id + '">编辑</div>' +
                                        '<div class="promoteidelete" onclick="frienddelect(this.id)" id="' + jsonData.items[0].rows[G].id + '">删除</div>' +
                                        '</div>' +
                                        '</li>' +
                                        '</ul>' +
                                        '</div>';
                                    var K = $(D);
                                    o.append(K);
                                }
                            }
                        }
                    })

                })




                function friendUpadete(id) {
                    $(location).attr('href', '<%=basePath %>/url/GenerallzeUpdate?id='+id+'')
                }
                function friendinset() {
                    $(location).attr('href', '<%=basePath %>/url/GenerallzeInsert')
                }

                function friendImg(id) {
                    $(location).attr('href', '<%=basePath %>/url/FriendImg?id='+id+'')
                }

                //删除会员
                function frienddelect(id){
                    var userId=3100;
                    var key="3E457CECE7CD995CD2672DC76D876EC0";
                    //询问框
                    layer.confirm('是否删除', {
                        btn: ['是','否'] //按钮
                    }, function(){
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"${ctx }/friend/deleteFriend",
                            data:{id:id},
                            success:function(result){
                                var jsonData=JSON.parse(result);
                                var urlx=jsonData.items[0].url;
                                if(jsonData.code=="200"){
                                    $.getJSON('https://12i.cn/api.ashx?format=del&userId='+userId+'&key='+key+'&url='+urlx+'', function(data) {
                                        if(data.success=="ok"){
                                            layer.msg('删除成功', {icon: 1,time: 5000});
                                            window.location.reload();
                                        }
                                    });
                                }else{
                                    layer.msg("删除失败")
                                }

                            },error:function(XMLhttpServlet){
                                if (XMLhttpServlet.status==401){
                                    $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                                }else{
                                    layer.msg("错误")
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
                    //点击按钮
                    $('#button').click(function(){
                        sousuo2=$("input[name='placeholder2']").val();
                        $(".promote-tbody1").empty();
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"<%=basePath %>/friend/friendList",
                            data:{title:sousuo2},
                            success: function(result){
                                var jsonData=JSON.parse(result);
                                total2=jsonData.items[0].total;
                                var  I=jsonData.items[0].rows.length;
                                var o = $(".promote-tbody1");
                                if (jsonData.length!==0) {
                                    for(var G=0;G<I;G++){
                                        var D ='<div class="promote-tbody-item">' +
                                            ' <ul class="ul">' +
                                            '<li>'+jsonData.items[0].rows[G].title+'</li>'+
                                            '<li>'+jsonData.items[0].rows[G].url+'</li>' +
                                            '<li>'+jsonData.items[0].rows[G].addTime+'</li>'+
                                            '<li>'+jsonData.items[0].rows[G].pv+'</li>'+
                                            '<li>'+jsonData.items[0].rows[G].uv+'</li>'+
                                            '<li>'+jsonData.items[0].rows[G].enrollment+'</li>'+
                                            '<li>'+
                                            '<div class="promotesets">'+
                                            '<div onclick="friendImg(this.id)" >图形数据</div>'+
                                            '<div class="promoteEditor"  onclick="friendUpadete(this.id)" id="'+jsonData.items[0].rows[G].id+'">编辑</div>' +
                                            '<div class="promoteidelete" onclick="frienddelect(this.id)" id="'+jsonData.items[0].rows[G].id+'">删除</div>' +
                                            '</div>'+
                                            '</li>'+
                                            '</ul>' +
                                            '</div>';
                                        var K=$(D);
                                        o.append(K);

                                    }
                                }
                                $(".promote-tbody1").paging(options)
                            },
                            error:function(XMLhttpServlet){
                                if (XMLhttpServlet.status==401){
                                    $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                                }else{
                                    layer.msg("错误")
                                }
                            }
                        });
                        //ajax结束


                    })



                    //点击进入会员管理刷新页面
                    $.ajax({
                        type:"post",
                        dateType:"json",
                        url:"<%=basePath %>/friend/friendList",
                        data:{},
                        success: function(result){
                            var jsonData=JSON.parse(result);
                            total2=jsonData.items[0].total;
                            var  I=jsonData.items[0].rows.length;
                            var o = $(".promote-tbody1");
                            if (jsonData.length!==0) {
                                for(var G=0;G<I;G++){
                                    var D ='<div class="promote-tbody-item">' +
                                        ' <ul class="ul">' +
                                        '<li>'+jsonData.items[0].rows[G].title+'</li>'+
                                        '<li>'+jsonData.items[0].rows[G].url+'</li>' +
                                        '<li>'+jsonData.items[0].rows[G].addTime+'</li>'+
                                        '<li>'+jsonData.items[0].rows[G].pv+'</li>'+
                                        '<li>'+jsonData.items[0].rows[G].uv+'</li>'+
                                        '<li>'+jsonData.items[0].rows[G].enrollment+'</li>'+
                                        '<li>'+
                                        '<div class="promotesets">'+
                                        '<div onclick="friendImg(this.id)" id="'+jsonData.items[0].rows[G].id+'">图形数据</div>'+
                                        '<div class="promoteEditor"  onclick="friendUpadete(this.id)" id="'+jsonData.items[0].rows[G].id+'">编辑</div>' +
                                        '<div class="promoteidelete" onclick="frienddelect(this.id)" id="'+jsonData.items[0].rows[G].id+'">删除</div>' +
                                        '</div>'+
                                        '</li>'+
                                        '</ul>' +
                                        '</div>';
                                    var K=$(D);
                                    o.append(K);

                                }
                            }
                            $(".promote-tbody1").paging(options)
                        },
                        error:function(XMLhttpServlet){
                            if (XMLhttpServlet.status==401){
                                $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                            }else{
                                layer.msg("错误")
                            }
                        }
                    });
                    //ajax结束
                    var options = {
                        list:".ul",//列表标识
                        currentPage:1,//初始页（选传，默认1）
                        pageSize:7,//每页列表数
                        // listTotal:5,//列表总数（选传），不传为list总数
                        callback:function(currentPage){//翻页回调（可填，可做ajax请求）,不传为纯html切换
                            loadData2(ajaxDemo2(currentPage))
                        }
                    }

                    //会员得到数据
                    function ajaxDemo2(page,pageSize){
                        if(!pageSize)var pageSize = 7;
                        if(sousuo2==""||sousuo2.valueOf("")){
                            //没有搜索的时候
                            $.post('<%=basePath %>/friend/friendList',{pageNo:page,pageSize:pageSize,title:sousuo2},function(data){
                                loadData2(data);
                            })

                        }else {
                            //搜索有值的时候
                            $.post('<%=basePath %>/friend/friendList',{pageNo:page,pageSize:pageSize},function(data){
                                loadData2(data);
                            })

                        }

                    }
                    //会员拼接数据
                    function loadData2(data){
                        console.log("callback")
                        $(".promote-tbody1").empty();
                        var jsonData=JSON.parse(data);
                        var I=jsonData.items[0].rows.length;
                        var o = $(".promote-tbody1");
                        if (jsonData.length!==0) {
                            for(var G=0;G<I;G++){
                                var D ='<div class="promote-tbody-item">' +
                                    ' <ul class="ul">' +
                                    '<li>'+jsonData.items[0].rows[G].title+'</li>'+
                                    '<li>'+jsonData.items[0].rows[G].url+'</li>' +
                                    '<li>'+jsonData.items[0].rows[G].addTime+'</li>'+
                                    '<li>'+jsonData.items[0].rows[G].pv+'</li>'+
                                    '<li>'+jsonData.items[0].rows[G].uv+'</li>'+
                                    '<li>'+jsonData.items[0].rows[G].enrollment+'</li>'+
                                    '<li>'+
                                    '<div class="promotesets">'+
                                    '<div onclick="Img(this.id)" >图形数据</div>'+
                                    '<div class="promoteEditor"  onclick="friendUpadete(this.id)" id="'+jsonData.items[0].rows[G].id+'">编辑</div>' +
                                    '<div class="promoteidelete" onclick="frienddelect(this.id)" id="'+jsonData.items[0].rows[G].id+'">删除</div>' +
                                    '</div>'+
                                    '</li>'+
                                    '</ul>' +
                                    '</div>';
                                var K=$(D);
                                o.append(K);
                            }
                        }
                    }
                });
            </script>

</body>
</html>