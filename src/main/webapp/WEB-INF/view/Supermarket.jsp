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
    <title>产品展示</title>
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
<!--超市展示右边-->
            <div class="indexcontent-right6" style="display: block;">
                <div class="indexcontent-right-main">

                    <%@ include file="top.jsp" %>

                    <div class="indexcontent-right-bottom" style="height: 884px;">
                        <div class="indexcontent-right-bottom-main">
                            <div class="indexcontent-right-bottom-main-header">
                                <div class="indexcontent-header-title">超市展示列表</div>
                                <div class="indexcontent-header-search">
                                    <input placeholder="请输入搜索关键词">
                                    <div class="search-img">
                                        <img id="buttont" src="${ctx }/images/SEARCH.svg">
                                    </div>
                                </div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <div class="refresh">
                                    <div  onclick="window.location.reload();" style="background: rgb(36,143,255);color:#fff;">刷新</div>
                                    <div id="add" class="super-add" style="margin-left:-30px;background:#FF8D2F;color:#fff;">新增</div>
                                    <div class="labelSelet" style="width:80%;height:90px;margin-left:20px;margin-top:10px;padding:0px;">
                                        <div class="labelSelet-main">
                                            <div class="selectDiv">
                                                <p>排序方式</p>
                                                <select id="Index1" class="select">
                                                    <option value="1">添加时间</option>
                                                    <option value="2">推荐级别</option>
                                                    <option value="3">点击量</option>
                                                </select>
                                            </div>

                                            <div class="selectDiv">
                                                <p>产品属性</p>
                                                <select  id="propertyId" class="select">
                                                    <option value="1">新户专享</option>
                                                    <option value="2">贷款超市</option>
                                                    <option value="3">大额快贷</option>
                                                    <option value="4">小额快贷</option>
                                                </select>
                                            </div>
                                            <button id="ok" class="layui-btn layui-btn-normal">确定</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="shopping-tab">
                                    <div class="shopping-thead">
                                        <ul>
                                            <li>产品图片</li>
                                            <li>产品名称</li>
                                            <li>所属属性</li>
                                            <%--<li>上架状态</li>--%>
                                            <li>添加时间</li>
                                            <li>PV</li>
                                            <li>UV</li>
                                            <li>操作</li>
                                        </ul>
                                    </div>
                                    <div class="shopping-tbody1">


                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>


                //获取选框对象


                $('#add').click(function(){
                    $(location).attr('href', '<%=basePath %>/url/SupermarketAdd')
                })

                function supermarUpadete(id) {

                    $(location).attr('href', '<%=basePath %>/url/SupermarketUpdate?id='+id+'')
                }

                //到数据招
                function supermarkshowData(id) {

                    $(location).attr('href', '<%=basePath %>/data/pvuv?goodsid='+id+'')
                }
                //删除会员
                function supermardelect(id){
                    //询问框
                    layer.confirm('是否删除', {
                        btn: ['是','否'] //按钮
                    }, function(){
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"${ctx }/Supermarke/getSupermarket",
                            data:{id:id},
                            success:function(result){
                                var imgs='${ctx }';
                                if(result.code=="200"){
                                    layer.msg('删除成功', {icon: 1,time: 5000});
                                    window.location.reload();
                                }else{
                                    layer.msg("删除失败")
                                }

                            },error:function(result){
                                layer.msg('错误');
                            }
                        })
                    }, function(){
                    });
                }

                var total2=0;
                //数据框的值
                var sousuo2="";
                var propertyIds="";
                var Index="";
                //
                //点击按钮
                $('#buttont').click(function(){
                    sousuo2=$("input[name='placeholder2']").val();
                    $(".shopping-tbody1").empty();
                    $.ajax({
                        type:"post",
                        dateType:"json",
                        url:"<%=basePath %>/Supermarke/getSupermarket",
                        data:{title:sousuo2},
                        success: function(result){
                            total2=result.total;
                            var  I=result.rows.length;
                            var o = $(".shopping-tbody1");
                            var imgs='<%=basePath %>';
                            if (result.length!==0) {
                                for(var G=0;G<I;G++){
                                    var D ='<div class="shopping-tbody-item">' +
                                        '<ul class="ul">' +
                                        '<li>'+
                                        '<img src="'+imgs+''+result.rows[G].img+'">' +
                                        '</li>' +
                                        '<li>'+result.rows[G].title+'</li>' +
                                        '<li>'+result.rows[G].ptitle+'</li>' +
                                        // '<li>'+result.rows[G].pstatus+'</li>' +
                                        '<li>'+result.rows[G].addTime+'</li>' +
                                        '<li>'+result.rows[G].pv+'</li>' +
                                        '<li>'+result.rows[G].uv+'</li>' +
                                        '<li>'+
                                        '<div class="sets">'+
                                        '<div onclick="supermarkshowData(this.id)" id="' + result.rows[G].id + '"  class="supermarketgraphics">图形数据</div>' +
                                        '<div class="promoteEditor"  onclick="supermarUpadete(this.id)" id="' + result.rows[G].id + '">编辑</div>' +
                                        '<div class="promoteidelete" onclick="supermardelect(this.id)" id="' + result.rows[G].id  + '">删除</div>' +
                                        ' </div>' +
                                        '</li>' +
                                        '</ul>' +
                                        '</div>'
                                    var K=$(D);
                                    o.append(K);

                                }
                            }
                            $(".shopping-tbody1").paging(options)
                        },
                        error:function(){
                            alert("错误")
                        }
                    });
                    //ajax结束


                })

                //点击确定
                $('#ok').click(function(){
                    Index = document.getElementById("Index1").value;
                    propertyIds = document.getElementById("propertyId").value;
                    // var status = document.getElementById("status").value;
                    $(".shopping-tbody1").empty();
                    $.ajax({
                        type:"post",
                        dateType:"json",
                        url:"<%=basePath %>/Supermarke/getSupermarket",
                        data:{Index1:Index,propertyId:propertyIds},
                        success: function(result) {
                            total2=result.total;
                            var  I=result.rows.length;
                            var o = $(".shopping-tbody1");
                            var imgs='<%=basePath %>';
                            if (result.length!==0) {
                                for(var G=0;G<I;G++){
                                    var D ='<div class="shopping-tbody-item">' +
                                        '<ul class="ul">' +
                                        '<li>'+
                                        '<img src="'+imgs+''+result.rows[G].img+'">' +
                                        '</li>' +
                                        '<li>'+result.rows[G].title+'</li>' +
                                        '<li>'+result.rows[G].ptitle+'</li>' +
                                        // '<li>'+result.rows[G].pstatus+'</li>' +
                                        '<li>'+result.rows[G].addTime+'</li>' +
                                        '<li>'+result.rows[G].pv+'</li>' +
                                        '<li>'+result.rows[G].uv+'</li>' +
                                        '<li>'+
                                        '<div class="sets">'+
                                        '<div onclick="supermarkshowData(this.id)" id="' + result.rows[G].id + '"  class="supermarketgraphics">图形数据</div>' +
                                        '<div class="promoteEditor"  onclick="supermarUpadete(this.id)" id="' + result.rows[G].id + '">编辑</div>' +
                                        '<div class="promoteidelete" onclick="supermardelect(this.id)" id="' + result.rows[G].id  + '">删除</div>' +
                                        ' </div>' +
                                        '</li>' +
                                        '</ul>' +
                                        '</div>'
                                    var K=$(D);
                                    o.append(K);

                                }
                            }
                            $(".shopping-tbody1").paging(options)
                        }
                    })

                });



                var options = {
                    list:".ul",//列表标识
                    currentPage:1,//初始页（选传，默认1）
                    pageSize:5,//每页列表数
                    // listTotal:5,//列表总数（选传），不传为list总数
                    callback:function(currentPage){//翻页回调（可填，可做ajax请求）,不传为纯html切换
                        ajaxDemo2(currentPage)
                    }
                }

                //会员得到数据
                function ajaxDemo2(page,pageSize){
                    if(!pageSize)var pageSize = 5;
                    if(sousuo2!=""||!sousuo2.valueOf("")){
                        //搜索有值的时候
                        $.post('<%=basePath %>/Supermarke/getSupermarket',{pageNo:page,pageSize:pageSize},function(data){
                            loadData2(data);
                        })
                    }if(propertyIds!=''||!propertyIds.valueOf("")){
                        $.post('<%=basePath %>/Supermarke/getSupermarket',{pageNo:page,pageSize:pageSize,propertyId:propertyIds,Index1:Index},function(data){
                            loadData2(data);
                        })
                    }
                }
                //会员拼接数据
                function loadData2(data){
                    //var jsonData=JSON.parse(data);
                    // var jsonData=JSON.parse(data);
                    $(".shopping-tbody1").empty();
                    var I=data.rows.length;
                    var o = $(".shopping-tbody1");
                    var imgs='<%=basePath %>';
                    if (data.length!==0) {
                        for(var G=0;G<I;G++){
                            var D ='<div class="shopping-tbody-item">' +
                                '<ul class="ul">' +
                                '<li>'+
                                '<img src="'+imgs+''+data.rows[G].img+'">' +
                                '</li>' +
                                '<li>'+data.rows[G].title+'</li>' +
                                '<li>'+data.rows[G].ptitle+'</li>' +
                                // '<li>'+data.rows[G].pstatus+'</li>' +
                                '<li>'+data.rows[G].addTime+'</li>' +
                                '<li>'+data.rows[G].pv+'</li>' +
                                '<li>'+data.rows[G].uv+'</li>' +
                                '<li>'+
                                '<div class="sets">'+
                                '<div onclick="Img(this.id)" class="supermarketgraphics">图形数据</div>' +
                                '<div class="promoteEditor"  onclick="supermarUpadete(this.id)" id="' + data.rows[G].id + '">编辑</div>' +
                                '<div class="promoteidelete" onclick="supermardelect(this.id)" id="' + data.rows[G].id  + '">删除</div>' +
                                ' </div>' +
                                '</li>' +
                                '</ul>' +
                                '</div>'
                            var K=$(D);
                            o.append(K);

                        }
                    }
                }


                $(document).ready(function(){

                    var flot=false;
                    if(flot==false){
                    //点击进入会员管理刷新页面
                    $.ajax({
                        type:"post",
                        dateType:"json",
                        url:"<%=basePath %>/Supermarke/getSupermarket",
                        data:{},
                        success: function(result){
                           // var jsonData=JSON.parse(result);
                            total2=result.total;
                            var  I=result.rows.length;
                            var o = $(".shopping-tbody1");
                            var imgs='<%=basePath %>';
                            if (result.length!==0) {
                                for(var G=0;G<I;G++){
                                    var D ='<div class="shopping-tbody-item">' +
                                        '<ul class="ul">' +
                                        '<li>'+
                                        '<img src="'+imgs+''+result.rows[G].img+'">' +
                                        '</li>'+
                                        '<li>'+result.rows[G].title+'</li>' +
                                        '<li>'+result.rows[G].ptitle+'</li>' +
                                        // '<li>'+result.rows[G].pstatus+'</li>' +
                                        '<li>'+result.rows[G].addTime+'</li>' +
                                        '<li>'+result.rows[G].pv+'</li>' +
                                        '<li>'+result.rows[G].uv+'</li>' +
                                        '<li>'+
                                        '<div class="sets">'+
                                        '<div onclick="supermarkshowData(this.id)"id="' + result.rows[G].id +'"  class="supermarketgraphics">图形数据</div>' +
                                        '<div class="promoteEditor"  onclick="supermarUpadete(this.id)" id="' + result.rows[G].id + '">编辑</div>' +
                                        '<div class="promoteidelete" onclick="supermardelect(this.id)" id="' + result.rows[G].id  + '">删除</div>' +
                                        ' </div>' +
                                        '</li>' +
                                        '</ul>' +
                                        '</div>'
                                    var K=$(D);
                                    o.append(K);

                                }
                            }
                            $(".shopping-tbody1").paging(options)
                            flot=true;
                        },
                        error:function(){
                            alert("错误")
                        }
                    });
                    //ajax结束
                    }
                });


            </script>
</body>
</html>